/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package managementparksystems.entities.concretes;

/**
 *
 * @author Volkan
 */
public class Personel {
    private int id;
    private String firstName;
    private String lastName;
    private String TcNo;
    private String memberNo;
    private String workPosition;
    private String year; 
    private String salary;

    
    public Personel(){
    }
    public Personel(int id, String ad, String soyad, String tcno, String uyeNo, String pozisyon, String dogumYil, String maas){
        this.id = id;
        this.firstName = ad;
        this.lastName = soyad;
        this.TcNo = tcno;
        this.memberNo = uyeNo;
        this.workPosition = pozisyon;
        this.year = dogumYil;
        this.salary = maas;
    }

    public Personel(String ad, String soyad, String yil) {
        this.firstName = ad;
        this.lastName = soyad;
        this.year = yil;
    }

    
    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the TcNo
     */
    public String getTcNo() {
        return TcNo;
    }

    /**
     * @param TcNo the TcNo to set
     */
    public void setTcNo(String TcNo) {
        this.TcNo = TcNo;
    }

    /**
     * @return the memberNo
     */
    public String getMemberNo() {
        return memberNo;
    }

    /**
     * @param memberNo the memberNo to set
     */
    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo;
    }

    /**
     * @return the workPosition
     */
    public String getWorkPosition() {
        return workPosition;
    }

    /**
     * @param workPosition the workPosition to set
     */
    public void setWorkPosition(String workPosition) {
        this.workPosition = workPosition;
    }

    /**
     * @return the year
     */
    public String getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * @return the salary
     */
    public String getSalary() {
        return salary;
    }

    /**
     * @param salary the salary to set
     */
    public void setSalary(String salary) {
        this.salary = salary;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
    
}
