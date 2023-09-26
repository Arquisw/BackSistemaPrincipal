package co.edu.uco.arquisw.dominio.usuario.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PeticionActivacionCuentaDTO  {
    Long id;
    String correo;
    String codigo;
    LocalDateTime fecha;
}