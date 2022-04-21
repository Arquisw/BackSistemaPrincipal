package co.edu.uco.arquisw.aplicacion.dto;

public class UsuarioPostulacionDTO
{
    private int codigo;
    private boolean estaSeleccionado;
    private UsuarioDTO usuario;
    private PostulacionDTO postulacion;
    private RolDTO rol;

    public UsuarioPostulacionDTO()
    {

    }

    public UsuarioPostulacionDTO(int codigo, boolean estaSeleccionado, UsuarioDTO usuario, PostulacionDTO postulacion, RolDTO rol)
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

    public UsuarioDTO getUsuario()
    {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario)
    {
        this.usuario = usuario;
    }

    public PostulacionDTO getPostulacion()
    {
        return postulacion;
    }

    public void setPostulacion(PostulacionDTO postulacion)
    {
        this.postulacion = postulacion;
    }

    public RolDTO getRol()
    {
        return rol;
    }

    public void setRol(RolDTO rol)
    {
        this.rol = rol;
    }
}
