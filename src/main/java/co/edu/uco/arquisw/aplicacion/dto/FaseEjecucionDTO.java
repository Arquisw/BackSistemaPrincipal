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
public class FaseEjecucionDTO
{
    private int codigo;
    private boolean estado;
    private String urlDocumentacion;
    private List<ComentarioDTO> comentarios;
}