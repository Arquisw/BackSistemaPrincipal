package co.edu.uco.arquisw.aplicacion.dto;

import java.util.List;

public class FaseEjecucionDTO
{
    private int codigo;
    private boolean estado;
    private String urlDocumentacion;
    private List<ComentarioDTO> comentarios;

    public FaseEjecucionDTO()
    {

    }

    public FaseEjecucionDTO(int codigo, boolean estado, String urlDocumentacion, List<ComentarioDTO> comentarios)
    {
        this.codigo = codigo;
        this.estado = estado;
        this.urlDocumentacion = urlDocumentacion;
        this.comentarios = comentarios;
    }

    public int getCodigo()
    {
        return codigo;
    }

    public void setCodigo(int codigo)
    {
        this.codigo = codigo;
    }

    public boolean isEstado()
    {
        return estado;
    }

    public void setEstado(boolean estado)
    {
        this.estado = estado;
    }

    public String getUrlDocumentacion()
    {
        return urlDocumentacion;
    }

    public void setUrlDocumentacion(String urlDocumentacion)
    {
        this.urlDocumentacion = urlDocumentacion;
    }

    public List<ComentarioDTO> getComentarios()
    {
        return comentarios;
    }

    public void setComentarios(List<ComentarioDTO> comentarios)
    {
        this.comentarios = comentarios;
    }
}