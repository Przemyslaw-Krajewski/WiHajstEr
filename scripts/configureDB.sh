export PGPASSWORD=password
psql -d postgres -U admin -h localhost -p 5432 -f ../setup/database/configDB/createSchema.sql -w

export PGPASSWORD=password
psql -d postgres -U admin -h localhost -p 5432 -f ../setup/database/configDB/createTables.sql -w
psql -d postgres -U admin -h localhost -p 5432 -f ../setup/database/configDB/createUser.sql -w
#psql -d postgres -U admin -h localhost -p 5432 -f ../setup/database/configDB/populateData.sql -w

