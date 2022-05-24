package co.edu.uco.arquisw.aplicacion.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EjecucionDTO
{
    private int codigo;
    private LocalDate fechaInicio;
    private LocalDate fechaFinal;
    private ProyectoDTO proyecto;
    private PostulacionDTO postulacion;
}