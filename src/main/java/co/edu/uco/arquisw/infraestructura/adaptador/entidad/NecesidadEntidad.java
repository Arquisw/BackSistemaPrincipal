package co.edu.uco.arquisw.infraestructura.adaptador.entidad;

public class NecesidadEntidad
{
    private int codigo;
    private int tiempo;
    private String rutaArchivo;
    private ProyectoEntidad proyecto;
    private EstadoNecesidadEntidad estado;

    public NecesidadEntidad()
    {

    }

    public NecesidadEntidad(int codigo, int tiempo, String rutaArchivo, ProyectoEntidad proyecto, EstadoNecesidadEntidad estado)
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

    public ProyectoEntidad getProyecto()
    {
        return proyecto;
    }

    public void setProyecto(ProyectoEntidad proyecto)
    {
        this.proyecto = proyecto;
    }

    public EstadoNecesidadEntidad getEstado()
    {
        return estado;
    }

    public void setEstado(EstadoNecesidadEntidad estado)
    {
        this.estado = estado;
    }
}