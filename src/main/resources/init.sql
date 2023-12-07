INSERT INTO spring_security.users (name, surname, email, username, password)
VALUES
    ('Alexey', 'Vatin', 'vatalex@mail.ru', 'vatin', '$2a$12$cFQ1xnSjVjOWki2C8FkBN.PUeQwOtHV57/.oNCeIS8BF.jJwFYM66'),
    ('Dmitriy', 'Ivanov', 'vatalex@mail.ru', 'ivanov', '$2a$12$cFQ1xnSjVjOWki2C8FkBN.PUeQwOtHV57/.oNCeIS8BF.jJwFYM66'),
    ('Ivan', 'Sokolov', 'ivsokol@gmail.com', 'sokolov', '$2a$12$cFQ1xnSjVjOWki2C8FkBN.PUeQwOtHV57/.oNCeIS8BF.jJwFYM66'),
    ('Maria', 'Bunina', 'buninamar@mail.ru', 'bunina', '$$2a$12$cFQ1xnSjVjOWki2C8FkBN.PUeQwOtHV57/.oNCeIS8BF.jJwFYM66');

# Пароль для всех пользователей: 123

INSERT INTO spring_security.roles (id, name)
VALUES
    ('1', 'ROLE_USER'),
    ('2', 'ROLE_ADMIN');

INSERT INTO spring_security.users_roles (users_id, roles_id)
VALUES
    ('1', '1'),
    ('1', '2'),
    ('2', '1'),
    ('3', '1'),
    ('4', '1');