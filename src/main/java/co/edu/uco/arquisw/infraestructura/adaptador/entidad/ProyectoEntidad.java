package co.edu.uco.arquisw.infraestructura.adaptador.entidad;

public class ProyectoEntidad
{
    private int codigo;
    private String nombre;
    private String descripcion;
    private EstadoProyectoEntidad estado;
    private FaseProyectoEntidad fase;
    private TipoConsultoriaEntidad tipoConsultoria;

    public ProyectoEntidad()
    {

    }

    public ProyectoEntidad(int codigo, String nombre, String descripcion, EstadoProyectoEntidad estado, FaseProyectoEntidad fase, TipoConsultoriaEntidad tipoConsultoria)
    {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fase = fase;
        this.tipoConsultoria = tipoConsultoria;
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

    public String getDescripcion()
    {
        return descripcion;
    }

    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }

    public EstadoProyectoEntidad getEstado()
    {
        return estado;
    }

    public void setEstado(EstadoProyectoEntidad estado)
    {
        this.estado = estado;
    }

    public FaseProyectoEntidad getFase()
    {
        return fase;
    }

    public void setFase(FaseProyectoEntidad fase)
    {
        this.fase = fase;
    }

    public TipoConsultoriaEntidad getTipoConsultoria()
    {
        return tipoConsultoria;
    }

    public void setTipoConsultoria(TipoConsultoriaEntidad tipoConsultoria)
    {
        this.tipoConsultoria = tipoConsultoria;
    }
}