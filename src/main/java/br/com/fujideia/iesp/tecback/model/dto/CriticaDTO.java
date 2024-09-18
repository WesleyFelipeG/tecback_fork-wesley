package br.com.fujideia.iesp.tecback.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CriticaDTO {
    private Long id;
    private String autor;
    private int nota;
    private String comentario;
    private Long filmeId;
}