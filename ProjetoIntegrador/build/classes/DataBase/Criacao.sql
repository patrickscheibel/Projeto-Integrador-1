--Repensar
create table formula(
    id serial PRIMARY KEY,
    nome varchar(100) not null,
    descricao varchar(100) not null
);

create table cor_material(
    id serial PRIMARY KEY,
    descricao varchar(100) not null,
    radiacao_minima decimal(10,2) not null,
    radiacao_maxima decimal(10,2) not null
);

create table tipo_material(
     id serial PRIMARY KEY,
     descricao varchar(100) not null
);
					  
create table material(
    id serial PRIMARY KEY,
    tipo_id integer not null,
    descricao varchar(100) not null,
    cor_id integer not null,    
    emissividade decimal(10,2) not null,
    conducao_termica decimal(10,2) not null,
    preco decimal(10,2),
--     preco money,
    FOREIGN KEY (cor_id) REFERENCES cor_material(id),
    FOREIGN KEY (tipo_id) REFERENCES tipo_material(id)
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
	
