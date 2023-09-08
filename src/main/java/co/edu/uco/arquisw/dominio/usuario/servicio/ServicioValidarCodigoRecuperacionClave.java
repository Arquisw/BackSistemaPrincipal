package co.edu.uco.arquisw.dominio.usuario.servicio;

import co.edu.uco.arquisw.dominio.transversal.excepciones.TiempoVencidoExcepcion;
import co.edu.uco.arquisw.dominio.transversal.excepciones.ValorInvalidoExcepcion;
import co.edu.uco.arquisw.dominio.transversal.servicio.ServicioCifrarTexto;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.usuario.puerto.comando.PersonaRepositorioComando;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class ServicioValidarCodigoRecuperacionClave {
    private final PersonaRepositorioConsulta personaRepositorioConsulta;
    private final PersonaRepositorioComando personaRepositorioComando;
    private final ServicioCifrarTexto servicioCifrarTexto;

    public ServicioValidarCodigoRecuperacionClave(PersonaRepositorioConsulta personaRepositorioConsulta, PersonaRepositorioComando personaRepositorioComando, ServicioCifrarTexto servicioCifrarTexto) {
        this.personaRepositorioConsulta = personaRepositorioConsulta;
        this.personaRepositorioComando = personaRepositorioComando;
        this.servicioCifrarTexto = servicioCifrarTexto;
    }

    public Boolean ejecutar(String correo, String codigo) {
        validarSiNoExisteCodigo(codigo, correo);

        var peticionRecuperacionClaveDTO = this.personaRepositorioConsulta.consultarPeticionRecuperacionClaveDTOConCorreo(correo);

        validarSiAunEsValidoElCodigo(peticionRecuperacionClaveDTO.getFecha());

        this.personaRepositorioComando.eliminarPeticionRecuperacionClave(peticionRecuperacionClaveDTO.getId());

        return Boolean.TRUE;
    }

    private void validarSiNoExisteCodigo(String codigo, String correo) {
        var codigoCifrado = this.personaRepositorioConsulta.consultarCodigoConCorreo(correo);

        if(!this.servicioCifrarTexto.existe(codigo, codigoCifrado)) {
            throw new ValorInvalidoExcepcion(Mensajes.EL_CODIGO_PARA_RECUPERAR_CLAVE_ES_INCORRECTO);
        }
    }

    private void validarSiAunEsValidoElCodigo(LocalDateTime fecha) {
        var ahora = LocalDateTime.now();

        var minutosDiferencia = ChronoUnit.MINUTES.between(fecha, ahora);

        if (minutosDiferencia > 5) {
            throw new TiempoVencidoExcepcion(Mensajes.EL_CODIGO_PARA_RECUPERAR_CLAVE_YA_NO_ES_VALIDO);
        }
    }
}