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
public class TypeAbsence {

    private int id;
    private String libelle;
    private String justification;

    public TypeAbsence(int id,String libelle,String justification)
    {
        this.id=id;
        this.libelle=libelle;
        this.justification=justification;
    }
    public TypeAbsence( String libelle,String justification)
    {
         
        this.libelle=libelle;
        this.justification=justification;
    }
    @Override
    public String toString()
    {
        return "TypeAbsence [id=" + getId() + "]";
    }
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the libelle
     */
    public String getLibelle() {
        return libelle;
    }

    /**
     * @param libelle the libelle to set
     */
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    /**
     * @return the justification
     */
    public String getJustification() {
        return justification;
    }

    /**
     * @param justification the justification to set
     */
    public void setJustification(String justification) {
        this.justification = justification;
    }
    
    

}
