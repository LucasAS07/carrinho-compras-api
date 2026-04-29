package br.com.losystem.nosso_carrinho_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "usuario")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    @Size(min = 4, max = 255)
    private String name;

    @Email
    @Size(max = 100)
    private String email;

    @Size(max = 20)
    @Column(name = "senha")
    private String password;

    @Size(min = 11, max = 11)
    @Column(name = "telefone")
    private String phone;

}
