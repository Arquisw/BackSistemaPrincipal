package co.edu.uco.arquisw.dominio.asociacion.dto;

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
    private Long id;
    private String nombre;
    private String nit;
    private String numeroContacto;
    private String nombreContacto;
}