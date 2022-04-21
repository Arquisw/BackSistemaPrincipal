package co.edu.uco.arquisw.aplicacion.dto;

public class ComentarioDTO
{
    private int codigo;
    private String descripcion;

    public ComentarioDTO()
    {

    }

    public int getCodigo()
    {
        return codigo;
    }

    public void setCodigo(int codigo)
    {
        this.codigo = codigo;
    }

    public String getDescripcion()
    {
        return descripcion;
    }

    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }

    public ComentarioDTO(int codigo, String descripcion)
    {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }
}