http://localhost:8080/jersey-exception-mapping-example/resources/exception


Exception Mapping Example
=========================

This example demonstrates how to create a custom exception mapping. There are described several common use-cases such as
`WebApplicationException`, custom exceptions and an exception mapper inheritance.

The full description how to handle exception and map them to Response object can be found in Jersey User Guide, chapter
[WebApplicationException and Mapping Exceptions to Responses](https://jersey.java.net/documentation/latest/representations.html#d0e6567).

Contents
--------

The mapping of the URI path space is presented in the following table:

URI path                                   | HTTP methods  | Allowed Values                              | Description
-----------------------------------------  | ------------- |-------------------------------------------- | ----------------
**_/exception_**                           | GET           | ---                                         | returns "ping!"
**_/exception/webapplication_entity_**     | POST          | two numbers delimited by colons e.g. 1:201  | not handled by `WebApplicationExceptionMapper` (already has an entity in the exception)
**_/exception/webapplication_noentity_**   | POST          | e.g. 1:201                                  | handled by `WebApplicationExceptionMapper`
**_/exception/my_**                        | POST          | e.g. 1:201                                  | handled by `MyExceptionMapper`
**_/exception/mysub_**                     | POST          | e.g. 1:201                                  | handled by `MySubExceptionMapper`
**_/exception/mysubsub_**                  | POST          | e.g. 1:201                                  | handled by `MySubExceptionMapper`
**_/exception/request_exception_**         | POST          | String "Request Exception"                  | not reached a resource method, processed by `ContainerRequestFilter`
**_/exception/response_exception_**        | GET           | ---                                         | response handled and changed by `ContainerResponseFilter`


Application is based on Grizzly container (see `App`). Everything needed
(resources/providers) is registered in `ExceptionResource` and custom exceptions
along with mappers can be found in `Exceptions` class.

Running the Example
-------------------

Run the example as follows:

>     mvn clean compile exec:java

This deploys the example using [Grizzly](http://grizzly.java.net/) container.

-   <http://localhost:8080/base/exception>
-   <http://localhost:8080/base/exception/response_exception>
