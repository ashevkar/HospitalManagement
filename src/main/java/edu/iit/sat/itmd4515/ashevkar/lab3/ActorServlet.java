/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.ashevkar.lab3;

import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

/**
 *
 * @author ashevkar
 */
@WebServlet(name = "ActorServlet", urlPatterns = {"/actor", "/act", "/a"})
public class ActorServlet extends HttpServlet {

    @Resource
    Validator validator;
    
    @Resource(name = "java:app/jdbc/itmd4515DS")
    DataSource ds;
    
    private static final Logger LOG = Logger.getLogger(ActorServlet.class.getName());

    public ActorServlet() {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("ActorServlet inside doPost");
        
        String actIdParam = req.getParameter("actId");
        String actFirstNameParam = req.getParameter("firstName");
        String actLastNameParam = req.getParameter("lastName");
        
        LOG.info("actIdParam\t\t" + actIdParam);
        LOG.info("actFirstNameParam\t\t" + actFirstNameParam);
        LOG.info("actLastNameParam\t\t" + actLastNameParam);
        
        
        Integer actId = null;
        
        if(actIdParam != null && !actIdParam.isBlank()){
            actId = Integer.parseInt(actIdParam); 
        }
        Actor a = new Actor(actId, actFirstNameParam, actLastNameParam);
        
        Set<ConstraintViolation<Actor>> violations = validator.validate(a);
        
        if(violations.size() > 0){
            
            LOG.info("Actor has failed validation. These are the voilations: ");
            for (ConstraintViolation<Actor> violation : violations) {
                LOG.info(violation.toString());
            }
            
            req.setAttribute("actor", a);
            req.setAttribute("violations", violations);
            RequestDispatcher rd = req.getRequestDispatcher("actor.jsp");
            rd.forward(req, resp);
            
            
        }else {
            LOG.info("Actor has Passed validation.");
            
            createAActor(a);
            
            req.setAttribute("actor", a);
            RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/confirmation.jsp");
            rd.forward(req, resp);
        }

        LOG.info("Built Actor POJO post-conversion values:\t\t" + a.toString());
    }
    
    
      private void createAActor(Actor a) {
        String query = "insert into actor "
                + "(actor_id, first_name, last_name) "
                + "values (?,?,?)";

        try (
                Connection con = ds.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {

            ps.setInt(1, a.getId());
            ps.setString(2, a.getFirstName());
            ps.setString(3, a.getLastName());
        

            ps.executeUpdate();
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }
    }
    
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("ActorServlet inside doGet");
        resp.sendRedirect(req.getContextPath() + "/actor.jsp");

    }
    
}
