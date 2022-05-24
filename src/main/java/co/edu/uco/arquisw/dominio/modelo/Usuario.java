package co.edu.uco.arquisw.dominio.modelo;

import co.edu.uco.arquisw.dominio.validador.ValidarTexto;
import lombok.Getter;

import java.util.List;

@Getter
public class Usuario
{
    private int codigo;
    private String nombre;
    private String apellidos;
    private String numeroIdentificacion;
    private String correo;
    private String clave;
    private String institucion;
    private List<Perfil> perfiles;

    private Usuario(int codigo, String nombre, String apellidos, String numeroIdentificacion, String correo, String clave, String institucion, List<Perfil> perfiles)
    {
        this.codigo = codigo;
        setNombre(nombre);
        setApellidos(apellidos);
        setNumeroIdentificacion(numeroIdentificacion);
        setCorreo(correo);
        setClave(clave);
        setInstitucion(institucion);
        setPerfiles(perfiles);
    }

    public static Usuario crear(int codigo, String nombre, String apellidos, String numeroIdentificacion, String correo, String clave, String institucion, List<Perfil> perfiles)
    {
        return new Usuario(codigo, nombre, apellidos, numeroIdentificacion, correo, clave, institucion, perfiles);
    }

    private void setNombre(String nombre)
    {
        if(ValidarTexto.cadenaEstaVacia(nombre))
        {
            new IllegalArgumentException("El nombre no puede estar vacio");
        }

        if(!ValidarTexto.cadenaAlfanumerica(nombre))
        {
            new IllegalArgumentException("El nombre solo puede contener letras y numeros");
        }

        if(!ValidarTexto.longitudEsValida(nombre, 1, 50))
        {
            new IllegalArgumentException("La longitud del nombre debe estar entre 1 y 50 caracteres");
        }

        this.nombre = nombre;
    }

    private void setApellidos(String apellidos)
    {
        if(ValidarTexto.cadenaEstaVacia(apellidos))
        {
            new IllegalArgumentException("Los apellidos no puede estar vacio");
        }

        if(!ValidarTexto.cadenaAlfanumerica(apellidos))
        {
            new IllegalArgumentException("Los apellidos solo puede contener letras y numeros");
        }

        if(!ValidarTexto.longitudEsValida(apellidos, 1, 70))
        {
            new IllegalArgumentException("La longitud de los apellidos debe estar entre 1 y 70 caracteres");
        }

        this.apellidos = apellidos;
    }

    private void setNumeroIdentificacion(String numeroIdentificacion)
    {
        if(ValidarTexto.cadenaEstaVacia(numeroIdentificacion))
        {
            new IllegalArgumentException("El numero de identificacion no puede estar vacio");
        }

        if(!ValidarTexto.cadenaID(numeroIdentificacion))
        {
            new IllegalArgumentException("El numero de identificacion solo puede tener numeros");
        }

        if(!ValidarTexto.longitudEsValida(numeroIdentificacion, 8, 11))
        {
            new IllegalArgumentException("La longitud del numero de identificacion debe estar entre 8 y 11 caracteres");
        }

        this.numeroIdentificacion = numeroIdentificacion;
    }

    private void setCorreo(String correo)
    {
        if(ValidarTexto.cadenaEstaVacia(correo))
        {
            new IllegalArgumentException("El correo no puede estar vacio");
        }

        if(!ValidarTexto.cadenaCorreo(correo))
        {
            new IllegalArgumentException("el correo debe cumplir el patron de @example.com");
        }

        if(!ValidarTexto.longitudEsValida(correo, 10, 100))
        {
            new IllegalArgumentException("La longitud del correo debe estar entre 10 y 100 caracteres");
        }

        this.correo = correo;
    }

    private void setClave(String clave)
    {
        if(ValidarTexto.cadenaEstaVacia(clave))
        {
            new IllegalArgumentException("La clave no puede estar vacio");
        }

        if(!ValidarTexto.cadenaClave(clave))
        {
            new IllegalArgumentException("La clave debe tener minimo una mayuscula, y un numero");
        }

        if(!ValidarTexto.longitudEsValida(clave, 6, 100))
        {
            new IllegalArgumentException("La longitud de la clave  debe estar entre 6 y 100 caracteres");
        }

        this.clave = clave;
    }

    private void setInstitucion(String institucion)
    {
        if(ValidarTexto.cadenaEstaVacia(institucion))
        {
            new IllegalArgumentException("La institucion no puede estar vacio");
        }

        if(!ValidarTexto.cadenaAlfanumerica(institucion))
        {
            new IllegalArgumentException("La institucion solo puede tener letras y numeros");
        }

        if(!ValidarTexto.longitudEsValida(institucion, 1, 100))
        {
            new IllegalArgumentException("La longitud de la institucion  debe estar entre 10 y 100 caracteres");
        }

        this.institucion = institucion;
    }

    private void setPerfiles(List<Perfil> perfiles)
    {
        this.perfiles = perfiles;
    }
}