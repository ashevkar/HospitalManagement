/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.ashevkar.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author ashevkar
 */
@Entity
@NamedQuery(name = "Doctor.findAll", query = "select d from Doctor d")
public class Doctor {
//    serves as the primary key.
    @Id         
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DOCTOR_ID")
    private Long id;
    
//    bean validation   
    @NotBlank        
    @Column(name = "DOCTOR_NAME")
    private String name;
    
    @Column(name = "DOCTOR_SPECIALIZATION")
    private String specialization;  
    
//    bean validation   
//    @Pattern(regexp="\\(\\d{3}\\)\\d{3}-\\d{4}")    
    @Column(name = "CONTACT_NUMBER")
    private Long contactNumber;
    
//    temporal data type
//    @FutureOrPresent
    @Column(name = "AVAILABLE_DATE")
    private LocalDate availableDate;
    
//    1:1 unidirectional relationship b/w doctor and hospital
//    Doctor is the owning side of this realtionship
    @OneToOne
    @JoinColumn(name = "HOSPITAL_ID")
    private Hospital hospital;
    
    
//    1:M/M:1 bidirectional relationship
//    M:1 is always the owning side
//    Appointment is the owner of this relationship
    @OneToMany(mappedBy= "doctor")
    private List<Appointment> appointments = new ArrayList<>();
    
    
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
     * Get the value of hospital
     *
     * @return the value of hospital
     */
    public Hospital getHospital() {
        return hospital;
    }

    /**
     * Set the value of hospital
     *
     * @param hospital new value of hospital
     */
    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    /**
     * Get the value of availableDate
     *
     * @return the value of availableDate
     */
    public LocalDate getAvailableDate() {
        return availableDate;
    }

    /**
     * Set the value of availableDate
     *
     * @param availableDate new value of availableDate
     */
    public void setAvailableDate(LocalDate availableDate) {
        this.availableDate = availableDate;
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
     * Get the value of specialization
     *
     * @return the value of specialization
     */
    public String getSpecialization() {
        return specialization;
    }

    /**
     * Set the value of specialization
     *
     * @param specialization new value of specialization
     */
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
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

//    constructor
    public Doctor(String name, String specialization, Long contactNumber, LocalDate availableDate) {
        this.name = name;
        this.specialization = specialization;
        this.contactNumber = contactNumber;
        this.availableDate = availableDate;
    }
//    constructor
    public Doctor() {
    }
    
    
    
        @Override
    public String toString() {
        return "Doctor{" + "id=" + id + ", name=" + name + ", specialization=" + specialization + ", contactNumber=" + contactNumber + ", availableDate=" + availableDate + '}';
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final Doctor other = (Doctor) obj;
        if(this.id == null || other.id == null){
            return false;
        }
        
        return Objects.equals(this.id, other.id);
    }
}
