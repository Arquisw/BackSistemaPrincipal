package co.edu.uco.arquisw.dominio.modelo;

public class UsuarioEntidad
{
    private int codigo;
    private Usuario usuario;
    private Entidad entidad;

    private UsuarioEntidad(int codigo, Usuario usuario, Entidad entidad)
    {
        this.codigo = codigo;
        setUsuario(usuario);
        setEntidad(entidad);
    }

    public static UsuarioEntidad crear(int codigo, Usuario usuario, Entidad entidad)
    {
        return new UsuarioEntidad(codigo, usuario, entidad);
    }

    public int getCodigo()
    {
        return codigo;
    }

    public Usuario getUsuario()
    {
        return usuario;
    }

    private void setUsuario(Usuario usuario)
    {
        this.usuario = usuario;
    }

    public Entidad getEntidad()
    {
        return entidad;
    }

    private void setEntidad(Entidad entidad)
    {
        this.entidad = entidad;
    }
}