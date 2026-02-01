/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gsabsence.service;

import gsabsence.connexion.Connexion;
import gsabsence.entities.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author badz_
 */
public class userService {

    public User auth(String userName, String passeword) {
        String req = "select * from User where username  = ?  ";
        try {
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setString(1, userName);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String hashedPassword = rs.getString("passeword");
                if (BCrypt.checkpw(passeword, hashedPassword)) {
                    return new User(
                                rs.getInt("id"),
                                rs.getString("username"),
                                rs.getString("email"),
                                hashedPassword
                    );
                }
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }

    public boolean register(String username, String email, String password) {

        String sql = "INSERT INTO User(username, email, passeword) VALUES (?, ?, ?)";

        try {
            String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

            PreparedStatement ps = Connexion.getConnection().prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, email);
            ps.setString(3, hashedPassword);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean emailExists(String email) {

        String sql = "SELECT id FROM User WHERE email = ?";

        try {
            PreparedStatement ps = Connexion.getConnection().prepareStatement(sql);
            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();
            return rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean resetPassword(String email, String newPassword) {

        String sql = "UPDATE User SET passeword = ? WHERE email = ?";

        try {
            String hashedPassword = BCrypt.hashpw(newPassword, BCrypt.gensalt());

            PreparedStatement ps = Connexion.getConnection().prepareStatement(sql);
            ps.setString(1, hashedPassword);
            ps.setString(2, email);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
