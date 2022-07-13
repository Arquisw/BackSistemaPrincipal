package co.edu.uco.arquisw.dominio.postulacion.testdatabuilder;

import co.edu.uco.arquisw.dominio.postulacion.modelo.Postulacion;


import java.time.LocalDate;

public class PostulacionTestDataBuilder {

    private LocalDate fecha;
    private boolean seleccionado;

    public PostulacionTestDataBuilder()
    {
        this.seleccionado = false;
    }

  public Postulacion build()
  {
      return Postulacion.crear(seleccionado);
  }
}
