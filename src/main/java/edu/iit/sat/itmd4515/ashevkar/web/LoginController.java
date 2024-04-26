/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.ashevkar.web;

import edu.iit.sat.itmd4515.ashevkar.security.User;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.security.enterprise.AuthenticationStatus;
import jakarta.security.enterprise.SecurityContext;
import jakarta.security.enterprise.authentication.mechanism.http.AuthenticationParameters;
import jakarta.security.enterprise.credential.Credential;
import jakarta.security.enterprise.credential.Password;
import jakarta.security.enterprise.credential.UsernamePasswordCredential;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sas
 */
@Named
@RequestScoped
public class LoginController {

    private static final Logger LOG = Logger.getLogger(LoginController.class.getName());

    @Inject
    SecurityContext securityContext;

    @Inject
    FacesContext facesContext;

    private User user;

    public LoginController() {
    }

    @PostConstruct
    private void postContruct() {
        LOG.info("LoginController.postConstruct");
        user = new User();
    }

    public String getAuthenticatedUser() {
        return securityContext.getCallerPrincipal().getName();
    }
    public boolean isPatient(){
        return securityContext.isCallerInRole("PATIENT_ROLE");
    }
    public boolean isHospital(){
        return securityContext.isCallerInRole("HOSPITAL_ROLE");
    }
    public boolean isAdmin(){
        return securityContext.isCallerInRole("ADMIN_ROLE");
    }
    public boolean isDoctor(){
        return securityContext.isCallerInRole("DOCTOR_ROLE");
    }

    public String doLogin() {
        LOG.info("LoginController.doLogin");

        HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
        HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
        Credential cred = new UsernamePasswordCredential(this.user.getUserName(), new Password(this.user.getPassword()));

        AuthenticationStatus status
                = securityContext.authenticate(
                        request,
                        response,
                        AuthenticationParameters.withParams().credential(cred)
                );

        switch (status) {
            case SUCCESS:
                LOG.info(status.toString());
                break;
            case SEND_FAILURE:
                LOG.info("FAILURE!" + status.toString());
                return "/error.xhtml";
            case NOT_DONE:
                LOG.info("NOT DONE!" + status.toString());
                return "/error.xhtml";
            case SEND_CONTINUE:
                LOG.info(status.toString());
                break;
        }

        return "/welcome.xhtml?faces-redirect=true";

    }

    public String doLogout() {
        LOG.info("LoginController.doLogout");

        try {
            HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
            request.logout();

        } catch (ServletException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }

        return "/login.xhtml?faces-redirect=true";
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
