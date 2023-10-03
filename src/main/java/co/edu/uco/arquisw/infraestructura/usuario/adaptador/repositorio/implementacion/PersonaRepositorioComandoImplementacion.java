package co.edu.uco.arquisw.infraestructura.usuario.adaptador.repositorio.implementacion;

import co.edu.uco.arquisw.dominio.transversal.utilitario.LogicoConstante;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;
import co.edu.uco.arquisw.dominio.usuario.modelo.HojaDeVidaPersona;
import co.edu.uco.arquisw.dominio.usuario.modelo.Persona;
import co.edu.uco.arquisw.dominio.usuario.modelo.Rol;
import co.edu.uco.arquisw.dominio.usuario.modelo.Usuario;
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
    RolUsuarioDAO rolUsuarioDAO;
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
    @Autowired
    PeticionActivacionCuentaDAO peticionActivacionCuentaDAO;
    @Autowired
    PeticionActivacionCuentaMapeador peticionActivacionCuentaMapeador;
    @Autowired
    RolDAO rolDAO;

    @Override
    public Long guardar(Persona persona, Usuario usuario, String clave) {
        var usuarioEntidad = this.usuarioMapeador.construirEntidad(usuario, clave);
        var personaEntidad = this.personaMapeador.construirEntidad(persona);

        this.usuarioDAO.save(usuarioEntidad);

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
        var usuario = this.usuarioDAO.findById(id).orElse(null);
        var entidad = this.rolMapeador.construirEntidad(rol);

        assert usuario != null;
        usuario.getRoles().add(entidad);

        this.usuarioDAO.save(usuario);
    }

    @Override
    public void eliminarRolAsociacion(Rol rol, Long id) {
        var asociacion = this.asociacionDAO.findById(id).orElse(null);

        assert asociacion != null;
        eliminarRol(rol, asociacion.getUsuario());
    }

    @Override
    public void eliminarRol(Rol rol, Long id) {
        var persona = this.personaDAO.findById(id).orElse(null);

        assert persona != null;
        var entidad = this.usuarioDAO.findByCorreo(persona.getCorreo());
        assert entidad != null;
        var roles = entidad.getRoles();
        var rolParaEliminar = roles.stream().filter(rolUsuario -> rolUsuario.getRol().getNombre().equals(rol.getNombre())).findFirst().orElse(null);

        assert rolParaEliminar != null;
        roles.remove(rolParaEliminar);
        entidad.setRoles(roles);

        this.rolUsuarioDAO.deleteById(rolParaEliminar.getId());
        this.usuarioDAO.save(entidad);
    }

    @Override
    public void eliminar(Long id) {
        var usuario = this.usuarioDAO.findById(id).orElse(null);

        assert usuario != null;
        usuario.getRoles().forEach(rol -> this.rolUsuarioDAO.deleteById(rol.getId()));

        this.usuarioDAO.deleteById(id);

        this.personaDAO.deleteById(id);
    }

    @Override
    public void eliminarPorAdminsitrador(Long id) {
        var usuario = this.usuarioDAO.findById(id).orElse(null);
        var peticionEliminacionUsuario = this.peticionEliminacionPersonaDAO.findByUsuario(id);

        assert usuario != null;
        usuario.getRoles().forEach(rol -> this.rolUsuarioDAO.deleteById(rol.getId()));

        this.peticionEliminacionPersonaDAO.deleteById(peticionEliminacionUsuario.getId());

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

        if (ValidarObjeto.esNulo(entidad)) {
            entidad = this.peticionRecuperacionClaveMapeador.construirEntidad(codigo, correo, fecha);
        } else {
            this.peticionRecuperacionClaveMapeador.actualizarEntidad(entidad, codigo, fecha);
        }

        return this.peticionRecuperacionClaveDAO.save(entidad).getId();
    }

    @Override
    public void eliminarPeticionRecuperacionClave(Long id) {
        this.peticionRecuperacionClaveDAO.deleteById(id);
    }

    @Override
    public Long actualizarRol(boolean leer, boolean escribir, boolean actualizar, boolean eliminar, Long id) {
        var entidad = this.rolDAO.findById(id).orElse(null);

        assert entidad != null;
        entidad.setLeer(leer);
        entidad.setEscribir(escribir);
        entidad.setActualizar(actualizar);
        entidad.setEliminar(eliminar);

        return this.rolDAO.save(entidad).getId();
    }

    @Override
    public Long crearPeticionActivacionCuenta(String codigo, String correo, String fecha) {
        var entidad = this.peticionActivacionCuentaDAO.findByCorreo(correo);

        if (ValidarObjeto.esNulo(entidad)) {
            entidad = this.peticionActivacionCuentaMapeador.construirEntidad(codigo, correo, fecha);
        } else {
            this.peticionActivacionCuentaMapeador.actualizarEntidad(entidad, codigo, fecha);
        }

        return this.peticionActivacionCuentaDAO.save(entidad).getId();
    }

    @Override
    public Long activarCuenta(String correo) {
        var entidad = this.usuarioDAO.findByCorreo(correo);

        entidad.setActivado(LogicoConstante.USUARIO_ACTIVADO);

        return this.usuarioDAO.save(entidad).getId();
    }

    @Override
    public void eliminarPeticionActivacionCuenta(Long id) {
        this.peticionActivacionCuentaDAO.deleteById(id);
    }
}