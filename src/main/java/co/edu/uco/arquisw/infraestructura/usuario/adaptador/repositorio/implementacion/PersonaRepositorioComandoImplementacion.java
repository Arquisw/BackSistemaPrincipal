package co.edu.uco.arquisw.infraestructura.usuario.adaptador.repositorio.implementacion;

import co.edu.uco.arquisw.dominio.usuario.modelo.Persona;
import co.edu.uco.arquisw.dominio.usuario.puerto.comando.PersonaRepositorioComando;
import co.edu.uco.arquisw.infraestructura.usuario.adaptador.mapeador.PersonaMapeador;
import co.edu.uco.arquisw.infraestructura.usuario.adaptador.mapeador.UsuarioMapeador;
import co.edu.uco.arquisw.infraestructura.usuario.adaptador.repositorio.jpa.PersonaDAO;
import co.edu.uco.arquisw.infraestructura.usuario.adaptador.repositorio.jpa.RolPersonaDAO;
import co.edu.uco.arquisw.infraestructura.usuario.adaptador.repositorio.jpa.UsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PersonaRepositorioComandoImplementacion implements PersonaRepositorioComando
{
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

    @Override
    public Long guardar(Persona persona)
    {
        var usuario = this.usuarioMapeador.construirEntidad(persona.getCorreo(), persona.getClave());
        var entidad = this.personaMapeador.construirEntidad(persona);

        usuario.setId(obtenerUsuarioID());
        entidad.setId(obtenerPersonaID());
        entidad.getRoles().forEach(rol -> rol.setId(obtenerRolPersonaID()));

        entidad.getRoles().forEach(rol -> this.rolPersonaDAO.save(rol));
        this.usuarioDAO.save(usuario);
        return this.personaDAO.save(entidad).getId();
    }

    private Long obtenerRolPersonaID()
    {
        var id = 1L;
        var roles = this.rolPersonaDAO.findAll();

        if(!roles.isEmpty())
        {
            id = roles.get(roles.size() - 1).getId() + 1L;
        }

        return id;
    }

    private Long obtenerPersonaID()
    {
        var id = 1L;
        var personas = this.personaDAO.findAll();

        if(!personas.isEmpty())
        {
            id = personas.get(personas.size() - 1).getId() + 1L;
        }

        return id;
    }

    private Long obtenerUsuarioID()
    {
        var id = 1L;
        var usuarios = this.usuarioDAO.findAll();

        if(!usuarios.isEmpty())
        {
            id = usuarios.get(usuarios.size() - 1).getId() + 1L;
        }

        return id;
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
}