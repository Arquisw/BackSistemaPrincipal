package co.edu.uco.arquisw.dominio.modelo;

public class UsuarioPostulacion
{
    private int codigo;
    private boolean estaSeleccionado;
    private Usuario usuario;
    private Postulacion postulacion;
    private Rol rol;

    private UsuarioPostulacion(int codigo, boolean estaSeleccionado, Usuario usuario, Postulacion postulacion, Rol rol)
    {
        this.codigo = codigo;
        setEstaSeleccionado(estaSeleccionado);
        setUsuario(usuario);
        setPostulacion(postulacion);
        setRol(rol);
    }

    public static UsuarioPostulacion crear(int codigo, boolean estaSeleccionado, Usuario usuario, Postulacion postulacion, Rol rol)
    {
        return new UsuarioPostulacion(codigo,estaSeleccionado, usuario, postulacion, rol);
    }

    public int getCodigo()
    {
        return codigo;
    }

    public boolean isEstaSeleccionado()
    {
        return estaSeleccionado;
    }

    private void setEstaSeleccionado(boolean estaSeleccionado)
    {
        this.estaSeleccionado = estaSeleccionado;
    }

    public Usuario getUsuario()
    {
        return usuario;
    }

    private void setUsuario(Usuario usuario)
    {
        this.usuario = usuario;
    }

    public Postulacion getPostulacion()
    {
        return postulacion;
    }

    private void setPostulacion(Postulacion postulacion)
    {
        this.postulacion = postulacion;
    }

    public Rol getRol()
    {
        return rol;
    }

    private void setRol(Rol rol)
    {
        this.rol = rol;
    }
}
