package co.edu.uco.arquisw.dominio.usuario.testdatabuilder;

import co.edu.uco.arquisw.dominio.usuario.modelo.Persona;
import co.edu.uco.arquisw.dominio.usuario.modelo.Rol;

import java.util.List;

public class PersonaTestDataBuilder
{
    private final String nombre;
    private final String apellidos;
    private final String correo;
    private final String clave;
    private final List<Rol> roles;

    public PersonaTestDataBuilder() {
        this.nombre = "juan";
        this.apellidos = "valencia";
        this.correo = "jjuandiego23@gmail.com";
        this.clave = "Asd1234a";
        this.roles = List.of(new RolTestDataBuilder().build());
    }
     public Persona build()
     {
         return Persona.crear(nombre,apellidos,correo,clave,List.of(roles.get(0)));
     }

}