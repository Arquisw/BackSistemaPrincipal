package co.edu.uco.arquisw.aplicacion.dto;

public class RequerimientoDTO
{
    private int codigo;
    private NecesidadDTO necesidad;
    private ContratoDTO contrato;

    public RequerimientoDTO()
    {

    }

    public RequerimientoDTO(int codigo, NecesidadDTO necesidad, ContratoDTO contrato)
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

    public NecesidadDTO getNecesidad()
    {
        return necesidad;
    }

    public void setNecesidad(NecesidadDTO necesidad)
    {
        this.necesidad = necesidad;
    }

    public ContratoDTO getContrato()
    {
        return contrato;
    }

    public void setContrato(ContratoDTO contrato)
    {
        this.contrato = contrato;
    }
}