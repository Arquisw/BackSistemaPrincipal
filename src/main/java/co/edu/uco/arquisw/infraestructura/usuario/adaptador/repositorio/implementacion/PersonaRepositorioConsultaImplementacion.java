package co.edu.uco.arquisw.infraestructura.usuario.adaptador.repositorio.implementacion;

import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;
import co.edu.uco.arquisw.dominio.usuario.dto.HojaDeVidaPersonaDTO;
import co.edu.uco.arquisw.dominio.usuario.dto.PersonaDTO;
import co.edu.uco.arquisw.dominio.usuario.dto.PeticionEliminacionPersonaDTO;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;
import co.edu.uco.arquisw.infraestructura.usuario.adaptador.mapeador.HojaDeVidaPersonaMapeador;
import co.edu.uco.arquisw.infraestructura.usuario.adaptador.mapeador.PersonaMapeador;
import co.edu.uco.arquisw.infraestructura.usuario.adaptador.mapeador.PeticionEliminacionPersonaMapeador;
import co.edu.uco.arquisw.infraestructura.usuario.adaptador.repositorio.jpa.HojaDeVidaPersonaDAO;
import co.edu.uco.arquisw.infraestructura.usuario.adaptador.repositorio.jpa.PersonaDAO;
import co.edu.uco.arquisw.infraestructura.usuario.adaptador.repositorio.jpa.PeticionEliminacionPersonaDAO;
import co.edu.uco.arquisw.infraestructura.usuario.adaptador.repositorio.jpa.UsuarioDAO;
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
    PersonaDAO personaDAO;
    @Autowired
    UsuarioDAO usuarioDAO;
    @Autowired
    HojaDeVidaPersonaDAO hojaDeVidaPersonaDAO;
    @Autowired
    PeticionEliminacionPersonaDAO peticionEliminacionPersonaDAO;

    @Override
    public PersonaDTO consultarPorId(Long id) {
        var entidad = this.personaDAO.findById(id).orElse(null);

        if(ValidarObjeto.esNulo(entidad)) {
            return null;
        }

        return this.personaMapeador.construirDTO(entidad);
    }

    @Override
    public PersonaDTO consultarPorCorreo(String correo) {
        var entidad = this.personaDAO.findByCorreo(correo);

        if(ValidarObjeto.esNulo(entidad)) {
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

        if(ValidarObjeto.esNulo(entidad)) {
            return null;
        }

        return this.hojaDeVidaPersonaMapeador.construirDTO(entidad);
    }

    @Override
    public List<PeticionEliminacionPersonaDTO> consultarPeticionesDeEliminacionDeUsuarios() {
        var entidades = this.peticionEliminacionPersonaDAO.findAll();

        return this.peticionEliminacionPersonaMapeador.construirDTOs(entidades);
    }
}