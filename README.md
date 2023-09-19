# notes
# 1. About the project
notes is a simple todo app based on <strong>REST API</strong> divided into three layers: <strong>Repository</strong> (H2, MySQL), <strong>Service</strong> (Business logic) and <strong>Presentation</strong> (Model-View-Contrller). The motivation of the project is to provide maintainable code using JAVA (Spring Boot mini framework), GitHub and Test Driven Development approach.

# 2. Getting started 
## 2.1 Prerequisites 
<code>mvn</code> - Maven command <br> 
alternativelly use <code>mvnw</code> for UNIX/LINUX or <code>mvnw.cmd</code> for Windows<br> 

Postman (https://www.postman.com/) or another API platform <br> 
Import into Postman postmanRequests/Notes Requests.postman_collection.json<br> 

## 2.2 Installation
1. Clone repo: <code>git clone https://github.com/krzysztof-moszczynski/notes.git</code><br> 
2. Change location: <code>cd notes/notes</code><br> 
3. Start Spring Boot: <code>mvn clean spring-boot:run</code><br> 
3.1 Alternatively: <code>./mvnw clean spring-boot:run</code> (UNIX/LINUX, MacOS)<br> 
3.2 Alternatively: <code>mvnw.cmd clean spring-boot:run </code>(Windows)<br> 

## 2.2 Usage
1. <strong>Front-end</strong>: open localhost:8080 in web browser<br>
2. <strong>API operations<strong>: use imported Postman reqests collections<br>
YouTube: [Link] (https://www.youtube.com/watch?v=LT_o94vO-TU)<br>

# 3 Roadmap
## 3.2 For MySQL usage configure
src/main/resources/application.properties<br>
<code>
\#H2 connectivity <br>
\#spring.h2.console.enabled=true<br>
\#spring.h2.console.path=/h2<br>
\#spring.datasource.url=jdbc:h2:mem:grade-submission<br>

\#MySQL connectivity<br>
spring.jpa.hibernate.ddl-auto=update<br>
\#create or use existing DATABASE, e.g. db_notes <br>
spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:3306/db_notes<br>
spring.datasource.username=user<br>
spring.datasource.password=password<br>
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver<br>
spring.jpa.show-sql: true<br>
</code>

# Contact
<krzysztof.moszczynski@gmail.com> <br>
Project Link: [Link] https://github.com/krzysztof-moszczynski/notes

# Acknowledgments
I'm pretty thankful for support, comments and inspirations to: Marcin Dudała and Piotr Wołowiec.
