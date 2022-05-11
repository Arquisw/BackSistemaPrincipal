package co.edu.uco.arquisw.infraestructura.adaptador.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EntidadEntidad
{
    private int codigo;
    private String nit;
    private String nombre;
    private EstadoEntidadEntidad estado;
    private NecesidadEntidad necesidad;
}