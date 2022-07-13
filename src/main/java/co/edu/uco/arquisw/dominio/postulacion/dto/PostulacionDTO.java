package co.edu.uco.arquisw.dominio.postulacion.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostulacionDTO
{
    private Long id;
    private LocalDate fecha;
    private Long proyectoID;
    private Long usuarioID;
}