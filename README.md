# geolocation-service
Spring Rest Service based on MaxMind & GH Repo https://github.com/geoacumen/geoacumen-country

# docker-compose
```yml
version: "3"
services:
  geolocation-service:
    image: ghcr.io/fo0/geolocation-service
    environment:
      SPRING_APPLICATION_NAME=geolocation
      SERVER_PORT=8080
      MAXMIND_GEOIP_DATABASE=classpath:Geoacumen-Country.mmdb
      LOGGING_LEVEL_ME_FO0=ERROR
    ports:
      - "8080:8080"
    expose:
      - "8080"
```
