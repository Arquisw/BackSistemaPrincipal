package co.edu.uco.arquisw.infraestructura.usuario.testdatabuilder;

import co.edu.uco.arquisw.aplicacion.usuario.comando.PersonaComando;

public class PersonaDtoTestDataBuilder {

    private String nombre;
    private String apellidos;
    private String correo;
    private String clave;

    public PersonaDtoTestDataBuilder() {
        this.nombre = "juan";
        this.apellidos = "valencia";
        this.correo = "jjuandiego23@gmail.com";
        this.clave = "Asd1234a";
    }

    public PersonaComando build() {
        return new PersonaComando(nombre, apellidos, correo, clave);
    }
}
