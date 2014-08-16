package ee.golive.arendaja.controller;

import ee.golive.arendaja.form.AdAction;
import ee.golive.arendaja.model.Ad;
import ee.golive.arendaja.repository.AdRepository;
import ee.golive.arendaja.service.AdService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.social.ApiException;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.FacebookLink;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AdminController {

    @Autowired
    private AdService adService;

    @Autowired
    private AdRepository adRepository;

    @Autowired
    Environment env;

    @RequestMapping("/admin/ads")
    public String page(Model model, HttpServletRequest request, @ModelAttribute AdAction action) {

        if (request.getMethod().equals("POST")) {
            Ad ad = adService.getById(Long.parseLong(action.getId()));
            switch (action.getAction()) {
                case "1":
                    ad.setActive("1");
                    adRepository.save(ad);

                    String company = ad.getCompany_title() + " - " + ad.getCompany_city() + ", " + ad.getCompany_country();

                    Facebook facebook = new FacebookTemplate(env.getProperty("facebook.longlivedtoken"));
                    FacebookLink link = new FacebookLink(
                            env.getProperty("host")+"/ad/"+ad.getId(), ad.getTitle(),
                            company,
                            ad.getSummary()
                    );

                    String msg = "(via arendaja.ee)";
                    msg = msg + " " + ad.getTitle() + " - " + ad.getSummary() + "\n\n";
                    msg = msg + "Firma: " + company;

                    try {
                        facebook.pageOperations().post(env.getProperty("facebook.pageid"), msg, link);
                    } catch (ApiException e) {

                    }
                    break;
                case "2":
                    ad.setActive("1");
                    adRepository.save(ad);
                    break;
                case "3":
                case "0":
                    ad.setActive("0");
                    adRepository.save(ad);
                    break;
                case "4":
                    ad.setActive("1");
                    adRepository.save(ad);
                    break;
                case "5":
                    adRepository.delete(ad);
                    break;
            }
        }
        List<Ad> ads = adService.getAll();
        model.addAttribute("ads", ads);

        Map<String,String> actions = new LinkedHashMap<String,String>();
        actions.put("-1", "----");
        actions.put("1", "Accept&Post");
        actions.put("2", "Accept");
        actions.put("0", "Denie");
        actions.put("3", "Unactive");
        actions.put("4", "Active");
        actions.put("5", "Remove");

        model.addAttribute("actions", actions);
        model.addAttribute("action", new AdAction());

        return "admin/ads";
    }
}
