/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gsabsence.service;

import gsabsence.connexion.Connexion;
import gsabsence.dao.IDao;
import gsabsence.entities.Employe;
import gsabsence.entities.TypeAbsence;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author badrBouaichi
 */
public class typeAbsenceService implements IDao<TypeAbsence> {

    @Override
    public boolean create(TypeAbsence o) {
        String req = "INSERT INTO `type_absence` (`id`, `libelle`, `justification`) VALUES (NULL, "
                    + " '" + o.getLibelle() + "', '" + o.getJustification() + "')";
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
    public boolean delete(TypeAbsence o) {
        String req = "delete from type_absence where id = ?";
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
    public boolean update(TypeAbsence o) {
        String req = "UPDATE `type_absence` SET `libelle` = ?, `justification` = ?  WHERE `id` = ?";
        int etat = 0;

        try {
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setString(1, o.getLibelle());
            ps.setString(2, o.getJustification());
            ps.setInt(3, o.getId());

            etat = ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return (etat == 0) ? false : true;
    }

    @Override
    public List<TypeAbsence> findAll() {
        List<TypeAbsence> typeAbsences = new ArrayList<>();
        String req = "SELECT * FROM type_absence";

        try {
            Statement st = Connexion.getConnection().createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                TypeAbsence e = new TypeAbsence(
                            rs.getInt("id"),
                            rs.getString("libelle"),
                            rs.getString("justification")
                );
                typeAbsences.add(e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return typeAbsences;
    }

    @Override
    public TypeAbsence findById(int id) {
        String req = "select * from type_absence where id  = ?";
        try {
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new TypeAbsence(rs.getInt("id"), rs.getString("libelle"), rs.getString("justification"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }

}
