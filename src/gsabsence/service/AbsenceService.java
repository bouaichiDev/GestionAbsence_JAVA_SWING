/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gsabsence.service;

import gsabsence.connexion.Connexion;
import gsabsence.dao.IDao;
import gsabsence.entities.Absence;
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
public class AbsenceService implements IDao<Absence> {

    @Override
    public boolean create(Absence o) {
        String sql = "INSERT INTO absence (employe_id, type_absence_id, date_debut, date_fin) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = Connexion.getConnection().prepareStatement(sql);
            ps.setInt(1, o.getEmploye().getId());
            ps.setInt(2, o.getTypeAbsemce().getId());
            ps.setDate(3, new java.sql.Date(o.getDateDebut().getTime()));
            ps.setDate(4, new java.sql.Date(o.getDateFin().getTime()));
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Absence o) {
        String sql = "DELETE FROM absence WHERE id = ?";
        try {
            PreparedStatement ps = Connexion.getConnection().prepareStatement(sql);
            ps.setInt(1, o.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Absence o) {
        String sql = "UPDATE absence SET date_debut=?, date_fin=?, type_absence_id=? WHERE id=?";
        try {
            PreparedStatement ps = Connexion.getConnection().prepareStatement(sql);
            ps.setDate(1, new java.sql.Date(o.getDateDebut().getTime()));
            ps.setDate(2, new java.sql.Date(o.getDateFin().getTime()));
            ps.setInt(3, o.getTypeAbsemce().getId());
            ps.setInt(4, o.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Absence> findAll() {
        List<Absence> list = new ArrayList<>();
        String sql = "SELECT * FROM absence";
        try {
            Statement st = Connexion.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Employe e = new EmployeService().findById(rs.getInt("employe_id"));
                TypeAbsence t = new typeAbsenceService().findById(rs.getInt("type_absence_id"));

                list.add(new Absence(
                            rs.getInt("id"),
                            e,
                            t,
                            rs.getDate("date_debut"),
                            rs.getDate("date_fin")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
 
    public  List<Absence> findAllByEmplye( int id) {
        List<Absence> list = new ArrayList<>();
        String sql = "SELECT * FROM absence  WHERE employe_id=?";
        try {
            PreparedStatement ps = Connexion.getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Employe e = new EmployeService().findById(rs.getInt("employe_id"));
                TypeAbsence t = new typeAbsenceService().findById(rs.getInt("type_absence_id"));

                list.add(new Absence(
                            rs.getInt("id"),
                            e,
                            t,
                            rs.getDate("date_debut"),
                            rs.getDate("date_fin")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    @Override
    public Absence findById(int id) {
        String sql = "SELECT * FROM absence WHERE id=?";
        try {
            PreparedStatement ps = Connexion.getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Employe e = new EmployeService().findById(rs.getInt("employe_id"));
                TypeAbsence t = new typeAbsenceService().findById(rs.getInt("type_absence_id"));

                return new Absence(
                            rs.getInt("id"),
                            e,
                            t,
                            rs.getDate("date_debut"),
                            rs.getDate("date_fin")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
 

}
