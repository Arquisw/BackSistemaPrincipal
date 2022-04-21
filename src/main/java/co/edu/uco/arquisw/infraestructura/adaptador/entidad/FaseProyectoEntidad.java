package co.edu.uco.arquisw.infraestructura.adaptador.entidad;

public class FaseProyectoEntidad
{
    private int codigo;
    private FaseDetalladaEntidad faseDetallada;
    private FaseEjecucionEntidad faseEjecucion;

    public FaseProyectoEntidad()
    {

    }

    public FaseProyectoEntidad(int codigo, FaseDetalladaEntidad faseDetallada, FaseEjecucionEntidad faseEjecucion)
    {
        this.codigo = codigo;
        this.faseDetallada = faseDetallada;
        this.faseEjecucion = faseEjecucion;
    }

    public int getCodigo()
    {
        return codigo;
    }

    public void setCodigo(int codigo)
    {
        this.codigo = codigo;
    }

    public FaseDetalladaEntidad getFaseDetallada()
    {
        return faseDetallada;
    }

    public void setFaseDetallada(FaseDetalladaEntidad faseDetallada)
    {
        this.faseDetallada = faseDetallada;
    }

    public FaseEjecucionEntidad getFaseEjecucion()
    {
        return faseEjecucion;
    }

    public void setFaseEjecucion(FaseEjecucionEntidad faseEjecucion)
    {
        this.faseEjecucion = faseEjecucion;
    }
}
