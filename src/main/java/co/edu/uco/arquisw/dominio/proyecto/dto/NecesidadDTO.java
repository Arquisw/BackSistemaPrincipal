package co.edu.uco.arquisw.dominio.proyecto.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NecesidadDTO {
    private Long id;
    private String motivoRechazo;
    private EstadoNecesidadDTO estado;
    private ProyectoDTO proyecto;
    private Long asociacion;
}