package co.edu.uco.arquisw.aplicacion.dto;

public class NecesidadDTO
{
    private int codigo;
    private int tiempo;
    private String rutaArchivo;
    private ProyectoDTO proyecto;
    private EstadoNecesidadDTO estado;

    public NecesidadDTO()
    {

    }

    public NecesidadDTO(int codigo, int tiempo, String rutaArchivo, ProyectoDTO proyecto, EstadoNecesidadDTO estado)
    {
        this.codigo = codigo;
        this.tiempo = tiempo;
        this.rutaArchivo = rutaArchivo;
        this.proyecto = proyecto;
        this.estado = estado;
    }

    public int getCodigo()
    {
        return codigo;
    }

    public void setCodigo(int codigo)
    {
        this.codigo = codigo;
    }

    public int getTiempo()
    {
        return tiempo;
    }

    public void setTiempo(int tiempo)
    {
        this.tiempo = tiempo;
    }

    public String getRutaArchivo()
    {
        return rutaArchivo;
    }

    public void setRutaArchivo(String rutaArchivo)
    {
        this.rutaArchivo = rutaArchivo;
    }

    public ProyectoDTO getProyecto()
    {
        return proyecto;
    }

    public void setProyecto(ProyectoDTO proyecto)
    {
        this.proyecto = proyecto;
    }

    public EstadoNecesidadDTO getEstado()
    {
        return estado;
    }

    public void setEstado(EstadoNecesidadDTO estado)
    {
        this.estado = estado;
    }
}