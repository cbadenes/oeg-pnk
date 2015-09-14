FROM tomcat:8-jre8

MAINTAINER Carlos Badenes (cbadenes@fi.upm.es)

RUN wget -O /usr/local/tomcat/webapps/pnk.war https://raw.github.com/cbadenes/oeg-pnk/mvn-repo/es/upm/oeg/oeg-pnk-web/1.0.0/oeg-pnk-web-1.0.0.war

CMD ["catalina.sh", "run"]
