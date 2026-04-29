package br.com.losystem.nosso_carrinho_api.model;

import br.com.losystem.nosso_carrinho_api.enums.StatusItem;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name = "itens")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descricao")
    @NotBlank(message = "Campo descrição não pode ser branco")
    @Size(min = 3, max = 255,message = "O tamanho minimo é 3 caracteres e maximo 255")
    private String description;

    @Column(name = "quantidade")
    @NotBlank(message = "Campo quantidade não pode ser branco")
    private BigDecimal amount;

    @Column(name = "unidade_medida")
    @Size(max = 20)
    @NotBlank(message = "Campo unidade medida não pode ser branco")
    private String unitMeasure;

    private StatusItem status;

    @Column(name = "preco")
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "id_lista")
    private ShoppingList list;

}
