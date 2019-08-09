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
    id_usuario integer not null,
    data timestamp not null,
	descricao text not null,
	dados text,
    FOREIGN KEY (id_usuario) REFERENCES usuario(id)	
);

create table log(
	id serial primary key not null,
	data timestamp not null,
	descricao text not null,
	dados text
);
				
create table estado(
 	id serial PRIMARY KEY,
 	descricao varchar(45)
);

create table cidade(
 	id serial PRIMARY KEY,
	descricao varchar(45),
 	id_estado integer,	 
 	FOREIGN KEY (id_estado) REFERENCES estado(id)	 
);
			  
create table fornecedor(
	id serial PRIMARY KEY,
	razao_social varchar(100),
	nome_fantasia varchar(100),
	cnpj integer,
	telefone integer,
	id_endereco integer,
	id_cidade integer,
        FOREIGN KEY (id_endereco) REFERENCES estado(id),
        FOREIGN KEY (id_cidade) REFERENCES cidade(id)
);