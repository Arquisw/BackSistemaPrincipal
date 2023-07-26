package co.edu.uco.arquisw.infraestructura.usuario.adaptador.repositorio.implementacion;

import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;
import co.edu.uco.arquisw.dominio.usuario.modelo.HojaDeVidaPersona;
import co.edu.uco.arquisw.dominio.usuario.modelo.Persona;
import co.edu.uco.arquisw.dominio.usuario.modelo.Rol;
import co.edu.uco.arquisw.dominio.usuario.puerto.comando.PersonaRepositorioComando;
import co.edu.uco.arquisw.infraestructura.asociacion.adaptador.repositorio.jpa.AsociacionDAO;
import co.edu.uco.arquisw.infraestructura.usuario.adaptador.mapeador.*;
import co.edu.uco.arquisw.infraestructura.usuario.adaptador.repositorio.jpa.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PersonaRepositorioComandoImplementacion implements PersonaRepositorioComando {
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
    RolPersonaDAO rolPersonaDAO;
    @Autowired
    UsuarioDAO usuarioDAO;
    @Autowired
    HojaDeVidaPersonaDAO hojaDeVidaPersonaDAO;
    @Autowired
    PeticionEliminacionPersonaDAO peticionEliminacionPersonaDAO;
    @Autowired
    AsociacionDAO asociacionDAO;
    @Autowired
    RolMapeador rolMapeador;
    @Autowired
    PeticionRecuperacionClaveDAO peticionRecuperacionClaveDAO;
    @Autowired
    PeticionRecuperacionClaveMapeador peticionRecuperacionClaveMapeador;

    @Override
    public Long guardar(Persona persona, String clave) {
        var usuario = this.usuarioMapeador.construirEntidad(persona.getCorreo(), clave);
        var personaEntidad = this.personaMapeador.construirEntidad(persona);

        this.usuarioDAO.save(usuario);

        return this.personaDAO.save(personaEntidad).getId();
    }

    @Override
    public Long actualizar(Persona persona, Long id) {
        var usuario = this.usuarioDAO.findById(id).orElse(null);
        var entidad = this.personaDAO.findById(id).orElse(null);

        assert usuario != null;
        this.usuarioMapeador.actualizarEntidad(usuario, persona.getCorreo(), usuario.getClave());
        assert entidad != null;
        this.personaMapeador.actualizarEntidad(entidad, persona);

        this.usuarioDAO.save(usuario);

        return this.personaDAO.save(entidad).getId();
    }

    @Override
    public Long actualizarClave(String claveNueva, Long id) {
        var usuario = this.usuarioDAO.findById(id).orElse(null);

        assert usuario != null;
        this.usuarioMapeador.actualizarEntidad(usuario, usuario.getCorreo(), claveNueva);

        return this.usuarioDAO.save(usuario).getId();
    }

    @Override
    public void crearRol(Rol rol, Long id) {
        var persona = this.personaDAO.findById(id).orElse(null);
        var entidad = this.rolMapeador.construirEntidad(rol);

        assert persona != null;
        persona.getRoles().add(entidad);

        this.personaDAO.save(persona);
    }

    @Override
    public void eliminarRolAsociacion(Rol rol, Long id) {
        var asociacion = this.asociacionDAO.findById(id).orElse(null);

        assert asociacion != null;
        eliminarRol(rol, asociacion.getUsuario());
    }

    @Override
    public void eliminarRol(Rol rol, Long id) {
        var entidad = this.personaDAO.findById(id).orElse(null);

        assert entidad != null;
        var roles = entidad.getRoles();
        var rolParaEliminar = roles.stream().filter(rolPersona -> rolPersona.getRol().getNombre().equals(rol.getNombre())).findFirst().orElse(null);

        assert rolParaEliminar != null;
        roles.remove(rolParaEliminar);
        entidad.setRoles(roles);

        this.rolPersonaDAO.deleteById(rolParaEliminar.getId());
        this.personaDAO.save(entidad);
    }

    @Override
    public void eliminar(Long id) {
        var persona = this.personaDAO.findById(id).orElse(null);

        assert persona != null;
        persona.getRoles().forEach(rol -> this.rolPersonaDAO.deleteById(rol.getId()));

        this.usuarioDAO.deleteById(id);

        this.personaDAO.deleteById(id);
    }

    @Override
    public Long guardarHojaDeVida(HojaDeVidaPersona hojaDeVida, Long usuarioId) {
        return this.hojaDeVidaPersonaDAO.save(this.hojaDeVidaPersonaMapeador.construirEntidad(hojaDeVida, usuarioId)).getId();
    }

    @Override
    public Long actualizarHojaDeVida(HojaDeVidaPersona hojaDeVida, Long usuarioId) {
        var entidad = this.hojaDeVidaPersonaDAO.findByUsuario(usuarioId);

        this.hojaDeVidaPersonaMapeador.actualizarEntidad(entidad, hojaDeVida);

        return this.hojaDeVidaPersonaDAO.save(entidad).getId();
    }

    @Override
    public void crearNotificacionEliminacion(Long id) {
        this.peticionEliminacionPersonaDAO.save(this.peticionEliminacionPersonaMapeador.construirEntidad(id));
    }

    @Override
    public Long crearPeticionRecuperacionClave(String codigo, String correo, String fecha) {
        var entidad = this.peticionRecuperacionClaveDAO.findByCorreo(correo);

        if(ValidarObjeto.esNulo(entidad)) {
            entidad = this.peticionRecuperacionClaveMapeador.construirEntidad(codigo, correo, fecha);
        } else {
            this.peticionRecuperacionClaveMapeador.actualizarEntidad(entidad, correo, fecha);
        }

        return this.peticionRecuperacionClaveDAO.save(entidad).getId();
    }

    @Override
    public void eliminarPeticionRecuperacionClave(Long id) {
        this.peticionRecuperacionClaveDAO.deleteById(id);
    }
}