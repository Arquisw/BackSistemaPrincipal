package co.edu.uco.arquisw.dominio.asociacion.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PeticionEliminacionAsociacionDTO {
    private Long id;
    private Long asociacion;
}