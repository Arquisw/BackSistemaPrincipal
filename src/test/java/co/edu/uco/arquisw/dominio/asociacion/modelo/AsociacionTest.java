package co.edu.uco.arquisw.dominio.asociacion.modelo;

import co.edu.uco.arquisw.dominio.transversal.excepciones.LongitudExcepcion;
import co.edu.uco.arquisw.dominio.transversal.excepciones.PatronExcepcion;
import co.edu.uco.arquisw.dominio.transversal.excepciones.ValorObligatorioExcepcion;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



public class AsociacionTest {

    @Test
    void  validarCreacionAsociacionExitosa()
    {
        String nombre = "Uco";
        String nit = "890984746-7";
        String numeroContacto = "3125678170";

        Asociacion asociacion = Asociacion.crear(nombre, nit,numeroContacto);

        Assertions.assertEquals(nombre,asociacion.getNombre());
        Assertions.assertEquals(nit,asociacion.getNit());
        Assertions.assertEquals(numeroContacto,asociacion.getNumeroContacto());

    }
    @Test
    void validarCamposFaltantes()
    {

        Assertions.assertEquals(Mensajes.NOMBRE_ASOCIACION_NO_PUEDE_ESTAR_VACIO,Assertions.assertThrows(ValorObligatorioExcepcion.class,() ->
                Asociacion.crear("","12345678-1","3125678170")).getMessage());

        Assertions.assertEquals(Mensajes.NIT_ASOCIACION_NO_PUEDE_ESTAR_VACIO,Assertions.assertThrows(ValorObligatorioExcepcion.class,() ->
                Asociacion.crear("Uco","","3125678170")).getMessage());

        Assertions.assertEquals(Mensajes.NUMERO_ASOCIACION_NO_PUEDE_ESTAR_VACIO,Assertions.assertThrows(ValorObligatorioExcepcion.class,() ->
                Asociacion.crear("Uco","12345678-1","")).getMessage());

    }
    @Test
    void validarPatronesIncorrecto()
    {
        Assertions.assertEquals(Mensajes.PATRON_NOMBRE_ASOCIACION_NO_ES_VALIDO,Assertions.assertThrows(PatronExcepcion.class,() ->
                Asociacion.crear("*Q-11","12345678-1","3125678170")).getMessage());

        Assertions.assertEquals(Mensajes.PATRON_NIT_ASOCIACION_NO_ES_VALIDO,Assertions.assertThrows(PatronExcepcion.class,() ->
                Asociacion.crear("Uco","123456781","3125678170")).getMessage());

        Assertions.assertEquals(Mensajes.PATRON_NUMERO_ASOCIACION_NO_ES_VALIDO,Assertions.assertThrows(PatronExcepcion.class,() ->
                Asociacion.crear("Uco","12345678-1","31256781700000")).getMessage());
    }
}
