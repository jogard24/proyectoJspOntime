<%@page import="conexion.ConexionBD"%>
<%@page import="java.sql.Connection"%>
<%
    try {
        Connection con = ConexionBD.getConexion();
        if(con != null) {
            out.println("¡Conexión exitosa!");
        }
    } catch (Exception e) {
        out.println("Error: " + e.getMessage());
    }
%>
