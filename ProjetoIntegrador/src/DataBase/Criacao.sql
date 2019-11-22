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
    tipo_material_id integer not null,
    cor_material_id integer not null,
    descricao varchar(100) not null,        
    condutividade decimal(10,2) not null,
    espessura decimal(10,2) not null,
    preco decimal(10,2),
    FOREIGN KEY (cor_material_id) REFERENCES cor_material(id),
    FOREIGN KEY (tipo_material_id) REFERENCES tipo_material(id)
);

create table permissao(
    id serial primary key,
    descricao varchar(100) not null
);

create table grupo_permissao(
    id serial primary key,
    descricao varchar(100) not null
);

create table permissao_grupo_permissao(
    id serial primary key,
    permissao_id integer not null,
    grupo_permissao_id integer not null,
    FOREIGN KEY (permissao_id) REFERENCES permissao(id),
    FOREIGN KEY (grupo_permissao_id) REFERENCES grupo_permissao(id)
);

create table usuario(
    id serial primary key not null,
    usuario varchar(100) not null,
    login varchar(100) not null,
    senha varchar(100) not null,
    situacao varchar(100),
    auditoria boolean,
    log boolean,
    grupo_permissao_id integer not null,
    FOREIGN KEY (grupo_permissao_id) REFERENCES grupo_permissao(id)
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

create table projeto(
    id serial primary key,
    nome varchar not null,
    descricao varchar(100),
    carga_termica DECIMAL(10,3)
);

create table ambiente(
    id serial primary key,
    descricao varchar(100), 
    transmitancia_termica DECIMAL(10,3),
    projeto_id int not null,
    FOREIGN KEY (projeto_id) REFERENCES projeto(id)
);

create table face(
    id serial primary key,
    descricao varchar(100),
    resistencia_interna DECIMAL(10,3) not null,
    resistencia_externa DECIMAL(10,3) not null,
    resistencia_total DECIMAL(10,3),
    transmitancia_termica DECIMAL(10,3),
    temperatura_solar DECIMAL(10,3),
    temperatura_interna DECIMAL(10,3),
    temperatura_externa DECIMAL(10,3),
    metro_quadrado DECIMAL(10,3),
    densidade_fluxo_calor DECIMAL(10,3),
    fator_solar DECIMAL(10,3),
    radiacao_solar_incidente DECIMAL(10,3),
    parede_ensolarada BOOLEAN,
    fluxo_calor DECIMAL(10,3),    
    fluxo_calor_vidro DECIMAL(10,3),    
    ambiente_id int not null,
    FOREIGN KEY (ambiente_id) REFERENCES ambiente(id)
);

create table camada(
    id serial primary key,
    resistencia DECIMAL(10,3) not null,
    face_id int not null,
    material_id int not null,
    FOREIGN KEY (face_id) REFERENCES face(id),
    FOREIGN KEY (material_id) REFERENCES material(id)
);