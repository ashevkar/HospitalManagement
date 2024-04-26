/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.ashevkar.web;

import edu.iit.sat.itmd4515.ashevkar.domain.Appointment;
import edu.iit.sat.itmd4515.ashevkar.domain.Doctor;
import edu.iit.sat.itmd4515.ashevkar.domain.Patient;
import edu.iit.sat.itmd4515.ashevkar.service.AppointmentService;
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
public class DoctorAppointmentController {

    private static final Logger LOG = Logger.getLogger(DoctorAppointmentController.class.getName());

    @Inject  WelcomeDoctorController dwc; 
    private Patient patient;
    
    @EJB AppointmentService appointmentSvc;
    
    private Appointment appointment;
    
    public DoctorAppointmentController() {
    }
    @PostConstruct
    private void postConstruct(){
        LOG.info("Inside DoctorAppointmentController postConstruct");
        appointment = new Appointment();
        appointment.setPatient(new Patient());
        appointment.setDoctor(new Doctor());
        appointment.setDoctor(dwc.getDoctor());
    }
    public String viewAppointmentPage(Appointment appointment){  
        this.appointment = appointment;
        LOG.info("Inside DoctorAppointmentController viewAppointmentPage postConstruct" + appointment.toString());
        return "/doctor/readAppointment.xhtml"; 
    }
    
    public String editAppointmentPage(Appointment appointment){    
        this.appointment = appointment;
        LOG.info("Inside DoctorAppointmentController editAppointmentPage postConstruct" + appointment.toString());
        return "/doctor/editAppointment.xhtml"; 
    }
    
    public String deleteAppointmentPage(Appointment appointment){ 
        this.appointment = appointment;
        LOG.info("Inside DoctorAppointmentController deleteAppointmentPage postConstruct" + appointment.toString());
        return "/doctor/welcome.xhtml"; 
    }
    public String scheduleAppointmentPage(Patient p){
        appointment.setPatient(p);
        LOG.info("Inside DoctorAppointmentController scheduleAppointmentPage postConstruct" + appointment.toString());
        return "/doctor/scheduleAppointment.xhtml"; 
    }
    public String cancelAppointmentPage(Patient p){    
        LOG.info("Inside DoctorAppointmentController cancelAppointmentPage postConstruct" + appointment.toString());
        return "/doctor/welcome.xhtml"; 
    }
    
    public String scheduleAppointment(){    
        LOG.info("Inside DoctorAppointmentController scheduleAppointment postConstruct" + appointment.toString());
        appointmentSvc.scheduleAppointment(appointment);
        dwc.refreshDoctorModel();
        return "/doctor/welcome.xhtml"; 
    }
    
    public String editAppointment(){    
        LOG.info("Inside DoctorAppointmentController editAppointment postConstruct" + appointment.toString());
        appointmentSvc.editAppointment(appointment);
        dwc.refreshDoctorModel();
        return "/doctor/welcome.xhtml"; 
    }

    public Appointment getAppointment() {
        return appointment;
    }
    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }
    
}
