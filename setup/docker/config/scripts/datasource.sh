/opt/jboss/wildfly/bin/jboss-cli.sh -c "/subsystem=datasources/jdbc-driver=postgres:add(driver-module-name=org.postgresql,driver-name=postgres,driver-class-name=org.postgresql.Driver,driver-xa-datasource-class-name=org.postgresql.xa.PGXADataSource)"
/opt/jboss/wildfly/bin/jboss-cli.sh -c "/subsystem=datasources/data-source=postgres:add(driver-name=postgres,connection-url=jdbc:postgresql://db:5432/postgres,jndi-name=java:jboss/datasources/postgres,password=password,user-name=whe)"