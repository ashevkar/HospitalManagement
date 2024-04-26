/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.ashevkar.web;

import edu.iit.sat.itmd4515.ashevkar.domain.Hospital;
import edu.iit.sat.itmd4515.ashevkar.service.HospitalService;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.logging.Logger;

/**
 *
 * @author ashevkar
 */
@Named
@RequestScoped
public class WelcomeController {

    private static final Logger LOG = Logger.getLogger(WelcomeController.class.getName());

    @EJB HospitalService hospitalSvc;
    @Inject LoginController loginController;
    
    private Hospital hospital;
    
    public WelcomeController() {
    }
    @PostConstruct
    private void postConstruct(){
        
        hospital =hospitalSvc.findByUsername(loginController.getAuthenticatedUser());
           
    }
    public void refreshModel(){
        hospital =hospitalSvc.findByUsername(loginController.getAuthenticatedUser());
    }
    
    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }
}
