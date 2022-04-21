package co.edu.uco.arquisw.infraestructura.adaptador.entidad;

public class RequerimientoEntidad
{
    private int codigo;
    private NecesidadEntidad necesidad;
    private ContratoEntidad contrato;

    public RequerimientoEntidad()
    {

    }

    public RequerimientoEntidad(int codigo, NecesidadEntidad necesidad, ContratoEntidad contrato)
    {
        this.codigo = codigo;
        this.necesidad = necesidad;
        this.contrato = contrato;
    }

    public int getCodigo()
    {
        return codigo;
    }

    public void setCodigo(int codigo)
    {
        this.codigo = codigo;
    }

    public NecesidadEntidad getNecesidad()
    {
        return necesidad;
    }

    public void setNecesidad(NecesidadEntidad necesidad)
    {
        this.necesidad = necesidad;
    }

    public ContratoEntidad getContrato()
    {
        return contrato;
    }

    public void setContrato(ContratoEntidad contrato)
    {
        this.contrato = contrato;
    }
}