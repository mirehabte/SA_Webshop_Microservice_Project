# SA_Webshop_Microservice_Project
Webshop Microservice Project with Springboot

![Capture](https://user-images.githubusercontent.com/53396966/184085868-cfa8e7c9-b27c-4bc0-b4f8-531a7a40ef36.PNG)

1. Customers service: you can get, add, update and delete customers. Customers have a 
customernumber, name, phone, email, street, city, zip. 
2. Products service: you can get, add, update and delete products. Products have a 
productnumber, name, price, description supplier name, supplier phone. Because this 
service is used a lot, make sure you run 2 instances of this products service. The API 
gateway should load balance between these instances. 
3. Payments service: you can get, add, update and delete payments. Payments have a 
date, amount, ordernumber and customernumber. 
4. OrdersCommand service: you can place an order. You can also get an order. An order 
has an ordernumber, date, total price, products and quantity, customernumber, 
customerName. 
5. OrdersQuery service: you can get an order. This order contains all the details of the 
order including products, quantity, customer and payment info. 
Store all data of the services in a Mongo database. For this project you can use 1 mongo 
instance for all services. Make sure all services use a different mongo collection. 
Implement the following supporting services: registry, API gateway, Zipkin and a config 
server. Make sure we have 2 registry replicas running. 

