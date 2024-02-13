/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.ashevkar.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author ashevkar
 */
@Entity 
//@Table(name = "AnynameYouWant")
public class Patient {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name = "PATIENT_ID")
    private Long id;
    
    @NotBlank           //bean validation
    @Column(name = "PATIENT_NAME", nullable = false, unique = true)    
    private String name;
    
    @PastOrPresent          //bean validation
    @Column(name = "PATIENT_BIRTHDAY")   
//    @Temporal(TemporalType.DATE)
    private LocalDate birthDate;

    @Column(name = "PATIENT_GENDER")    
    @Enumerated(EnumType.STRING)
    private PatientGender gender;

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


    /**
     * Get the value of id
     *
     * @return the value of id
     */
    public Long getId() {
        return id;
    }

    /**
     * Set the value of id
     *
     * @param id new value of id
     */
    public void setId(Long id) {
        this.id = id;
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
