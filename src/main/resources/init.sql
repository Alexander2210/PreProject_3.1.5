INSERT INTO spring_security.users (name, surname, email, username, password)
VALUES
    ('Alexey', 'Vatin', 'vatalex@mail.ru', 'vatin', '$2a$12$e8h6wixiD9.3gAbNzVYHr.3wPGW3DJ8K7SInvIl/gBoqg1YycrsLausers_roles'),
    ('Dmitriy', 'Ivanov', 'vatalex@mail.ru', 'ivanov', '$2a$12$vIwppZk/y8JKoQJLBynvt.RbR8uRo8TeuLMadnogfWkkUP47azjwC'),
    ('Ivan', 'Sokolov', 'ivsokol@gmail.com', 'sokolov', '$2a$12$H27IWmu6ldCuo0bPgWWd8.jPNVo9S9eBWi07FflBCv0xg1PJbyaO.'),
    ('Maria', 'Bunina', 'buninamar@mail.ru', 'bunina', '$2a$12$arP7UhgemlXLD2E3fM0U.OkLwfT8XZVCKQPwj312r3WZbqbbDOV.S');

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