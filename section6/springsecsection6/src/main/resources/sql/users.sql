insert ignore into `users` values('user', '{noop}EazyBytes@12345', '1');
insert ignore into `users` values('admin', '{bcrypt}$2a$12$TFjuSjyfoCek1n2AAWIzUeGNele1uQirLQS.H/C9JkA6/6HxSP38C', '1');

insert ignore into `authorities` values('user', 'read');
insert ignore into `authorities` values('admin', 'admin');

insert into `customer` (`email`, `pwd`, `role`) values ('user', '{noop}EazyBytes@12345', 'read');
insert into `customer` (`email`, `pwd`, `role`) values ('admin', '{bcrypt}$2a$12$TFjuSjyfoCek1n2AAWIzUeGNele1uQirLQS.H/C9JkA6/6HxSP38C', 'admin');