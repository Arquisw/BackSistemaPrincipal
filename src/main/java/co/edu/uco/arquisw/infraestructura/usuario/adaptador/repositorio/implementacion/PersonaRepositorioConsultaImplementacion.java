package co.edu.uco.arquisw.infraestructura.usuario.adaptador.repositorio.implementacion;

import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;
import co.edu.uco.arquisw.dominio.usuario.dto.*;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;
import co.edu.uco.arquisw.infraestructura.usuario.adaptador.mapeador.*;
import co.edu.uco.arquisw.infraestructura.usuario.adaptador.repositorio.jpa.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public class PersonaRepositorioConsultaImplementacion implements PersonaRepositorioConsulta {
    @Autowired
    PeticionEliminacionPersonaMapeador peticionEliminacionPersonaMapeador;
    @Autowired
    HojaDeVidaPersonaMapeador hojaDeVidaPersonaMapeador;
    @Autowired
    PersonaMapeador personaMapeador;
    @Autowired
    UsuarioMapeador usuarioMapeador;
    @Autowired
    PersonaDAO personaDAO;
    @Autowired
    UsuarioDAO usuarioDAO;
    @Autowired
    HojaDeVidaPersonaDAO hojaDeVidaPersonaDAO;
    @Autowired
    PeticionEliminacionPersonaDAO peticionEliminacionPersonaDAO;
    @Autowired
    PeticionRecuperacionClaveDAO peticionRecuperacionClaveDAO;
    @Autowired
    PeticionRecuperacionClaveMapeador peticionRecuperacionClaveMapeador;
    @Autowired
    RolDAO rolDAO;
    @Autowired
    RolMapeador rolMapeador;

    @Override
    public PersonaDTO consultarPorId(Long id) {
        var entidad = this.personaDAO.findById(id).orElse(null);

        if (ValidarObjeto.esNulo(entidad)) {
            return null;
        }

        return this.personaMapeador.construirDTO(entidad);
    }

    @Override
    public UsuarioDTO consultarUsuarioPorId(Long id) {
        var entidad = this.usuarioDAO.findById(id).orElse(null);

        if (ValidarObjeto.esNulo(entidad)) {
            return null;
        }

        return this.usuarioMapeador.construirDTO(entidad);
    }

    @Override
    public UsuarioDTO consultarUsuarioPorCorreo(String correo) {
        var entidad = this.usuarioDAO.findByCorreo(correo);

        if (ValidarObjeto.esNulo(entidad)) {
            return null;
        }

        return this.usuarioMapeador.construirDTO(entidad);
    }

    @Override
    public PersonaDTO consultarPorCorreo(String correo) {
        var entidad = this.personaDAO.findByCorreo(correo);

        if (ValidarObjeto.esNulo(entidad)) {
            return null;
        }

        return this.personaMapeador.construirDTO(entidad);
    }

    @Override
    public boolean existeConCorreo(String correo) {
        var usuario = this.usuarioDAO.findByCorreo(correo);
        var persona = this.personaDAO.findByCorreo(correo);

        return !ValidarObjeto.esNulo(this.usuarioDAO.findByCorreo(correo)) && !Objects.equals(persona.getId(), usuario.getId());
    }


    @Override
    public HojaDeVidaPersonaDTO consultarHojaDeVidaPorIdUsuario(Long usuarioID) {
        var entidad = this.hojaDeVidaPersonaDAO.findByUsuario(usuarioID);

        if (ValidarObjeto.esNulo(entidad)) {
            return null;
        }

        return this.hojaDeVidaPersonaMapeador.construirDTO(entidad);
    }

    @Override
    public List<PeticionEliminacionPersonaDTO> consultarPeticionesDeEliminacionDeUsuarios() {
        var entidades = this.peticionEliminacionPersonaDAO.findAll();

        return this.peticionEliminacionPersonaMapeador.construirDTOs(entidades);
    }

    @Override
    public String consultarClaveConCorreo(String correo) {
        var entidad = this.usuarioDAO.findByCorreo(correo);

        return entidad.getClave();
    }

    @Override
    public String consultarCodigoConCorreo(String correo) {
        var entidad = this.peticionRecuperacionClaveDAO.findByCorreo(correo);

        return entidad.getCodigo();
    }

    @Override
    public PeticionRecuperacionClaveDTO consultarPeticionRecuperacionClaveDTOConCorreo(String correo) {
        var entidad = this.peticionRecuperacionClaveDAO.findByCorreo(correo);

        return this.peticionRecuperacionClaveMapeador.construirDTO(entidad);
    }

    @Override
    public List<RolDTO> consultarRolesPorAdministrador() {
        var entidades = this.rolDAO.findAll();
        var totalElementos = entidades.size();
        var elementosAFiltrar = 8;

        var entidadesFiltradas = entidades.subList(totalElementos - elementosAFiltrar, totalElementos);
        entidadesFiltradas.sort((entidadUno, entidadDos) -> entidadUno.getId().compareTo(entidadDos.getId()));

        return this.rolMapeador.construirBaseDTOs(entidadesFiltradas);
    }

    @Override
    public RolDTO consultarRolPorId(Long id) {
        var entidad = this.rolDAO.findById(id).orElse(null);

        if (ValidarObjeto.esNulo(entidad)) {
            return null;
        }

        return this.rolMapeador.construirDTO(entidad);
    }
}