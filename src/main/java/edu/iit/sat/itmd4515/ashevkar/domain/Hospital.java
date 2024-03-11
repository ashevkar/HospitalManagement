/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.ashevkar.domain;

import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQuery;
import jakarta.validation.constraints.NotBlank;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author ashevkar
 */
@Entity
@XmlRootElement
@NamedQuery(name = "Hospital.findAll", query = "select h from Hospital h")
public class Hospital extends AbstractEntity{
 
    @NotBlank   
    @Column(name = "HOSPITAL_NAME")
    private String name;

    @Column(name = "HOSPITAL_ADDRESS")
    private String address;

    @Column(name = "CONTACT_NUMBER")
    private Long contactNumber;
    
//    M:M bidirectional relationship b/w patient & hospital
//    Hospital is the inverse (non-owning side of the relationship)mapped property
    @ManyToMany(mappedBy = "hospitals")
//    @JsonbTransient
    private List<Patient> patients = new ArrayList<>();

    /**
     * Get the value of patients
     *
     * @return the value of patients
     */
    public List<Patient> getPatients() {
        return patients;
    }

    /**
     * Set the value of patients
     *
     * @param patients new value of patients
     */
    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    /**
     * Get the value of contactNumber
     *
     * @return the value of contactNumber
     */
    public Long getContactNumber() {
        return contactNumber;
    }

    /**
     * Set the value of contactNumber
     *
     * @param contactNumber new value of contactNumber
     */
    public void setContactNumber(Long contactNumber) {
        this.contactNumber = contactNumber;
    }

    /**
     * Get the value of address
     *
     * @return the value of address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Set the value of address
     *
     * @param address new value of address
     */
    public void setAddress(String address) {
        this.address = address;
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
    
    
    public Hospital(String name, String address, Long contactNumber) {
        this.name = name;
        this.address = address;
        this.contactNumber = contactNumber;
    }

    public Hospital() {
    }
    

    @Override
    public String toString() {
        return "Hospital{" + "id=" + id + ", name=" + name + ", address=" + address + ", contactNumber=" + contactNumber + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.id);
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
        final Hospital other = (Hospital) obj;
        if(this.id == null || other.id == null){
            return false;
        }
        
        return Objects.equals(this.id, other.id);
    }


}
