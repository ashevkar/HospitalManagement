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
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author ashevkar
 */
public class AbstractJPATest {
    private static EntityManagerFactory emf;
    protected EntityManager em;
    protected EntityTransaction tx;
    
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
