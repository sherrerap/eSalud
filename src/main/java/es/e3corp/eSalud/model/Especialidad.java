package es.e3corp.eSalud.model;

import java.util.UUID;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

public class Especialidad {
  @Id
  /**
   * ID. author: e3corp
   */
  private String id;
  /**
   * Nombre. author: e3corp
   */
  @NotNull
  private String nombre;
  /**
   * Hora de inicio. author: e3corp
   */
  private String horaInicio;
  /**
   * Hora de fin. author: e3corp
   */
  private String horaFin;
  /**
   * Tiempo de consulta. author: e3corp
   */
  private String tiempoConsulta;

  public Especialidad(@NotNull String nombre, String horaInicio, String horaFin, String tiempoConsulta) {
    super();
    this.id = UUID.randomUUID().toString();
    this.nombre = nombre;
    this.horaInicio = horaInicio;
    this.horaFin = horaFin;
    this.tiempoConsulta = tiempoConsulta;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getHoraInicio() {
    return horaInicio;
  }

  public void setHoraInicio(String horaInicio) {
    this.horaInicio = horaInicio;
  }

  public String getHoraFin() {
    return horaFin;
  }

  public void setHoraFin(String horaFin) {
    this.horaFin = horaFin;
  }

  public String getTiempoConsulta() {
    return tiempoConsulta;
  }

  public void setTiempoConsulta(String tiempoConsulta) {
    this.tiempoConsulta = tiempoConsulta;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((horaFin == null) ? 0 : horaFin.hashCode());
    result = prime * result + ((horaInicio == null) ? 0 : horaInicio.hashCode());
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
    result = prime * result + ((tiempoConsulta == null) ? 0 : tiempoConsulta.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Especialidad other = (Especialidad) obj;
    if (horaFin == null) {
      if (other.horaFin != null)
        return false;
    } else if (!horaFin.equals(other.horaFin))
      return false;
    if (horaInicio == null) {
      if (other.horaInicio != null)
        return false;
    } else if (!horaInicio.equals(other.horaInicio))
      return false;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (nombre == null) {
      if (other.nombre != null)
        return false;
    } else if (!nombre.equals(other.nombre))
      return false;
    if (tiempoConsulta == null) {
      if (other.tiempoConsulta != null)
        return false;
    } else if (!tiempoConsulta.equals(other.tiempoConsulta))
      return false;
    return true;
  }

}
