/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.ashevkar.web;

import edu.iit.sat.itmd4515.ashevkar.domain.Doctor;
import edu.iit.sat.itmd4515.ashevkar.service.DoctorService;
import jakarta.ejb.EJB;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 *
 * @author ashevkar
 */
@FacesConverter(value = "doctorConverter", managed = true)
public class DoctorConverter implements Converter<Doctor> {

    @EJB DoctorService doctorSvc;
    @Override
    public Doctor getAsObject(FacesContext context, UIComponent component, String value) {
        return doctorSvc.read(Long.valueOf(value));            
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Doctor value) {
        return String.valueOf(value.getId());
    }
    
}
