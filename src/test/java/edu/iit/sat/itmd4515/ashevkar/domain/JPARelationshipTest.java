/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.ashevkar.domain;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 *
 * @author ashevkar
 */
public class JPARelationshipTest extends AbstractJPATest {
    
    @Test
    public void uniDirectionalRelationshipTest(){
        
        Hospital h = new Hospital("Noble", "1740 W Taylor St, Chicago, IL 60612", "8666002273");
        Doctor d = new Doctor("Neel", "Cardiology", 29329772l);
        //set the relationship
        d.setHospital(h);
        
        tx.begin();

        //non-owning side
        em.persist(d);
        //owning side
        em.persist(h);
        tx.commit();
        
        //read back from database
        Doctor readBackFromDatabase = em.find(Doctor.class, d.getId());
        //assertion
        assertNotNull(readBackFromDatabase.getHospital());
        assertEquals("Noble", readBackFromDatabase.getHospital().getName());
        
    }
    @Test
    public void biDirectionalRelationshipTest(){
        Patient p= new Patient("Saniya", LocalDate.of(2000, 02, 28), PatientGender.FEMALE);   
        
        Hospital h = new Hospital("Insight", "2525 S Michigan Ave, Chicago, IL 60616","4567890123");

//        non-owning side was set but the database was not updated.
//        h.getPatients().add(p);
        
//        owning side was set and database was updated.
//        collection have been populated on both the sides.
//        p.getHospitals().add(h);
//        h.getPatients().add(p);

        p.addHospital(h);
        
        tx.begin();
        //non-owning side
        em.persist(h);
        //owning side
        em.persist(p);
        tx.commit();
        
        System.out.println("Owning side"+ p.getHospitals().toString());
        System.out.println("Inverse side"+ h.getPatients().toString());

//        assert based on relationship
        assertFalse(p.getHospitals().isEmpty());
        assertTrue(h.getPatients().size() == 1);
        
        
//        delete data 
        tx.begin();
        p.removeHospital(h);
        em.remove(h);
        em.remove(p);
        tx.commit();
      
    }
    
}
