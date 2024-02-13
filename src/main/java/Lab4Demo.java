
import edu.iit.sat.itmd4515.ashevkar.domain.Patient;
import edu.iit.sat.itmd4515.ashevkar.domain.PatientGender;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.time.LocalDate;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ashevkar
 */
public class Lab4Demo {
    
    public static void main(String  ... args){
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("itmd4515testPU");
        
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx= em.getTransaction();
        
        Patient p1= new Patient("Ruchika", LocalDate.of(2010, 11, 11), PatientGender.FEMALE);
        
        System.out.println("Example: Patient.toString() Before : " + p1.toString());

        tx.begin();
        em.persist(p1);
        tx.commit();

        System.out.println("Example: Patient.toString() After : " + p1.toString());

        
        em.close();
        emf.close();
        
    }
}
