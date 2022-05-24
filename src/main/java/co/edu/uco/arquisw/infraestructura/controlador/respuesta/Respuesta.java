package co.edu.uco.arquisw.infraestructura.controlador.respuesta;

import co.edu.uco.arquisw.dominio.validador.ValidarTexto;
import co.edu.uco.arquisw.infraestructura.controlador.respuesta.enumerador.EstadoRespuesta;
import java.util.ArrayList;
import java.util.List;

public class Respuesta<T>
{
    private EstadoRespuesta estado = EstadoRespuesta.NO_EXITOSA;
    private List<String> mensajes = new ArrayList<>();
    private List<T> datos;

    public EstadoRespuesta getEstado()
    {
        return estado;
    }
    public void setEstado(EstadoRespuesta estado)
    {
        this.estado = estado;
    }
    public List<String> getMensajes()
    {
        return mensajes;
    }
    public void setMensajes(List<String> mensajes)
    {
        this.mensajes = mensajes;
    }
    public List<T> getDatos()
    {
        return datos;
    }
    public void setDatos(List<T> datos)
    {
        this.datos = datos;
    }

    public void añadirMensaje(String message)
    {
        if(!ValidarTexto.cadenaEsNula(message))
        {
            getMensajes().add(message);
        }
    }
}