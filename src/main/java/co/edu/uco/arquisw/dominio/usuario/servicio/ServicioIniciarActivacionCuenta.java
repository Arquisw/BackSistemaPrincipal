package co.edu.uco.arquisw.dominio.usuario.servicio;

import co.edu.uco.arquisw.dominio.postulacion.dto.SeleccionDTO;
import co.edu.uco.arquisw.dominio.transversal.excepciones.AutorizacionExcepcion;
import co.edu.uco.arquisw.dominio.transversal.excepciones.ValorInvalidoExcepcion;
import co.edu.uco.arquisw.dominio.transversal.formateador.FechaFormateador;
import co.edu.uco.arquisw.dominio.transversal.servicio.ServicioCifrarTexto;
import co.edu.uco.arquisw.dominio.transversal.servicio.notificacion.factoria.ServicioNotificacionFactoria;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.utilitario.NumeroConstante;
import co.edu.uco.arquisw.dominio.transversal.utilitario.TextoConstante;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;
import co.edu.uco.arquisw.dominio.usuario.puerto.comando.PersonaRepositorioComando;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;

import java.time.LocalDateTime;
import java.util.UUID;

import static co.edu.uco.arquisw.dominio.transversal.servicio.notificacion.enumerador.TipoNotificacion.ACTIVACION_CUENTA_INICIADA;

public class ServicioIniciarActivacionCuenta {
    private final ServicioNotificacionFactoria servicioNotificacionFactoria;
    private final PersonaRepositorioConsulta personaRepositorioConsulta;
    private final PersonaRepositorioComando personaRepositorioComando;
    private final ServicioCifrarTexto servicioCifrarTexto;

    public ServicioIniciarActivacionCuenta(ServicioNotificacionFactoria servicioNotificacionFactoria, PersonaRepositorioConsulta personaRepositorioConsulta, PersonaRepositorioComando personaRepositorioComando, ServicioCifrarTexto servicioCifrarTexto) {
        this.servicioNotificacionFactoria = servicioNotificacionFactoria;
        this.personaRepositorioConsulta = personaRepositorioConsulta;
        this.personaRepositorioComando = personaRepositorioComando;
        this.servicioCifrarTexto = servicioCifrarTexto;
    }

    public Long ejecutar(String correo) {
        validarSiNoExisteUsuarioConId(correo);
        validarSiUsuarioConIDNoEstaActivo(correo);

        var codigo = (UUID.randomUUID()).toString().replace("-", "").substring(0, 6);
        var codigoCifrado = this.servicioCifrarTexto.ejecutar(codigo);
        var fecha = FechaFormateador.obtenerFechaTexto(LocalDateTime.now());

        this.servicioNotificacionFactoria.orquestarNotificacion(
                ACTIVACION_CUENTA_INICIADA,
                NumeroConstante.CERO,
                NumeroConstante.CERO,
                NumeroConstante.CERO,
                NumeroConstante.CERO,
                codigo,
                TextoConstante.VACIO,
                correo,
                new SeleccionDTO()
        );

        return personaRepositorioComando.crearPeticionActivacionCuenta(codigoCifrado, correo, fecha);
    }

    private void validarSiNoExisteUsuarioConId(String correo) {
        if (ValidarObjeto.esNulo(this.personaRepositorioConsulta.consultarPorCorreo(correo))) {
            throw new ValorInvalidoExcepcion(Mensajes.obtenerNoExisteUsuarioConCorreo(correo));
        }
    }

    private void validarSiUsuarioConIDNoEstaActivo(String correo) {
        var usuario = this.personaRepositorioConsulta.consultarUsuarioPorCorreo(correo);

        if (usuario.isActivado()) {
            throw new AutorizacionExcepcion(Mensajes.EL_USUARIO_YA_ESTA_ACTIVADO_POR_LO_TANTO_NO_SE_PUEDE_VOLVER_A_ACTIVAR);
        }
    }
}