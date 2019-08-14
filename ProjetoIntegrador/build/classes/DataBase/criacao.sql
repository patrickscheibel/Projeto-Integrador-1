create table formula(
    id serial PRIMARY KEY,
    nome varchar(100) not null,
    descricao varchar(100) not null
);
					  
create table material(
    id serial PRIMARY KEY,
    descricao varchar(100) not null,
    tipo varchar(100),
    aplicacao varchar(100),
    tamanho varchar(20), 
    preco decimal(10,2) not null
);

create table usuario(
     id serial primary key not null,
     usuario varchar(100) not null,
     senha varchar(100) not null,
     situacao varchar(100)
);

create table auditoria(
    id serial primary key not null,
    usuario_id integer not null,
    data timestamp not null,
    descricao text not null,
    dados text,
    FOREIGN KEY (usuario_id) REFERENCES usuario(id)	
);

create table log(
    id serial primary key not null,
    data timestamp not null,
    descricao text not null,
    erro text not null,
    dados text
);
				
create table estado(
    id serial PRIMARY KEY,
    descricao varchar(45)
);

create table cidade(
    id serial PRIMARY KEY,
    descricao varchar(45) not null,
    estado_id integer not null,	 
    FOREIGN KEY (estado_id) REFERENCES estado(id)	 
);
			  
create table fornecedor(
    id serial PRIMARY KEY,
    razao_social varchar(100) not null,
    nome_fantasia varchar(100),
    cnpj integer not null,
    telefone integer,
    endereco_id integer not null,
    cidade_id integer not null,
    FOREIGN KEY (endereco_id) REFERENCES estado(id),
    FOREIGN KEY (cidade_id) REFERENCES cidade(id)
);