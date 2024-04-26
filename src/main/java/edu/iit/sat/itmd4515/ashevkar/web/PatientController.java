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
    @Inject PatientController pc;
    @Inject LoginController loginController;
    
    private Patient patient;

    public PatientController() {
    }

    @PostConstruct
    private void postConstruct() {
        patient = new Patient();
        LOG.info("PatientController.postConstruct");
        LOG.info("------------------------------------------------------------------------------------");
    }

    public PatientGender[] getPatientGender(){
        return PatientGender.values();
    }
    
    public String viewPatientPage(Patient p){
        this.patient = p;
        LOG.info("inside viewPatientPage with model"+ p.toString());
        return "/patient/viewPatient.xhtml";
    }
    
    public String editPatientPage(Patient p){
        this.patient = p;
        LOG.info("inside editPatientPage with model"+ p.toString());
        return "/patient/editPatient.xhtml";
    }
    public String editHospitalPatientPage(Patient p){
        this.patient = p;
        LOG.info("inside editPatientPage with model"+ p.toString());
        return "/hospital/editPatient.xhtml";
    }
    public String deletePatientPage(Patient p){
        this.patient = p;
        LOG.info("inside deletePatientPage with model"+ p.toString());
        return "/hospital/deletePatient.xhtml";
    }

    public String savePatient() {
        LOG.info("savePatient has been invoked with model: " + this.patient.toString());
//        patientSvc.create(patient);
        hospitalSvc.createPatient(wc.getHospital(), patient);      
        LOG.info("savePatient after calling service layer: " + this.patient.toString());      
        wc.refreshModel();
        return "welcome.xhtml";
    }
    
    public String editPatient(){
        LOG.info("editPatient has been invoked with model: " + this.patient.toString());
        patientSvc.editPatient(patient);
        pc.refreshPatientModel();
        return "/patient/welcome.xhtml";
    }
    public String editHospitalPatient(){
        LOG.info("editPatient has been invoked with model: " + this.patient.toString());
        patientSvc.editPatient(patient);
        wc.refreshModel();
        return "/hospital/welcome.xhtml";
    }
    
    public String deletePatient(){
        LOG.info("deletePatient has been invoked with model: " + this.patient.toString());
        wc.refreshModel();

        return "/hospital/welcome.xhtml";
    }

    public void refreshPatientModel(){
        patient =patientSvc.findByUsername(loginController.getAuthenticatedUser());  
    }
    
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    
}

