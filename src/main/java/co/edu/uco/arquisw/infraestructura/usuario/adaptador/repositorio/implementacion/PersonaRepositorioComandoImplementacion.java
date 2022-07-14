package co.edu.uco.arquisw.infraestructura.usuario.adaptador.repositorio.implementacion;

import co.edu.uco.arquisw.dominio.usuario.modelo.HojaDeVidaPersona;
import co.edu.uco.arquisw.dominio.usuario.modelo.Persona;
import co.edu.uco.arquisw.dominio.usuario.puerto.comando.PersonaRepositorioComando;
import co.edu.uco.arquisw.infraestructura.usuario.adaptador.mapeador.HojaDeVidaPersonaMapeador;
import co.edu.uco.arquisw.infraestructura.usuario.adaptador.mapeador.PersonaMapeador;
import co.edu.uco.arquisw.infraestructura.usuario.adaptador.mapeador.PeticionEliminacionMapeador;
import co.edu.uco.arquisw.infraestructura.usuario.adaptador.mapeador.UsuarioMapeador;
import co.edu.uco.arquisw.infraestructura.usuario.adaptador.repositorio.jpa.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PersonaRepositorioComandoImplementacion implements PersonaRepositorioComando
{
    @Autowired
    PeticionEliminacionMapeador peticionEliminacionMapeador;
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
    PeticionEliminacionDAO peticionEliminacionDAO;

    @Override
    public Long guardar(Persona persona)
    {
        var usuario = this.usuarioMapeador.construirEntidad(persona.getCorreo(), persona.getClave());
        var entidad = this.personaMapeador.construirEntidad(persona);

        entidad.getRoles().forEach(rol -> this.rolPersonaDAO.save(rol));
        this.usuarioDAO.save(usuario);
        return this.personaDAO.save(entidad).getId();
    }

    @Override
    public Long actualizar(Persona persona, Long id)
    {
        var entidad = this.personaDAO.findById(id).orElse(null);
        var usuario = this.usuarioDAO.findById(id).orElse(null);

        assert entidad != null;
        entidad.setNombre(persona.getNombre());
        entidad.setCorreo(persona.getCorreo());
        entidad.setApellidos(persona.getApellidos());

        assert usuario != null;
        usuario.setCorreo(persona.getCorreo());
        usuario.setClave(persona.getClave());

        this.usuarioDAO.save(usuario);
        return this.personaDAO.save(entidad).getId();
    }

    @Override
    public void eliminar(Long id)
    {
        var persona = this.personaDAO.findById(id).orElse(null);

        assert persona != null;
        persona.getRoles().forEach(rol -> this.rolPersonaDAO.deleteById(rol.getId()));

        this.usuarioDAO.deleteById(id);

        this.personaDAO.deleteById(id);
    }

    @Override
    public Long guardarHojaDeVida(HojaDeVidaPersona hojaDeVida, Long usuarioId)
    {
        return this.hojaDeVidaPersonaDAO.save(this.hojaDeVidaPersonaMapeador.construirEntidad(hojaDeVida, usuarioId)).getId();
    }

    @Override
    public Long actualizarHojaDeVida(HojaDeVidaPersona hojaDeVida, Long usuarioId)
    {
        var entidad = this.hojaDeVidaPersonaDAO.findByUsuario(usuarioId);

        entidad.setRuta(hojaDeVida.getRutaArchivo());

        return this.hojaDeVidaPersonaDAO.save(entidad).getId();
    }

    @Override
    public void crearNotificacionEliminacion(Long id)
    {
        this.peticionEliminacionDAO.save(this.peticionEliminacionMapeador.construirEntidad(id));
    }
}