/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DataAccessLayer;

import TransferObject.Book;

/**
 *
 * @author ch-sa
 */
public interface IBookDAO {

    Book getBook(int id);
    
}
