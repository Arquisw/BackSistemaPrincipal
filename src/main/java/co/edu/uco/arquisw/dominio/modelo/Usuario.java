package co.edu.uco.arquisw.dominio.modelo;

import co.edu.uco.arquisw.dominio.utilitario.UtilTexto;

public class Usuario
{
    private int codigo;
    private String nombre;
    private String apellidos;
    private String numeroIdentificacion;
    private String correo;
    private String clave;
    private String institucion;
    private Perfil perfil;

    private Usuario(int codigo, String nombre, String apellidos, String numeroIdentificacion, String correo, String clave, String institucion, Perfil perfil)
    {
        this.codigo = codigo;
        setNombre(nombre);
        setApellidos(apellidos);
        setNumeroIdentificacion(numeroIdentificacion);
        setCorreo(correo);
        setClave(clave);
        setInstitucion(institucion);
        setPerfil(perfil);
    }

    public static Usuario crear(int codigo, String nombre, String apellidos, String numeroIdentificacion, String correo, String clave, String institucion, Perfil perfil)
    {
        return new Usuario(codigo, nombre, apellidos, numeroIdentificacion, correo, clave, institucion, perfil);
    }

    public int getCodigo()
    {
        return codigo;
    }

    public String getNombre()
    {
        return nombre;
    }

    private void setNombre(String nombre)
    {
        if(UtilTexto.cadenaEstaVacia(nombre))
        {
            new IllegalArgumentException("El nombre no puede estar vacio");
        }

        if(!UtilTexto.cadenaAlfanumerica(nombre))
        {
            new IllegalArgumentException("El nombre solo puede contener letras y numeros");
        }

        if(!UtilTexto.longitudEsValida(nombre, 1, 50))
        {
            new IllegalArgumentException("La longitud del nombre debe estar entre 1 y 50 caracteres");
        }

        this.nombre = nombre;
    }

    public String getApellidos()
    {
        return apellidos;
    }

    private void setApellidos(String apellidos)
    {
        if(UtilTexto.cadenaEstaVacia(apellidos))
        {
            new IllegalArgumentException("Los apellidos no puede estar vacio");
        }

        if(!UtilTexto.cadenaAlfanumerica(apellidos))
        {
            new IllegalArgumentException("Los apellidos solo puede contener letras y numeros");
        }

        if(!UtilTexto.longitudEsValida(apellidos, 1, 70))
        {
            new IllegalArgumentException("La longitud de los apellidos debe estar entre 1 y 70 caracteres");
        }

        this.apellidos = apellidos;
    }

    public String getNumeroIdentificacion()
    {

        return numeroIdentificacion;
    }

    private void setNumeroIdentificacion(String numeroIdentificacion)
    {
        if(UtilTexto.cadenaEstaVacia(numeroIdentificacion))
        {
            new IllegalArgumentException("El numero de identificacion no puede estar vacio");
        }

        if(!UtilTexto.cadenaID(numeroIdentificacion))
        {
            new IllegalArgumentException("El numero de identificacion solo puede tener numeros");
        }

        if(!UtilTexto.longitudEsValida(numeroIdentificacion, 8, 11))
        {
            new IllegalArgumentException("La longitud del numero de identificacion debe estar entre 8 y 11 caracteres");
        }

        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getCorreo()
    {
        return correo;
    }

    private void setCorreo(String correo)
    {
        if(UtilTexto.cadenaEstaVacia(correo))
        {
            new IllegalArgumentException("El correo no puede estar vacio");
        }

        if(!UtilTexto.cadenaCorreo(correo))
        {
            new IllegalArgumentException("el correo debe cumplir el patron de @example.com");
        }

        if(!UtilTexto.longitudEsValida(correo, 10, 100))
        {
            new IllegalArgumentException("La longitud del correo debe estar entre 10 y 100 caracteres");
        }

        this.correo = correo;
    }

    public String getClave()
    {
        return clave;
    }

    private void setClave(String clave)
    {
        if(UtilTexto.cadenaEstaVacia(clave))
        {
            new IllegalArgumentException("La clave no puede estar vacio");
        }

        if(!UtilTexto.cadenaClave(clave))
        {
            new IllegalArgumentException("La clave debe tener minimo una mayuscula, y un numero");
        }

        if(!UtilTexto.longitudEsValida(clave, 6, 100))
        {
            new IllegalArgumentException("La longitud de la clave  debe estar entre 6 y 100 caracteres");
        }

        this.clave = clave;
    }

    public String getInstitucion()
    {
        return institucion;
    }

    private void setInstitucion(String institucion)
    {
        if(UtilTexto.cadenaEstaVacia(institucion))
        {
            new IllegalArgumentException("La institucion no puede estar vacio");
        }

        if(!UtilTexto.cadenaAlfanumerica(institucion))
        {
            new IllegalArgumentException("La institucion solo puede tener letras y numeros");
        }

        if(!UtilTexto.longitudEsValida(institucion, 1, 100))
        {
            new IllegalArgumentException("La longitud de la institucion  debe estar entre 10 y 100 caracteres");
        }

        this.institucion = institucion;
    }

    public Perfil getPerfil()
    {
        return perfil;
    }

    private void setPerfil(Perfil perfil)
    {
        this.perfil = perfil;
    }
}