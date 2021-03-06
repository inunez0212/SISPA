package com.uisrael.edu.ec.sispa.template.security;

import java.io.IOException;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Faces;

import com.uisrael.edu.ec.sispa.template.config.AdminConfig;
import com.uisrael.edu.ec.sispa.template.util.Constants;

/**
 * Created by rmpestano on 03/02/17.
 */
@Named
@RequestScoped
public class LogoutMB {

    @Inject
    AdminConfig adminConfig;


    public void doLogout() throws IOException {
        String loginPage = adminConfig.getLoginPage();
        if (loginPage == null || "".equals(loginPage)) {
            loginPage = Constants.DEFAULT_LOGIN_PAGE;
        }
        if (!loginPage.startsWith("/")) {
            loginPage = "/" + loginPage;
        }
        Faces.getSession().invalidate();
        ExternalContext ec = Faces.getExternalContext();
        ec.redirect(ec.getRequestContextPath() + loginPage);
    }

}
