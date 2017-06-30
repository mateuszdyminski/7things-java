



Run test of calculator:
```bash
hey -n 100 -c 10 -H "Content-type: text/plain" "http://localhost:8080/calculator/add?val1=3&val2=7"
```

Run grizzly server with ctx logging
```bash
java -jar target/log-context-1.0-SNAPSHOT-jar-with-dependencies.jar true
```

Make sample request to calculator service
```bash
curl 'http://localhost:8080/calculator/add?val1=3&val2=7'
```

API versioning - headers
```bash
curl http://localhost:8180/users

curl -H "Accept: application/vnd.usersapp-v1+json" http://localhost:8180/users

curl -H "Accept: application/vnd.usersapp-v2+json" http://localhost:8180/users
```

API versioning - url
```bash
curl http://localhost:8180/api/v1/users

curl http://localhost:8180/api/v2/users
```

Build versioning
```bash
curl -H http://localhost:8090/health
```