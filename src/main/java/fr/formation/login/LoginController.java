package fr.formation.login;

import fr.formation.login.services.LoginService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    private LoginService loginService;

    LoginController(LoginService loginService){
        this.loginService = loginService;
    }
    
}
