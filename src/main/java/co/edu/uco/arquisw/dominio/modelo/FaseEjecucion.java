package co.edu.uco.arquisw.dominio.modelo;

import co.edu.uco.arquisw.dominio.utilitario.UtilTexto;

import java.util.List;

public class FaseEjecucion
{
    private int codigo;
    private boolean estado;
    private String urlDocumentacion;
    private List<Comentario> comentarios;

    public FaseEjecucion(int codigo, boolean estado, String urlDocumentacion, List<Comentario> comentarios)
    {
        this.codigo = codigo;
        setEstado(estado);
        setUrlDocumentacion(urlDocumentacion);
        setComentarios(comentarios);
    }

    public static FaseEjecucion crear(int codigo, boolean estado, String urlDocumentacion, List<Comentario> comentarios)
    {
        return new FaseEjecucion(codigo, estado, urlDocumentacion, comentarios);
    }

    public int getCodigo()
    {
        return codigo;
    }

    public boolean isEstado()
    {
        return estado;
    }

    private void setEstado(boolean estado)
    {
        this.estado = estado;
    }

    public String getUrlDocumentacion()
    {
        return urlDocumentacion;
    }

    private void setUrlDocumentacion(String urlDocumentacion)
    {
        if(UtilTexto.cadenaEstaVacia(urlDocumentacion))
        {
            new IllegalArgumentException("El urlDocumentacion no puede estar vacio");
        }

        if(!UtilTexto.cadenaURL(urlDocumentacion))
        {
            new IllegalArgumentException("El urlDocumentacion debe cumplir el patron de url");
        }

        if(!UtilTexto.longitudEsValida(urlDocumentacion, 1, 2000))
        {
            new IllegalArgumentException("La longitud del urlDocumentacion debe estar entre 1 y 2000 caracteres");
        }

        this.urlDocumentacion = urlDocumentacion;
    }

    public List<Comentario> getComentarios()
    {
        return comentarios;
    }

    private void setComentarios(List<Comentario> comentarios)
    {
        this.comentarios = comentarios;
    }
}