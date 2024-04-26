/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.ashevkar.service;

import edu.iit.sat.itmd4515.ashevkar.domain.Appointment;
import edu.iit.sat.itmd4515.ashevkar.domain.Doctor;
import edu.iit.sat.itmd4515.ashevkar.domain.Patient;
import jakarta.ejb.Stateless;
import jakarta.inject.Named;
import java.util.List;

/**
 *
 * @author ashevkar
 */
@Named
@Stateless
public class AppointmentService extends AbstractService<Appointment>{   

    public AppointmentService() {
        super(Appointment.class);
        
    }
    
    public List<Appointment> findAll(){
        return super.findAll("Appointment.findAll");
    }
    
    public void editAppointment(Appointment appointment){
        Appointment managedRef = em.getReference(Appointment.class, appointment.getId());
        managedRef.setDate(appointment.getDate());
        managedRef.setTime(appointment.getTime());
        managedRef.setDoctor(appointment.getDoctor());
        managedRef.setPatient(appointment.getPatient());     
     
        em.merge(managedRef);
    }
    
    public void scheduleAppointment(Appointment appt){
        Appointment newAppt = new Appointment(appt.getDate(), appt.getTime());

        newAppt.scheduleApt(               
                em.getReference(Doctor.class, appt.getDoctor().getId()),
                em.getReference(Patient.class, appt.getPatient().getId())
        );  
        em.persist(newAppt);
    }
    
    
}
