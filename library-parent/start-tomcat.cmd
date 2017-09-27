echo "-----------------------"
echo "Start tomcat instance"
echo "-----------------------"

REM SET CATALINA_HOME="C:\Program Files\Apache Software Foundation\Tomcat 8.0"

REM echo "Using tomcat %CATALINA_HOME%"

REM %CATALINA_HOME%\bin\tomcat.exe start

echo "----------------------"
echo "tomcat is starting    "

net start Tomcat8
timeout 2

echo "tomcat started       "
echo "---------------------"