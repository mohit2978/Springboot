## Notes

GraphQl is Query language for APIs .
It helps client to get the data what they need nothing more nothing less!!

GraphQL is a query language to retrieve data from a server. It is an alternative to REST, SOAP, or gRPC

Add dependency -->spring for graphql

you see a folder graphQl in resources!!

```graphql
type Product{
    id: ID,
    name:String
    category:String
    price:Float
    stock:Int
}


type Query{
    getProducts:[Product]
    getProductsByCategory(category:String):[Product]
}

type  Mutation{
    updateStock(id:ID,stock:Int):Product
    receiveNewShipment(id:ID,quantity:Int):Product
}
```