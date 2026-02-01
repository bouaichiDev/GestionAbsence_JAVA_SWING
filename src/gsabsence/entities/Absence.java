/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gsabsence.entities;

import java.util.Date;

/**
 *
 * @author badz_
 */
public class Absence {

    private Employe employe;
    private TypeAbsence typeAbsemce;
    private Date dateDebut;
    private Date dateFin;

    @Override
    public String toString() {
        return " Absence info : Employe " + this.employe.getNom() + " Post :" + this.employe.getPost() + " date : " + this.dateDebut + " Au " + this.dateFin;
    }

    public Absence(Employe em, TypeAbsence ta, Date debut, Date fin) {

        this.employe = em;
        this.typeAbsemce = ta;
        this.dateDebut = debut;
        this.dateFin = fin;
    }

    /**
     * @return the employe
     */
    public Employe getEmploye() {
        return employe;
    }

    /**
     * @return the typeAbsemce
     */
    public TypeAbsence getTypeAbsemce() {
        return typeAbsemce;
    }

    /**
     * @return the dateDebut
     */
    public Date getDateDebut() {
        return dateDebut;
    }

    /**
     * @param dateDebut the dateDebut to set
     */
    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    /**
     * @return the dateFin
     */
    public Date getDateFin() {
        return dateFin;
    }

    /**
     * @param dateFin the dateFin to set
     */
    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

}
