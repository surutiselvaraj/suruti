
ALTER TABLE T_XBBNHFQ_ROOM ADD CONSTRAINT PK_T_XBBNHFQ_ROOM PRIMARY KEY (rid);

create table T_XBBNHFQ_USERDETAILS (cid integer,
firstname varchar(30),
lastname varchar(30),
address varchar(30),
district varchar(30),emailid varchar(30),contactno bigint, primary key (cid));


CREATE TABLE  T_XBBNHFQ_USERDETAILS
(
cid int NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1000, INCREMENT BY 1),
firstname varchar(30),
lastname varchar(30),
address varchar(30),
district varchar(30),emailid varchar(30),contactno bigint, primary key (cid));

create table T_XBBNHFQ_LOGIN(loginid int ,password varchar(30),foreign key(loginid) references  T_XBBNHFQ_USERDETAILS(cid));


CREATE OR REPLACE PROCEDURE getRoomDetails 
   (RoomID IN NUMBER) AS
BEGIN
   SELECT *    FROM T_XBBNHFQ_ROOM WHERE RID = RoomID;
END;
/

create or replace procedure T_XBBNHFQ_LOGIN(id T_XBBNHFQ_LOGIN.loginid%TYPE,password1 T_XBBNHFQ_LOGIN.password%TYPE)
is
begin
insert into T_XBBNHFQ_LOGIN(loginid,password)values(id,password1);
commit;
end;


insert into T_XBBNHFQ_LOGIN values (1001,'welcome',1001);

CREATE TABLE  T_XBBNHFQ_EMPLOYEEDETAILS
(
empid int NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1000, INCREMENT BY 1),
name varchar(30),
location varchar(30),
salary int,
emailid varchar(30),contactno bigint, primary key (cid));

alter table T_XBBNHFQ_ROOM add column hid integer;

create table T_XBBNHFQ_HOTEL (hid integer,name varchar(30),address varchar(30),location varchar(30),Level integer,rating integer);
create table T_XBBNHFQ_BOOKINGS (hid integer,rid integer,cid integer,fromdate date,todate date);

alter table T_XBBNHFQ_BOOKINGS add foreign key(hid) references T_XBBNHFQ_HOTEL(hid);
alter table T_XBBNHFQ_HOTEL add primary key(hid);
ALTER TABLE T_XBBNHFQ_HOTEL ALTER COLUMN hid  NOT NULL;
alter table T_XBBNHFQ_BOOKINGS add foreign key(cid) references T_XBBNHFQ_USERDETAILS(cid);
alter table T_XBBNHFQ_ROOM add primary key(hid,rid);
ALTER TABLE T_XBBNHFQ_ROOM ALTER COLUMN hid  NOT NULL;


create table T_XBBNHFQ_LOGIN (loginid varchar(30),password varchar(30));

alter TABLE T_XBBNHFQ_BOOKINGS add column loginid varchar(30);

create table T_XBBNHFQ_ROOM (
isac boolean,
no_of_cot int ,
grade int,
livingspace int,
cost int,
rid int,
hid int,
type varchar(30),
);

create table T_XBBNHFQ_MANAGER (
managerid int NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1000, INCREMENT BY 1),
hid int ,
managerfname varchar(30),
managerlname varchar(30),
address  varchar(30),
district varchar(30),
emailid varchar(30),
password varchar(30),
contactno bigint);


SELECT *  from T_XBBNHFQ_Manager b join T_XBBNHFQ_Hotel h on b.hid=h.hid

ALTER TABLE T_XBBNHFQ_Hotel ADD managerid int;

SELECT *  from T_XBBNHFQ_Manager b join T_XBBNHFQ_Hotel h on b.hid=h.hid


create table T_XBBNHFQ_CUSTOMER_FEEDBACK (loginid varchar(30),
hotelid integer,
improperfood integer,
priceissues integer,
poorcustomerservice integer,
plancancelled integer,
feedback varchar(300)
);
insert into T_XBBNHFQ_Room values(true,2,4,1500,1500,501,1003,'Royal Suite')
SELECT *  from T_XBBNHFQ_Bookings b join T_XBBNHFQ_Hotel h on b.hid=h.hid  order by h.name
SELECT *  from T_XBBNHFQ_HOTEL
SELECT *  from T_XBBNHFQ_MANAGER
SELECT *  from T_XBBNHFQ_Room

SELECT *  from T_XBBNHFQ_ROOM r join T_XBBNHFQ_HOTEL h on r.hid=h.hid where  h.location="Trichy"
SELECT * FROM T_XBBNHFQ_USERDETAILS;

SELECT * FROM T_XBBNHFQ_LOGIN;


select * from T_XBBNHFQ_BOOKINGS;
SELECT *  from T_XBBNHFQ_BOOKINGS td join T_XBBNHFQ_USERDETAILS tu on td.cid=tu.cid;