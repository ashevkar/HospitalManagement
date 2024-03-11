/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.ashevkar.service;

import edu.iit.sat.itmd4515.ashevkar.domain.Hospital;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

/**
 *
 * @author ashevkar
 */
@Stateless
public class HospitalService {

    
    @PersistenceContext(name = "itmd4515PU")
    private EntityManager em;
    
    public HospitalService() {
        
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
        return em.createNamedQuery("Hospital.findAll", Hospital.class).getResultList();
    }
    
}
