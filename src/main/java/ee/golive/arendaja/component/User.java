package ee.golive.arendaja.component;

import ee.golive.arendaja.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class User {

    @Autowired
    private UserService userService;
    private ee.golive.arendaja.model.User user;

    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public int getId() {
        Integer id = 0;
        if (getAuthentication().isAuthenticated()) {
            String rawId = getAuthentication().getName();
            try {
                id = Integer.parseInt(rawId);
            } catch (Exception e) {

            }
        }
        return id;
    }

    public ee.golive.arendaja.model.User getModel() {
        if (user == null && getId() > 0) {
            user = userService.getById(getId());
        }
        return user;
    }
}
