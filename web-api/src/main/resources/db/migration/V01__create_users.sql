CREATE TABLE user (
	id BIGINT(20),
	name VARCHAR(50) NOT NULL,
	email VARCHAR(50) NOT NULL,
	password VARCHAR(150) NOT NULL,
	PRIMARY KEY (id));

CREATE TABLE permission (
	id BIGINT(20),
	description VARCHAR(50) NOT NULL,
	PRIMARY KEY (id));

CREATE TABLE user_permission (
	user_id BIGINT(20) NOT NULL,
	permission_id BIGINT(20) NOT NULL,
	PRIMARY KEY (user_id, permission_id),
	FOREIGN KEY (user_id) REFERENCES user(id),
	FOREIGN KEY (permission_id) REFERENCES permission(id));

INSERT INTO user (id, name, email, password) values (1, 'Administrador', 'admin@webapi.com', '$2a$10$X607ZPhQ4EgGNaYKt3n4SONjIv9zc.VMWdEuhCuba7oLAL5IvcL5.');

-- INSERT INTO permission (id, description) values (1, 'ROLE_CADASTRAR_CATEGORIA');
-- INSERT INTO permission (codigo, descricao) values (2, 'ROLE_PESQUISAR_CATEGORIA');


-- admin
-- INSERT INTO user_permission (user_id, permission_id) values (1, 1);
-- INSERT INTO user_permission (user_id, permission_id) values (1, 2);
-- INSERT INTO user_permission (user_id, permission_id) values (2, 1);
-- INSERT INTO user_permission (user_id, permission_id) values (2, 2);
