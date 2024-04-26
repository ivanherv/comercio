Test Full Stack Zara 

* Nota: para el parámetro de fecha de aplicación se asume que en la petición se proporciona en formato
yyyy-mm-ddThh:mm:ss (por ejemplo, 2020-06-14T10:00:00). 

* Nota: se ha interpretado que todos los parámetros de la consulta son obligatorios.

Ejemplo de petición GET: http://localhost:8080/price/search?applicationDate=2020-06-14T16:00:00&productId=35455&brandId=1

Resultado: 
{
"id": 2,
"brandId": 1,
"productId": 35455,
"priceList": 2,
"startDate": "2020-06-14T15:00:00",
"endDate": "2020-06-14T18:30:00",
"price": 25.45
}