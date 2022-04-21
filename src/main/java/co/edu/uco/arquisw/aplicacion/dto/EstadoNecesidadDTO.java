package co.edu.uco.arquisw.aplicacion.dto;

public class EstadoNecesidadDTO
{
    private int codigo;
    private String nombre;

    public EstadoNecesidadDTO()
    {

    }

    public EstadoNecesidadDTO(int codigo, String nombre)
    {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public int getCodigo()
    {
        return codigo;
    }

    public void setCodigo(int codigo)
    {
        this.codigo = codigo;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
}
