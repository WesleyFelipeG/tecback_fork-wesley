package br.com.fujideia.iesp.tecback.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Cinematografia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String diretorDeFotografia;
    private String estilo;

    @ManyToOne
    @JoinColumn(name = "filme_id")
    private Filme filme;

    @ElementCollection
    @CollectionTable(name = "cinematografia_premios", joinColumns = @JoinColumn(name = "cinematografia_id"))
    @Column(name = "premio")
    private List<String> premios;
}