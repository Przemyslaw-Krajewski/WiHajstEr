CREATE TABLE przemo.question
(
    id integer primary key,
    question varchar(200),
    CONSTRAINT un_question UNIQUE (question)
);

CREATE TABLE przemo.item
(
    id integer primary key,
    name varchar(200),
    CONSTRAINT un_item UNIQUE (name)
);

CREATE TABLE przemo.answer
(
    id integer primary key,
    itemid integer,
    questionid integer,
    answer varchar(40),
    CONSTRAINT fk_item
       FOREIGN KEY(itemid)
       REFERENCES przemo.item(id),
    CONSTRAINT fk_question
       FOREIGN KEY(questionid)
       REFERENCES przemo.question(id)
);

CREATE SEQUENCE przemo.itemseq
start with 33
increment by 1
cycle;

CREATE SEQUENCE przemo.questionseq
start with 33
increment by 1
cycle;

CREATE SEQUENCE przemo.answerseq
start with 33
increment by 1
;