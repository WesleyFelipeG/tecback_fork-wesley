package br.com.fujideia.iesp.tecback.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class TrilhaSonora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String compositor;

    @ManyToOne
    @JoinColumn(name = "filme_id")
    private Filme filme;

    @ElementCollection
    @CollectionTable(name = "trilha_faixas", joinColumns = @JoinColumn(name = "trilha_sonora_id"))
    @Column(name = "faixa")
    private List<String> faixas;

    @ElementCollection
    @CollectionTable(name = "trilha_duracoes", joinColumns = @JoinColumn(name = "trilha_sonora_id"))
    @Column(name = "duracao")
    private List<Integer> duracoes;

    public int calcularDuracaoTotal() {
        return duracoes.stream().mapToInt(Integer::intValue).sum();
    }
}