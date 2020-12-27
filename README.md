# Setup
You need postgresql running in your machine with a database called kurl

## Setup your application properties
```
spring.main.banner-mode=off
logging.level.org.springframework=ERROR

spring.jpa.hibernate.ddl-auto=create-drop

spring.datasource.initialization-mode=always
spring.datasource.platform=postgres
spring.datasource.url=jdbc:postgresql://localhost:5432/kurl
spring.datasource.username=YOUR_USER
spring.datasource.password=YOUR_PASSWORD

spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
```
you can change the ``spring.jpa.hibernate.ddl-auto=create-drop`` to create, create-drop, validate, and update
for different behaviours in the db when you run the project

# Run

``gradle bootRun``