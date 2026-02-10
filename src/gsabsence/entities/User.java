/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gsabsence.entities;

/**
 *
 * @author badz_
 */
public class User {

    private int id;
    private String userName;
    private String email;
    private String passeWord;

    public User(int id, String userName, String _email, String passeWord) {
        this.id = id;
        this.userName = userName;
        this.passeWord = passeWord;
        this.email = _email;
    }

    public User() {

    }

    public User(String userName, String _email, String passeWord) {
        this.userName = userName;
        this.email = _email;
        this.passeWord = passeWord;
    }

    @Override
    public String toString() {
        return "Bienvenu " + getUserName()  ;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the passeWord
     */
    public String getPasseWord() {
        return passeWord;
    }

    /**
     * @param passeWord the passeWord to set
     */
    public void setPasseWord(String passeWord) {
        this.passeWord = passeWord;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

}
