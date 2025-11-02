## @Component

* This will help **SpringAutoConfiguration** to create a bean of the specific class, if we added **@Component** above to the class
* The annotations which are helping **SpringAutoConfiguration** to create a bean while running the application like **@Service**, **@Controller**, @Repository, etc.. are explisitly or implisitly Alias the **@Component** class.
    ## Alias Syntax (Inheritance of Component class):
        @AliasFor(
            annotation = Component.class
        }

## @Controller/@RestController
* These annotations Alias the **@Component** to create beans of Controller classes
* Additional feature is they handle HTTP requests.

## @Service
* **@Service** is an alias of **@Component**. However there is no additional feature with **@Service** we can replace **@Component** with **@Service**.

## @Repository
* @Repository is an alias of **@Component**, we can replace @Repository with **@Component** unless i won't get any Exeception.
* Additional feature of @Repository is, It can convert any Checked Exceptions into DataAccessException which are getting 
while persisting any table data.
* Even if an exception occurs, adding **@Component** annotation will still make it work. However, you will receive the default 
exception that are associated with the PersistenceException class.

## @Bean
* This is a method level annotation where return type will be an Object with some pre-Object-creation configurations.
like to build a db connection we need to configure dataSource object with host, url, username, password, class etc..

## @Configuration
* @Configuration is an alias of **@Component**, but it provides an additional feature, it ensures singleton behavior
for the objects created through methods annotated with **@Bean** inside the class. These beans are managed with pre-object-creation 
configurations, meaning Spring creates and manages a single shared instance for each **@Bean** method.


## Difference between @Controller vs @RestController
* This difference will give the clear picture of **@RestController** and **@Controller**.
    ## @RestController:
    * It returns data directly in Response Body
    * **@RestController** is a combination of **@Controller** and **@ResponseBody**. 
    * No need of ViewResolver

    ## @Controller:
    * It returns view name.
        ## View
        * View is template of html, jsp, json, etc... sent as a return type of 
        method which are there inside **@Controller** class.
    * It uses **ViewResolver** to resolve a template(eg, HTML or JSP) from view name.
    * It uses **@ResponseBody** to bypass the ViewResolver and send data directly.

## @ResponseBody
* It tells handler methods to send data as **HttpResponse** instead of passing data to **** 
because ViesResolver find jsp, json, html, etc.. files with name returning from the controller method

## Difference between @PathVariable vs @RequestParam.
* This will clear where to use **@PathVariable** & **@RequestParam**.
    # @RequestParam:
    * helps to extract query params from the URL.
    * It is used for optional parameters, filters and pagination logic.
        #
            localhost:8080/user/getUser?id=1&name=harry 
            .../fndByNameandDepartment?name=name&department=department

    # @PathVariable
    * Extract value directly from URL path.
    * It is used for Identifiers that uniquely locate a resource.
        #
            localhost:8080/user/getUser/1
            .../getById/{id}
            .../getByName/{name}
            .../getByCode/{code}

        

    
 
