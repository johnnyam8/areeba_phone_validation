# Areeba Phone Validation Microservice
 
A Java Spring Boot microservice utilizing Google's libphonenumber library for validating mobile numbers.
 
## Features
 
- Validate mobile number format.
- Retrieve details about the phone number.
 
## Getting Started
 
### Prerequisites
 
- Java 17 or higher - [Download Java](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- Maven - [Learn more about Maven](https://maven.apache.org/)
 
### Installation
 
1. Clone the repository:
   ```
   git clone https://github.com/johnnyam8/areeba_phone_validation.git
   ```
2. Change directory:
   ```
   cd areeba_phone_validation
   ```
3. **Build the Application**:
    - Run the following command to build the application:
      ```
      ./mvnw clean install
      ```
4. **Run the Application**:
    - Start the application with:
      ```
      ./mvnw spring-boot:run
      ```
    - The microservice will run on http://localhost:8080.
    - Verify the application is running by checking the output logs.

5. **Run the Application Using Docker** :
    -  Download docker and follow the details installation  - https://docs.docker.com/get-docker/
      
    - Navigate to the project directory: 
      ```
       cd areeba_phone_validation
      ```
   -  Build the docker image: 
       ```
        docker build -t areeba_phone_validation .
       ```
    -   After building the project, docker should be able to create an image, check the image created:
      ```
        docker images
      ```
    -  Run the image:
     ```
        docker run -p 8080:8080 [docker image id]
     ```
     -  Verify the application is running by checking the output logs or by running the following command:
     ```
        docker ps
     ```
     
### Usage
 
Access the Swagger API documentation at http://localhost:8080/swagger-ui/index.html#/ for details on API usage.
 
## Contribution
 
Contributions are welcome! If you have feedback, bug reports, or pull requests, please submit them through the project's GitHub page.
 
## Author
 
Johnny Abi Mansour
