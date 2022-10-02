package co.edu.uco.arquisw.dominio.usuario.modelo;

import co.edu.uco.arquisw.dominio.transversal.excepciones.PatronExcepcion;
import co.edu.uco.arquisw.dominio.transversal.excepciones.ValorObligatorioExcepcion;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

class PersonaTest
{
    @Test
    void  validarCreacionPersonaExitosa()
    {

        BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();

         String nombre = "juan";
         String apellidos = "Valencia";
         String correo = "jjuandiego23@gmail.com";
         String clave = "ASDasd1234";
         clave= passwordEncoder.encode(clave);
         List<Rol> roles = new ArrayList<>();
         Rol rol =  Rol.crear("administrador");
         roles.add(rol);

         Persona persona = Persona.crear(nombre, apellidos,correo,clave,roles);

        Assertions.assertEquals(nombre,persona.getNombre());
        Assertions.assertEquals(apellidos,persona.getApellidos());
        Assertions.assertEquals(correo,persona.getCorreo());
        Assertions.assertTrue(passwordEncoder.matches(clave,persona.getClave()));
        Assertions.assertEquals(rol,roles.get(0));

    }
    @Test
    void validarCamposFaltantes()
    {
        List<Rol> roles = new ArrayList<>();
        Rol rol =  Rol.crear("administrador");
        roles.add(rol);
        Assertions.assertEquals(Mensajes.NOMBRE_PERSONA_NO_PUEDE_ESTAR_VACIO,Assertions.assertThrows(ValorObligatorioExcepcion.class,() ->
                Persona.crear("","valencia","jjuandiego23@gmail.com","ASDasd1234",roles)).getMessage());

        Assertions.assertEquals(Mensajes.APELLIDOS_PERSONA_NO_PUEDE_ESTAR_VACIO,Assertions.assertThrows(ValorObligatorioExcepcion.class,() ->
                Persona.crear("juan","","jjuandiego23@gmail.com","ASDasd1234",roles)).getMessage());

        Assertions.assertEquals(Mensajes.CORREO_PERSONA_NO_PUEDE_ESTAR_VACIO,Assertions.assertThrows(ValorObligatorioExcepcion.class,() ->
                Persona.crear("juan","valencia","","ASDasd1234",roles)).getMessage());

        Assertions.assertEquals(Mensajes.CLAVE_PERSONA_NO_PUEDE_ESTAR_VACIO,Assertions.assertThrows(ValorObligatorioExcepcion.class,() ->
                Persona.crear("juan","valencia","jjuandiego23@gmail.com","",roles)).getMessage());

    }
    @Test
    void validarPatronesIncorrecto()
    {
        List<Rol> roles = new ArrayList<>();
        Rol rol =  Rol.crear("administrador");
        roles.add(rol);
        Assertions.assertEquals(Mensajes.PATRON_NOMBRE_PERSONA_NO_ES_VALIDO,Assertions.assertThrows(PatronExcepcion.class,() ->
                Persona.crear("juan1234-","valencia","jjuandiego23@gmail.com","ASDasd1234",roles)).getMessage());

        Assertions.assertEquals(Mensajes.PATRON_APELLIDOS_PERSONA_NO_ES_VALIDO,Assertions.assertThrows(PatronExcepcion.class,() ->
                Persona.crear("juan","valencia123-",
                        "jjuandiego23@gmail.com","ASDasd1234",roles)).getMessage());

        Assertions.assertEquals(Mensajes.PATRON_CORREO_PERSONA_NO_ES_VALIDO,Assertions.assertThrows(PatronExcepcion.class,() ->
                Persona.crear("juan","valencia","jjuandiego@asffgh","ASDasd1234",roles)).getMessage());

        Assertions.assertEquals(Mensajes.PATRON_CLAVE_PERSONA_NO_ES_VALIDO,Assertions.assertThrows(PatronExcepcion.class,() ->
                Persona.crear("juan","valencia","jjuandiego23@gmail.com","aaaaaaaaaaaa",roles)).getMessage());
    }
}
