package co.edu.uco.arquisw.infraestructura.adaptador.entidad;

import javax.persistence.*;

@Entity
@Table(name = "perfil")
public class PerfilEntidad
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codigo;
    private String nombre;

    public PerfilEntidad(int codigo, String nombre)
    {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public PerfilEntidad()
    {

    }

    public int getCodigo()
    {
        return codigo;
    }

    public void setCodigo(int codigo)
    {
        this.codigo = codigo;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
}