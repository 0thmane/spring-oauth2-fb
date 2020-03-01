package io.hitos.springoauth2.web;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Map;

@RestController
@EnableOAuth2Sso
public class AuthController {

    @GetMapping("/")
    public String home(Principal principal){
        Map<String, Object> details = (Map<String, Object>)((OAuth2Authentication)principal).getUserAuthentication().getDetails();
        String name = (String)details.get("name");
        return String.format("Hi %s !!", name);
    }
}
