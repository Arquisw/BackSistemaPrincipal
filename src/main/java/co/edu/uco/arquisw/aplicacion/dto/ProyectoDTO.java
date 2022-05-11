package co.edu.uco.arquisw.aplicacion.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProyectoDTO
{
    private int codigo;
    private String nombre;
    private String descripcion;
    private EstadoProyectoDTO estado;
    private FaseProyectoDTO fase;
    private TipoConsultoriaDTO tipoConsultoria;
}