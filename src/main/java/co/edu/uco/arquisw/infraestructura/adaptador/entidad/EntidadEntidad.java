package co.edu.uco.arquisw.infraestructura.adaptador.entidad;

public class EntidadEntidad
{
    private int codigo;
    private String nit;
    private String nombre;
    private EstadoEntidadEntidad estado;
    private NecesidadEntidad necesidad;

    public EntidadEntidad()
    {

    }

    public EntidadEntidad(int codigo, String nit, String nombre, EstadoEntidadEntidad estado, NecesidadEntidad necesidad)
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

    public EstadoEntidadEntidad getEstado()
    {
        return estado;
    }

    public void setEstado(EstadoEntidadEntidad estado)
    {
        this.estado = estado;
    }

    public NecesidadEntidad getNecesidad()
    {
        return necesidad;
    }

    public void setNecesidad(NecesidadEntidad necesidad)
    {
        this.necesidad = necesidad;
    }
}