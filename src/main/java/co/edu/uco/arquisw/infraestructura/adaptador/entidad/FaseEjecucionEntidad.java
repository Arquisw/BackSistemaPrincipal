package co.edu.uco.arquisw.infraestructura.adaptador.entidad;

import java.util.List;

public class FaseEjecucionEntidad
{
    private int codigo;
    private boolean estado;
    private String urlDocumentacion;
    private List<ComentarioEntidad> comentarios;

    public FaseEjecucionEntidad()
    {

    }

    public FaseEjecucionEntidad(int codigo, boolean estado, String urlDocumentacion, List<ComentarioEntidad> comentarios)
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

    public List<ComentarioEntidad> getComentarios()
    {
        return comentarios;
    }

    public void setComentarios(List<ComentarioEntidad> comentarios)
    {
        this.comentarios = comentarios;
    }
}