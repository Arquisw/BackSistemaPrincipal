package co.edu.uco.arquisw.dominio.transversal.utilitario;

public class Mensajes
{
    public static final String NOMBRE_ROL_VACIO = "El nombre no puede estar vacio";
    public static final String NOMBRE_PERSONA_NO_PUEDE_ESTAR_VACIO = "El nombre no puede estar vacio";
    public static final String PATRON_NOMBRE_ROL_INVALIDO = "El nombre solo puede contener letras y numeros";
    public static final String PATRON_NOMBRE_PERSONA_NO_ES_VALIDO = "El nombre solo puede contener letras y numeros";
    public static final String APELLIDOS_PERSONA_NO_PUEDE_ESTAR_VACIO = "Los apellidos de una persona no pueden ser vacios";
    public static final String PATRON_APELLIDOS_PERSONA_NO_ES_VALIDO = "Los apellidos solo puede contener letras y numeros";
    public static final String CORREO_PERSONA_NO_PUEDE_ESTAR_VACIO = "El correo no puede estar vacio";
    public static final String PATRON_CORREO_PERSONA_NO_ES_VALIDO = "El correo debe cumplir el patron de @example.com";
    public static final String CLAVE_PERSONA_NO_PUEDE_ESTAR_VACIO = "La clave no puede estar vacia";
    public static final String PATRON_CLAVE_PERSONA_NO_ES_VALIDO = "La clave debe tener minimo una minuscula, una mayuscula y un numero";
    public static final String OCURRIO_UN_ERROR_FAVOR_CONTACTAR_AL_ADMINISTRADOR = "Ocurrió un error favor contactar al administrador.";
    public static final String EXISTE_USUARIO_CON_CORREO = "Ya existe un usuario con ese correo";
    public static final String NO_EXISTE_USUARIO_CON_EL_ID = "No existe un usuario con el ID ";
    public static final String NO_EXISTE_HOJA_DE_VIDA_CON_EL_ID = "No existe una hoja de vida para ese usuario con el ID ";
    public static final String NOMBRE_ASOCIACION_NO_PUEDE_ESTAR_VACIO = "El nombre de una compañia no puede estar vacio.";
    public static final String PATRON_NOMBRE_ASOCIACION_NO_ES_VALIDO = "El nombre de una compañia debe ser alfanumerico";
    public static final String NIT_ASOCIACION_NO_PUEDE_ESTAR_VACIO = "El NIT de una compañia no puede estar vacio";
    public static final String PATRON_NIT_ASOCIACION_NO_ES_VALIDO = "El NIT de una compañia debe tener la estructura 111111111-1";
    public static final String NUMERO_ASOCIACION_NO_PUEDE_ESTAR_VACIO = "El numero de contacto de una compañia no puede estar vacio";
    public static final String PATRON_NUMERO_ASOCIACION_NO_ES_VALIDO = "El patrón del numero de contacto de una compañia es invalido";
    public static final String EXISTE_ASOCIACION_CON_NIT = "Ya existe una asociación con el NIT ";
    public static final String NO_EXISTE_ASOCIACION_CON_EL_ID = "No existe un asociacion con el ID ";
    public static final String NO_EXISTE_PROYECTO_CON_EL_ID = "No existe un proyecto con el ID ";
    public static final String NO_EXISTE_POSTULACION_CON_EL_ID = "No existe un postulacion con el ID ";
    public static final String NO_EXISTE_NECESIDAD_CON_EL_ID = "No existe un necesidad con el ID ";
    public static final String NOMBRE_ESTADO_NECESIDAD_NO_PUEDE_ESTAR_VACIO = "El nombre del estado de la necesidad no puede estar vacio";
    public static final String PATRON_NOMBRE_ESTADO_NECESIDAD_NO_ES_VALIDO = "El nombre del estado de la necesidad solo puede contener letras y espacios";
    public static final String NOMBRE_ESTADO_PROYECTO_NO_PUEDE_ESTAR_VACIO = "El nombre del estado del proyecto no puede estar vacio";
    public static final String PATRON_NOMBRE_ESTADO_PROYECTO_NO_ES_VALIDO = "El nombre del estado del proyecto solo puede contener letras y espacios";
    public static final String NOMBRE_TIPO_CONSULTORIA_NO_PUEDE_ESTAR_VACIO = "El nombre del tipo de consultoria del proyecto no puede estar vacio";
    public static final String PATRON_NOMBRE_TIPO_CONSULTORIA_NO_ES_VALIDO = "El nombre del tipo de consultoria del proyecto solo puede contener letras y espacios";
    public static final String NOMBRE_PROYECTO_NO_PUEDE_ESTAR_VACIO = "El nombre del proyecto no puede estar vacio";
    public static final String PATRON_NOMBRE_PROYECTO_NO_ES_VALIDO = "El nombre del proyecto debe ser alfanúmerico";
    public static final String DESCRIPCION_ESTADO_PROYECTO_NO_PUEDE_ESTAR_VACIO = "La descripcion del proyecto no puede estar vacio";
    public static final String PATRON_DESCRIPCION_PROYECTO_NO_ES_VALIDO = "La descripcion del proyecto debe ser alfanúmerico";
    public static final String RUTA_ARCHIVO_NECESIDAD_NO_PUEDE_ESTAR_VACIO = "La ruta del archivo de una necesidad no puede estar vacio";
    public static final String PATRON_RUTA_ARCHIVO_NECESIDAD_NO_ES_VALIDO = "La ruta del archivo de una necesidad es incorrecto";
    public static final String RUTA_ARCHIVO_HOJA_DE_VIDA_NO_PUEDE_ESTAR_VACIO = "La ruta del archivo de la hoja de vida no puede estar vacia";
    public static final String PATRON_RUTA_ARCHIVO_HOJA_DE_VIDA_NO_ES_VALIDO = "La ruta del archivo de la hoja de vida es incorrecto";
    public static final String NO_PUEDE_ELIMINAR_POR_TENER_ASOCIACION_A_CARGO = "No puedes eliminar la cuenta porque tienes una Asociacion registrada a tu cargo, sin embargo la solicitud fue enviada al administrador.";
    public static final String NO_PUEDE_ELIMINAR_POR_ESTAR_SELECCIONADO_EN_UN_PROYECTO = "No puedes eliminar la cuenta porque estas seleccionado dentro de un proyecto, sin embargo la solicitud fue enviada al administrador.";
    public static final String NO_PUEDE_ELIMINAR_POR_ESTAR_EN_UN_PROCESO_DE_POSTULACION = "No puedes eliminar la cuenta porque estas postulado a un proyecto, sin embargo la solicitud fue enviada al administrador.";
    public static final String NO_PUEDE_ELIMINAR_POR_TENER_NECESIDAD_REGISTRADA = "No puedes eliminar la asociacion porque tienes una necesidad registrada, sin embargo la solicitud fue enviada al administrador.";
    public static final String NO_PUEDE_ELIMINAR_POR_TENER_NECESIDAD_APROBADA_PARA_SU_DESARROLLO = "No puedes eliminar la necesidad porque esta ya fue aprobada para ser ejecutada, sin embargo la solicitud fue enviada al administrador.";
    public static final String RUTA_ARCHIVO_CONTRATO_NO_PUEDE_ESTAR_VACIO = "La ruta del archivo del contrato no puede estar vacia";
    public static final String PATRON_RUTA_ARCHIVO_CONTRATO_NO_ES_VALIDO = "La ruta del archivo del contrato es incorrecto";

    private Mensajes()
    {

    }
}