drop table if exists author CASCADE
drop table if exists book CASCADE
drop table if exists comment CASCADE
drop table if exists genre CASCADE
create table author (id bigint generated by default as identity, last_name varchar(50) not null, name varchar(50) not null, primary key (id))
create table book (id bigint generated by default as identity, name varchar(50) not null, year_of_publication integer not null, author_id bigint, genre_id bigint, primary key (id))
create table comment (id bigint generated by default as identity, text varchar(50) not null, book_id bigint, primary key (id))
create table genre (id bigint generated by default as identity, name varchar(50) not null, primary key (id))
alter table book add constraint FKklnrv3weler2ftkweewlky958 foreign key (author_id) references author
alter table book add constraint FKm1t3yvw5i7olwdf32cwuul7ta foreign key (genre_id) references genre
alter table comment add constraint FKkko96rdq8d82wm91vh2jsfak7 foreign key (book_id) references book