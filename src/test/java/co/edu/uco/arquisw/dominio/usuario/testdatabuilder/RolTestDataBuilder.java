package co.edu.uco.arquisw.dominio.usuario.testdatabuilder;

import co.edu.uco.arquisw.dominio.usuario.modelo.Rol;

public class RolTestDataBuilder
{
    private final String nombre;

    public RolTestDataBuilder() {
        this.nombre = "Administrador";
    }

    public Rol build ()
    {
        return Rol.crear(nombre);
    }
}
