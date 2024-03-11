/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.ashevkar.service;

import edu.iit.sat.itmd4515.ashevkar.domain.Appointment;
import jakarta.ejb.Stateless;
import java.util.List;

/**
 *
 * @author ashevkar
 */
@Stateless
public class AppointmentService extends AbstractService<Appointment>{   

    public AppointmentService() {
        super(Appointment.class);
        
    }
    
    public List<Appointment> findAll(){
        return super.findAll("Appointment.findAll");
    }
}
