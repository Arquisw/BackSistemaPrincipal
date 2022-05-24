package co.edu.uco.arquisw.aplicacion.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AsociacionDTO
{
    private int codigo;
    private String nit;
    private String nombre;
    private EstadoAsociacionDTO estado;
    private NecesidadDTO necesidad;
}