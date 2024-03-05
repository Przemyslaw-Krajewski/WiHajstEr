INSERT INTO przemo.question (id,question) VALUES (-1,'Czy jest czarny');
INSERT INTO przemo.question (id,question) VALUES (-2,'Czy jest wysoki');
INSERT INTO przemo.question (id,question) VALUES (-3,'Czy jest fajny');
INSERT INTO przemo.question (id,question) VALUES (-4,'Czy moze miec rece');


INSERT INTO przemo.item (id,name) VALUES (-1,'Pomnik');
INSERT INTO przemo.item (id,name) VALUES (-2,'Wegiel');
INSERT INTO przemo.item (id,name) VALUES (-3,'Snieg');
INSERT INTO przemo.item (id,name) VALUES (-4,'Slup');

INSERT INTO przemo.answer (id,itemid,questionid,answer) VALUES (-1,-1,-1,'YES');
INSERT INTO przemo.answer (id,itemid,questionid,answer) VALUES (-2,-1,-2,'YES');
INSERT INTO przemo.answer (id,itemid,questionid,answer) VALUES (-3,-2,-1,'YES');
INSERT INTO przemo.answer (id,itemid,questionid,answer) VALUES (-4,-2,-2,'NO');
INSERT INTO przemo.answer (id,itemid,questionid,answer) VALUES (-5,-3,-1,'NO');
INSERT INTO przemo.answer (id,itemid,questionid,answer) VALUES (-6,-4,-2,'YES');
