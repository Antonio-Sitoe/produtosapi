create table produto (
  id varchar(36) primary key,
  nome varchar(255) not null,
  descricao varchar(255),
  preco decimal(10, 2)
);