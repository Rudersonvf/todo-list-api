INSERT INTO tb_user(name, email, password) VALUES('John Doe', 'john@gmail.com', '$2a$12$jYoAYQUY1i.JPrPoVhrJg.30hvqgVY20bhStwsz0VJrBqTshM/y5S');
INSERT INTO tb_user(name, email, password) VALUES('Jane Smith', 'jane.smith@gmail.com', '$2a$12$jYoAYQUY1i.JPrPoVhrJg.30hvqgVY20bhStwsz0VJrBqTshM/y5S');
INSERT INTO tb_user(name, email, password) VALUES('Alice Johnson', 'alice.johnson@gmail.com', '$2a$12$jYoAYQUY1i.JPrPoVhrJg.30hvqgVY20bhStwsz0VJrBqTshM/y5S');

INSERT INTO tb_role(authority) VALUES('ROLE_ADMIN');
INSERT INTO tb_role(authority) VALUES('ROLE_USER');

INSERT INTO tb_user_role(user_id, role_id) VALUES(1, 1);
INSERT INTO tb_user_role(user_id, role_id) VALUES(1, 2);
INSERT INTO tb_user_role(user_id, role_id) VALUES(2, 2);
INSERT INTO tb_user_role(user_id, role_id) VALUES(3, 2);


INSERT INTO tb_task(description, priority, is_complete, created_at, completed_at, user_id) VALUES('Estudar Java', 0, FALSE, '2024-12-29T10:00:00', NULL, 2);
INSERT INTO tb_task(description, priority, is_complete, created_at, completed_at, user_id) VALUES('Ler um livro', 1, FALSE, '2024-12-29T11:00:00', NULL, 2);
INSERT INTO tb_task(description, priority, is_complete, created_at, completed_at, user_id) VALUES('Limpar a casa', 2, FALSE, '2024-12-29T12:00:00', NULL, 2);
INSERT INTO tb_task(description, priority, is_complete, created_at, completed_at, user_id) VALUES('Fazer compras', 1, FALSE, '2024-12-29T13:00:00', NULL, 2);
INSERT INTO tb_task(description, priority, is_complete, created_at, completed_at, user_id) VALUES('Escrever relatório', 0, FALSE, '2024-12-29T14:00:00', NULL, 2);
INSERT INTO tb_task(description, priority, is_complete, created_at, completed_at, user_id) VALUES('Praticar exercícios', 1, FALSE, '2024-12-29T15:00:00', NULL, 2);
INSERT INTO tb_task(description, priority, is_complete, created_at, completed_at, user_id) VALUES('Planejar viagem', 2, FALSE, '2024-12-29T16:00:00', NULL, 2);
INSERT INTO tb_task(description, priority, is_complete, created_at, completed_at, user_id) VALUES('Assistir filme', 2, FALSE, '2024-12-29T17:00:00', NULL, 2);
INSERT INTO tb_task(description, priority, is_complete, created_at, completed_at, user_id) VALUES('Estudar Spring', 0, FALSE, '2024-12-29T10:00:00', NULL, 3);
INSERT INTO tb_task(description, priority, is_complete, created_at, completed_at, user_id) VALUES('Comprar um presente', 1, FALSE, '2024-12-29T11:00:00', NULL, 3);
INSERT INTO tb_task(description, priority, is_complete, created_at, completed_at, user_id) VALUES('Organizar escritório', 2, FALSE, '2024-12-29T12:00:00', NULL, 3);
INSERT INTO tb_task(description, priority, is_complete, created_at, completed_at, user_id) VALUES('Fazer exercícios de yoga', 1, FALSE, '2024-12-29T13:00:00', NULL, 3);
INSERT INTO tb_task(description, priority, is_complete, created_at, completed_at, user_id) VALUES('Ler artigo sobre programação', 0, FALSE, '2024-12-29T14:00:00', NULL, 3);
INSERT INTO tb_task(description, priority, is_complete, created_at, completed_at, user_id) VALUES('Fazer pesquisa de mercado', 1, FALSE, '2024-12-29T15:00:00', NULL, 3);
INSERT INTO tb_task(description, priority, is_complete, created_at, completed_at, user_id) VALUES('Planejar aniversário', 2, FALSE, '2024-12-29T16:00:00', NULL, 3);
INSERT INTO tb_task(description, priority, is_complete, created_at, completed_at, user_id) VALUES('Assistir tutorial de React', 2, FALSE, '2024-12-29T17:00:00', NULL, 3);