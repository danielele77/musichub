# Musichub

This repository contains a Docker Compose setup for running a Spring Boot application with PostgreSQL as the database and Adminer as the database management tool. Follow the steps below to get the entire stack up and running.

## Prerequisites

Make sure you have Docker and Docker Compose installed on your machine.

- Docker: [Install Docker](https://docs.docker.com/get-docker/)
- Docker Compose: [Install Docker Compose](https://docs.docker.com/compose/install/)

## Clone the Repository

```bash
git clone <https://github.com/danielele77/musichub>
cd <repository-directory>
```

### Run the docker containers

To run Docker containers type the following command into terminal:


```bash
docker-compose up --build
```

This command will download the necessary Docker images, build the Spring Boot application, and start the containers.

The Spring Boot application will be accessible at [http://localhost:8082](http://localhost:8082/), and Adminer will be accessible at [http://localhost:8081](http://localhost:8081/).



### Accessing Adminer

- **URL**: [http://localhost:8081](http://localhost:8081/)

- **System**: PostgreSQL

- **Server**: db

- **Username**: admin

- **Password**: admin

- **Database**: db

Use Adminer to manage your PostgreSQL database easily.



### Stopping the Containers

To stop the running containers, press `Ctrl + C` in the terminal where the containers are running, or run the following command:

```bash
docker-compose down
```


