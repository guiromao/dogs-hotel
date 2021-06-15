CREATE TABLE owners
(
    id  SERIAL PRIMARY KEY,
    name   varchar(30) NOT NULL,
    contact varchar(50) NOT NULL,
);

CREATE TABLE dogs
(
    id  SERIAL PRIMARY KEY,
    name  varchar(30)  NOT NULL,
    birthdate date NOT NULL,
    breed varchar(25),
    gender varchar(1),
);