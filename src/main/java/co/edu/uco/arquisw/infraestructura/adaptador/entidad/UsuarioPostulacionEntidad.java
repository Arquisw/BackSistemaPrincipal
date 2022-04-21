package co.edu.uco.arquisw.infraestructura.adaptador.entidad;

public class UsuarioPostulacionEntidad
{
    private int codigo;
    private boolean estaSeleccionado;
    private UsuarioEntidad usuario;
    private PostulacionEntidad postulacion;
    private RolEntidad rol;

    public UsuarioPostulacionEntidad()
    {

    }

    public UsuarioPostulacionEntidad(int codigo, boolean estaSeleccionado, UsuarioEntidad usuario, PostulacionEntidad postulacion, RolEntidad rol)
    {
        this.codigo = codigo;
        this.estaSeleccionado = estaSeleccionado;
        this.usuario = usuario;
        this.postulacion = postulacion;
        this.rol = rol;
    }

    public int getCodigo()
    {
        return codigo;
    }

    public void setCodigo(int codigo)
    {
        this.codigo = codigo;
    }

    public boolean isEstaSeleccionado()
    {
        return estaSeleccionado;
    }

    public void setEstaSeleccionado(boolean estaSeleccionado)
    {
        this.estaSeleccionado = estaSeleccionado;
    }

    public UsuarioEntidad getUsuario()
    {
        return usuario;
    }

    public void setUsuario(UsuarioEntidad usuario)
    {
        this.usuario = usuario;
    }

    public PostulacionEntidad getPostulacion()
    {
        return postulacion;
    }

    public void setPostulacion(PostulacionEntidad postulacion)
    {
        this.postulacion = postulacion;
    }

    public RolEntidad getRol()
    {
        return rol;
    }

    public void setRol(RolEntidad rol)
    {
        this.rol = rol;
    }
}
