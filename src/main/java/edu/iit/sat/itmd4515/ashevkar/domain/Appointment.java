 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.ashevkar.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.validation.constraints.FutureOrPresent;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

/**
 *
 * @author ashevkar
 */
@Entity 
@NamedQuery(name = "Appointment.findAll", query = "select a from Appointment a")
public class Appointment extends AbstractEntity{
    
    @FutureOrPresent
    @Column(name = "APPOINTMENT_DATE")
    private LocalDate date;
    
    @Column(name = "APPOINTMENT_TIME")
    private LocalTime time;

//    1:M/M:1 bidirectional relationship
//    M:1 is always the owning side
//    Appointment is the owner of this relationship
//    Patient_id is the FK
    @ManyToOne
    @JoinColumn(name = "PATIENT_ID")
    private Patient patient;
    
//    1:M/M:1 bidirectional relationship
//    M:1 is always the owning side
//    Appointment is the owner of this relationship
//    Doctor_id is the FK
    @ManyToOne
    @JoinColumn(name = "DOCTOR_ID")
    private Doctor doctor;

    
    public Doctor getDoctor() {
        return doctor;
    }

    
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    
    
    public Patient getPatient() {
        return patient;
    }
    
    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    
    public Appointment(LocalDate date, LocalTime time) {
        this.date = date;
        this.time = time;
    }

    public Appointment() {
    }
    
    //helper method to manage jpa
    public void scheduleApt(Doctor d, Patient p){
        this.doctor= d;
        this.patient= p;
        
        if(!p.getAppointments().contains(this)){
            p.getAppointments().add(this);
        }
        if(!d.getAppointments().contains(this)){
            d.getAppointments().add(this);
        }
    }
    public void cancelApt(){
        if(this.patient.getAppointments().contains(this)){
            this.patient.getAppointments().remove(this);
        }
        if(this.doctor.getAppointments().contains(this)){
            this.doctor.getAppointments().remove(this);
        }     
    }

    @Override
    public String toString() {
        return "Appointment{" + "date=" + date + ", time=" + time + ", patient=" + patient + ", doctor=" + doctor + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.id);
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
        final Appointment other = (Appointment) obj;
        
        if(this.id == null || other.id == null){
            return false;
        }
        
        return Objects.equals(this.id, other.id);
    }

    
    
    public LocalDate getDate() {
        return date;
    }

    
    public void setDate(LocalDate date) {
        this.date = date;
    }

    
    public LocalTime getTime() {
        return time;
    }

    
    public void setTime(LocalTime time) {
        this.time = time;
    }

       
}
