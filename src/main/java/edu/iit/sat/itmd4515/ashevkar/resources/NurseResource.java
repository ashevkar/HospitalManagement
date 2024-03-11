/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.ashevkar.resources;

import edu.iit.sat.itmd4515.ashevkar.domain.Nurse;
import edu.iit.sat.itmd4515.ashevkar.service.NurseService;
import jakarta.ejb.EJB;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author ashevkar
 */
@Path("/hospitals/nurse")
public class NurseResource {
    
    private static final Logger LOG = Logger.getLogger(NurseResource.class.getName());
    
    @EJB 
    NurseService nurseSvc;
    
    @GET
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public List<Nurse> getAllNurse(){
        return nurseSvc.findAll();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})

    public Nurse createNewNurse(Nurse n){
        nurseSvc.create(n);
        LOG.info("Create a new Nurse with"+ n.toString());
        return n;
    }
    
    @GET
    @Path("/id/{id}")
    public Nurse getNurseById(@PathParam("id")Long id){
        return nurseSvc.read(id);
    }
}
 