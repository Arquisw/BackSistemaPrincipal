package co.edu.uco.arquisw.infraestructura.contrato.adaptador.repositorio.implementacion;

import co.edu.uco.arquisw.dominio.contrato.modelo.Contrato;
import co.edu.uco.arquisw.dominio.contrato.puerto.comando.ContratoRepositorioComando;
import co.edu.uco.arquisw.infraestructura.contrato.adaptador.mapeador.ContratoMapeador;
import co.edu.uco.arquisw.infraestructura.contrato.adaptador.repositorio.jpa.ContratoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ContratoRepositorioComandoImplementacion implements ContratoRepositorioComando {
    @Autowired
    ContratoMapeador contratoMapeador;
    @Autowired
    ContratoDAO contratoDAO;

    @Override
    public Long guardar(Contrato contrato, Long id) {
        var entidad = this.contratoMapeador.construirEntidad(contrato, id);

        return this.contratoDAO.save(entidad).getId();
    }

    @Override
    public Long actualizar(Contrato contrato, Long id) {
        var entidad = this.contratoDAO.findByNecesidad(id);

        entidad.setRuta(contrato.getRutaArchivo());

        return this.contratoDAO.save(entidad).getId();
    }

    @Override
    public void eliminar(Long id) {
        var entidad = this.contratoDAO.findByNecesidad(id);

        this.contratoDAO.deleteById(entidad.getId());
    }
}