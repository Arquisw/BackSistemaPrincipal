package co.edu.uco.arquisw.dominio.postulacion.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostulacionDTO {
    private Long id;
    private boolean seleccionado;
    private boolean rechazado;
    private String motivoDelRechazo;
    private String nombreDelUsuario;
    private String correoDelUsuario;
    private String fecha;
    private List<String> roles;
    private Long proyectoID;
    private Long usuarioID;
}