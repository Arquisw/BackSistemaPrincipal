package co.edu.uco.arquisw.dominio.usuario.testdatabuilder;

import co.edu.uco.arquisw.dominio.usuario.modelo.Persona;
import co.edu.uco.arquisw.dominio.usuario.modelo.Rol;

import java.util.List;

public class PersonaTestDataBuilder
{
    private String nombre;
    private String apellidos;
    private String correo;
    private String clave;
    private List<Rol> roles;

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