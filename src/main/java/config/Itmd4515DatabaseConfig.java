/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import jakarta.annotation.sql.DataSourceDefinition;
import jakarta.enterprise.context.ApplicationScoped;

/**
 *
 * @author ashevkar
 */

@ApplicationScoped
@DataSourceDefinition(
        name="java:app/jdbc/itmd4515DS",
        className="com.mysql.cj.jdbc.MysqlDataSource",
        serverName= "localhost",
        portNumber= 3306,
        databaseName= "sakila",
        user= "itmd4515",
        password = "itmd4515",
        properties = {
            "zeroDateTimeBehavior=CONVERT_TO_NULL",
            "useSSL= false"
        }        
)

public class Itmd4515DatabaseConfig {  
}