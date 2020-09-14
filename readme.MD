ProductAPI
 1. get all Products
   path: /products
   Request Method: GET
 2. create a Product
   path: /products
   Request Method: POST
   payload: 
    name     String
    price    double
    units    int
   
CartAPI
 1. Add product cart
   path: /cart
   Request Method: POST
   payload:
    quantity        int 
    unitPrice       double  
    productId       int
       
 2. get all carts
    path: /cart
    Request Method: GET
 3. add item to existing cart
    path: /cart/{cartId}
    Request Method: POST
    payload:
       quantity        int 
       unitPrice       double  
       productId       int
       
OrderAPI
 1. place order
    path: /orders/{cartId}
    Request Method: GET
    
 2. get all orders
    path: /orders   
    Request Method: GET   
  