package co.edu.uco.arquisw.infraestructura.adaptador.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProyectoEntidad
{
    private int codigo;
    private String nombre;
    private String descripcion;
    private EstadoProyectoEntidad estado;
    private FaseProyectoEntidad fase;
    private TipoConsultoriaEntidad tipoConsultoria;
}