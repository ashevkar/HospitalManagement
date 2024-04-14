/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.ashevkar.web;

import edu.iit.sat.itmd4515.ashevkar.domain.Patient;
import edu.iit.sat.itmd4515.ashevkar.domain.PatientGender;
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
public class PatientController {
    
private static final Logger LOG = Logger.getLogger(PatientController.class.getName());
        
    @EJB PatientService patientSvc;
    @EJB HospitalService hospitalSvc;  
    @Inject WelcomeController wc;
    
    private Patient patient;

    public PatientController() {
    }

    @PostConstruct
    private void postConstruct() {
        patient = new Patient();
        LOG.info("PatientController.postConstruct");
    }

    public PatientGender[] getPatientGender(){
        return PatientGender.values();
    }
    
    public String demoAction() {
        LOG.info("demoAction has been invoked with model: " + this.patient.toString());

        return "confirmation.xhtml";
    }

    public String savePatient() {
        LOG.info("savePatient has been invoked with model: " + this.patient.toString());

//        patientSvc.create(patient);
        hospitalSvc.createPatient(wc.getHospital(), patient);
        
 
        LOG.info("savePatient after calling service layer: " + this.patient.toString());
        
        return "confirmation.xhtml";
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    
}

