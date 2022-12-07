/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package managementparksystems.entities.concretes;

/**
 *
 * @author Volkan
 */
public class Toy {
    private int id;
    private String toyName;
    private String toyBelongsTo;

   
    public Toy(){}
    public Toy(int id, String toyName, String toyBelongsTo){
        
      this.id = id;
      this.toyName = toyName;
      this.toyBelongsTo = toyBelongsTo;
    }
    
    
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the toyName
     */
    public String getToyName() {
        return toyName;
    }

    /**
     * @param toyName the toyName to set
     */
    public void setToyName(String toyName) {
        this.toyName = toyName;
    }

    /**
     * @return the toyBelongsTo
     */
    public String getToyBelongsTo() {
        return toyBelongsTo;
    }

    /**
     * @param toyBelongsTo the toyBelongsTo to set
     */
    public void setToyBelongsTo(String toyBelongsTo) {
        this.toyBelongsTo = toyBelongsTo;
    }
    
}
