package co.edu.uco.arquisw.dominio.modelo;

public class Requerimiento
{
    private int codigo;
    private Necesidad necesidad;
    private Contrato contrato;

    private Requerimiento(int codigo, Necesidad necesidad, Contrato contrato)
    {
        this.codigo = codigo;
        setNecesidad(necesidad);
        setContrato(contrato);
    }

    public static Requerimiento crear(int codigo, Necesidad necesidad, Contrato contrato)
    {
        return new Requerimiento(codigo, necesidad, contrato);
    }

    public int getCodigo()
    {
        return codigo;
    }

    public Necesidad getNecesidad()
    {
        return necesidad;
    }

    private void setNecesidad(Necesidad necesidad)
    {
        this.necesidad = necesidad;
    }

    public Contrato getContrato()
    {
        return contrato;
    }

    private void setContrato(Contrato contrato)
    {
        this.contrato = contrato;
    }
}