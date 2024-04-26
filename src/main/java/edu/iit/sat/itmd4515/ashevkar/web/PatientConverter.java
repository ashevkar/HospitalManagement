/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.ashevkar.web;

import edu.iit.sat.itmd4515.ashevkar.domain.Patient;
import edu.iit.sat.itmd4515.ashevkar.service.PatientService;
import jakarta.ejb.EJB;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 *
 * @author ashevkar
 */
@FacesConverter(value = "patientConverter", managed=true)
public class PatientConverter implements Converter<Patient>{
    @EJB PatientService patientSvc;
    @Override
    public Patient getAsObject(FacesContext context, UIComponent component, String value) {
        return patientSvc.read(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Patient value) {
        return String.valueOf(value.getId());
    }
    
}
