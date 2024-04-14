/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.ashevkar.service;

import edu.iit.sat.itmd4515.ashevkar.domain.Appointment;
import edu.iit.sat.itmd4515.ashevkar.domain.Doctor;
import edu.iit.sat.itmd4515.ashevkar.domain.Hospital;
import edu.iit.sat.itmd4515.ashevkar.domain.Nurse;
import edu.iit.sat.itmd4515.ashevkar.domain.Patient;
import edu.iit.sat.itmd4515.ashevkar.domain.PatientGender;
import edu.iit.sat.itmd4515.ashevkar.security.Group;
import edu.iit.sat.itmd4515.ashevkar.security.GroupService;
import edu.iit.sat.itmd4515.ashevkar.security.User;
import edu.iit.sat.itmd4515.ashevkar.security.UserService;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.logging.Logger;

/**
 *
 * @author ashevkar
 */
@Startup
@Singleton
public class StartupDBInitializer {
    
    private static final Logger LOG = Logger.getLogger(StartupDBInitializer.class.getName());
    //non-owning side of the relationship
    @EJB 
    HospitalService hospitalSvc;
    //owning side of the relationship
    @EJB 
    PatientService patientSvc;
    @EJB 
    DoctorService doctorSvc;
    @EJB 
    AppointmentService appointmentSvc;
    @EJB 
    NurseService nurseSvc;

    @EJB
    UserService userSvc;
    @EJB
    GroupService groupSvc;
    
    public StartupDBInitializer() {
    }
    
    @PostConstruct
    private void postConstruct(){
        LOG.info("StartupDBInitializer.postConstruct");
        
        Group hospitalGroup = new Group("HOSPITAL_GROUP","Security realm hospital group");
        Group patientGroup = new Group("PATIENT_GROUP","Security realm patient group");        
        Group adminGroup = new Group("ADMIN_GROUP","Security realm admin user");
        
        groupSvc.create(adminGroup);
        groupSvc.create(hospitalGroup);
        groupSvc.create(patientGroup);
        
        User hospital1 = new User("hospital1","hospital1");
        hospital1.addGroup(hospitalGroup);
        hospital1.addGroup(adminGroup);
        userSvc.create(hospital1);
         
        User hospital2 = new User("hospital2","hospital2");
        hospital2.addGroup(hospitalGroup);
        userSvc.create(hospital2);
        
        User hospital3 = new User("hospital3","hospital3");
        hospital3.addGroup(hospitalGroup);
        userSvc.create(hospital3);
                
        User patient1 = new User("patient1","patient1");
        patient1.addGroup(patientGroup);
        userSvc.create(patient1);

        User admin = new User("admin","admin");
        admin.addGroup(adminGroup);
        userSvc.create(admin);
                    
        Patient p1= new Patient("Nehal", LocalDate.of(1999,11,10), PatientGender.MALE);
        p1.setUser(patient1);
        Patient p2= new Patient("Aishwarya", LocalDate.of(1998,11,6), PatientGender.FEMALE);
        
//        p2.addHospital(h1);
        Patient p3= new Patient("Saniya", LocalDate.of(2000,2,28), PatientGender.FEMALE);
//        p3.addHospital(h1);
        Patient p4= new Patient("Yash", LocalDate.of(2002,8,30), PatientGender.MALE);
//        p4.addHospital(h2);
        Patient p5= new Patient("Jai", LocalDate.of(1997,7,17), PatientGender.MALE);
//        p5.addHospital(h2);
        
        patientSvc.create(p1);
        patientSvc.create(p2);
        patientSvc.create(p3);
        patientSvc.create(p4);
        patientSvc.create(p5);
        
        Hospital h1= new Hospital("Insight Hospital","2525 S Michigan Ave", "3125672000");
        h1.addPatient(p1);
        h1.addPatient(p5);
        h1.setUser(hospital1);
        Hospital h2= new Hospital("Northwestern Memorial Hospital", "251 E Huron St" ,  "3129262000");
        h2.addPatient(p2);
        h2.addPatient(p4);
        h2.setUser(hospital2);
        Hospital h3= new Hospital("Noble Hospital","2123 S Roger park", "8726642261");
        h3.addPatient(p3);
        h3.setUser(hospital3);

        hospitalSvc.create(h1);
        hospitalSvc.create(h2);
        hospitalSvc.create(h3);
        
        Doctor d1 = new Doctor("Nitin", "Neurology", 7324732647L);
        d1.setHospital(h1);
        Doctor d2 = new Doctor("Lata", "Orthopedics", 9422314917L);
        d2.setHospital(h2);
        Doctor d3 = new Doctor("Sunil", "Urology", 9420697107L);
        d3.setHospital(h2);
        Doctor d4 = new Doctor("Priya", "Cardiology", 7709353388L);
        d4.setHospital(h1);
        
        doctorSvc.create(d1);
        doctorSvc.create(d2);
        doctorSvc.create(d3);
        doctorSvc.create(d4);
        
        Appointment a1 = new Appointment(LocalDate.of(2024, 6, 11), LocalTime.of(10, 45));
        a1.scheduleApt(d4, p2);
        Appointment a2 = new Appointment(LocalDate.of(2024, 7, 20), LocalTime.of(8, 30));
        a2.scheduleApt(d1, p3);
        Appointment a3 = new Appointment(LocalDate.of(2024, 8, 12), LocalTime.of(10, 45));
        a3.scheduleApt(d3, p4);
        Appointment a4 = new Appointment(LocalDate.of(2024, 6, 15), LocalTime.of(8, 30));
        a4.scheduleApt(d2, p5);
        
        appointmentSvc.create(a1);
        appointmentSvc.create(a2);
        appointmentSvc.create(a3);
        appointmentSvc.create(a4);

        
        Nurse n1= new Nurse("Nisha");
        nurseSvc.create(n1);
        Nurse n2= new Nurse("Shirin");
        nurseSvc.create(n2);
        
            LOG.info("---------------------------Entities and their JPA relationship------------------------------");
        
        for( Doctor d : doctorSvc.findAll()){
            LOG.info("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");

            LOG.info("\t"+ d.toString());
            
            LOG.info("\t-------------------------Unidirectional 1:1 with Hospital--------------------------------");
            LOG.info("\t" + d.getHospital().toString());
            
            LOG.info("\t------------------------Bidirectional 1:M with Appointment-----------------------------");
            
            for(Appointment a : d.getAppointments()){
                LOG.info("\t" + a.toString());
            }
        }
    }
}
