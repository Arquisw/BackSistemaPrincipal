package co.edu.uco.arquisw.dominio.modelo;

public class UsuarioAsociacion
{
    private int codigo;
    private Usuario usuario;
    private Asociacion asociacion;

    private UsuarioAsociacion(int codigo, Usuario usuario, Asociacion asociacion)
    {
        this.codigo = codigo;
        setUsuario(usuario);
        setEntidad(asociacion);
    }

    public static UsuarioAsociacion crear(int codigo, Usuario usuario, Asociacion asociacion)
    {
        return new UsuarioAsociacion(codigo, usuario, asociacion);
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

    public Asociacion getEntidad()
    {
        return asociacion;
    }

    private void setEntidad(Asociacion asociacion)
    {
        this.asociacion = asociacion;
    }
}