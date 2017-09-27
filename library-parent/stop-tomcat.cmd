echo "-----------------------"
echo "Stop tomcat instance"
echo "-----------------------"

REM SET CATALINA_HOME="C:\Program Files\Apache Software Foundation\Tomcat 8.0"

REM echo "Using tomcat %CATALINA_HOME%"

REM %CATALINA_HOME%\bin\tomcat.exe stop

echo "-----------------------"
echo "tomcat is stoping      "

net stop Tomcat8
timeout 2

echo "tomcat stoped          "
echo "-----------------------"