/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package BusinessLogicLayer;

import TransferObject.Research;

/**
 *
 * @author ch-sa
 */
public interface IMergerResearch {

    boolean mergeResearches(String name, Research research1, Research research2);
    
}
