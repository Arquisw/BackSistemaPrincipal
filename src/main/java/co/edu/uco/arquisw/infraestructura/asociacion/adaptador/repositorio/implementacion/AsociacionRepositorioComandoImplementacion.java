package co.edu.uco.arquisw.infraestructura.asociacion.adaptador.repositorio.implementacion;

import co.edu.uco.arquisw.dominio.asociacion.modelo.Asociacion;
import co.edu.uco.arquisw.dominio.asociacion.puerto.comando.AsociacionRepositorioComando;
import co.edu.uco.arquisw.dominio.transversal.utilitario.TextoConstante;
import co.edu.uco.arquisw.dominio.usuario.modelo.Rol;
import co.edu.uco.arquisw.infraestructura.asociacion.adaptador.mapeador.AsociacionMapeador;
import co.edu.uco.arquisw.infraestructura.asociacion.adaptador.mapeador.PeticionEliminacionAsociacionMapeador;
import co.edu.uco.arquisw.infraestructura.asociacion.adaptador.repositorio.jpa.AsociacionDAO;
import co.edu.uco.arquisw.infraestructura.asociacion.adaptador.repositorio.jpa.PeticionEliminacionAsociacionDAO;
import co.edu.uco.arquisw.infraestructura.usuario.adaptador.mapeador.RolMapeador;
import co.edu.uco.arquisw.infraestructura.usuario.adaptador.repositorio.jpa.PersonaDAO;
import co.edu.uco.arquisw.infraestructura.usuario.adaptador.repositorio.jpa.RolPersonaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AsociacionRepositorioComandoImplementacion implements AsociacionRepositorioComando
{
    @Autowired
    AsociacionMapeador asociacionMapeador;
    @Autowired
    AsociacionDAO asociacionDAO;
    @Autowired
    RolPersonaDAO rolPersonaDAO;
    @Autowired
    PersonaDAO personaDAO;
    @Autowired
    RolMapeador rolMapeador;
    @Autowired
    PeticionEliminacionAsociacionDAO peticionEliminacionAsociacionDAO;
    @Autowired
    PeticionEliminacionAsociacionMapeador peticionEliminacionAsociacionMapeador;

    @Override
    public Long guardar(Asociacion asociacion, Long usuarioID)
    {
        var entidad = this.asociacionMapeador.construirEntidad(asociacion, usuarioID);

        var usuario = this.personaDAO.findById(usuarioID).orElse(null);

        assert usuario != null;
        var roles = usuario.getRoles();

        roles.add(this.rolMapeador.construirEntidad(Rol.crear(TextoConstante.ROL_ASOCIACION)));

        usuario.setRoles(roles);

        usuario.getRoles().forEach(rol -> this.rolPersonaDAO.save(rol));
        this.personaDAO.save(usuario);

        return this.asociacionDAO.save(entidad).getId();
    }

    @Override
    public Long actualizar(Asociacion asociacion, Long id)
    {
        var entidad = this.asociacionDAO.findByUsuario(id);

        entidad.setNombre(asociacion.getNombre());
        entidad.setNit(asociacion.getNit());
        entidad.setNumeroContacto(asociacion.getNumeroContacto());

        return this.asociacionDAO.save(entidad).getId();
    }

    @Override
    public void eliminar(Long id)
    {
        this.asociacionDAO.deleteById(id);
    }

    @Override
    public void crearNotificacionEliminacion(Long id)
    {
        this.peticionEliminacionAsociacionDAO.save(this.peticionEliminacionAsociacionMapeador.construirEntidad(id));
    }
}