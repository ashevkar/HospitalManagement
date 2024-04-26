/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.ashevkar.service;

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
public class PatientService extends AbstractService<Patient>{   

    public PatientService() {
        super(Patient.class);  
    }
    
    public List<Patient> findAll(){
        return super.findAll("Patient.findAll");
    }  
    
    public Patient findByUsername(String username){
        return em.createNamedQuery("Patient.findByUsername",Patient.class).setParameter("uname", username).getSingleResult();
    }   
    public void editPatient(Patient p){
        Patient managedRef = em.getReference(Patient.class, p.getId());
        managedRef.setName(p.getName());
        managedRef.setBirthDate(p.getBirthDate());
        managedRef.setGender(p.getGender());
        
        em.merge(managedRef);
    }
}
