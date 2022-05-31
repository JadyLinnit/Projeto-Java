
insert into tb_categoria (nome) values ('Romance');
insert into tb_categoria (nome) values ('Fantasia');
insert into tb_categoria (nome) values ('Drama');
insert into tb_categoria (nome) values ('Terror');

insert into tb_produto (descricao, estoque, preco, foto, categoria_id) values ('Romance contemporâneo que se passa na Inglaterra sobre pessoas que dividem um apartamento mas não se conhecem. Em breve adaptação em série!',1,16.00,'jpg',1);
insert into tb_produto (descricao, estoque, preco, foto, categoria_id) values ('Se passa na Segunda Guerra Mundial, histórias de três mulheres que tem suas vidas entrelaçadas durante e após guerra',1,14.00,'jpg',3);
insert into tb_produto (descricao, estoque, preco, foto, categoria_id) values ('Garota levada para um mundo férico repletos de perigos e muita magia',1,15.00,'jpg',2);
insert into tb_produto (descricao, estoque, preco, foto, categoria_id) values ('Um homem recebe proposta para administrar um hotel misterioso',1,18.00,'jpg',2);

insert into tb_usuario (nome,email,senha,cpf,fone,estado,cidade,bairro,rua,cep,numero,complemento,perfil) values ('Renata Floro','renata@gmail.com','12345','123.456.789-00','(81) 98585-8585','Pernambuco','Camaragibe','Timbi','Rua Timbi','54768-080','123','Próximo da escola','ADM');
insert into tb_usuario (nome,email,senha,cpf,fone,estado,cidade,bairro,rua,cep,numero,complemento,perfil) values ('Jady Linnit','jady@gmail.com','123456','987.654.321-00','(81) 98282-8585','Pernambuco','Recife','Cohab','Rua Tancredo Neves','45872-050','123','Casa','CLIENTE');