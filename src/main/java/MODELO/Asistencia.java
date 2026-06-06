package MODELO;

import java.time.LocalDateTime;

public class Asistencia {
    // Atributos privados: Encapsulamiento para proteger los datos
    private int id;
    private int usuario_id;
    private LocalDateTime fechaHora;
    private String tipo_evento;
    private String observacion;
    private int jornada_id ;

    // --- GETTERS Y SETTERS ---
    // Son los métodos de acceso: permiten que otras clases (como el DAO o el Servlet)
    // consulten o modifiquen los valores de forma controlada.

    public int getId() { return id; }
    public void setId(int id) { this.id = id; } 

    public int getUsuarioid() { return usuario_id; }
    public void setUsuarioid(int usuario_id) { this.usuario_id = usuario_id; }

    public LocalDateTime getFechaHora() { return fechaHora; }
    public void setFechaHora(LocalDateTime fechaHora) { this.fechaHora = fechaHora; }

    public String getTipoEvento() { return tipo_evento; }
    public void setTipoEvento(String tipo_evento) { this.tipo_evento = tipo_evento; }

    public String getObservacion() { return observacion; }
    public void setObservacion(String observacion) { this.observacion = observacion; }

    public int getJornadaid() { return jornada_id; }
    public void setJornadaid(int jornada_id) { this.jornada_id = jornada_id; }





}
    
