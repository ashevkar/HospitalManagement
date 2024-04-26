/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.ashevkar.web;

import edu.iit.sat.itmd4515.ashevkar.domain.Doctor;
import edu.iit.sat.itmd4515.ashevkar.service.DoctorService;
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
public class WelcomeDoctorController {

    private static final Logger LOG = Logger.getLogger(WelcomeDoctorController.class.getName());

    @EJB DoctorService doctorSvc;
    @Inject LoginController loginController;
    
    private Doctor doctor;

    public WelcomeDoctorController() {
    }
    
   
    @PostConstruct
    private void postConstruct(){
        
        doctor = doctorSvc.findByUsername(loginController.getAuthenticatedUser());
        LOG.info("WelcomeDoctorController.postConstruct: " + doctor.toString());

    }
    public void refreshDoctorModel(){
        doctor = doctorSvc.findByUsername(loginController.getAuthenticatedUser());
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
  
}
