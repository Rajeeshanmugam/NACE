# NACE
1. link : http://localhost:8080/swagger-ui.html#/
2. Added Dependencies in pom.xml
3. DB uri is configured in application.properties, Please change the db setting and make it work in local machine
4. DB changes 
collection name : naceDetails
created unique Index : db.naceDetails.createIndex( { "order": 1 }, { unique: true } )

5. Swagger configuration is created under configuration folder (SwaggerConfig.java)
6. Created sample of custom exception under exception folder
7. Created end points for putNaceDetails and getNaceDetails, Able to add NACE details from swagger using post mapping and get details based on order by using get mapping
8. Data structure implemted based on NACE csv file.
9. Used MongoRepository for data storage, Not used hibernate mapping (OneToMany) because of no sql.)
10. Created NaceService method for create and getDetails 
11. Implemented NaceService method in NaceServiceImpl and saved data with the help of NaceRepository, NaceRepository which extends MongoRepository
12. MongoRepository supports curd opertion and calling save method for repository method.
13. created own method method to get the details based on Order
14. optional is used to avoid nullpointer exception and handled exception by using custom exception class NotFoundException.java
15. created test case for service and for repository.
