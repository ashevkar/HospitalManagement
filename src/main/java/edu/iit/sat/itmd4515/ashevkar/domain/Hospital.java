/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.ashevkar.domain;

import edu.iit.sat.itmd4515.ashevkar.security.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
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
@NamedQuery(name = "Hospital.findByUsername", query = "select h from Hospital h where h.user.userName= :uname")
public class Hospital extends AbstractEntity{
 
    @NotBlank   
    @Column(name = "HOSPITAL_NAME")
    private String name;

    @Column(name = "HOSPITAL_ADDRESS")
    private String address;
    
    @Pattern(regexp="[0-9]{10}", message="Contact number must be 10 digits long")
    @Column(name = "CONTACT_NUMBER")
    private String contactNumber;
    
    @OneToOne
    @JoinColumn(name = "USERNAME")
    private User user;

//    M:M bidirectional relationship b/w patient & hospital
//    Hospital is the inverse (non-owning side of the relationship)mapped property
    @ManyToMany(mappedBy = "hospitals")
    private List<Patient> patients = new ArrayList<>();
      
    public User getUser() {
        return user;
    } 
    public void setUser(User user) {
        this.user = user;
    }

    public List<Patient> getPatients() {
        return patients;
    }
    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }
  
    public String getContactNumber() {
        return contactNumber;
    }  
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
  
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }  
    public void setName(String name) {
        this.name = name;
    }
    
    public void addPatient(Patient p){     
        if(! this.patients.contains(p)){
            this.patients.add(p);
        }
        if(!p.getHospitals().contains(this)){
            p.getHospitals().add(this);
        }
    }
    public void removePatient(Patient p){        
        if(this.patients.contains(p)){
            this.patients.remove(p);
        }
        if(p.getHospitals().contains(this)){
            p.getHospitals().remove(this);
        }
    }
    
    public Hospital(String name, String address, String contactNumber) {
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
