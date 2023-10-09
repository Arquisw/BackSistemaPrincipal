package co.edu.uco.arquisw.aplicacion.usuario.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonaActualizacionComando {
    private String nombre;
    private String apellidos;
    private String correo;
}