package co.edu.uco.arquisw.dominio.contrato.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContratoDTO {
    private Long id;
    private String rutaArchivo;
    private Long asociacionId;
}