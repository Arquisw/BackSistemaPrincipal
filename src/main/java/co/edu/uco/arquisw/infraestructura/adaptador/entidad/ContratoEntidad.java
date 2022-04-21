package co.edu.uco.arquisw.infraestructura.adaptador.entidad;

import javax.persistence.*;

@Entity
@Table(name = "contrato")
public class ContratoEntidad
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codigo;
    private String urlArchivo;

    public ContratoEntidad()
    {

    }

    public ContratoEntidad(int codigo, String urlArchivo)
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
