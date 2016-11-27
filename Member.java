/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author RickyL
 */
public class Member {
    
  private String id;
    private String password;
    private String status;

    public Member() {
    }

    
    public Member(String id, String password, String status) {
        this.id = id;
        this.password = password;
        this.status = status;
    }

    public void setId(String id) {
        this.id = id;
    }

    
    public String getId() {
        return id;
    }

     public void setPassword(String password) {
        this.password = password;
    }
     
    public String getPassword() {
        return password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
   
}
