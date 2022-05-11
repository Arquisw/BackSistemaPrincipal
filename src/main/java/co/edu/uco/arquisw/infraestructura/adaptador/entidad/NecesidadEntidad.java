package co.edu.uco.arquisw.infraestructura.adaptador.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NecesidadEntidad
{
    private int codigo;
    private int tiempo;
    private String rutaArchivo;
    private ProyectoEntidad proyecto;
    private EstadoNecesidadEntidad estado;
}