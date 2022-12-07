/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package managementparksystems.business.abstracts;

import java.util.List;
import managementparksystems.entities.concretes.Personel;


/**
 *
 * @author Volkan
 */
public interface PersonelService {
    void getAllPersonel();
    List<Personel> getAll();
    List<Personel> searchPersonel(String whatSrch,String srcKey);
    String[] searchMember(String memberNo,String tcNo);
    int editMember(String tcNo,String firstName,String lastName);
    String[] alternateSearchMember(String memberNo);
    int addNewMember(String memberNo,String tcNo,String name,String surname);
    int deleteMemberWithTcNo(String tcNo,String name,String surname);
}
