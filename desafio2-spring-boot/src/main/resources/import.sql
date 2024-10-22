INSERT INTO tb_participante (nome, email) VALUES ('José Silva', 'jose@gmail.com');
INSERT INTO tb_participante (nome, email) VALUES ('Tiago Faria', 'tiago@gmail.com');
INSERT INTO tb_participante (nome, email) VALUES ('Maria do Rosário', 'maria@gmail.com');
INSERT INTO tb_participante (nome, email) VALUES ('Teresa Silva', 'teresa@gmail.com');

INSERT INTO tb_categoria (descricao) VALUES ('Curso');
INSERT INTO tb_categoria (descricao) VALUES ('Oficina');

INSERT INTO tb_atividade (nome, descricao, preco, categoria_id) VALUES ('Curso de HTML', 'Aprenda HTML de forma prática', 80.00, 1);
INSERT INTO tb_atividade (nome, descricao, preco, categoria_id) VALUES ('Oficina de GitHub', 'Controle de versões de seus projetos', 50.00, 2);

--Query que consulta a relação entre BLOCO, ATIVIDADE e CATEGORIA pelo ID da ATIVIDADE

--SELECT B.ATIVIDADE_ID, B.INICIO INICIO_DA_ATIVIDADE, B.FIM AS FIM_DA_ATIVIDADE,  A.PRECO, A. DESCRICAO, A.NOME, A.ID AS ID_ATIVIDADE, C.DESCRICAO AS CATEGORIA  FROM TB_BLOCO B
--INNER JOIN TB_ATIVIDADE A ON B.ATIVIDADE_ID = A.ID
--INNER JOIN TB_CATEGORIA C ON A.CATEGORIA_ID = C.ID
--WHERE A.ID = 2;

INSERT INTO tb_bloco (inicio, fim, atividade_id) VALUES (TIMESTAMP WITH TIME ZONE '2023-10-25T11:00:00Z', TIMESTAMP WITH TIME ZONE '2023-10-25T18:00:00Z', 1);
INSERT INTO tb_bloco (inicio, fim, atividade_id) VALUES (TIMESTAMP WITH TIME ZONE '2023-11-25T14:00:00Z', TIMESTAMP WITH TIME ZONE '2023-11-25T18:00:00Z', 2);
INSERT INTO tb_bloco (inicio, fim, atividade_id) VALUES (TIMESTAMP WITH TIME ZONE '2023-11-26T11:00:00Z', TIMESTAMP WITH TIME ZONE '2023-11-26T18:00:00Z', 2);

INSERT INTO tb_atividade_participante (participante_id, atividade_id) VALUES (1, 1);
INSERT INTO tb_atividade_participante (participante_id, atividade_id) VALUES (1, 2);
INSERT INTO tb_atividade_participante (participante_id, atividade_id) VALUES (2, 1);
INSERT INTO tb_atividade_participante (participante_id, atividade_id) VALUES (3, 1);
INSERT INTO tb_atividade_participante (participante_id, atividade_id) VALUES (3, 2);
INSERT INTO tb_atividade_participante (participante_id, atividade_id) VALUES (4, 2);

