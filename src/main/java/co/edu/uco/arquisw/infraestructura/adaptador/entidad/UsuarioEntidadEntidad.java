package co.edu.uco.arquisw.infraestructura.adaptador.entidad;

public class UsuarioEntidadEntidad
{
    private int codigo;
    private UsuarioEntidad usuario;
    private EntidadEntidad entidad;

    public UsuarioEntidadEntidad()
    {

    }

    public UsuarioEntidadEntidad(int codigo, UsuarioEntidad usuario, EntidadEntidad entidad)
    {
        this.codigo = codigo;
        this.usuario = usuario;
        this.entidad = entidad;
    }

    public int getCodigo()
    {
        return codigo;
    }

    public void setCodigo(int codigo)
    {
        this.codigo = codigo;
    }

    public UsuarioEntidad getUsuario()
    {
        return usuario;
    }

    public void setUsuario(UsuarioEntidad usuario)
    {
        this.usuario = usuario;
    }

    public EntidadEntidad getEntidad()
    {
        return entidad;
    }

    public void setEntidad(EntidadEntidad entidad)
    {
        this.entidad = entidad;
    }
}