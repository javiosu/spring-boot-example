
Application.yml


```
spring:
  datasource:
    type: com.zaxxer.hikari.HikariDataSource
    url: jdbc:sqlserver://10.1.224.7:1433;database=PORTALDB
    username: skhappuser
    password: 1230Skhapp
    hikari:
      poolName: Hikari
      auto-commit: false
      data-source-properties:
        cachePrepStmts: true
        prepStmtCacheSize: 250
        prepStmtCacheSqlLimit: 2048
        useServerPrepStmts: true
  log-datasource:
    type: com.zaxxer.hikari.HikariDataSource
    url: jdbc:sqlserver://10.1.224.7:1433;database=SKHAPPDB
    username: skhappuser
    password: 1230Skhapp
    hikari:
      poolName: Hikari
      auto-commit: false
      data-source-properties:
        cachePrepStmts: true
        prepStmtCacheSize: 250
        prepStmtCacheSqlLimit: 2048
        useServerPrepStmts: true
```



databaseConfiguration.java

LogDatabaseConfiguration.java


