package co.edu.uco.arquisw.infraestructura.adaptador.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FaseProyectoEntidad
{
    private int codigo;
    private FaseDetalladaEntidad faseDetallada;
    private FaseEjecucionEntidad faseEjecucion;
}
