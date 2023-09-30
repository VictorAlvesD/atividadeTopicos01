-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (  field) values(1, 'field-1');
-- insert into myentity (  field) values(2, 'field-2');
-- insert into myentity (  field) values(3, 'field-3');
-- alter sequence myentity_seq restart with 4;

insert into livro (nome, autor, editora, isbn, genero) values('amor impossivel', 'David Parente', 'algoritmos', '1478596k69s5', 'ação');
insert into livro (nome, autor, editora, isbn, genero) values('Amor', 'David Parente', 'açgoritmos', '1478511ksks5', 'aventura');
insert into livro (nome, autor, editora, isbn, genero) values('amor romantico', 'David Parente', 'azgoritmos', '1478500ksks5', 'terror');
insert into livro (nome, autor, editora, isbn, genero) values('fati', 'David Parente', 'ritmos', '1478599ksks5', 'animação');

insert into usuario (nome, login, cpf, senha) values('Vitim', 'vitim@gmail.com', '066.788.511-02','terror');