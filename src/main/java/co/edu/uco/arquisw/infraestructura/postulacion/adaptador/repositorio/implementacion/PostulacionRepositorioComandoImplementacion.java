package co.edu.uco.arquisw.infraestructura.postulacion.adaptador.repositorio.implementacion;

import co.edu.uco.arquisw.dominio.postulacion.modelo.Postulacion;
import co.edu.uco.arquisw.dominio.postulacion.modelo.Seleccion;
import co.edu.uco.arquisw.dominio.postulacion.puerto.comando.PostulacionRepositorioComando;
import co.edu.uco.arquisw.dominio.transversal.utilitario.TextoConstante;
import co.edu.uco.arquisw.dominio.usuario.modelo.Rol;
import co.edu.uco.arquisw.infraestructura.postulacion.adaptador.mapeador.PostulacionMapeador;
import co.edu.uco.arquisw.infraestructura.postulacion.adaptador.mapeador.SeleccionMapeador;
import co.edu.uco.arquisw.infraestructura.postulacion.adaptador.repositorio.jpa.PostulacionDAO;
import co.edu.uco.arquisw.infraestructura.postulacion.adaptador.repositorio.jpa.SeleccionDAO;
import co.edu.uco.arquisw.infraestructura.usuario.adaptador.mapeador.RolMapeador;
import co.edu.uco.arquisw.infraestructura.usuario.adaptador.repositorio.jpa.PersonaDAO;
import co.edu.uco.arquisw.infraestructura.usuario.adaptador.repositorio.jpa.RolPersonaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PostulacionRepositorioComandoImplementacion implements PostulacionRepositorioComando
{
    @Autowired
    PostulacionMapeador postulacionMapeador;
    @Autowired
    SeleccionMapeador seleccionMapeador;
    @Autowired
    PostulacionDAO postulacionDAO;
    @Autowired
    SeleccionDAO seleccionDAO;
    @Autowired
    RolPersonaDAO rolPersonaDAO;
    @Autowired
    PersonaDAO personaDAO;
    @Autowired
    RolMapeador rolMapeador;

    @Override
    public Long guardar(Postulacion postulacion, Long proyectoID, Long usuarioID)
    {
        var entidad = this.postulacionMapeador.construirEntidad(postulacion, proyectoID, usuarioID);

        var usuario = this.personaDAO.findById(usuarioID).orElse(null);

        assert usuario != null;
        var roles = usuario.getRoles();

        roles.add(this.rolMapeador.construirEntidad(Rol.crear(TextoConstante.ROL_POSTULADO)));

        usuario.setRoles(roles);

        usuario.getRoles().forEach(rol -> this.rolPersonaDAO.save(rol));

        return this.postulacionDAO.save(entidad).getId();
    }

    @Override
    public Long actualizar(Postulacion postulacion, Seleccion seleccion, Long id, Long usuarioID)
    {
        var entidad = this.postulacionDAO.getById(id);

        entidad.setSeleccionado(postulacion.isSeleccionado());

        var seleccionEntidad = this.seleccionMapeador.construirEntidad(seleccion, entidad.getProyecto(), entidad.getUsuario());

        var usuario = this.personaDAO.findById(usuarioID).orElse(null);

        assert usuario != null;
        var roles = usuario.getRoles();

        roles.add(this.rolMapeador.construirEntidad(Rol.crear(TextoConstante.ROL_SELECCIONADO)));

        this.rolPersonaDAO.deleteById(roles.get(0).getId());
        roles.remove(0);

        usuario.setRoles(roles);

        usuario.getRoles().forEach(rol -> this.rolPersonaDAO.save(rol));

        this.seleccionDAO.save(seleccionEntidad);

        return this.postulacionDAO.save(entidad).getId();
    }
}