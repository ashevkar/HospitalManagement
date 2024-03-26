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
import jakarta.inject.Named;
import java.util.logging.Logger;

/**
 *
 * @author ashevkar
 */
@Named
@RequestScoped
public class HospitalController {
    
private static final Logger LOG = Logger.getLogger(HospitalController.class.getName());
    
    @EJB HospitalService hospitalSvc;
    
    private Hospital hospital;

    public HospitalController() {
    }

    @PostConstruct
    private void postConstruct() {
        hospital = new Hospital();
        LOG.info("HospitalController.postConstruct");
    }
    
    public String demoAction() {
        LOG.info("demoAction has been invoked with model: " + this.hospital.toString());

        return "confirmation.xhtml";
    }

    public String saveHospital() {
        LOG.info("saveHospital has been invoked with model: " + this.hospital.toString());

        hospitalSvc.create(hospital);

        LOG.info("saveHospital after calling service layer: " + this.hospital.toString());
        
        return "confirmation.xhtml";
    }
    
    
    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

}

