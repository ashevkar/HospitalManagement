/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.ashevkar.domain;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

/**
 *
 * @author ashevkar
 */
public class PatientJPATest extends AbstractJPATest{
    
    @Test
    public void createTest(){
        Patient p2= new Patient("Aishwarya", LocalDate.of(2010, 11, 11), PatientGender.FEMALE);    
        
        tx.begin();
        em.persist(p2);
        tx.commit();
        
        //read it back from the database 
        Patient readBackFromDatabaseForAssertion = em.find(Patient.class, p2.getId());
        //assertion that it was successfully updated
        assertEquals(p2.getId(), readBackFromDatabaseForAssertion.getId());
    }
    
    @Test
    public void readTest(){
        
        Patient p3 = em.createQuery("select p from Patient p where p.name = 'Ruchika'",             
                Patient.class).getSingleResult();
    
        //read it back from the database 
        Patient readBackFromDatabaseForAssertion = em.find(Patient.class, p3.getId());
        //assertion that it was successfully updated
        assertEquals(p3.getId(), readBackFromDatabaseForAssertion.getId());
    }
    
    @Test
    public void updateTest(){
        Patient p = em.createQuery("select p from Patient p where p.name = 'Ruchika'", 
            Patient.class).getSingleResult();      
        
        LocalDate newBirthDay = LocalDate.of(2010, 12, 12);  
        
//        System.out.println("Before update: " + p.getBirthDate()); 
        tx.begin();
        p.setBirthDate(newBirthDay);
        tx.commit();
//        System.out.println("After update: " + p.getBirthDate());
        
        //read it back from the database  
        Patient readBackFromDatabaseForAssertion = em.find(Patient.class, p.getId());  
        //assertion that it was successfully updated
        assertEquals(newBirthDay, readBackFromDatabaseForAssertion.getBirthDate());
    }  
    
    @Test
    public void deleteTest(){    
        Patient p4 = em.createQuery("select p from Patient p where p.name = 'Aishwarya'", 
            Patient.class).getSingleResult();
        
        tx.begin();
        em.remove(p4);
        tx.commit();
        
        //read it back from the database  
        Patient readBackFromDatabaseForAssertion = em.find(Patient.class, p4.getId());
        //assertion that it was successfully updated
        assertNull(readBackFromDatabaseForAssertion, "Patient should not exist in the database after deletion");
    }
    
   
    
    
}
