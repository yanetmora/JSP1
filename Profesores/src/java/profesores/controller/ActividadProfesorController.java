package profesores.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import profesores.dao.ActividadProfesorDAO;
import profesores.dao.ActividadProfesorDAOImp;
import profesores.model.ActividadProfesor;

public class ActividadProfesorController extends HttpServlet {

    private final String LISTA_ACTIVIDADESPROFESORES = "/lista_actividadesprofesores.jsp";
    private final String AGREGAR_CAMBIAR = "/actividadprofesor.jsp";
    private ActividadProfesorDAO dao;

    public ActividadProfesorController() {
        dao = new ActividadProfesorDAOImp();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        String forward = "";

        if (action.equalsIgnoreCase("borrar")) {
            forward = LISTA_ACTIVIDADESPROFESORES;
            int idActividad = Integer.parseInt(request.getParameter("idactividad"));
            dao.borrarActividadProfesor(idActividad);
            request.setAttribute("actividadprofesores", dao.desplegarActividadesProfesores());
        } else if (action.equalsIgnoreCase("cambiar")) {
            forward = AGREGAR_CAMBIAR;
            int idActividad= Integer.parseInt(request.getParameter("idactividad"));
            ActividadProfesor actividadprofesor = dao.elegirActividadProfesor(idActividad);
            request.setAttribute("actividadprofesor", actividadprofesor);
        } else if (action.equalsIgnoreCase("agregar")) {
            forward = AGREGAR_CAMBIAR;
        } else {
            forward = LISTA_ACTIVIDADESPROFESORES;
            request.setAttribute("actividadprofesores", dao.desplegarActividadesProfesores());
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);

        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ActividadProfesor actividadprofesor = new ActividadProfesor();
       actividadprofesor.sethoraAsignadas(Float.parseFloat(request.getParameter("horasAsignadas")));
        actividadprofesor.setActividad(request.getParameter("actividad"));
        actividadprofesor.setMaestro(request.getParameter("maestro"));
        actividadprofesor.setPeriodo(Integer.parseInt(request.getParameter("periodo")));

        String idActividad = request.getParameter("idActividad");

        if (idActividad == null || idActividad.isEmpty()) {
            dao.agregarActividadProfesor(actividadprofesor);
        } else {
            actividadprofesor.setIdActividad(Integer.parseInt(idActividad));
            dao.cambiarActividadProfesor(actividadprofesor);
        }

        RequestDispatcher view = request.getRequestDispatcher(LISTA_ACTIVIDADESPROFESORES);
        request.setAttribute("actividadesprofesores", dao.desplegarActividadesProfesores());
        view.forward(request, response);

    }
}
