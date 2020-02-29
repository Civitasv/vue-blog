use blog;
# article表
create table article
(
    ARTICLE_ID  int primary key auto_increment,
    PUBLIC_TIME double,
    TITLE       TEXT,
    DIGEST      TEXT,
    CONTENT     TEXT,
    HEAT        DOUBLE,
    COMMEND_NUM INT,
    READ_NUM    INT
);

# label表
CREATE TABLE label
(
    LABEL_ID INT PRIMARY KEY AUTO_INCREMENT,
    LABEL    VARCHAR(45)
);

# comment表，一个文章可以有多个评论，一对多
CREATE TABLE comment
(
    COMMENT_ID   INT PRIMARY KEY AUTO_INCREMENT,
    CONTENT      TEXT,
    COMMENT_TIME DOUBLE,
    COMMENT_NUM  INT,
    COMMENT_NAME VARCHAR(45),
    EMAIL        VARCHAR(45),
    ARTICLE_ID int,
    foreign key (ARTICLE_ID) references article(ARTICLE_ID)
        on delete cascade # 级联更新 级联删除
        on UPDATE cascade
);

# 一个文章可以有多个标签，一个标签也对应多个文章，即多对多，创建中间表
CREATE TABLE article2label
(
    ID         INT PRIMARY KEY AUTO_INCREMENT,
    ARTICLE_ID INT,
    LABEL_ID   INT,
    FOREIGN KEY (ARTICLE_ID) references article (ARTICLE_ID)
        on delete cascade
        on UPDATE cascade,
    foreign key (LABEL_ID) references label(LABEL_ID)
        on delete cascade
        on UPDATE cascade
);