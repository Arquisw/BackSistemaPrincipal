package co.edu.uco.arquisw.aplicacion.dto;

import java.util.List;

public class UsuarioAdministradorDTO
{
    private int codigo;
    private UsuarioDTO usuario;
    private List<RequerimientoDTO> requerimientos;
    private List<UsuarioPostulacionDTO> usuariosPostulados;

    public UsuarioAdministradorDTO()
    {

    }

    public UsuarioAdministradorDTO(int codigo, UsuarioDTO usuario, List<RequerimientoDTO> requerimientos, List<UsuarioPostulacionDTO> usuariosPostulados)
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

    public UsuarioDTO getUsuario()
    {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario)
    {
        this.usuario = usuario;
    }

    public List<RequerimientoDTO> getRequerimientos()
    {
        return requerimientos;
    }

    public void setRequerimientos(List<RequerimientoDTO> requerimientos)
    {
        this.requerimientos = requerimientos;
    }


    public List<UsuarioPostulacionDTO> getUsuariosPostulados()
    {
        return usuariosPostulados;
    }

    public void setUsuariosPostulados(List<UsuarioPostulacionDTO> usuariosPostulados)
    {
        this.usuariosPostulados = usuariosPostulados;
    }
}
