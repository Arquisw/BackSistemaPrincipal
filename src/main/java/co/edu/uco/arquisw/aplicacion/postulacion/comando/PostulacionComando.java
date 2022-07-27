package co.edu.uco.arquisw.aplicacion.postulacion.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostulacionComando
{
    private String rol;
    private Long proyectoID;
    private Long usuarioID;
}