package co.edu.uco.arquisw.dominio.usuario.servicio;

import co.edu.uco.arquisw.dominio.transversal.excepciones.TiempoVencidoExcepcion;
import co.edu.uco.arquisw.dominio.transversal.excepciones.ValorInvalidoExcepcion;
import co.edu.uco.arquisw.dominio.transversal.servicio.ServicioCifrarTexto;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.usuario.puerto.comando.PersonaRepositorioComando;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class ServicioActivarCuenta {
    private final PersonaRepositorioConsulta personaRepositorioConsulta;
    private final PersonaRepositorioComando personaRepositorioComando;
    private final ServicioCifrarTexto servicioCifrarTexto;

    public ServicioActivarCuenta(PersonaRepositorioConsulta personaRepositorioConsulta, PersonaRepositorioComando personaRepositorioComando, ServicioCifrarTexto servicioCifrarTexto) {
        this.personaRepositorioConsulta = personaRepositorioConsulta;
        this.personaRepositorioComando = personaRepositorioComando;
        this.servicioCifrarTexto = servicioCifrarTexto;
    }

    public Long ejecutar(String correo, String codigo) {
        validarSiNoExisteCodigo(codigo, correo);

        var peticionActivacionCuentaDTO = this.personaRepositorioConsulta.consultarPeticionActivacionCuentaConCorreo(correo);

        validarSiAunEsValidoElCodigo(peticionActivacionCuentaDTO.getFecha());

        this.personaRepositorioComando.eliminarPeticionActivacionCuenta(peticionActivacionCuentaDTO.getId());

        return this.personaRepositorioComando.activarCuenta(correo);
    }

    private void validarSiNoExisteCodigo(String codigo, String correo) {
        var codigoCifrado = this.personaRepositorioConsulta.consultarCodigoActivacionCuentaConCorreo(correo);

        if (!this.servicioCifrarTexto.existe(codigo, codigoCifrado)) {
            throw new ValorInvalidoExcepcion(Mensajes.EL_CODIGO_PARA_ACTIVAR_CUENTA_ES_INCORRECTO);
        }
    }

    private void validarSiAunEsValidoElCodigo(LocalDateTime fecha) {
        var ahora = LocalDateTime.now();

        var minutosDiferencia = ChronoUnit.MINUTES.between(fecha, ahora);

        if (minutosDiferencia > 5) {
            throw new TiempoVencidoExcepcion(Mensajes.EL_CODIGO_PARA_ACTIVAR_CUENTA_YA_NO_ES_VALIDO);
        }
    }
}