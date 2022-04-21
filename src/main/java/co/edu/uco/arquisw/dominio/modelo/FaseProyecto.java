package co.edu.uco.arquisw.dominio.modelo;

public class FaseProyecto
{
    private int codigo;
    private FaseDetallada faseDetallada;
    private FaseEjecucion faseEjecucion;

    private FaseProyecto(int codigo, FaseDetallada faseDetallada, FaseEjecucion faseEjecucion)
    {
        this.codigo = codigo;
        setFaseDetallada(faseDetallada);
        setFaseEjecucion(faseEjecucion);
    }

    public static FaseProyecto crear(int codigo, FaseDetallada faseDetallada, FaseEjecucion faseEjecucion)
    {
        return new FaseProyecto(codigo, faseDetallada, faseEjecucion);
    }

    public int getCodigo()
    {
        return codigo;
    }

    public FaseDetallada getFaseDetallada()
    {
        return faseDetallada;
    }

    private void setFaseDetallada(FaseDetallada faseDetallada)
    {
        this.faseDetallada = faseDetallada;
    }

    public FaseEjecucion getFaseEjecucion()
    {
        return faseEjecucion;
    }

    private void setFaseEjecucion(FaseEjecucion faseEjecucion)
    {
        this.faseEjecucion = faseEjecucion;
    }
}
