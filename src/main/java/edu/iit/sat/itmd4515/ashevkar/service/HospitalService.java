/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.ashevkar.service;

import edu.iit.sat.itmd4515.ashevkar.domain.Hospital;
import edu.iit.sat.itmd4515.ashevkar.domain.Patient;
import jakarta.ejb.Stateless;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author ashevkar
 */
@Named
@Stateless
public class HospitalService extends AbstractService<Hospital>{

    private static final Logger LOG = Logger.getLogger(HospitalService.class.getName());   
    @PersistenceContext(name = "itmd4515PU")
    private EntityManager em;

    public HospitalService() {
        super(Hospital.class);
    } 
    
    public void create(Hospital h){ 
        em.persist(h);        
    }
    
    public Hospital read(Long id){
        return em.find(Hospital.class, id);
    }
    
    public void update(Hospital h){
        em.merge(h);
    }
    
    public void delete(Hospital h){
        em.remove(em.merge(h));
    }
    public List<Hospital> findAll(){
//        return em.createQuery("select h from Hospital h", Hospital.class).getResultList();
//        return em.createNamedQuery("Hospital.findAll", Hospital.class).getResultList();
          return super.findAll("Hospital.findAll");
    }
    public Hospital findByUsername(String username){
        return em.createNamedQuery("Hospital.findByUsername",Hospital.class).setParameter("uname", username).getSingleResult();
    }   

    public void createPatient(Hospital hospital, Patient patient) {
        em.persist(patient);
        Hospital hospitalRef = em.getReference(Hospital.class, hospital.getId());
        hospitalRef.addPatient(patient);
        em.merge(hospitalRef);
    }
}
