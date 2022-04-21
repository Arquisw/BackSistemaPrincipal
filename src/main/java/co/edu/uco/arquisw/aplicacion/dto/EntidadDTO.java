package co.edu.uco.arquisw.aplicacion.dto;

public class EntidadDTO
{
    private int codigo;
    private String nit;
    private String nombre;
    private EstadoEntidadDTO estado;
    private NecesidadDTO necesidad;

    public EntidadDTO()
    {

    }

    public EntidadDTO(int codigo, String nit, String nombre, EstadoEntidadDTO estado, NecesidadDTO necesidad)
    {
        this.codigo = codigo;
        this.nit = nit;
        this.nombre = nombre;
        this.estado = estado;
        this.necesidad = necesidad;
    }

    public int getCodigo()
    {
        return codigo;
    }

    public void setCodigo(int codigo)
    {
        this.codigo = codigo;
    }

    public String getNit()
    {
        return nit;
    }

    public void setNit(String nit)
    {
        this.nit = nit;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public EstadoEntidadDTO getEstado()
    {
        return estado;
    }

    public void setEstado(EstadoEntidadDTO estado)
    {
        this.estado = estado;
    }

    public NecesidadDTO getNecesidad()
    {
        return necesidad;
    }

    public void setNecesidad(NecesidadDTO necesidad)
    {
        this.necesidad = necesidad;
    }
}