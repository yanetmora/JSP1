/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profesores.model;

/**
 *
 * @author Yanet
 */
public class ActividadProfesor{
    private int idActividad;
    private float   horasAsignadas;
    private String   actividad;
    private String   maestro;
     private int periodo;

    public ActividadProfesor(int idActividad, float horasAsignadas, String actividad, String maestro,int periodo) {
        this.idActividad = idActividad;
        this.horasAsignadas = horasAsignadas;
        this.actividad = actividad;
        this.maestro = maestro;
        this.periodo =  periodo;
    }
    
    public ActividadProfesor(){
        this(0,0,"","",0);
    }

    public void sethoraAsignadas(float horasAsignadas) {
        this.horasAsignadas = horasAsignadas;
    }

    public void setActividad(String actividad) {
        this.actividad= actividad;
    }

    public void setMaestro(String maestro) {
        this.maestro= maestro;
    }
    
    
    public void setPeriodo(int perdiodo) {
        this.periodo= periodo;
    }
 
      public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }
    
   
    public float getHoraAsignadas() {
        return horasAsignadas;
    }

    public String getActividad() {
        return actividad;
    }

    public int getIdActividad() {
        return idActividad;
    }

    public String getMaestro() {
        return maestro;
    }
     public int getPeriodo() {
        return periodo;
    }

    @Override
    public String toString() {
        return "ActividadProfesor{" + "idActividad=" + idActividad + ", horasAsignadas=" + horasAsignadas + ", actividad=" + actividad + ", maestro=" + maestro + ", periodo=" + periodo +  '}';
    }
 
    
}
