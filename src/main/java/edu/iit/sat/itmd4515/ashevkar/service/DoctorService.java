/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.ashevkar.service;

import edu.iit.sat.itmd4515.ashevkar.domain.Doctor;
import jakarta.ejb.Stateless;
import java.util.List;

/**
 *
 * @author ashevkar
 */
@Stateless
public class DoctorService extends AbstractService<Doctor>{   

    public DoctorService() {
        super(Doctor.class);
        
    }
    
    public List<Doctor> findAll(){
        return super.findAll("Doctor.findAll");
    }
}
