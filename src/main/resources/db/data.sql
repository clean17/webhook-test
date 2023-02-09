insert into user_tb (username, password, email, create_at) values ('ssar','1234','ssar@nate.com',now());
insert into user_tb (username, password, email, create_at) values ('love','1234','love@nate.com',now());

insert into board_tb (title, content, user_id, create_at) values ('첫번째 제목 입니다.','첫번째 내용입니다.', 1, now());
insert into board_tb (title, content, user_id, create_at) values ('두번째 제목 입니다.','두번째 내용입니다.', 2, now());
insert into board_tb (title, content, user_id, create_at) values ('세번째 제목 입니다.','세번째 내용입니다.', 1, now());
insert into board_tb (title, content, user_id, create_at) values ('네번째 제목 입니다.','네번째 내용입니다.', 1, now());
insert into board_tb (title, content, user_id, create_at) values ('다섯번째 제목 입니다.','다섯번째 내용입니다.', 2, now());
insert into board_tb (title, content, user_id, create_at) values ('여섯번째 제목 입니다.','여섯번째 내용입니다.', 2, now());
insert into board_tb (title, content, user_id, create_at) values ('일곱번째 제목 입니다.','일곱번째 내용입니다.', 2, now());

insert into reply_tb (content, user_id, create_at) values ('1등 ㅋㅋ', 2, now());
insert into reply_tb (content, user_id, create_at) values ('2등', 1, now());

insert into love_tb (count, user_id) values (1, 1);

commit;