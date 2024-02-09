# NLW Expert (Java)

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)

```markdown
# Spring Boot NLW - EXPERT

Esse projeto foi criado durante a Next level week, provida pela RockeSeat.

## Table of Contents

- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
  - [Installation](#installation)
  - [Configuration](#configuration)
- [Usage](#usage)
- [Contributing](#contributing)

## Prerequisites

- Java JDK (version 17)
- Maven (version 3.9.6)
- MySQL/PostgreSQL/Other database (if applicable)

## Getting Started
    To run the project you will need java 17, maven and dockerDesktop.


### Installation

1. Clone the repository: `git clone git@github.com:aviiamelia/nlw-java-certifcation.git`
2. Navigate to the project directory: `cd your-repo`
3. Build the project: `mvn clean install`


## Usage


1. Create the container for the database with 
```bash
docker compose up -d
```
2. Then run the applcation with the command 
```bash
mvn spring-boot:run 
```
API will be accessible at http://localhost:8080

## Features

```markdown
GET /questions/technology/{technology} - Retrieve a list of all questions for a given technology
```

```markdown
Get /ranking/topten - Retrieve a list of the top 10 highest scoring users
```
```markdown
POST /students/verifyCertification- Check whether the user has a certification in a technology
```
```json
[
    {
      "email": "teste@email.com",
      "technology": "JAVA"
    },
    
]
```
```markdown
POST /students/certification/answer - Endpoint of user responses
```
```json
[
    {
      "email": "teste@email.com",
      "technology": "JAVA",
      "questionsAnswers": [
        {
          "questionID": "c5f02721-6dc3-4fa6-b46d-6f2e8dca9c66",
          "alternativeID": "bafdf631-6edf-482a-bda9-7dce1efb1890"
        },
        {
          "questionID": "b0ec9e6b-721c-43c7-9432-4d0b6eb15b01",
          "alternativeID": "f8e6e9b3-199b-4f0d-97ce-7e5bdc080da9"
        },
        {
          "questionID": "f85e9434-1711-4e02-9f9e-7831aa5c743a",
          "alternativeID": "d3e51a56-9b97-4bb8-9827-8bcf89f4b276"
        }
      ]
    },
    
]
```

## Contributing

Contributions are welcome! If you find any issues or have suggestions for improvements, please open an issue or submit a pull request to the repository.