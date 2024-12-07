Courcework

Run with ./gradlew bootRun
Need to have docker.

curl commands to test entpoints:

Add ingredient: 
curl -X POST http://localhost:8080/api/v1/ingredient/add      -H "Content-Type: application/json"      -d '{"name": "cheese"}'

Add dish:
curl -X POST http://localhost:8080/api/v1/dish/addDish      -H "Content-Type: application/json"      -d '{"name": "banitsa","weight": 250.0,"price": 12.99,"ingredients": [{"id": 1},{"id": 2},{"id": 3},{"id": 4}]}'

Edit dish:
curl -X PUT "http://localhost:8080/api/v1/dish/editDish?dishId=1"      -H "Content-Type: application/json"      -d '{"name": "musaka","weight": 250.0,"price": 12.99,"ingredients": [{"id": 1}]}'

Get dishes by price:
curl -X GET "http://localhost:8080/api/v1/dish/getByPrice?price=12.99"

Delete a dish:
curl -X DELETE "http://localhost:8080/api/v1/dish/delDish?dishId=2"

Get all dishes:
curl -X GET "localhost:8080/api/v1/dish/getAll"
