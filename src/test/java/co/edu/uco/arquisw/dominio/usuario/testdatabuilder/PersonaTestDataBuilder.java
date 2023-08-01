package co.edu.uco.arquisw.dominio.usuario.testdatabuilder;

import co.edu.uco.arquisw.dominio.usuario.modelo.Persona;

public class PersonaTestDataBuilder {
    private final String nombre;
    private final String apellidos;
    private final String correo;

    public PersonaTestDataBuilder() {
        this.nombre = "juan";
        this.apellidos = "valencia";
        this.correo = "jjuandiego23@gmail.com";
    }

    public Persona build() {
        return Persona.crear(nombre, apellidos, correo);
    }
}