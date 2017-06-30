# /bin/bash

liquibase --changeLogFile=changelog.sql
     --driver=com.microsoft.sqlserver.jdbc.SQLServerDriver
     --classpath=jdbc/sqljdbc4-4.0.jar
     --url="jdbc:sqlserver://somedb.database.windows.net:1433;database=some-db"
     --username=some-user
     --password=some-password
     update // HL