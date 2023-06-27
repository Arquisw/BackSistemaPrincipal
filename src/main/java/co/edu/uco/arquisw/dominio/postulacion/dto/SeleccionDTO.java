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
public class SeleccionDTO {
    private Long id;
    private String fecha;
    private List<String> roles;
    private Long proyectoID;
    private Long usuarioID;
}