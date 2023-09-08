package co.edu.uco.arquisw.dominio.transversal.utilitario;

public class TextoConstante {
    public static final String VACIO = "";
    public static final String ESPACIO = " ";
    public static final String ROL_USUARIO = "ROLE_USUARIO"; // ID = 1
    public static final String ROL_ASOCIACION = "ROLE_ASOCIACION"; // ID = 2
    public static final String ROL_ADMINISTRADOR = "ROLE_ADMINISTRADOR"; // ID = 3
    public static final String ROL_POSTULADO = "ROLE_POSTULADO"; // ID = 4
    public static final String ROL_SELECCIONADO = "ROLE_SELECCIONADO"; // ID = 5
    public static final String ROL_DIRECTOR_PROYECTO = "ROLE_DIRECTOR_PROYECTO"; // ID = 6
    public static final String ROL_PARTE_INTERESADA = "ROLE_PARTE_INTERESADA"; // ID = 7
    public static final String ROL_EQUIPO_DESARROLLO = "ROLE_EQUIPO_DESARROLLO"; // ID = 8
    public static final String ROL_INGENIERIA = "ROLE_INGENIERIA"; // ID = 9
    public static final String ROL_ARQUITECTURA = "ROLE_ARQUITECTURA"; // ID = 10
    public static final String ROL_ANALISTA = "ROLE_ANALISTA"; // ID = 11
    public static final String ROL_LIDER_DEL_EQUIPO = "ROLE_LIDER_DE_EQUIPO"; // ID = 12
    public static final String ROL_PATROCINADOR = "ROLE_PATROCINADOR"; // ID = 13
    public static final String INGENIERIA_DE_REQUISITOS = "Ingenieria de Requisitos"; // ID = 1
    public static final String SQA = "SQA"; // ID = 2
    public static final String SQC = "SQC"; // ID = 3

    public static final String ESTADO_EN_ESPERA = "En Espera"; // ID = 1
    public static final String ESTADO_APROBADO = "Aprobado"; // ID = 2
    public static final String ESTADO_NEGOCIADO = "Negociado"; // ID = 3
    public static final String ESTADO_RECHAZADO = "Rechazado"; // ID = 4
    public static final String ESTADO_EN_PROCESO = "En Proceso"; // ID = 5
    public static final String ESTADO_EN_DESARROLLO  = "En Desarrollo"; // ID = 6
    public static final String ESTADO_FINALIZADO = "Finalizado"; // ID = 7

    public static final String INGENIERIA_DE_REQUISITOS_URL = "http://localhost:8081/api/fases/";
    public static final String HEADER_VALUE = "Authorization";

    public static final String LECTURA = "LECTURA";
    public static final String ESCRITURA = "ESCRITURA";
    public static final String ACTUALIZACION = "ACTUALIZACION";
    public static final String ELIMINACION = "ELIMINACION";
    public static final String CUENTA_DE_ARQUISQ_ELIMINADA_ASUNTO = "Cuenta de ArquiSW eliminada";
    public static final String TU_CUENTA_HA_SIDO_ELIMINADA_DE_FORMA_DEFINITIVA_POR_TI = "Haz realizado la petición para eliminar tu cuenta, por lo tanto ha sido eliminada definitivamente de la plataforma. Esperamos que vuelvas pronto.";
    public static final String TU_CUENTA_HA_SIDO_ELIMINADA_DE_FORMA_DEFINITIVA_POR_EL_ADMINISTRADOR = "Tu petición para eliminar tu cuenta, ha sido aceptada por el administrador, por lo tanto ha sido eliminada definitivamente de la plataforma. Esperamos que vuelvas pronto.";
    public static final String ASOCIACION_DE_TU_CUENTA_DE_ARQUISWQ_ELIMINADA_ASUNTO = "La Asociación o Empresa de tu cuenta de ArquiSW ha sido eliminada";
    public static final String LA_ASOCIACION_O_EMPRESA = "La asociación o Empresa ";
    public static final String CON_EL_NIT = " con el NIT: ";
    public static final String HA_SIDO_ELIMINADA_POR_TI = " ha sido eliminada por ti de manera exitosa.";
    public static final String HA_SIDO_ELIMINADA_POR_EL_ADMINISTRADOR = " ha sido eliminada de manera exitosa, luego de que tu petición haya sido aceptada por el administrador.";
    public static final String PROYECTO_DE_LA_ASOCIACION_DE_TU_CUENTA_DE_ARQUISWQ_ELIMINADA_ASUNTO = "El Proyecto de la Asociación o Empresa de tu cuenta de ArquiSW ha sido eliminado";
    public static final String EL_PROYECTO = "El proyecto ";
    public static final String HA_SIDO_ELIMINADO_PROYECTO_POR_TI = " ha sido eliminado por ti de manera exitosa.";
    public static final String HA_SIDO_ELIMINADO_PROYECTO_POR_EL_ADMINISTRADOR = " ha sido eliminado de manera exitosa, luego de que tu petición haya sido aceptada por el administrador.";
    public static final String HA_SIDO_APROBADO_POR_EL_ADMINISTRADOR = " ha sido aprobado por el administrador";
    public static final String PROYECTO_APROBADO_POR_EL_ADMINISTRADOR_ASUNTO = "Proyecto aprobado por el administrador";
    public static final String PROYECTO_RECHAZADO_POR_EL_ADMINISTRADOR_ASUNTO = "Proyecto rechazado por el administrador";
    public static final String HA_SIDO_RECHAZADO_POR_EL_ADMINISTRADO_CUYO_MOTIVO_ES_POR = " ha sido rechazado por el administrador, cuyo motivo del rechazo es por ";
    public static final String PROYECTO_ACTUAL_APROBADO_POR_ROL_INGENIERIA = "Proyecto aprobado por el Rol Ingeniería";
    public static final String HA_SIDO_APROBADO_POR_EL_ROL_INGENIERIA = " ha sido aprobado por el rol ingenieria, lo que significa que ya puedes aprobar el proyecto como Lider del Equipo.";
    public static final String PROYECTO_ACTUAL_APROBADO_POR_ROL_LIDER_DE_EQUIPO = "Proyecto aprobado por el Rol Lider de Equipo";
    public static final String HA_SIDO_APROBADO_POR_EL_ROL_LIDER_DE_EQUIPO = " ha sido aprobado por el Lider de Equipo, lo que significa que ya puedes aprobar el proyecto como Director del Proyecto.";
    public static final String PROYECTO_ACTUAL_APROBADO_POR_ROL_DIRECTOR_DE_PROYECTO = "Proyecto aprobado por el Rol Director del Proyecto";
    public static final String HA_SIDO_APROBADO_POR_EL_ROL_DIRECTOR_DE_PROYECTO = " ha sido aprobado por el Director del Proyecto, lo que significa que el proyecto esta listo para iniciar el proceso de consultoria.";
    public static final String CONTRATO_DEL_PROYECTO_ACTUAL_EFECTUADO = "Contrato del proyecto actual efectuado";
    public static final String EL_CONTRATO_DEL_PROYECTO = "El contrato del proyecto ";
    public static final String HA_SIDO_EFECTUADO_Y_GUARDADO_EN_LA_PLATAFORMA_POR_EL_ADMINISTRADOR = " ha sido efectuado y guardado en la plataforma por el Administrador.";
    public static final String CONTRATO_DEL_PROYECTO_ACTUAL_ACTUALIZADO = "Contrato del proyecto actual actualizado";
    public static final String HA_SIDO_ACTUALIZADO_POR_EL_ADMINISTRADOR = " ha sido actualizado por el Administrador.";

    private TextoConstante() { }
}