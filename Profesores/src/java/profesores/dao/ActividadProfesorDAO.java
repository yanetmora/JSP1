/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profesores.dao;

import java.util.List;
import profesores.model.ActividadProfesor;
import profesores.model.Profesor;

/**
 *
 * @author Yanet
 */
public interface ActividadProfesorDAO{
    void agregarActividadProfesor(ActividadProfesor actividadprofesor);
    void borrarActividadProfesor(int idActividad);
    void cambiarActividadProfesor(ActividadProfesor actividadprofesor);
    
    List<ActividadProfesor> desplegarActividadesProfesores();
    ActividadProfesor elegirActividadProfesor (int idActividad);
    
}









