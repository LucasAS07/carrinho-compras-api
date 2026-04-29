package br.com.losystem.nosso_carrinho_api.model;

import br.com.losystem.nosso_carrinho_api.enums.StatusList;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "lista")
public class ShoppingList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    @Size(max = 255)
    private String name;

    @Column(name = "data_criacao")
    private OffsetDateTime dateCreation;

    @Column(name = "data_fechamento")
    private OffsetDateTime dateClosing;

    @Size(max = 20)
    @Enumerated(EnumType.STRING)
    private StatusList status;

    @Column(name = "valor_total")
    private BigDecimal totalvalue;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private User user;

    @OneToMany(mappedBy = "list", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Item> itens;

}
