#OEG Pnk
[![Build Status](https://travis-ci.org/cbadenes/oeg-stemming.svg)](https://travis-ci.org/cbadenes/oeg-stemming) 

## Get started!

### Pre-requisites
- [Java](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Docker](https://docs.docker.com/installation/)
- [Maven 3.x](https://maven.apache.org/download.cgi)
- Include the host: `microservices.oeg` in your local configuration or DNS server:  
    a). **Linux Users**:  
        edit `/etc/hosts` and include:  
        ```
        127.0.0.1 microservices.oeg
        ```  
    b). **Mac OSx Users**:  
        edit `/private/etc/hosts/` and include the ip obtained by `boot2docker ip` or `docker-machine ip`:  
        ```  
        [ip]  microservices.oeg  
        ```   
    c). **Windows Users**: 
        edit `C:\Windows\System32\drivers\etc\hosts` and include the ip obtained by `boot2docker ip` or `docker-machine ip`:  
        ```  
        [ip]  microservices.oeg  
        ```  
    

### To build from source
1. Compile the project  
    ```
    mvn clean package
    ```  
2. Build the docker image  
    ```
    ./docker.build
    ```  
3. Run it  
    ```
    ./docker.vrun
    ```  

### To run from DockerHub
1. Download the image  
    ```
    docker pull cbadenes/pnk
    ```  
2. Run it  
    ```
    docker run -it --rm -e JAVA_OPTS='-Xmx1g' -p 8080:8080 cbadenes/pnk
    ```  
    
## ... and now Test it!
Check [http://microservices.oeg:8080/pnk](http://microservices.oeg:8080/pnk)