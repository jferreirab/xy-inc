
create database xy_inc;

CREATE USER xy_inc_dba WITH PASSWORD 'root';

CREATE TABLE poi
(
  id bigint NOT NULL,
  descricao character varying(255),
  x integer,
  y integer,
  CONSTRAINT poi_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE poi
  OWNER TO xy_inc_dba;

  CREATE SEQUENCE hibernate_sequence
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE hibernate_sequence
  OWNER TO xy_inc_dba;


insert into poi values(nextval ('hibernate_sequence'),'Lanchonete',27,12);
insert into poi values(nextval ('hibernate_sequence'),'Posto',31,18);
insert into poi values(nextval ('hibernate_sequence'),'Joalheria',15,12);
insert into poi values(nextval ('hibernate_sequence'),'Floricultura',19,21);
insert into poi values(nextval ('hibernate_sequence'),'Pub',12,8);
insert into poi values(nextval ('hibernate_sequence'),'Supermercado',23,6);
insert into poi values(nextval ('hibernate_sequence'),'Churrascaria',28,2);