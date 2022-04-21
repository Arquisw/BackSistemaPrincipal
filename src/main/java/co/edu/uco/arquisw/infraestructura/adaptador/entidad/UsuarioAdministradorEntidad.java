package co.edu.uco.arquisw.infraestructura.adaptador.entidad;

import java.util.List;

public class UsuarioAdministradorEntidad
{
    private int codigo;
    private UsuarioEntidad usuario;
    private List<RequerimientoEntidad> requerimientos;
    private List<UsuarioPostulacionEntidad> usuariosPostulados;

    public UsuarioAdministradorEntidad()
    {

    }

    public UsuarioAdministradorEntidad(int codigo, UsuarioEntidad usuario, List<RequerimientoEntidad> requerimientos, List<UsuarioPostulacionEntidad> usuariosPostulados)
    {
        this.codigo = codigo;
        this.usuario = usuario;
        this.requerimientos = requerimientos;
        this.usuariosPostulados = usuariosPostulados;
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

    public List<RequerimientoEntidad> getRequerimientos()
    {
        return requerimientos;
    }

    public void setRequerimientos(List<RequerimientoEntidad> requerimientos)
    {
        this.requerimientos = requerimientos;
    }


    public List<UsuarioPostulacionEntidad> getUsuariosPostulados()
    {
        return usuariosPostulados;
    }

    public void setUsuariosPostulados(List<UsuarioPostulacionEntidad> usuariosPostulados)
    {
        this.usuariosPostulados = usuariosPostulados;
    }
}
