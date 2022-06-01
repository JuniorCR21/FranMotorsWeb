INSERT INTO user (username,password,status,account_locked,role,created_at) VALUES ('jcarrior', '#Jc123456', true, 0, 'A', NOW());
INSERT INTO user (username,password,status,account_locked,role,created_at) VALUES ('cmendozv', '#Ur123456', true, 3, 'U', NOW());
INSERT INTO user (username,password,status,account_locked,role,created_at) VALUES ('ggutierr', '#Ur123456', true, 0, 'U', NOW());
INSERT INTO user (username,password,status,account_locked,role,created_at) VALUES ('csanchev', '#Ur123456', false, 0, 'U', NOW());
INSERT INTO user (username,password,status,account_locked,role,created_at) VALUES ('fgutiers', '#Ad123456', true, 0, 'A', NOW());

INSERT INTO employee (name, surname, dni, email, phone, date_birth, user_id) VALUES ('Junior', 'Carrion Rodriguez', '70355540', 'jcarrior@gmail.com', '987654321', '1998-11-21', 1);
INSERT INTO employee (name, surname, dni, email, phone, date_birth, user_id) VALUES ('Carlos', 'Mendoza Vargas', '45785212', 'cmendozv@gmail.com', '963852741', '1996-08-25', 2);
INSERT INTO employee (name, surname, dni, email, phone, date_birth, user_id) VALUES ('Gino', 'Gutierrez Rodriguez', '49875632', 'ggutierr@gmail.com', '951753846', '1997-06-15', 3);
INSERT INTO employee (name, surname, dni, email, phone, date_birth, user_id) VALUES ('Claudia', 'Sanchez Vargas', '49875123', 'csanchev@gmail.com', '950045846', '1995-01-10', 4);
INSERT INTO employee (name, surname, dni, email, phone, date_birth, user_id) VALUES ('Frank', 'Gutierrez Sanchez', '48723632', 'fgutiers@gmail.com', '951750201', '1998-05-20', 5);

