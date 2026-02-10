package gsabsence.service;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.List;

import gsabsence.connexion.Connexion;
import gsabsence.dao.IDao;
import gsabsence.entities.Employe;
import java.util.ArrayList;

/**
 *
 * @author badrBouaichi
 */
public class EmployeService implements IDao<Employe> {

    @Override
    public boolean create(Employe o) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String req = "INSERT INTO `Employe` (`id`, `nom`, `departement`, `poste`) VALUES (NULL, '" + o.getNom()
                    + "', '" + o.getDepartement() + "', '" + o.getPost() + "')";
        int etat = 0;
        try {
            Statement st = Connexion.getConnection().createStatement();
            etat = st.executeUpdate(req);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (etat == 0) ? false : true;
    }

    @Override
    public boolean delete(Employe o) {

        String req = "delete from Employe where id = ?";
        int etat = 0;
        try {
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setInt(1, o.getId());
            etat = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (etat == 0) ? false : true;
    }

    @Override
    public boolean update(Employe o) {
        String req = "UPDATE `Employe` SET `nom` = ?, `departement` = ?, `poste` = ? WHERE `id` = ?";
        int etat = 0;

        try {
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setString(1, o.getNom());
            ps.setString(2, o.getDepartement());
            ps.setString(3, o.getPost());
            ps.setInt(4, o.getId());

            etat=ps.executeUpdate();
             
        } catch (SQLException e) {
             System.out.println(e.getMessage()); 
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return (etat == 0) ? false : true;
    }

    @Override
    public List<Employe> findAll() {
        List<Employe> employes = new ArrayList<>();
        String req = "SELECT * FROM Employe";

        try {
            Statement st = Connexion.getConnection().createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                Employe e = new Employe(
                            rs.getInt("id"),
                            rs.getString("nom"),
                            rs.getString("departement"),
                            rs.getString("poste")
                );
                employes.add(e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employes;
    }

    @Override
    public Employe findById(int id) {
        String req = "select * from Employe where id  = ?";
        try {
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Employe(rs.getInt("id"), rs.getString("nom"), rs.getString("departement"),
                            rs.getString("poste"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }

}
