# Student-Management-System Complex Java lab 1
## **Project creation**

- This Java EE project for the Java 19 course from ITHS was developed by Nicklas Johansson and Luis Gutierrez. We both pair-coded and collaborated to create this laboratorium.

## **Projects obstacles**

- One issue we had during the process of building the rest Endpoints was that we got the "PUT" Method only inserted new data and not 
updated the specific record. The reason behind this was a misunderstanding on how CDI operated with the "@GeneratedValue".
We believed we didn't need to have a method the sets new value. After lots of searching we added the method and like magic the "PUT" method 
started to act as it should.  

# Endpoints

# GET
|Method|Description|URL|
|---|---|--|
|GET|Get all students from registry|http://localhost:8080/student-management-system/api/v1/student/getall|

|Response Body Exemple|
|---|
```ruby
  {
    "email": "luis@google.com",
    "firstname": "Luis",
    "id": 1,
    "lastname": "Gutierrez",
    "phonenumber": "555-2343"
  },
  {
    "email": "erick@google.com",
    "firstname": "Erick",
    "id": 2,
    "lastname": "Gutierrez",
    "phonenumber": "555-2673"
  },
  {
    "email": "nicklas@google.com",
    "firstname": "Nicklas",
    "id": 3,
    "lastname": "Johansson",
    "phonenumber": "555-7596"
  },
  {
    "email": "lennart@google.com",
    "firstname": "Lennart",
    "id": 4,
    "lastname": "Johansson",
    "phonenumber": "555-9867"
  },
  {
    "email": "rob@google.com",
    "firstname": "Rob",
    "id": 5,
    "lastname": "Sam",
    "phonenumber": "555-3639"
  },
  {
    "email": "daniel@google.com",
    "firstname": "Daniel",
    "id": 6,
    "lastname": "Van Rankin",
    "phonenumber": "555-1086"
  }
```
|Method|Description|URL|
|---|---|--|
|GET|Get student with given ID|http://localhost:8080/student-management-system/api/v1/student/searchById/{id}|

|Response Body Example||
|---|---|
|Example URL| http://localhost:8080/student-management-system/api/v1/student/searchById/2|

```ruby
  {
  "email": "erick@google.com",
  "firstname": "Erick",
  "id": 2,
  "lastname": "Gutierrez",
  "phonenumber": "555-2673"
  }
 ```
 |Method|Description|URL|
|---|---|--|
|GET|Get student with given last name|http://localhost:8080/student-management-system/api/v1/student/searchByLastName/{lastname}|

|Response Body Example||
|---|---|
|Example URL| http://localhost:8080/student-management-system/api/v1/student/searchByLastName/Gutierrez|
 
```ruby
  [
  {
    "email": "luis@google.com",
    "firstname": "Luis",
    "id": 1,
    "lastname": "Gutierrez",
    "phonenumber": "555-2343"
  },
  {
    "email": "erick@google.com",
    "firstname": "Erick",
    "id": 2,
    "lastname": "Gutierrez",
    "phonenumber": "555-2673"
  }
]
 ```

# POST
|Method|Description|URL|
|---|---|--|
|POST|Create a new student record in registry|http://localhost:8080/student-management-system/api/v1/student/new|

|Request Body Example|
|---|
```ruby
{
  "email": "example@iths.se",
  "firstname": "Ronald",
  "lastname": "McDonald",
  "phonenumber": "555-2249"
}

```
|Response Body Example|
|---|
```ruby
{
  "email": "example@iths.se",
  "firstname": "Ronald",
  "id": 7,
  "lastname": "McDonald",
  "phonenumber": "555-2249"
}

```

# PUT
|Method|Description|URL|
|---|---|--|
|PUT|Update an existing student record in registry|http://localhost:8080/student-management-system/api/v1/student/update|

|Request Body Example and Response Body Example|
|---|
```ruby
{
  "email": "rob@google.com",
  "firstname": "Robbie",
  "id": 5,
  "lastname": "Sam",
  "phonenumber": "555-3639"
}

```

# DELETE
|Method|Description|URL|
|---|---|--|
|DELETE|Remove an existing student with given ID from registry|http://localhost:8080/student-management-system/api/v1/student/deleteById/{id}|

|Response Body Example||
|---|---|
|Example URL| http://localhost:8080/student-management-system/api/v1/student/deleteById/3|

```ruby
Student with ID 3 removed from registry
```

