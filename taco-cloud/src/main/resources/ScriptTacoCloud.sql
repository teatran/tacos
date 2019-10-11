create table if not exists Ingredient (
	id varchar(4) not null,
	name varchar(25) not null,
	type varchar(10) not null
);

create table if not exists Taco (
	id bigint primary key,
	name varchar(50) not null,
	createdAt timestamp not null
);

create table if not exists Taco_Ingredients (
	taco bigint not null,
	ingredient varchar(4) not null
);

alter table Taco_Ingredients
add foreign key (taco) references Taco(id);

alter table Taco_Ingredients
add foreign key (ingredient) references Ingredient(id);

create table if not exists Taco_Order (
	id bigint primary key,
	deliveryName varchar(50) not null,
	deliveryStreet varchar(50) not null,
	deliveryCity varchar(50) not null,
	deliveryState varchar(2) not null,
	deliveryZip varchar(10) not null,
	ccNumber varchar(16) not null,
	ccExpiration varchar(5) not null,
	ccCVV varchar(3) not null,
	placedAt timestamp not null
);

create table if not exists Taco_Order_Tacos (
	tacoOrder bigint not null,
	taco bigint not null
);

alter table Taco_Order_Tacos
add foreign key (tacoOrder) references Taco_Order(id);

alter table Taco_Order_Tacos
add foreign key (taco) references Taco(id);


insert into Ingredient (id, name, type)
values ('FLTO', 'Flour Tortilla', 'WRAP');

insert into Ingredient (id, name, type)
values ('COTO', 'Corn Tortilla', 'WRAP');

insert into Ingredient (id, name, type)
values ('GRBF', 'Ground Beef', 'PROTEIN');

insert into Ingredient (id, name, type)
values ('CARN', 'Carnitas', 'PROTEIN');

insert into Ingredient (id, name, type)
values ('TMTO', 'Diced Tomatoes', 'VEGGIES');

insert into Ingredient (id, name, type)
values ('LETC', 'Lettuce', 'VEGGIES');

insert into Ingredient (id, name, type)
values ('CHED', 'Cheddar', 'CHEESE');

insert into Ingredient (id, name, type)
values ('JACK', 'Monterrey Jack', 'CHEESE');

insert into Ingredient (id, name, type)
values ('SLSA', 'Salsa', 'SAUCE');

insert into Ingredient (id, name, type)
values ('SRCR', 'Sour Cream', 'SAUCE');

select * from Ingredient;

create table Users (
	username varchar(10) primary key,
	password varchar(256),
	enable boolean
);

create extension pgcrypto;   -- to use digest function

delete from Users;

insert into Users (username, password, enable) 
values ('tea', '$2a$10$EblZqNptyYvcLm/VwDCVAuBjzZOI7khzdyGPBr08PpIi0na624b8.', true);

insert into Users (username, password, enable) 
values ('code', '$2a$10$W9oRWeFmOT0bByL5fmAceucetmEYFg2yzq3e50mcu.CO7rUDb/poG', true);

insert into Users (username, password, enable) 
values ('david', crypt('123', 'hello'), true);


select * from Users;

create table Authorities (
	username varchar(10),
	authority varchar(20)
);

insert into Authorities(username, authority)
values ('tea', 'ROLE_ADMIN');

insert into Authorities(username, authority)
values ('code', 'ROLE_USER');

select * from Authorities;