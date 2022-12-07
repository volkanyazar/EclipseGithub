/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package managementparksystems.business.abstracts;

import java.util.List;
import managementparksystems.entities.concretes.Toy;

/**
 *
 * @author Volkan
 */
public interface ToyService extends ConnectionService{
    List<Toy> getEmptyToys();
    String [] getToysForPersonel(String memberNo);
    int removeToyFromPersonel(String toyName,String memberNo);
    int addToyToPersonel(String toyName,String memberNo);
}
