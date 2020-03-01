# CountryInformation
App using docker

This application is a task from "Akademia Kodu"
To run the application just use "docker-compose up"

<br/><br/>
Task:

You are required to:
1. Create a spring boot docker application with Jre8
2. Application required to download image database https://github.com/ghusta/docker-postgres-world-db during build and connect to it during runtime
3. Implement an endpoint which when given country code should return country information
Example  GET- http:/localhost:8080/BHR should return:
{
"name": "Bahrain"
"continent": "Asia"
"population":617000
"life_expectancy":73
"country_language":"Arabic"
}
4. Create Unit Tests for the following tests
    1. if non existent code is called then return error message:"INVALID_COUNTRY_CODE" and http response should be internal server error
    2. if database is down then the error message should be "INTERNAL_ERROR" and http response should be internal server error
5. Result code should be uploaded to a public github  repository and link should be sent