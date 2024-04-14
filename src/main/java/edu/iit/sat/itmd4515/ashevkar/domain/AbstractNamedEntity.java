/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.ashevkar.domain;

import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotBlank;

/**
 *
 * @author ashevkar
 */
@MappedSuperclass
public class AbstractNamedEntity extends AbstractEntity{
    @NotBlank           
    protected String name;
      
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
