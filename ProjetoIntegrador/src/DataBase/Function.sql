create or replace view QtdProjeto as 
select count(p) from projeto p;

create or replace view QtdMaterial as 
select count(m) from material m;
	 
create or replace view QtdFace as
select count(f) from face f;

 create or replace view NewMaterial as
     select id, tipo_material_id, cor_material_id,
     descricao as nome,
     condutividade, espessura,
     preco as valor from material;

create or replace view NewTipoMaterial as
select id, descricao as tipodomaterial from tipo_material;



