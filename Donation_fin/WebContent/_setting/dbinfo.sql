create table don_member (
mno int(11) auto_increment,
mname varchar(100) not null,
mid varchar(100) not null,
mpwd varchar(500) not null,
mphone varchar(500) not null,
mins varchar(500),
primary key(mno)
);
create table don_product (
pno int(11) auto_increment,
pname varchar(200) not null,
price int(11) default 0,
imgfile varchar(100),
thumb varchar(500),
primary key(pno)
); 
create table don_ins (
ino int(11) auto_increment,
iname varchar(200) not null,
loc varchar(500) not null,
ipeople int(10) default 0,
icnt varchar(500),
imgfile varchar(500),
thumb varchar(500),
represent varchar(100) not null,
primary key(ino)
); //추가한부분 :represent 
create table don_comment (
cno int(11) auto_increment,
ino int(11) not null,
writer varchar(100) not null,
comment varchar(1000) not null,
cregdate timestamp default current_timestamp,
primary key(cno)
);
create table don_support(
sno int(11) auto_increment,
pname varchar(100) not null,
price int(11) default 0,
thumb varchar(500),
primary key(sno)
);

create table don_board (
bno int(11) auto_increment,
iname varchar(200) not null,
bregdate timestamp default current_timestamp,
moddate timestamp default current_timestamp,
imgfile varchar(500),
thumb varchar(500),
bid varchar(100),
bcontent varchar(1000),
bperson varchar(100),
primary key(bno)
);
create table don_report (
rno int(11) auto_increment,
name varchar(200) not null,
product varchar(200) not null,
price int(11) not null,
count int (11) default 1,
ins varchar(200) not null,
regdate timestamp default current_timestamp,
primary key(rno)
);