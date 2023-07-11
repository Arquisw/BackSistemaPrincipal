package co.edu.uco.arquisw.dominio.usuario.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RolDTO {
    private String nombre;
    private boolean leer;
    private boolean escribir;
    private boolean actualizar;
    private boolean eliminar;
}