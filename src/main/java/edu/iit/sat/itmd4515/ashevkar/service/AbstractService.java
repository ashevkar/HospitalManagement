/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.ashevkar.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

/**
 *
 * @author ashevkar
 */
public abstract class AbstractService<T> {

    @PersistenceContext(name = "itmd4515PU")
    protected EntityManager em;

    protected Class<T> entityClass;

    //initializing super from the child
    protected AbstractService(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
    
    public void create(T entity) {
        em.persist(entity);
        
    }

    public T read(Long id) {
        return em.find(entityClass, id);
    }

    public void update(T entity) {
        em.merge(entity);
    }

    public void delete(T entity) {
        em.remove(em.merge(entity));
    }

    protected List<T> findAll(String namedQueryName) {
        return em.createNamedQuery(namedQueryName, entityClass).getResultList();
    }

}


