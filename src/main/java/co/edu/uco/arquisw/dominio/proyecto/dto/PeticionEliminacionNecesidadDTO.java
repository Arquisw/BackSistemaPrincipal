package co.edu.uco.arquisw.dominio.proyecto.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PeticionEliminacionNecesidadDTO
{
    private Long id;
    private Long necesidad;
}