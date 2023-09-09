package co.edu.uco.arquisw.aplicacion.proyecto.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProyectoComando {
    private String nombre;
    private String descripcion;
    private List<TipoConsultoriaComando> tiposConsultoria;
}