package co.edu.uco.arquisw.aplicacion.dto;

public class ContratoDTO
{
    private int codigo;
    private String urlArchivo;

    public ContratoDTO()
    {

    }

    public ContratoDTO(int codigo, String urlArchivo)
    {
        this.codigo = codigo;
        this.urlArchivo = urlArchivo;
    }

    public int getCodigo()
    {
        return codigo;
    }

    public void setCodigo(int codigo)
    {
        this.codigo = codigo;
    }

    public String getUrlArchivo()
    {
        return urlArchivo;
    }

    public void setUrlArchivo(String urlArchivo)
    {
        this.urlArchivo = urlArchivo;
    }
}
