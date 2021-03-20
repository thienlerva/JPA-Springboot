set Mode Oracle;
create table student (
    id int not null primary key,
    name varchar(255) not null,
    phone varchar(255),
    email varchar(255),
    courseId int

--    instructorId integer foreign key references instructor(id)
);

create table course (
    id int primary key,
    name varchar(255),
    instructor varchar(255));