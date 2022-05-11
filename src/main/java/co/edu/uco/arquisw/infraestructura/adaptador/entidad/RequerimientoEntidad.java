package co.edu.uco.arquisw.infraestructura.adaptador.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequerimientoEntidad
{
    private int codigo;
    private NecesidadEntidad necesidad;
    private ContratoEntidad contrato;
}