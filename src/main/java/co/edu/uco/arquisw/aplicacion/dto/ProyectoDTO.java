package co.edu.uco.arquisw.aplicacion.dto;

public class ProyectoDTO
{
    private int codigo;
    private String nombre;
    private String descripcion;
    private EstadoProyectoDTO estado;
    private FaseProyectoDTO fase;
    private TipoConsultoriaDTO tipoConsultoria;

    public ProyectoDTO()
    {

    }

    public ProyectoDTO(int codigo, String nombre, String descripcion, EstadoProyectoDTO estado, FaseProyectoDTO fase, TipoConsultoriaDTO tipoConsultoria)
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

    public EstadoProyectoDTO getEstado()
    {
        return estado;
    }

    public void setEstado(EstadoProyectoDTO estado)
    {
        this.estado = estado;
    }

    public FaseProyectoDTO getFase()
    {
        return fase;
    }

    public void setFase(FaseProyectoDTO fase)
    {
        this.fase = fase;
    }

    public TipoConsultoriaDTO getTipoConsultoria()
    {
        return tipoConsultoria;
    }

    public void setTipoConsultoria(TipoConsultoriaDTO tipoConsultoria)
    {
        this.tipoConsultoria = tipoConsultoria;
    }
}