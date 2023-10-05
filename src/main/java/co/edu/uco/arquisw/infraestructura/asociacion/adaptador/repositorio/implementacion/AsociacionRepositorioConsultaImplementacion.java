package co.edu.uco.arquisw.infraestructura.asociacion.adaptador.repositorio.implementacion;

import co.edu.uco.arquisw.dominio.asociacion.dto.AsociacionDTO;
import co.edu.uco.arquisw.dominio.asociacion.dto.PeticionEliminacionAsociacionDTO;
import co.edu.uco.arquisw.dominio.asociacion.puerto.consulta.AsociacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.utilitario.TextoConstante;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;
import co.edu.uco.arquisw.infraestructura.asociacion.adaptador.mapeador.AsociacionMapeador;
import co.edu.uco.arquisw.infraestructura.asociacion.adaptador.mapeador.PeticionEliminacionAsociacionMapeador;
import co.edu.uco.arquisw.infraestructura.asociacion.adaptador.repositorio.jpa.AsociacionDAO;
import co.edu.uco.arquisw.infraestructura.asociacion.adaptador.repositorio.jpa.PeticionEliminacionAsociacionDAO;
import co.edu.uco.arquisw.infraestructura.usuario.adaptador.repositorio.jpa.PersonaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AsociacionRepositorioConsultaImplementacion implements AsociacionRepositorioConsulta {
    @Autowired
    AsociacionMapeador asociacionMapeador;
    @Autowired
    AsociacionDAO asociacionDAO;
    @Autowired
    PersonaDAO personaDAO;
    @Autowired
    PeticionEliminacionAsociacionDAO peticionEliminacionAsociacionDAO;
    @Autowired
    PeticionEliminacionAsociacionMapeador peticionEliminacionAsociacionMapeador;

    @Override
    public AsociacionDTO consultarPorIDUsuario(Long id) {
        var entidad = this.asociacionDAO.findByUsuario(id);

        if (ValidarObjeto.esNulo(entidad)) {
            return null;
        }

        var usuario = this.personaDAO.findById(entidad.getUsuario()).orElse(null);

        assert usuario != null;
        return this.asociacionMapeador.construirDTO(entidad, usuario.getNombre() + TextoConstante.ESPACIO + usuario.getApellidos());
    }

    @Override
    public AsociacionDTO consultarPorID(Long id) {
        var entidad = this.asociacionDAO.findById(id).orElse(null);

        if (ValidarObjeto.esNulo(entidad)) {
            return null;
        }

        var usuario = this.personaDAO.findById(entidad.getUsuario()).orElse(null);

        assert usuario != null;
        return this.asociacionMapeador.construirDTO(entidad, usuario.getNombre() + TextoConstante.ESPACIO + usuario.getApellidos());
    }

    @Override
    public AsociacionDTO consultarPorNIT(String nit) {
        var entidad = this.asociacionDAO.findByNit(nit);

        if (ValidarObjeto.esNulo(entidad)) {
            return null;
        }

        return this.asociacionMapeador.construirDTO(entidad, TextoConstante.VACIO);
    }

    @Override
    public Page<PeticionEliminacionAsociacionDTO> consultarPeticionesDeEliminacionDeAsociaciones(int pagina, int tamano) {

        var entidades = this.peticionEliminacionAsociacionDAO.findAll(PageRequest.of(pagina, tamano));

        return this.peticionEliminacionAsociacionMapeador.construirDTOsPaginado(entidades);
    }
}