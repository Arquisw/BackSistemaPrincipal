package co.edu.uco.arquisw.infraestructura.adaptador.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EjecucionEntidad
{
    private int codigo;
    private Date fechaInicio;
    private Date fechaFinal;
    private ProyectoEntidad proyecto;
    private PostulacionEntidad postulacion;
}