/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hostel.managment.system;

/**
 *
 * @author Kamrul
 */
public class ModelTable {
     String mobilenumber,name,father, mother, email, address, collage ,idnumber ,roomnumber ,status;
     
    public ModelTable(String mobilenumber, String name, String father, String mother, String email, String address, String collage, String idnumber, String roomnumber, String status) {
        this.mobilenumber = mobilenumber;
        this.name = name;
        this.father = father;
        this.mother = mother;
        this.email = email;
        this.address = address;
        this.collage = collage;
        this.idnumber = idnumber;
        this.roomnumber = roomnumber;
        this.status = status;
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public String getMother() {
        return mother;
    }

    public void setMother(String mother) {
        this.mother = mother;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCollage() {
        return collage;
    }

    public void setCollage(String collage) {
        this.collage = collage;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    public String getRoomnumber() {
        return roomnumber;
    }

    public void setRoomnumber(String roomnumber) {
        this.roomnumber = roomnumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
       
String numberdb,activatedb,statussdb;
    public ModelTable(String numberdb, String activatedb, String statussdb) {
        this.numberdb = numberdb;
        this.activatedb = activatedb;
        this.statussdb = statussdb;
    }

    public String getNumberdb() {
        return numberdb;
    }

    public void setNumberdb(String numberdb) {
        this.numberdb = numberdb;
    }

    public String getActivatedb() {
        return activatedb;
    }

    public void setActivatedb(String activatedb) {
        this.activatedb = activatedb;
    }

    public String getStatussdb() {
        return statussdb;
    }

    public void setStatussdb(String statussdb) {
        this.statussdb = statussdb;
    }
String Monthdb,AmountDb;

    public ModelTable(String Monthdb, String AmountDb) {
        this.Monthdb = Monthdb;
        this.AmountDb = AmountDb;
    }

    public String getMonthdb() {
        return Monthdb;
    }

    public void setMonthdb(String Monthdb) {
        this.Monthdb = Monthdb;
    }

    public String getAmountDb() {
        return AmountDb;
    }

    public void setAmountDb(String AmountDb) {
        this.AmountDb = AmountDb;
    }

   
}
