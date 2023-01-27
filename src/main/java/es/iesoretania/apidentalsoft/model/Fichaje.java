package es.iesoretania.apidentalsoft.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "fichaje_empleado")
public class Fichaje {
    @Id
    private int id;
    private String empleado;
    private Date fecha;
    private Time hora;

    public Fichaje() {
    }

    public Fichaje(int id, String empleado, Date fecha, Time hora) {
        this.id = id;
        this.empleado = empleado;
        this.fecha = fecha;
        this.hora = hora;
    }

    public Fichaje(String empleado) {
        this.empleado = empleado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }
}
