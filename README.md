# springboot-demo

## start
```bash
# package
mvn clean && mvn package -e -X 

# build docker image
docker build -t springboot-demo .

# run
docker run -it -p 8080:8080 --rm --name my-running-demo springboot-demo
```
