CREATE USER whe WITH PASSWORD 'password';

GRANT CONNECT ON DATABASE postgres TO whe;
GRANT USAGE ON SCHEMA przemo TO whe;
GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA przemo TO whe;
GRANT USAGE ON SEQUENCE przemo.itemseq TO whe;
GRANT SELECT ON SEQUENCE przemo.itemseq TO whe;
GRANT USAGE ON SEQUENCE przemo.questionseq TO whe;
GRANT USAGE ON SEQUENCE przemo.answerseq TO whe;