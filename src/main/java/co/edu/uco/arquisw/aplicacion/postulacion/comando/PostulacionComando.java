package co.edu.uco.arquisw.aplicacion.postulacion.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostulacionComando {
    private List<String> roles;
    private Long proyectoID;
    private Long usuarioID;
}