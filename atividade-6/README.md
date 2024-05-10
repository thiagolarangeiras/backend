# Noticias e Comentarios

## como rodar
    
    ./mvnw spring-boot:run

## CURL
[GET] noticias
``` sh 
curl --location 'http://localhost:8080/noticias' 
```

[POST] noticias
``` sh 
curl --location 'http://localhost:8080/noticias' \
--header 'Content-Type: application/json' \
--data '{
    "autor": "1",
    "titulo": "1",
    "texto": "1"
}'
```

[PUT] noticias
``` sh 
curl --location --request PUT 'http://localhost:8080/noticias/1' \
--header 'Content-Type: application/json' \
--data '{
    "autor": "",
    "titulo": "",
    "texto": "",
    "data": "2024-05-10"
}'
```

[DELETE] noticias
``` sh 
curl --location --request DELETE 'http://localhost:8080/noticias/1'
```
<br/>

---

<br/>

[GET] comentarios
``` sh 
curl --location 'http://localhost:8080/noticias/1/comentarios'
```

[POST] comentarios
``` sh 
curl --location 'http://localhost:8080/noticias/1/comentarios' \
--header 'Content-Type: application/json' \
--data '{
    "usuario": "eu",
    "texto": "texto"
}'
```

[PUT] comentarios
``` sh 
curl --location --request PUT 'http://localhost:8080/noticias/1/comentarios/2' \
--header 'Content-Type: application/json' \
--data '{
    "texto": "texto2"
}'
```

[DELETE] comentarios
``` sh 
curl --location --request DELETE 'http://localhost:8080/noticias/1/comentarios/1'
```