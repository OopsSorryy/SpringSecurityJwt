# SpringSecurityJwt

#HOW TO RUN

- First of all, You must have JDK 17, PostgreSQL and Postman on your computer.
- Secondly, When you open project please first run RoleRepositoryTests.class and secondly run UserRepositoryTests.class.
- Also, You must run SpringSecurityApplication.class and project ready to use. 
- Furthermore, You must open Postman, create POST method, write localhost:8080/auth/login and Select body part create JSON object 
     {
      "email" : "muslera1@gmail.com",
      "password": "muslera261"
     }
-

![Post](https://user-images.githubusercontent.com/73158508/178813258-29b935a2-8e4a-4806-b143-3cc6482d225c.PNG)

- Finally, If you want to list product and add project follow below screenshot after copy your token.

- Paste Token here

![token](https://user-images.githubusercontent.com/73158508/178812880-b43fe792-04c7-4a0b-9c6a-d5a1b764ad89.PNG)

- Create POST method and write localhost:8080/products/add

![xiaomi](https://user-images.githubusercontent.com/73158508/178812905-5b22c96d-debf-4473-acc2-e6384850b2e0.PNG)

- Create GET method and write localhost:8080/products/getAll

![list](https://user-images.githubusercontent.com/73158508/178812921-050f5e6e-6d2a-464a-9063-bf636feccf21.PNG)
