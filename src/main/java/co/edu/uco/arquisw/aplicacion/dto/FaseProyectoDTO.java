package co.edu.uco.arquisw.aplicacion.dto;

public class FaseProyectoDTO
{
    private int codigo;
    private FaseDetalladaDTO faseDetallada;
    private FaseEjecucionDTO faseEjecucion;

    public FaseProyectoDTO()
    {

    }

    public FaseProyectoDTO(int codigo, FaseDetalladaDTO faseDetallada, FaseEjecucionDTO faseEjecucion)
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

    public FaseDetalladaDTO getFaseDetallada()
    {
        return faseDetallada;
    }

    public void setFaseDetallada(FaseDetalladaDTO faseDetallada)
    {
        this.faseDetallada = faseDetallada;
    }

    public FaseEjecucionDTO getFaseEjecucion()
    {
        return faseEjecucion;
    }

    public void setFaseEjecucion(FaseEjecucionDTO faseEjecucion)
    {
        this.faseEjecucion = faseEjecucion;
    }
}
