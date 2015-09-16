FROM tomcat:8-jre8

MAINTAINER Carlos Badenes (cbadenes@fi.upm.es)

ADD web/entities/ /usr/local/tomcat/entities/

ADD web/model/ /usr/local/tomcat/model/

ADD web/target/pnk.war /usr/local/tomcat/webapps/pnk.war

CMD ["catalina.sh", "run"]
