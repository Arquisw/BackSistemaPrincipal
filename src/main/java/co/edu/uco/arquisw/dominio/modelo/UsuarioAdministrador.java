package co.edu.uco.arquisw.dominio.modelo;

import java.util.List;

public class UsuarioAdministrador
{
    private int codigo;
    private Usuario usuario;
    private List<Requerimiento> requerimientos;
    private List<UsuarioPostulacion> usuariosPostulados;

    private UsuarioAdministrador(int codigo, Usuario usuario, List<Requerimiento> requerimientos, List<UsuarioPostulacion> usuariosPostulados)
    {
        this.codigo = codigo;
        setUsuario(usuario);
        setRequerimientos(requerimientos);
        setUsuariosPostulados(usuariosPostulados);
    }

    public static UsuarioAdministrador crear(int codigo, Usuario usuario, List<Requerimiento> requerimientos, List<UsuarioPostulacion> usuariosPostulados)
    {
        return new UsuarioAdministrador(codigo, usuario, requerimientos, usuariosPostulados);
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

    public List<Requerimiento> getRequerimientos()
    {
        return requerimientos;
    }

    private void setRequerimientos(List<Requerimiento> requerimientos)
    {
        this.requerimientos = requerimientos;
    }

    public List<UsuarioPostulacion> getUsuariosPostulados()
    {
        return usuariosPostulados;
    }

    private void setUsuariosPostulados(List<UsuarioPostulacion> usuariosPostulados)
    {
        this.usuariosPostulados = usuariosPostulados;
    }
}
