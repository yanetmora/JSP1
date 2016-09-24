/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profesores.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import profesores.model.ActividadProfesor;
import profesores.model.Profesor;
import profesores.util.UtilDB;

/**
 *
 * @author Yanet
 */
public class ActividadProfesorDAOImp implements ActividadProfesorDAO {

    private Connection connection;

    public ActividadProfesorDAOImp() {
        connection = UtilDB.getConnection();

    }

    @Override
    public void agregarActividadProfesor(ActividadProfesor actividadprofesor) {
        String sql = "INSERT INTO actividadesprofesores (horasAsoganadas,actividad,maestro,periodo)"
                + " VALUES (?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setFloat(1, actividadprofesor.getHoraAsignadas());
            ps.setString(2, actividadprofesor.getActividad());
            ps.setString(3,actividadprofesor.getMaestro());
            ps.setInt(4, actividadprofesor.getPeriodo());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void borrarActividadProfesor(int idActividad) {
        String sql = "DELETE FROM actividadadesprofesores WHERE id_actividad=? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, idActividad);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    

    @Override
    public void cambiarActividadProfesor(ActividadProfesor actividadprofesor) {
        String sql = "UPDATE profesores SET horasAsignadas=?, actividad=?, maestro=?  periodo=?"
                + "WHERE id_actividad=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setFloat(1, actividadprofesor.getHoraAsignadas());
            ps.setString(2, actividadprofesor.getActividad());
            ps.setString(3, actividadprofesor.getMaestro());
            ps.setInt(4, actividadprofesor.getPeriodo());
            ps.setInt(5, actividadprofesor.getIdActividad());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ActividadProfesor> desplegarActividadesProfesores() {
        List<ActividadProfesor> actividadesprofesores = new ArrayList<ActividadProfesor>();
        try {
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM actividadesprofesores");
            while (rs.next()) {

                ActividadProfesor Actividadprofesor = new ActividadProfesor(rs.getInt("id_actividad"),
                        rs.getFloat("horasAsignadas"),
                        rs.getString("actividad"),
                        rs.getString("maestro"),
                        rs.getInt("periodo"));
                actividadesprofesores.add(Actividadprofesor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return actividadesprofesores;
    }

    

    @Override
    public ActividadProfesor elegirActividadProfesor(int idActividad) {
        ActividadProfesor actividadprofesor = null;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM actividadprofesores "
                    + "WHERE id_actividad=?");
            ps.setInt(1, idActividad);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                actividadprofesor = new ActividadProfesor(
                        rs.getInt("in_actividad"),
                        rs.getFloat("horasAsignadas"),
                        rs.getString("actividad"),
                        rs.getString("maestro"),
                        rs.getInt("periodo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return actividadprofesor;
    }

}
