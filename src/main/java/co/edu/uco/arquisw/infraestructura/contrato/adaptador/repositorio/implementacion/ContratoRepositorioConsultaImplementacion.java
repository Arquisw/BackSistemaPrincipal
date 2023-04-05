package co.edu.uco.arquisw.infraestructura.contrato.adaptador.repositorio.implementacion;

import co.edu.uco.arquisw.dominio.contrato.dto.ContratoDTO;
import co.edu.uco.arquisw.dominio.contrato.puerto.consulta.ContratoRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;
import co.edu.uco.arquisw.infraestructura.contrato.adaptador.mapeador.ContratoMapeador;
import co.edu.uco.arquisw.infraestructura.contrato.adaptador.repositorio.jpa.ContratoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ContratoRepositorioConsultaImplementacion implements ContratoRepositorioConsulta {
    @Autowired
    ContratoMapeador contratoMapeador;
    @Autowired
    ContratoDAO contratoDAO;

    @Override
    public ContratoDTO consultarPorId(Long id) {
        var entidad = this.contratoDAO.findByNecesidad(id);

        if(ValidarObjeto.esNulo(entidad)) {
            return null;
        }

        return this.contratoMapeador.construirDTO(entidad);
    }
}