CREATE TABLE DEPARTMENT
(
  ID INTEGER AUTO_INCREMENT PRIMARY KEY NOT NULL,
  NAME VARCHAR(50)
);
CREATE UNIQUE INDEX "department_id_uindex" ON DEPARTMENT (ID);

CREATE TABLE EMPLOYEE
(
  ID INTEGER AUTO_INCREMENT PRIMARY KEY NOT NULL,
  NAME VARCHAR(50),
  DEPARTMENT_ID INTEGER,
  CONSTRAINT DEPARTMENT_ID FOREIGN KEY (DEPARTMENT_ID) REFERENCES DEPARTMENT (ID)
);
CREATE UNIQUE INDEX "user_id_uindex" ON EMPLOYEE (ID);
CREATE INDEX DEPARTMENT_ID_INDEX_7 ON EMPLOYEE (DEPARTMENT_ID);

insert into department(name) values ('IT department');
insert into department(name) values ('Sales department');
insert into department(name) values ('Financial department');
insert into department(name) values ('Security department');
insert into department(name) values ('HR department');

insert into employee(name, department_id) VALUES ('John', 1);
insert into employee(name, department_id) VALUES ('Greg', 1);
insert into employee(name, department_id) VALUES ('Jacob', 2);
insert into employee(name, department_id) VALUES ('Peter', 2);
insert into employee(name, department_id) VALUES ('Richard', 3);
insert into employee(name, department_id) VALUES ('Paul', 3);
insert into employee(name, department_id) VALUES ('Jared', 4);
insert into employee(name, department_id) VALUES ('Donald', 4);
insert into employee(name, department_id) VALUES ('Diana', 5);
insert into employee(name, department_id) VALUES ('Jennifer', 5);