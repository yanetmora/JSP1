<%-- 
    Document   : lista_profesores
    Created on : 21/09/2016, 10:34:46 AM
    Author     : yanet
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de ActividadesProfesores</title>
    </head>
    <body>
        <table>
            <thead>
                <tr>  ID Actividad</tr>
                <tr>-  HorasAsignadas</tr>
                 <tr>-  Actividad</tr>
                <tr>-  Maestro</tr>
                <tr>-  Periodo</tr>
            </thead>
            <tbody>
                <c:forEach items="${actividadesprofesores}" var="actividadprofesor">
                    <tr>
                        <td>${actividadprofesor.idActividad}</td>
                        <td>${actividadprofesor.horasAsiganadas}</td>
                        <td>${actividadprofesor.maestro}</td>
                        <td>${actividadprofesor.actividad}</td>
                        <td>${actividadprofesor.periodo}</td>
                        <td> 
                            <a href="ActividadController?action=cambiar&idActividad=${actividadprofesor.idActividad}">Cambiar</a> 
                        </td>
                        <td> 
                            <a href="ActividadProfesorController?action=borrar&idAtividad=${actividadprofesor.idActividad}">Borrar</a> 
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <p>
            <a href="ActividadProfesorController?action=agregar">AgregarActividadProfesor</a>
        </p>
    </body>
</html>
