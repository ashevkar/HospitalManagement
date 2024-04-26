/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.ashevkar.web;

import edu.iit.sat.itmd4515.ashevkar.domain.Hospital;
import edu.iit.sat.itmd4515.ashevkar.domain.Patient;
import edu.iit.sat.itmd4515.ashevkar.service.HospitalService;
import edu.iit.sat.itmd4515.ashevkar.service.PatientService;
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
public class WelcomePatientController {

    private static final Logger LOG = Logger.getLogger(WelcomePatientController.class.getName());

    @EJB PatientService patientSvc;
    @EJB HospitalService hospitalSvc;
    @Inject LoginController loginController;
    
    private Patient patient;
    private Hospital hospital;
    
    public WelcomePatientController() {
    }
    @PostConstruct
    private void postConstruct(){
        patient = new Patient();
        LOG.info("WelcomePatientController.postConstruct");

        patient =patientSvc.findByUsername(loginController.getAuthenticatedUser());  
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    
    
    
}