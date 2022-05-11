package co.edu.uco.arquisw.aplicacion.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioAdministradorDTO
{
    private int codigo;
    private UsuarioDTO usuario;
    private List<RequerimientoDTO> requerimientos;
    private List<UsuarioPostulacionDTO> usuariosPostulados;
}