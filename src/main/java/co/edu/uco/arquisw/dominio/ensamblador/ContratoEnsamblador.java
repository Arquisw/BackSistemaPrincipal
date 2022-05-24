package co.edu.uco.arquisw.dominio.ensamblador;

import co.edu.uco.arquisw.aplicacion.dto.ContratoDTO;
import co.edu.uco.arquisw.dominio.modelo.Contrato;
import co.edu.uco.arquisw.infraestructura.adaptador.entidad.ContratoEntidad;

public interface ContratoEnsamblador extends Ensamblador<Contrato, ContratoEntidad, ContratoDTO>
{

}