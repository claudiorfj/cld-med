create table patient(

    id bigint not null auto_increment,
    name varchar(100) not null,
    sex varchar(50) not null,
    email varchar(100) not null unique,
    cpf varchar(11) not null unique,
    phone varchar(20) not null,
    street varchar(100) not null,
    district varchar(100) not null,
    zipCode varchar(9) not null,
    complement varchar(100),
    number varchar(20),
    state char(100) not null,
    city varchar(100) not null,

    primary key(id)

);