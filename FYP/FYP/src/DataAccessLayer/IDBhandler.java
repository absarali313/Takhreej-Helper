/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DataAccessLayer;

import java.sql.Connection;

/**
 *
 * @author Remal
 */
public interface IDBhandler {

    Connection getConnection();
    
}
