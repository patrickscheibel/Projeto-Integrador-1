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
     login varchar(100) not null,
     senha varchar(100) not null,
     situacao varchar(100),
     auditoria boolean,
     log boolean
);

create table auditoria(
    id serial primary key not null,
    usuario_id integer not null,
    data timestamp not null,
    acao text not null,
    dados text,
    FOREIGN KEY (usuario_id) REFERENCES usuario(id)	
);

create table log(
    id serial primary key not null,
    data timestamp not null,
    acao text not null,
    erro text not null,
    dados text
);
	
--Repensar			
create table estado(
    id serial PRIMARY KEY,
    descricao varchar(45)
);

--Repensar
create table cidade(
    id serial PRIMARY KEY,
    descricao varchar(45) not null,
    estado_id integer not null,	 
    FOREIGN KEY (estado_id) REFERENCES estado(id)	 
);
	