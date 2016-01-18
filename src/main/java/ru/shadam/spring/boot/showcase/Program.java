package ru.shadam.spring.boot.showcase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.MissingAuthorizationException;
import org.springframework.social.vkontakte.api.VKontakte;
import org.springframework.social.vkontakte.api.VKontakteProfile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author sala
 */
@EnableAutoConfiguration
@Configuration
@Controller
public class Program {
    @Autowired
    VKontakte vkontakte;

    public static void main(String[] args) {
        SpringApplication.run(Program.class, args);
    }

    @RequestMapping("/")
    public String renderIndex(ModelMap modelMap) {
        try {
            final List<VKontakteProfile> profiles = vkontakte.friendsOperations().get().getItems();
            modelMap.put("profiles", profiles);
            return "index";
        } catch (MissingAuthorizationException authEx) {
            return "redirect:/connect/vkontakte";
        }
    }
}
