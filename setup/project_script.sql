CREATE SEQUENCE pessoa_seq START 1 INCREMENT 1;

CREATE TABLE pessoa (
    id INT PRIMARY KEY DEFAULT nextval('pessoa_seq'),
    nome VARCHAR(150),
    data_nascimento DATE,
    sexo VARCHAR(1)
);

CREATE SEQUENCE endereco_seq START 1 INCREMENT 1;

CREATE TABLE endereco (
    id INT PRIMARY KEY DEFAULT nextval('endereco_seq'),
    estado VARCHAR(2),
    cidade VARCHAR(100),
    logradouro VARCHAR(100),
    numero INT,
    cep VARCHAR(8),
    id_pessoa INT,
    FOREIGN KEY (id_pessoa) REFERENCES pessoa(id)
);