package co.edu.uco.arquisw.aplicacion.usuario.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RolActualizacionComando {
    private boolean leer;
    private boolean escribir;
    private boolean actualizar;
    private boolean eliminar;
}