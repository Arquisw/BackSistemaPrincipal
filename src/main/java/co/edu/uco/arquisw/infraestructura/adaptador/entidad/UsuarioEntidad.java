package co.edu.uco.arquisw.infraestructura.adaptador.entidad;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
public class UsuarioEntidad
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codigo;
    private String nombre;
    private String apellidos;
    private String numeroIdentificacion;
    private String correo;
    private String clave;
    private String institucion;
    @ManyToOne
    @JoinColumn(name = "perfil")
    private PerfilEntidad perfil;

    public UsuarioEntidad()
    {

    }

    public UsuarioEntidad(int codigo, String nombre, String apellidos, String numeroIdentificacion, String correo, String clave, String institucion, PerfilEntidad perfil)
    {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.numeroIdentificacion = numeroIdentificacion;
        this.correo = correo;
        this.clave = clave;
        this.institucion = institucion;
        this.perfil = perfil;
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

    public String getApellidos()
    {
        return apellidos;
    }

    public void setApellidos(String apellidos)
    {
        this.apellidos = apellidos;
    }

    public String getNumeroIdentificacion()
    {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion)
    {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getCorreo()
    {
        return correo;
    }

    public void setCorreo(String correo)
    {
        this.correo = correo;
    }

    public String getClave()
    {
        return clave;
    }

    public void setClave(String clave)
    {
        this.clave = clave;
    }

    public String getInstitucion()
    {
        return institucion;
    }

    public void setInstitucion(String institucion)
    {
        this.institucion = institucion;
    }

    public PerfilEntidad getPerfil()
    {
        return perfil;
    }

    public void setPerfil(PerfilEntidad perfil)
    {
        this.perfil = perfil;
    }
}