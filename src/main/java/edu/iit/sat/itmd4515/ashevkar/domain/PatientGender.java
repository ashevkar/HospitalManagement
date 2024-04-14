/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package edu.iit.sat.itmd4515.ashevkar.domain;

/**
 *
 * @author ashevkar
 */
public enum PatientGender {
    MALE("Male"), 
    FEMALE("Female"), 
    OTHER("Other");
    
    private String label;

    private PatientGender(String label) {
        this.label = label;
    }
    
    public String getLabel(){
        return label;
    }
}
