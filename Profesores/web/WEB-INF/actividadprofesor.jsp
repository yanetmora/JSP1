<%-- 
    Document   : profesor
    Created on : 21/09/2016, 10:34:16 AM
    Author     : Yanet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario de ActividadesProfesores</title>
    </head>
    <body>
        <form action="ActividadesProfesorController" method="post">
            <fieldset> 
                <legend> Registro de ActividadesProfesores </legend>
                <div>
                    <label for="idActividad">ID Actividad: </label>
                    <input type="text" name="idActividad" placeholder="ID Actividad" values="${actividadprofesor.idActividad}" readonly="readonly">
                </div>
                <div>
                    <label for="horasAsgnadas">actividadprofesor: </label>
                    <input type="text" name="horasAsignadas" placeholder="HorasAsignadas del Profesor" values="$actividadprofesor.horasasignadas}">
                </div>
                <div>
                    <label for="maestro">Maestro : </label>
                    <input type="text" name="maestro" placeholder="Maestro" values="${actividadprofesor.maestro}">
                </div>
                <div>
                    <label for="actividad">Actividad del Profesor: </label>
                    <input type="text" name="actividad" placeholder="Actividad" values="${actividadprofesor.maestro}">
                </div>
                
                <div>
                    <label for="periodo">Periodo del Profesor: </label>
                    <input type="number" name="periodo" placeholder="Periodo" values="${actividadprofesor.actividad}">
                </div>
          
                <div>
                    <input type="submit" values="Guardar">
                </div>
            </fieldset>
        </form>
    </body>
</html>
