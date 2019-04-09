package fr.formation.controller;

import fr.formation.models.User;
import fr.formation.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

public abstract class AbstractController {
    @Autowired
    private UserService userService;

    /**
     * Récupération du username de l'utilisateur authentifié
     * @return
     */
    protected String getAuthenticatedUsername () {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    /**
     * Récupération de l'utilisateur authentifié
     * @return
     */
    protected User getAuthenticatedUser () {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        return userService.getUserByUsername(username);

    }
}
