/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.ashevkar.domain;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.time.LocalDate;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author ashevkar
 */
public class PatientJPATest {
    
    private static EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction tx;
    
    @BeforeAll
    public static void beforeAll(){
        emf = Persistence.createEntityManagerFactory("itmd4515testPU");
    }
    
    @BeforeEach
    public void beforeEach(){
        em = emf.createEntityManager();
        tx = em.getTransaction();
        
        Patient p1= new Patient("Ruchika", LocalDate.of(2010, 11, 11), PatientGender.FEMALE);

        tx.begin();
        em.persist(p1);
        tx.commit();
    }
    
    @Test
    public void createTest(){
        Patient p2= new Patient("Aishwarya", LocalDate.of(2010, 11, 11), PatientGender.FEMALE);    
        
        tx.begin();
        em.persist(p2);
        tx.commit();
        
        Patient readBackFromDatabaseForAssertion = em.find(Patient.class, p2.getId());
        assertEquals(p2.getId(), readBackFromDatabaseForAssertion.getId());
    }
    
    @Test
    public void readTest(){
        
        Patient p3 = em.createQuery("select p from Patient p where p.name = 'Ruchika'",             
                Patient.class).getSingleResult();
    
        Patient readBackFromDatabaseForAssertion = em.find(Patient.class, p3.getId());
        assertEquals(p3.getId(), readBackFromDatabaseForAssertion.getId());
    }
    
    @Test
    public void updateTest(){
        Patient p = em.createQuery("select p from Patient p where p.name = 'Ruchika'", 
            Patient.class).getSingleResult();      
        
        LocalDate newBirthDay = LocalDate.of(2010, 12, 12);  
        
        System.out.println("Before update: " + p.getBirthDate()); 
        tx.begin();
        p.setBirthDate(newBirthDay);
        em.flush();
        tx.commit();
        System.out.println("After update: " + p.getBirthDate());
        
        Patient readBackFromDatabaseForAssertion = em.find(Patient.class, p.getId());       //to read from the database        
        assertEquals(newBirthDay, readBackFromDatabaseForAssertion.getBirthDate());
    }  
    
    @Test
    public void deleteTest(){    
        Patient p = em.createQuery("select p from Patient p where p.name = 'Aishwarya'", 
            Patient.class).getSingleResult();
        
        tx.begin();
        em.remove(p);
        tx.commit();
    }
    
    @AfterEach
    public void afterEach(){
        
        Patient p = em.createQuery("select p from Patient p where p.name = 'Ruchika'", 
                Patient.class).getSingleResult();
        
        tx.begin();
        em.remove(p);
        tx.commit();
        
        em.close();
    }
    
    @AfterAll
    public static void afterAll(){
        emf.close();
    }
}
