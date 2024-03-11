/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.ashevkar.service;

import edu.iit.sat.itmd4515.ashevkar.domain.Patient;
import jakarta.ejb.Stateless;
import java.util.List;

/**
 *
 * @author ashevkar
 */
@Stateless
public class PatientService extends AbstractService<Patient>{   

    public PatientService() {
        super(Patient.class);
        
    }
    
    public List<Patient> findAll(){
        return super.findAll("Patient.findAll");
    }
}
