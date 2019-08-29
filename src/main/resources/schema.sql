CREATE TABLE employee (
  id  VARCHAR(64) PRIMARY KEY,
  name VARCHAR(64) NOT NULL,
  age   int(4) NOT NULL
);

create table system_administrator(
sysAdminID int  primary key ,
userName varchar(30) not null ,
password varchar(30) not null
);

create table company(
companyID int primary key,
companyName varchar(30) not null,
sysAdminID int);
ALTER TABLE company ADD CONSTRAINT FK_system_administrator
FOREIGN KEY(sysAdminID ) REFERENCES system_administrator(sysAdminID);


create table employee(
employeeID int  primary key ,
employeeName varchar(30) NOT null,
age int not null,
homeAddress varchar(256),
vacation date not null ,
companyID int not null

);
ALTER TABLE employee ADD CONSTRAINT FK_company_cid
FOREIGN KEY(companyID) REFERENCES company(companyID);


create table company_administrator(
companyAdminID int primary key ,
companyAdminName varchar(30),
companyID int not null
);
ALTER TABLE company_administrator ADD CONSTRAINT FK_company
FOREIGN KEY(companyID) REFERENCES company(companyID);