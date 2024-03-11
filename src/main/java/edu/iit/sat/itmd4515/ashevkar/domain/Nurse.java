/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.ashevkar.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.NamedQuery;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

/**
 *
 * @author ashevkar
 */
@Entity
@XmlRootElement
@NamedQuery(name = "Nurse.findAll", query = "select n from Nurse n")
public class Nurse extends AbstractEntity{
   
       
    @Override
    public String toString() {
        return "Nurse{" + "id=" + id + ", name=" + name + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Nurse other = (Nurse) obj;
        return Objects.equals(this.id, other.id);
    }
    

    private String name;

    public Nurse(String name) {
        this.name = name;
    }

    public Nurse() {
    }

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name) {
        this.name = name;
    }
 
}
