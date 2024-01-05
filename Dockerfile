FROM tomcat:latest

RUN mv /usr/local/tomcat/webapps /usr/local/tomcat/webapps2
RUN mv /usr/local/tomcat/webapps.dist /usr/local/tomcat/webapps
RUN rm -rf /usr/local/tomcat/webapps/ROOT

COPY ./src/main/resources/songs /usr/local/tomcat/src/main/resources/songs

ADD target/ROOT.war /usr/local/tomcat/webapps/

EXPOSE 8082

CMD ["catalina.sh", "run"]