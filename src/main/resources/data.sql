INSERT INTO tb_autor (nome, email, descricao, data_criacao)
VALUES ('Diego Batista', 'diego.batista@zup.com.br', 'Teste descrição', '2021-06-28T16:19:32.4618312');
INSERT INTO tb_autor (nome, email, descricao, data_criacao)
VALUES ('João das Neves', 'joao.neves@zup.com.br', 'Teste descrição', '2021-06-28T16:19:32.4618312');
INSERT INTO tb_autor (nome, email, descricao, data_criacao)
VALUES ('Daniela Tagarela', 'daniela.tagarela@zup.com.br', 'Teste descrição', '2021-06-28T16:19:32.4618312');

INSERT INTO tb_categoria (nome)
VALUES ('Java');
INSERT INTO tb_categoria (nome)
VALUES ('Python');
INSERT INTO tb_categoria (nome)
VALUES ('Scrum');

INSERT INTO tb_livro (titulo, resumo, sumario, preco, numero_paginas, isbn, data_publicacao, categoria_id, autor_id)
VALUES ('Spring Boot for dummies', 'texto resumo', 'texto sumario', 20.0, 200, 'f4g21h42u', '2021-12-25', 1, 1);
INSERT INTO tb_livro (titulo, resumo, sumario, preco, numero_paginas, isbn, data_publicacao, categoria_id, autor_id)
VALUES ('Python for dummies', 'texto resumo', 'texto sumario', 20.0, 200, 'f564ads6a', '2021-12-25', 2, 2);