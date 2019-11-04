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

--Cadastro de Materiais
--Tipo:
insert into tipo_material values(default, 'Madeira');

--Cor:
insert into cor_material values(default, 'Escura',0,0);

--Material:
insert into material values(default, 1, 'Madeira Tatajuba', 1,0,0,10);
