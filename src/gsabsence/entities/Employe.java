package gsabsence.entities;

import java.util.Date;

public class Employe {

    private int id;
    private String nom;
    private String departement;
    private String post;

    public Employe(int id, String nom, String departemant, String post) {
        this.id = id;
        this.nom = nom;
        this.departement = departemant;
        this.post = post;
    }

    public Employe(String nom, String departemant, String post) {
        this.nom = nom;
        this.departement = departemant;
        this.post = post;
    }

    @Override
    public String toString() {
        return "Etudiant [id=" + getId() + ", nom=" + getNom() + ", departemant=" + departement + ", post=" + post + "]";
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the departement
     */
    public String getDepartement() {
        return departement;
    }

    /**
     * @param departement the departement to set
     */
    public void setDepartement(String departement) {
        this.departement = departement;
    }

    /**
     * @return the post
     */
    public String getPost() {
        return post;
    }

    /**
     * @param post the post to set
     */
    public void setPost(String post) {
        this.post = post;
    }

}
