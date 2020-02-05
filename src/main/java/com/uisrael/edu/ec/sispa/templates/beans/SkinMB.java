package com.uisrael.edu.ec.sispa.templates.beans;

import static com.uisrael.edu.ec.sispa.template.util.Assert.has;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.uisrael.edu.ec.sispa.template.config.AdminConfig;

/**
 * Created by rmpestano on 07/01/17.
 */
@Named
@SessionScoped
public class SkinMB implements Serializable {

    private String skin;

    @Inject
    AdminConfig adminConfig;

    @PostConstruct
    public void init() {
        skin = adminConfig.getSkin();
        if(!has(skin)) {
            skin = "skin-blue";
        }
    }


    public void changeSkin(String skin){
        this.skin = skin;
    }

    public String getSkin() {
        return skin;
    }

    public void setSkin(String skin) {
        this.skin = skin;
    }
}
