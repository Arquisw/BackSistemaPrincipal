package co.edu.uco.arquisw.aplicacion.contrato.comando.fabrica;

import co.edu.uco.arquisw.aplicacion.contrato.comando.ContratoComando;
import co.edu.uco.arquisw.dominio.contrato.modelo.Contrato;
import org.springframework.stereotype.Component;

@Component
public class ContratoFabrica {
    public Contrato construir(ContratoComando contrato) {
        return Contrato.crear(contrato.getRutaArchivo());
    }
}