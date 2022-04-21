package co.edu.uco.arquisw.aplicacion.dto;

public class UsuarioEntidadDTO
{
    private int codigo;
    private UsuarioDTO usuario;
    private EntidadDTO entidad;

    public UsuarioEntidadDTO()
    {

    }

    public UsuarioEntidadDTO(int codigo, UsuarioDTO usuario, EntidadDTO entidad)
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

    public UsuarioDTO getUsuario()
    {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario)
    {
        this.usuario = usuario;
    }

    public EntidadDTO getEntidad()
    {
        return entidad;
    }

    public void setEntidad(EntidadDTO entidad)
    {
        this.entidad = entidad;
    }
}