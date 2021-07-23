create table users
(
    id         bigserial primary key,
    username   varchar(30) not null unique,
    password   varchar(80) not null,
    email      varchar(80) unique,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);

create table roles
(
    id         bigserial primary key,
    name       varchar(50) not null unique,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);

CREATE TABLE users_roles
(
    user_id bigint not null references users (id),
    role_id bigint not null references roles (id),
    primary key (user_id, role_id)
);

insert into roles (name)
values ('ROLE_USER'),
       ('ROLE_ADMIN');

insert into users (username, password, email)
values ('user', '$2y$12$4g1SOm4vGFSF/CbT84nOzOyygKSuTtRshecj7HYOCC1xUPjhkVPWG', 'bob_johnson@gmail.com'),
       ('admin', '$2y$12$4g1SOm4vGFSF/CbT84nOzOyygKSuTtRshecj7HYOCC1xUPjhkVPWG', 'john_johnson@gmail.com');

insert into users_roles (user_id, role_id)
values (1, 1),
       (2, 2);

create table categories
(
    id         bigserial primary key,
    title      varchar(255),
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);

insert into categories (title)
values ('Food');

create table products
(
    id          bigserial primary key,
    title       varchar(255),
    price       numeric(8, 2),
    category_id bigint references categories (id),
    created_at  timestamp default current_timestamp,
    updated_at  timestamp default current_timestamp
);

insert into products (title, price, category_id)
values ('Хлеб', 25.50, 1),
       ('Молоко', 80.40, 1),
       ('Помидоры', 80.40, 1),
       ('Огурцы', 80.40, 1),
       ('Лук', 80.40, 1),
       ('Макароны', 80.40, 1),
       ('Спагетти', 80.40, 1),
       ('Вода', 80.40, 1),
       ('Чипсы', 80.40, 1),
       ('Сухарики', 80.40, 1),
       ('Вино', 80.40, 1),
       ('Пиво', 80.40, 1),
       ('Салат', 80.40, 1),
       ('Пирожок', 80.40, 1),
       ('Булочка', 80.40, 1),
       ('Конфеты', 80.40, 1),
       ('Шоколад', 80.40, 1),
       ('Сыр', 80.40, 1),
       ('Колбаса', 80.40, 1),
       ('Шпроты', 80.40, 1),
       ('Паприка', 80.40, 1),
       ('Картошка', 80.40, 1),
       ('Бисквит', 80.40, 1),
       ('Крем', 80.40, 1),
       ('Сливки', 80.40, 1),
       ('Киндер', 325.00, 1);


create table orders
(
    id         bigserial primary key,
    user_id    bigint references users (id),
    price      numeric(8, 2),
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp

);
create table order_items
(
    id                bigserial primary key,
    order_id          bigint references products (id),
    product_id        bigint references products (id),
    quantity          int,
    price_per_product numeric(8, 2),
    price             numeric(8, 2),
    created_at        timestamp default current_timestamp,
    updated_at        timestamp default current_timestamp
);



