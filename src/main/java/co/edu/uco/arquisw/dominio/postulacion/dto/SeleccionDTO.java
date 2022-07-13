package co.edu.uco.arquisw.dominio.postulacion.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SeleccionDTO
{
    private Long id;
    private String fecha;
    private Long proyectoID;
    private Long usuarioID;
}