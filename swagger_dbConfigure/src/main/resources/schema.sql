set Mode Oracle;
create table student (
    id int primary key,
    name varchar(255) not null,
    phone varchar(255),
    email varchar(255),

--    instructorId integer foreign key references instructor(id)
);

