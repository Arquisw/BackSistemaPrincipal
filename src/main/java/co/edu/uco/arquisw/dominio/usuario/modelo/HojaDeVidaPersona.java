package co.edu.uco.arquisw.dominio.usuario.modelo;

import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarTexto;
import lombok.Getter;

@Getter
public class HojaDeVidaPersona
{
    private String rutaArchivo;

    private HojaDeVidaPersona(String rutaArchivo)
    {
        setRutaArchivo(rutaArchivo);
    }

    public static HojaDeVidaPersona crear(String rutaArchivo)
    {
        return new HojaDeVidaPersona(rutaArchivo);
    }

    private void setRutaArchivo(String rutaArchivo)
    {
        ValidarTexto.validarObligatorio(rutaArchivo, Mensajes.RUTA_ARCHIVO_HOJA_DE_VIDA_NO_PUEDE_ESTAR_VACIO);

        this.rutaArchivo = rutaArchivo;
    }
}
