create table student (
    id int not null primary key,
    name varchar(255) not null,
    passport varchar(255) not null,
    instructorId int,

--    instructorId integer foreign key references instructor(id)
);

create table instructor (
    id int not null primary key,
    name varchar(255) not null,
    email varchar(255),
 );