FROM quay.io/wildfly/wildfly:27.0.0.Final-jdk17

USER root

COPY scripts /scripts/
RUN chmod +x /scripts/*

COPY modules /opt/jboss/wildfly/modules/system/layers/base/

USER jboss

#RUN /opt/jboss/wildfly/bin/standalone.sh -b 0.0.0.0 -bmanagement 0.0.0.0 > /dev/null & /scripts/configure.sh

RUN rm -rf /opt/jboss/wildfly/standalone/configuration/standalone_xml_history/current