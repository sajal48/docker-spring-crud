create table if not exists products
(
    id          int auto_increment primary key,
    name        varchar(255)   not null,
    description text,
    price       int
);