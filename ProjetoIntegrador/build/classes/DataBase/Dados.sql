/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Scheibel
 * Created: 15/08/2019
 */
--Criacao do Grupo do administrador
insert into grupo_permissao VALUES(default, 'Administrador');

--Criacao usuario do administrador
insert into usuario VALUES(default,'Administrador', 'admin', 'admin','Ativo', true, true, 1);

--Permissoes de Material
insert into permissao VALUES(default, 'ver_material');
insert into permissao VALUES(default, 'adicionar_material');
insert into permissao VALUES(default, 'editar_material');

--Permissoes de Usuario
insert into permissao VALUES(default, 'ver_usuario');
insert into permissao VALUES(default, 'adicionar_usuario');
insert into permissao VALUES(default, 'editar_usuario');

--Permissoes de TipoMaterial
insert into permissao VALUES(default, 'ver_tipoMaterial');
insert into permissao VALUES(default, 'adicionar_tipoMaterial');
insert into permissao VALUES(default, 'editar_tipoMaterial');

--Permissoes de CorMaterial
insert into permissao VALUES(default, 'ver_corMaterial');
insert into permissao VALUES(default, 'adicionar_corMaterial');
insert into permissao VALUES(default, 'editar_corMaterial');

--Permissoes de GrupoPermissao
insert into permissao VALUES(default, 'ver_grupoPermissao');
insert into permissao VALUES(default, 'adicionar_grupoPermissao');
insert into permissao VALUES(default, 'editar_grupoPermissao');

--Permissoes de Configuracao de auditoria e log
insert into permissao VALUES(default, 'ver_configuracao');
insert into permissao VALUES(default, 'editar_configuracao');

--Permissoes de Projeto
insert into permissao VALUES(default, 'ver_projeto');
insert into permissao VALUES(default, 'adicionar_projeto');
insert into permissao VALUES(default, 'editar_projeto');

--Permissoes de Configuracao de auditoria e log
insert into permissao VALUES(default, 'ver_email');

--Grupo de permissoes
insert into permissao_grupo_permissao VALUES(default, 1, 1); 
insert into permissao_grupo_permissao VALUES(default, 2, 1);
insert into permissao_grupo_permissao VALUES(default, 3, 1); 
insert into permissao_grupo_permissao VALUES(default, 4, 1);
insert into permissao_grupo_permissao VALUES(default, 5, 1);
insert into permissao_grupo_permissao VALUES(default, 6, 1); 
insert into permissao_grupo_permissao VALUES(default, 7, 1);
insert into permissao_grupo_permissao VALUES(default, 8, 1);
insert into permissao_grupo_permissao VALUES(default, 9, 1);
insert into permissao_grupo_permissao VALUES(default, 10, 1);
insert into permissao_grupo_permissao VALUES(default, 11, 1);
insert into permissao_grupo_permissao VALUES(default, 12, 1);
insert into permissao_grupo_permissao VALUES(default, 13, 1);
insert into permissao_grupo_permissao VALUES(default, 14, 1);
insert into permissao_grupo_permissao VALUES(default, 15, 1);
insert into permissao_grupo_permissao VALUES(default, 16, 1);
insert into permissao_grupo_permissao VALUES(default, 17, 1);
insert into permissao_grupo_permissao VALUES(default, 18, 1);
insert into permissao_grupo_permissao VALUES(default, 19, 1);
insert into permissao_grupo_permissao VALUES(default, 20, 1);
insert into permissao_grupo_permissao VALUES(default, 21, 1);

--Cadastro de Materiais
--Tipo:
insert into tipo_material values(default, 'Madeira');
insert into tipo_material values(default, 'Vidro');
insert into tipo_material values(default, 'Tijolo');

--Cor:
insert into cor_material values(default, 'Escura',0,0);
insert into cor_material values(default, 'Claro',0,0);

--Material:
insert into material values(default, 1, 1, 'Madeira Tatajuba',0.14,4,10);
insert into material values(default, 2, 2, 'Vidro Temperado',4,0.8,20);
insert into material values(default, 3, 1, 'Tijolo Laminado',0.65,25,20);
