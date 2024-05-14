/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package DataAccessLayer;

import TransferObject.Book;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ch-sa
 */
public class BookDAOTest {
    
 
    @Test
    public void testGetBook() {
        System.out.println("getBook");
        int id = 1;
       BookDAO bookDAO = new BookDAO();
       Book expectedBook = bookDAO.getBook(1);
       Book resultBook = bookDAO.getBook(id);
       assertEquals(expectedBook.getName(),resultBook.getName());
        
    }
     @Test
    public void testGetBookWrongId() {
       System.out.println("getBook");
       int id = 0;
       BookDAO bookDAO = new BookDAO();
       Book resultBook = bookDAO.getBook(id);
       assertNull(resultBook);
        
    }
    
}

