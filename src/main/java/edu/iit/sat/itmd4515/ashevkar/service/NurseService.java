/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.ashevkar.service;

import edu.iit.sat.itmd4515.ashevkar.domain.Nurse;
import jakarta.ejb.Stateless;
import java.util.List;

/**
 *
 * @author ashevkar
 */
@Stateless
public class NurseService extends AbstractService<Nurse>{   

    public NurseService() {
        super(Nurse.class);
        
    }
    
    public List<Nurse> findAll(){
        return super.findAll("Nurse.findAll");
    }
}
