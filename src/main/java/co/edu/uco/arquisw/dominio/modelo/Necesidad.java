package co.edu.uco.arquisw.dominio.modelo;

import co.edu.uco.arquisw.dominio.utilitario.UtilNumero;
import co.edu.uco.arquisw.dominio.utilitario.UtilTexto;

public class Necesidad
{
    private int codigo;
    private int tiempo;
    private String rutaArchivo;
    private Proyecto proyecto;
    private EstadoNecesidad estado;

    private Necesidad(int codigo, int tiempo, String rutaArchivo, Proyecto proyecto, EstadoNecesidad estado)
    {
        this.codigo = codigo;
        setTiempo(tiempo);
        setRutaArchivo(rutaArchivo);
        setProyecto(proyecto);
        setEstado(estado);
    }

    public static Necesidad crear(int codigo, int tiempo, String rutaArchivo, Proyecto proyecto, EstadoNecesidad estado)
    {
        return new Necesidad(codigo, tiempo, rutaArchivo, proyecto, estado);
    }

    public int getCodigo()
    {
        return codigo;
    }

    public int getTiempo()
    {
        return tiempo;
    }

    private void setTiempo(int tiempo)
    {
        if(UtilNumero.numeroEsMenorOIgual(tiempo, 0))
        {
            new IllegalArgumentException("El tiempo no puede ser menor o igual que cero");
        }

        this.tiempo = tiempo;
    }

    public String getRutaArchivo()
    {
        return rutaArchivo;
    }

    private void setRutaArchivo(String rutaArchivo)
    {
        if(UtilTexto.cadenaEstaVacia(rutaArchivo))
        {
            new IllegalArgumentException("El urlArchivo no puede estar vacio");
        }

        if(!UtilTexto.cadenaURL(rutaArchivo))
        {
            new IllegalArgumentException("El urlArchivo debe cumplir el patron el url");
        }

        if(!UtilTexto.longitudEsValida(rutaArchivo, 1, 2000))
        {
            new IllegalArgumentException("La longitud del nombre debe estar entre 1 y 2000 caracteres");
        }

        this.rutaArchivo = rutaArchivo;
    }

    public Proyecto getProyecto()
    {
        return proyecto;
    }

    private void setProyecto(Proyecto proyecto)
    {
        this.proyecto = proyecto;
    }

    public EstadoNecesidad getEstado()
    {
        return estado;
    }

    private void setEstado(EstadoNecesidad estado)
    {
        this.estado = estado;
    }
}
