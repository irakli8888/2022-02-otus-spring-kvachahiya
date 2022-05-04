create table if not exists author
(
    id int auto_increment primary key ,
    name varchar(200) not null,
    last_name varchar(200) not null
    );


create table if not exists genre
(
    id int auto_increment primary key,
    name varchar(200) not null
    );

create table if not exists  book
(
    id int auto_increment primary key ,
    name varchar(100) not null,
    year_of_publication smallint not null,
    genre_id int,
    author_id int ,
    foreign key (author_id) references author(id) ON DELETE SET NULL
    );
