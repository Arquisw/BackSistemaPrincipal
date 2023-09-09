package co.edu.uco.arquisw.dominio.usuario.modelo;

import co.edu.uco.arquisw.dominio.transversal.excepciones.PatronExcepcion;
import co.edu.uco.arquisw.dominio.transversal.excepciones.ValorObligatorioExcepcion;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

class PersonaTest {
    @Test
    void validarCreacionPersonaExitosa() {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        String nombre = "juan";
        String apellidos = "Valencia";
        String correo = "jjuandiego23@gmail.com";

        Persona persona = Persona.crear(nombre, apellidos, correo);

        Assertions.assertEquals(nombre, persona.getNombre());
        Assertions.assertEquals(apellidos, persona.getApellidos());
        Assertions.assertEquals(correo, persona.getCorreo());
    }

    @Test
    void validarCamposFaltantes() {
        Assertions.assertEquals(Mensajes.NOMBRE_PERSONA_NO_PUEDE_ESTAR_VACIO, Assertions.assertThrows(ValorObligatorioExcepcion.class, () ->
                Persona.crear("", "valencia", "jjuandiego23@gmail.com")).getMessage());

        Assertions.assertEquals(Mensajes.APELLIDOS_PERSONA_NO_PUEDE_ESTAR_VACIO, Assertions.assertThrows(ValorObligatorioExcepcion.class, () ->
                Persona.crear("juan", "", "jjuandiego23@gmail.com")).getMessage());

        Assertions.assertEquals(Mensajes.CORREO_PERSONA_NO_PUEDE_ESTAR_VACIO, Assertions.assertThrows(ValorObligatorioExcepcion.class, () ->
                Persona.crear("juan", "valencia", "")).getMessage());


    }

    @Test
    void validarPatronesIncorrecto() {
        Assertions.assertEquals(Mensajes.PATRON_NOMBRE_PERSONA_NO_ES_VALIDO, Assertions.assertThrows(PatronExcepcion.class, () ->
                Persona.crear("juan1234-", "valencia", "jjuandiego23@gmail.com")).getMessage());

        Assertions.assertEquals(Mensajes.PATRON_APELLIDOS_PERSONA_NO_ES_VALIDO, Assertions.assertThrows(PatronExcepcion.class, () ->
                Persona.crear("juan", "valencia123-",
                        "jjuandiego23@gmail.com")).getMessage());

        Assertions.assertEquals(Mensajes.PATRON_CORREO_PERSONA_NO_ES_VALIDO, Assertions.assertThrows(PatronExcepcion.class, () ->
                Persona.crear("juan", "valencia", "jjuandiego@asffgh")).getMessage());

    }
}
