package co.edu.uco.arquisw.dominio.usuario.servicio;

import co.edu.uco.arquisw.dominio.transversal.excepciones.AutorizacionExcepcion;
import co.edu.uco.arquisw.dominio.transversal.excepciones.ValorInvalidoExcepcion;
import co.edu.uco.arquisw.dominio.transversal.formateador.FechaFormateador;
import co.edu.uco.arquisw.dominio.transversal.servicio.ServicioCifrarTexto;
import co.edu.uco.arquisw.dominio.transversal.servicio.ServicioEnviarCorreoElectronico;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;
import co.edu.uco.arquisw.dominio.usuario.puerto.comando.PersonaRepositorioComando;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;

import javax.mail.MessagingException;
import java.time.LocalDateTime;
import java.util.UUID;

public class ServicioIniciarActivacionCuenta {
    private final ServicioEnviarCorreoElectronico servicioEnviarCorreoElectronico;
    private final PersonaRepositorioConsulta personaRepositorioConsulta;
    private final PersonaRepositorioComando personaRepositorioComando;
    private final ServicioCifrarTexto servicioCifrarTexto;

    public ServicioIniciarActivacionCuenta(ServicioEnviarCorreoElectronico servicioEnviarCorreoElectronico, PersonaRepositorioConsulta personaRepositorioConsulta, PersonaRepositorioComando personaRepositorioComando, ServicioCifrarTexto servicioCifrarTexto) {
        this.servicioEnviarCorreoElectronico = servicioEnviarCorreoElectronico;
        this.personaRepositorioConsulta = personaRepositorioConsulta;
        this.personaRepositorioComando = personaRepositorioComando;
        this.servicioCifrarTexto = servicioCifrarTexto;
    }

    public Long ejecutar(String correo) throws MessagingException {
        validarSiNoExisteUsuarioConId(correo);
        validarSiUsuarioConIDNoEstaActivo(correo);

        var codigo = (UUID.randomUUID()).toString().replace("-", "").substring(0, 6);
        var codigoCifrado = this.servicioCifrarTexto.ejecutar(codigo);
        var fecha = FechaFormateador.obtenerFechaTexto(LocalDateTime.now());
        var asunto = Mensajes.ACTIVACION_DE_LA_CUENTA;
        var cuerpo = Mensajes.CODIGO + codigo;

        this.servicioEnviarCorreoElectronico.enviarCorreo(correo, asunto, cuerpo);

        return personaRepositorioComando.crearPeticionActivacionCuenta(codigoCifrado, correo, fecha);
    }

    private void validarSiNoExisteUsuarioConId(String correo) {
        if (ValidarObjeto.esNulo(this.personaRepositorioConsulta.consultarPorCorreo(correo))) {
            throw new ValorInvalidoExcepcion(Mensajes.NO_EXISTE_USUARIO_CON_EL_CORREO + correo);
        }
    }

    private void validarSiUsuarioConIDNoEstaActivo(String correo) {
        var usuario = this.personaRepositorioConsulta.consultarUsuarioPorCorreo(correo);

        if (usuario.isActivado()) {
            throw new AutorizacionExcepcion(Mensajes.EL_USUARIO_YA_ESTA_ACTIVADO_POR_LO_TANTO_NO_SE_PUEDE_VOLVER_A_ACTIVAR);
        }
    }
}
