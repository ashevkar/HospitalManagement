/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.ashevkar.web;

import edu.iit.sat.itmd4515.ashevkar.domain.Appointment;
import edu.iit.sat.itmd4515.ashevkar.domain.Doctor;
import edu.iit.sat.itmd4515.ashevkar.domain.Patient;
import edu.iit.sat.itmd4515.ashevkar.service.AppointmentService;
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
public class PatientAppointmentController {

    private static final Logger LOG = Logger.getLogger(PatientAppointmentController.class.getName());

    @EJB PatientService patientSvc;
    @Inject  PatientController pc; 
    private Patient patient;
    
    @EJB AppointmentService appointmentSvc;
    
    private Appointment appointment;
    
    public PatientAppointmentController() {
    }
    @PostConstruct
    private void postConstruct(){
        LOG.info("Inside PatientAppointmentController postConstruct");
        appointment = new Appointment();
        appointment.setPatient(new Patient());
        appointment.setDoctor(new Doctor());
        appointment.setPatient(pc.getPatient());
    }
    public String viewAppointmentPage(Appointment appointment){  
        this.appointment = appointment;
        LOG.info("Inside viewPatientAppointmentPage postConstruct" + appointment.toString());
        return "/patient/readAppointment.xhtml"; 
    }
    
    public String editAppointmentPage(Appointment appointment){    
        this.appointment = appointment;
        LOG.info("Inside editPatientAppointmentPage postConstruct" + appointment.toString());
        return "/patient/editAppointment.xhtml"; 
    }
    
    public String deleteAppointmentPage(Appointment appointment){ 
        this.appointment = appointment;
        LOG.info("Inside deletePatientAppointmentPage postConstruct" + appointment.toString());
        return "/patient/welcome.xhtml"; 
    }
    
    public String scheduleAppointmentPage(Patient p){ 
        appointment.setPatient(p);
        LOG.info("Inside schedulePatientAppointment postConstruct" + appointment.toString());
        return "/patient/scheduleAppointment.xhtml"; 
    }
    
    public String cancelAppointmentPage(Patient p){    
        LOG.info("Inside cancelPatientAppointmentPage postConstruct" + appointment.toString());
        return "/patient/welcome.xhtml"; 
    }
    
    public String editAppointment(){
        LOG.info("editAppointment has been invoked with model: " + this.appointment.toString()); 
        appointmentSvc.editAppointment(appointment);
        pc.refreshPatientModel();
        return "/patient/welcome.xhtml";
    }
    
    public String scheduleAppointment(){    
        LOG.info("Inside schedulePatientAppointment postConstruct" + appointment.toString());
        appointmentSvc.scheduleAppointment(appointment);
        pc.refreshPatientModel();
        return "/patient/welcome.xhtml"; 
    }

    public Appointment getAppointment() {
        return appointment;
    }
    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }
    
}
