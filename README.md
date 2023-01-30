# weatherforecast
Weather Forecast application with CICD using Docker

<h2>Step 1 : Pull Docker Image</h2>
Docker Image can be pulled from Docker hub using following command

docker pull mahaveer91/weatherforecast-cicd-image

<h2> Step 2 : Run Docker Container</h2>

Run Docker Container using 

docker run -p 8080:8080 mahaveer91/weatherforecast-cicd-image

<h2>Step 3 : Access the API's</h2>

Access the API Swagger documentations at

http://localhost:8080/swagger-ui/index.html#/