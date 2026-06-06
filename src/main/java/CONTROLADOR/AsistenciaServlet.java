package CONTROLADOR;

import MODELO.Asistencia;
import DAO.AsistenciaDAO;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "AsistenciaServlet", urlPatterns = {"/AsistenciaServlet"})
public class AsistenciaServlet extends HttpServlet {

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String cedula = request.getParameter("usuarioId");
    AsistenciaDAO DAO = new AsistenciaDAO();
    
    // 1. Buscamos el ID real del usuario
    int idReal = DAO.obtenerIdPorDocumento(cedula);
    
    // 2. Buscamos qué jornada tiene asignada en su contrato (¡Esto es dinámico!)
    int jornadaId = DAO.obtenerJornadaIdDelUsuario(idReal);
    
    if (idReal != -1 && jornadaId != -1) {
        Asistencia asis = new Asistencia();
        asis.setUsuarioid(idReal);
        asis.setJornadaid(jornadaId); // Toma el valor actual del contrato
        asis.setTipoEvento(request.getParameter("tipoEvento"));
        
        if (DAO.registrarAsistencia(asis)) {
            response.sendRedirect("html/pinpad.jsp?mensaje=exito");
        }
    } else {
        response.sendRedirect("html/pinpad.jsp?mensaje=error_usuario_sin_jornada");
    }
}
}
