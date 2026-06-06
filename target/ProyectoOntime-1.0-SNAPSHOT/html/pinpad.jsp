

<div class="contenedor-asistencia-pinpad">
    <div class="tarjeta-pinpad">
        <div class="encabezado-pinpad">
            <h2>REGISTRO DE ASISTENCIA</h2>
            <p>Ingresa tu ID y presiona OK</p>
        </div>

        <form action="../AsistenciaServlet" method="POST">

            <div class="pantalla-pinpad">
                <input type="number" name="Usuarioid" placeholder="Digita tu ID aquí" required>
            </div>

            <input type="hidden" name="Jornadaid" value="1">
            <input type="hidden" name="tipoEvento" value="Entrada">
            <input type="hidden" name="Observacion" value="Registro manual">

            <div class="teclado-grid">
                <button type="submit" class="btn-accion btn-confirmar">OK</button>
            </div>
            <div id="asistencia-feedback" class="feedback-mensaje">
                <%
                    // Capturamos el parámetro que enviamos desde el Servlet
                    String status = request.getParameter("status");

                    if ("exito".equals(status)) {
                        out.println("<p style='color: green; font-weight: bold;'>¡Asistencia registrada correctamente!</p>");
                    } else if ("error".equals(status)) {
                        out.println("<p style='color: red; font-weight: bold;'>Error: No se pudo registrar. Intente de nuevo.</p>");
                    }
                %>
            </div>
        </form>

        <div id="asistencia-feedback" class="feedback-mensaje"></div>
        <button class="bt-menu-item" id="btnAdminCont">Admin / Cont</button>
    </div>
</div>