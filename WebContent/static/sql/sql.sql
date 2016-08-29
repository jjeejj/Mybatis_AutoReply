create table message(
	id int(10) not null primary key auto_increment,
	command varchar(20),
	description varchar(200),
	content varchar(200)
)

--指令表
create table command(
	id int(10) not null primary key auto_increment,
	name varchar(20),
	description varchar(200)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

--内容表
create table content(
	id int(10) not null primary key auto_increment,
	command_id int(10) not null,
	content varchar(200)
)ENGINE=InnoDB  DEFAULT CHARSET=utf8;