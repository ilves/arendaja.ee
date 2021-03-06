package ee.golive.arendaja.controller;


import ee.golive.arendaja.model.Ad;
import ee.golive.arendaja.repository.AdRepository;
import ee.golive.arendaja.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AdController {

    @Autowired
    private AdService adService;

    @Autowired
    private AdRepository adRepository;

    @RequestMapping("/")
    public ModelAndView adList() {
        ModelAndView modelAndView = new ModelAndView("home");
        List<Ad> ads = adService.getAllActive();
        modelAndView.addObject("ads", ads);
        return modelAndView;
    }

    @RequestMapping("/ad/{someID}")
    public String singleAd(ModelMap model, @PathVariable(value="someID") Long id) {
        Ad ad = adRepository.findOne(id);
        model.addAttribute("ad", ad);
        return "singleAd";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ModelAndView addNewAd() {
        return new ModelAndView("new", "ad", new Ad());
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public ModelAndView saveAd (@Valid Ad ad, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("new", "ad", ad);
        }
        adRepository.save(ad);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("singleAd");
        modelAndView.addObject("ad", ad);
        return modelAndView;
    }
}
