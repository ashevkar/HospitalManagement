/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.ashevkar.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.PastOrPresent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author ashevkar
 */
@Entity 
@NamedQuery(name = "Patient.findAll", query= "select p from Patient p")
public class Patient extends AbstractNamedEntity{

    //bean validation
    @PastOrPresent          
    @Column(name = "PATIENT_BIRTHDATE")   
    private LocalDate birthDate;

    @Column(name = "PATIENT_GENDER")    
    @Enumerated(EnumType.STRING)
    private PatientGender gender;
    
//    M:M bidirectional relationship b/w patient & hospital
//    Patient is the owning of the relationship
    @ManyToMany
    @JoinTable(name = "PATIENT_HOSPITALS",
            joinColumns = @JoinColumn(name = "PATIENT_ID"),
            inverseJoinColumns = @JoinColumn(name = "HOSPITAL_ID"))
    private List<Hospital> hospitals = new ArrayList<>();
    
    
//    1:M/M:1 bidirectional relationship
//    M:1 is always the owning side
//    Appointment is the owner of this relationship
    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments = new ArrayList<>();
   
    
    
    public void addHospital(Hospital h){
        
        if(! this.hospitals.contains(h)){
            this.hospitals.add(h);
        }
        if(!h.getPatients().contains(this)){
            h.getPatients().add(this);
        }
    }
    public void removeHospital(Hospital h){
        
        if(this.hospitals.contains(h)){
            this.hospitals.remove(h);
        }
        if(h.getPatients().contains(this)){
            h.getPatients().remove(this);
        }
    }

    
        /**
     * Get the value of appointments
     *
     * @return the value of appointments
     */
    public List<Appointment> getAppointments() {
        return appointments;
    }

    /**
     * Set the value of appointments
     *
     * @param appointments new value of appointments
     */
    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }   

    /**
     * Get the value of hospitals
     *
     * @return the value of hospitals
     */
    public List<Hospital> getHospitals() {
        return hospitals;
    }

    /**
     * Set the value of hospitals
     *
     * @param hospitals new value of hospitals
     */
    public void setHospitals(List<Hospital> hospitals) {
        this.hospitals = hospitals;
    }
     
    /**
     * Get the value of gender
     *
     * @return the value of gender
     */
    public PatientGender getGender() {
        return gender;
    }

    /**
     * Set the value of gender
     *
     * @param gender new value of gender
     */
    public void setGender(PatientGender gender) {
        this.gender = gender;
    }
    
    /**
     * Get the value of birthDate
     *
     * @return the value of birthDate
     */
    public LocalDate getBirthDate() {
        return birthDate;
    }

    /**
     * Set the value of birthDate
     *
     * @param birthDate new value of birthDate
     */
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    

    public Patient(String name, LocalDate birthDate, PatientGender gender) {
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
    }
    public Patient() {
    }

    @Override
    public String toString() {
        return "Patient{" + "id=" + id + ", name=" + name + ", birthDate=" + birthDate + ", gender=" + gender + '}';
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final Patient other = (Patient) obj;
        if(this.id == null || other.id == null){
            return false;
        }
        
        
        return Objects.equals(this.id, other.id);
    }
}

