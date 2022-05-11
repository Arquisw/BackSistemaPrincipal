package co.edu.uco.arquisw.dominio.ensamblador;

public interface Ensamblador<D, E, T>
{
    D ensamblarDominioDesdeEntidad(E entidad);

    E ensamblarEntidadDesdeDominio(D dominio);

    D ensamblarDominioDesdeDTO(T dto);

    T ensamblarDTODesdeDominio(D dominio);
}