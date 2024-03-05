#!/bin/bash

docker exec compose_whe_1 mkdir /tmp/ears
docker cp ../src/WHEServicesWAR/target/WHEServicesWAR-0.0.0.war compose_whe_1:/tmp/ears/WiHajstEr.war
docker exec compose_whe_1 /opt/jboss/wildfly/bin/jboss-cli.sh -c 'undeploy WiHajstEr.war'
docker exec compose_whe_1 /opt/jboss/wildfly/bin/jboss-cli.sh -c 'deploy /tmp/ears/WiHajstEr.war'
