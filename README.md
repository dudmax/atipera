
# ATIPERA TASK

A brief description of what this project does and who it's for


## Authors

- Maxim Dudyshev [@dudmax](https://www.github.com/octokatherine)


## Stack

Technology stack: Java 17, Spring Boot 3, REST, Json, Maven, Lombok

## Documentation

As an api consumer, given login and header “Accept: application/json”, response is a list all user github repositories, which are not forks. Information provided in JSON is:

Repository Name
Owner Login
For each branch it’s name and last commit sha

As an api consumer, given not existing github user - produce a 404 response in such a format:
{
“status”: ${responseCode}
“Message”: ${whyHasItHappened}
}

As an api consumer, given header “Accept: application/xml” - produce 406 response in such a format:
{
“status”: ${responseCode}
“Message”: ${whyHasItHappened}
}

## Usage - good case

```java
http://localhost:8080/repos/dudmax
```

Answer is:

```json
    {
        "name": "allegro-android-app",
        "owner": {
            "login": "dudmax"
        },
        "branches": [
            {
                "name": "master",
                "lastCommitSha": "13b27c4cb58ad745002f3e18812051a81ec95f6a"
            }
        ]
    },
    {
        "name": "bank-narodowy",
        "owner": {
            "login": "dudmax"
        },
        "branches": [
            {
                "name": "main",
                "lastCommitSha": "b17621f214a78a42a58baf6fb2fb5016568b0974"
            }
        ]
    },
    {
        "name": "dev",
        "owner": {
            "login": "dudmax"
        },
        "branches": [
            {
                "name": "master",
                "lastCommitSha": "9f148f4957c9776968a61bb13a20d8e95b73c8ef"
            }
        ]
    },
    {
        "name": "formula1",
        "owner": {
            "login": "dudmax"
        },
        "branches": [
            {
                "name": "master",
                "lastCommitSha": "6c8453052317f43a234512f7ed8415cbc51396b6"
            }
        ]
    },
    {
        "name": "game2048",
        "owner": {
            "login": "dudmax"
        },
        "branches": [
            {
                "name": "master",
                "lastCommitSha": "03bde9dd0887facccd68ab596276d805be0dbd47"
            }
        ]
    },
    {
        "name": "lsn-tasks",
        "owner": {
            "login": "dudmax"
        },
        "branches": [
            {
                "name": "master",
                "lastCommitSha": "f94b3d9b5560e9818f7fd73d72a2b9d4b5a2ccfd"
            }
        ]
    },
    {
        "name": "space-rest",
        "owner": {
            "login": "dudmax"
        },
        "branches": [
            {
                "name": "dependabot/maven/com.fasterxml.jackson.core-jackson-databind-2.12.7.1",
                "lastCommitSha": "e81c325b70c31400f5712b80bb7582f21db87cd5"
            },
            {
                "name": "dependabot/maven/com.h2database-h2-2.1.210",
                "lastCommitSha": "658617a93c7c969c46b3c97de19c338044720f1a"
            },
            {
                "name": "dependabot/maven/junit-junit-4.13.1",
                "lastCommitSha": "148802d5298f79a11f156ab6298fbaa94e96b92f"
            },
            {
                "name": "dependabot/maven/mysql-mysql-connector-java-8.0.28",
                "lastCommitSha": "56f5a67d7ecb1afbf828bbec3eadf50514903469"
            },
            {
                "name": "dependabot/maven/org.springframework-spring-beans-5.2.20.RELEASE",
                "lastCommitSha": "8a5d406220ef4ef27e0234549d45b16830aacd33"
            },
            {
                "name": "dependabot/maven/org.springframework-spring-core-5.2.22.RELEASE",
                "lastCommitSha": "c3b984fb08908f8d2238c35b0d22a6b53fa41bf5"
            },
            {
                "name": "dependabot/maven/org.springframework-spring-webmvc-5.2.20.RELEASE",
                "lastCommitSha": "45a877e5b748f7a4bf1d2b63475b1d2d1b474c26"
            },
            {
                "name": "dependabot/maven/spring.version-5.2.6.RELEASE",
                "lastCommitSha": "8e080add8c5bddb4c7bc28c89a73f62e7fedf170"
            },
            {
                "name": "master",
                "lastCommitSha": "d053b220c9448ac7a6c7424262cd4cb9f9497dd7"
            }
        ]
    },
    {
        "name": "vacancy-agregator",
        "owner": {
            "login": "dudmax"
        },
        "branches": [
            {
                "name": "master",
                "lastCommitSha": "8fe301d4df9e2b9a929af0946114cdb822c120a0"
            }
        ]
    },
    {
        "name": "zip-manager",
        "owner": {
            "login": "dudmax"
        },
        "branches": [
            {
                "name": "master",
                "lastCommitSha": "f43899e5ba9af364f6683a06d7eee0279d711cdf"
            }
        ]
    }
]
```

## Usage - 404 not found

```java
http://localhost:8080/repos/dudmax
```

Answer is:

```json
    {
        "name": "allegro-android-app",
        "owner": {
            "login": "dudmax"
        },
        "branches": [
            {
                "name": "master",
                "lastCommitSha": "13b27c4cb58ad745002f3e18812051a81ec95f6a"
            }
        ]
    },
    {
        "name": "bank-narodowy",
        "owner": {
            "login": "dudmax"
        },
        "branches": [
            {
                "name": "main",
                "lastCommitSha": "b17621f214a78a42a58baf6fb2fb5016568b0974"
            }
        ]
    },
    {
        "name": "dev",
        "owner": {
            "login": "dudmax"
        },
        "branches": [
            {
                "name": "master",
                "lastCommitSha": "9f148f4957c9776968a61bb13a20d8e95b73c8ef"
            }
        ]
    },
    {
        "name": "formula1",
        "owner": {
            "login": "dudmax"
        },
        "branches": [
            {
                "name": "master",
                "lastCommitSha": "6c8453052317f43a234512f7ed8415cbc51396b6"
            }
        ]
    },
    {
        "name": "game2048",
        "owner": {
            "login": "dudmax"
        },
        "branches": [
            {
                "name": "master",
                "lastCommitSha": "03bde9dd0887facccd68ab596276d805be0dbd47"
            }
        ]
    },
    {
        "name": "lsn-tasks",
        "owner": {
            "login": "dudmax"
        },
        "branches": [
            {
                "name": "master",
                "lastCommitSha": "f94b3d9b5560e9818f7fd73d72a2b9d4b5a2ccfd"
            }
        ]
    },
    {
        "name": "space-rest",
        "owner": {
            "login": "dudmax"
        },
        "branches": [
            {
                "name": "dependabot/maven/com.fasterxml.jackson.core-jackson-databind-2.12.7.1",
                "lastCommitSha": "e81c325b70c31400f5712b80bb7582f21db87cd5"
            },
            {
                "name": "dependabot/maven/com.h2database-h2-2.1.210",
                "lastCommitSha": "658617a93c7c969c46b3c97de19c338044720f1a"
            },
            {
                "name": "dependabot/maven/junit-junit-4.13.1",
                "lastCommitSha": "148802d5298f79a11f156ab6298fbaa94e96b92f"
            },
            {
                "name": "dependabot/maven/mysql-mysql-connector-java-8.0.28",
                "lastCommitSha": "56f5a67d7ecb1afbf828bbec3eadf50514903469"
            },
            {
                "name": "dependabot/maven/org.springframework-spring-beans-5.2.20.RELEASE",
                "lastCommitSha": "8a5d406220ef4ef27e0234549d45b16830aacd33"
            },
            {
                "name": "dependabot/maven/org.springframework-spring-core-5.2.22.RELEASE",
                "lastCommitSha": "c3b984fb08908f8d2238c35b0d22a6b53fa41bf5"
            },
            {
                "name": "dependabot/maven/org.springframework-spring-webmvc-5.2.20.RELEASE",
                "lastCommitSha": "45a877e5b748f7a4bf1d2b63475b1d2d1b474c26"
            },
            {
                "name": "dependabot/maven/spring.version-5.2.6.RELEASE",
                "lastCommitSha": "8e080add8c5bddb4c7bc28c89a73f62e7fedf170"
            },
            {
                "name": "master",
                "lastCommitSha": "d053b220c9448ac7a6c7424262cd4cb9f9497dd7"
            }
        ]
    },
    {
        "name": "vacancy-agregator",
        "owner": {
            "login": "dudmax"
        },
        "branches": [
            {
                "name": "master",
                "lastCommitSha": "8fe301d4df9e2b9a929af0946114cdb822c120a0"
            }
        ]
    },
    {
        "name": "zip-manager",
        "owner": {
            "login": "dudmax"
        },
        "branches": [
            {
                "name": "master",
                "lastCommitSha": "f43899e5ba9af364f6683a06d7eee0279d711cdf"
            }
        ]
    }
]
```## Usage - 404 not found

```java
http://localhost:8080/repos/dudmaxxxx
```

Answer is:

```json
    {
    "status": "NOT_FOUND",
    "message": "404 Not Found: \"{\"message\":\"Not Found\",\"documentation_url\":\"https://docs.github.com/rest/repos/repos#list-repositories-for-a-user\"}\""
}
```

## Usage - 406 not accetable

```java
http://localhost:8080/repos/dudmax

Header parametrs:
Accept: application/xml
```

Answer is:

```json
    {"message":"Acceptable MIME type:application/json","status":"NOT_ACCEPTABLE"}
```
