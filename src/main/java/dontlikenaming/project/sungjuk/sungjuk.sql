-- 성적 테이블 만들기
create table sungjuk (
    sjno int auto_increment,
    name varchar(10) not null,
    kor int not null,
    eng int not null,
    mat int not null,
    tot int not null,
    avg decimal(5,1) not null,
    grd varchar(2) not null,
    regdate date default current_timestamp,
    primary key (sjno)
);