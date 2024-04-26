/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.ashevkar.service;

import edu.iit.sat.itmd4515.ashevkar.domain.Doctor;
import jakarta.ejb.Stateless;
import jakarta.inject.Named;
import java.util.List;

/**
 *
 * @author ashevkar
 */
@Named
@Stateless
public class DoctorService extends AbstractService<Doctor>{   

    public DoctorService() {
        super(Doctor.class);
        
    }
    
    public List<Doctor> findAll(){
        return super.findAll("Doctor.findAll");
    }
    
     public Doctor findByUsername(String username){
        return em.createNamedQuery("Doctor.findByUsername",Doctor.class).setParameter("uname", username).getSingleResult();
    } 
}
