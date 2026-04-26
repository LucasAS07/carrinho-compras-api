CREATE TABLE usuario(
                        id serial PRIMARY KEY,
                        nome VARCHAR(255) not null,
                        email VARCHAR(100) not null unique,
                        senha VARCHAR(20) not null,
                        telefone varchar(9) not null
);


CREATE TABLE lista(
                      id SERIAL PRIMARY KEY,
                      nome VARCHAR(255) NOT NULL,
                      data_criacao TIMESTAMP WITH TIME ZONE DEFAULT NOW() NOT NULL,
                      data_fechamento TIMESTAMP WITH TIME ZONE,
                      status VARCHAR(20) DEFAULT 'ABERTA' NOT NULL,
                      valor_total NUMERIC(10,2),
                      id_usuario INTEGER NOT NULL,

                      CONSTRAINT fk_usuario_id_lista
                          FOREIGN KEY (id_usuario)
                              REFERENCES usuario(id)
                              ON DELETE CASCADE
);

CREATE INDEX idx_lista_usuario ON lista(id_usuario);

CREATE TABLE itens(
                      id SERIAL PRIMARY KEY,
                      descricao VARCHAR(255) NOT NULL,
                      quantidade NUMERIC(10,2) NOT NULL,
                      unidade_medida VARCHAR(20) NOT NULL,
                      status VARCHAR(20) DEFAULT 'PENDENTE' NOT NULL,
                      valor NUMERIC(10,2) NOT NULL,
                      id_lista INTEGER NOT NULL,

                      CONSTRAINT fk_lista_id_item
                          FOREIGN KEY (id_lista)
                              REFERENCES lista(id)
                              ON UPDATE CASCADE
                              ON DELETE RESTRICT
);

CREATE INDEX idx_itens_lista ON itens(id_lista);

ALTER TABLE itens
    ADD CONSTRAINT chk_status_item
        CHECK (status IN ('PENDENTE', 'COMPRADO'));