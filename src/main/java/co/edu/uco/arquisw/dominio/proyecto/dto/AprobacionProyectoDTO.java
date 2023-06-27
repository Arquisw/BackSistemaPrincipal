package co.edu.uco.arquisw.dominio.proyecto.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AprobacionProyectoDTO {
    private Long id;
    private boolean ingenieria;
    private boolean liderDeEquipo;
    private boolean directorDeProyecto;
}
