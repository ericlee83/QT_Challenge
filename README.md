# Airport Finder

AirportFinder application consumes the Qantas JSON API and allows the consumer to list and filter airports
by country, airport code, international, domestic airports.

AirportFinder exposes two end points for listing and filtering airports. By default it use http://localhost:8080.

1. /rest/airports : It lists all the airports information based on the Qantas JSOM API.

```
e.g. get all Australian airport
http://localhost:8080/rest/airports
```

2. /rest/airports/filters : It filters the airports by the condition given via the URL. Now the service can take following four key words: countryCode, airportCode, internationalAirport and regionalAirport.


```
e.g. get all Australian airports

http://localhost:8080/rest/airports/filters?countryCode=AU
```
```
e.g. get all Australian international airports

http://localhost:8080/rest/airports/filters?countryCode=AU&internationalAirport=true
```
```
e.g. get all Australian regional airports

http://localhost:8080/rest/airports/filters?countryCode=AU&regionalAirport=true
```
```
e.g. get get Sydney airport

http://localhost:8080/rest/airports/filters?airportCode=SYD
```

This application breaks down into three layers. 

Controller layer contains all the end point and basic validations of input parameters. It also converts inputs into filter strategies. 

On service layer it applies filters on the airport list and returns filtered result. 

On domain layer it has all POJOs required in the Qantas Json API.

The filter strategy is created and applied based on inputs. Currently it contains airportCodeFilter, airportContryCodeFilter, airportInternationalfilter and airportRegionalFilter. 

## Getting Started

$ get clone https://github.com/ericlee83/QT_Challenge


### Running this application

#### Running from an IDE

You can run AirportFinder application from your IDE as a simple Java application. However, you first need to import your project. Import steps vary depending on your IDE and build system.For example, STS users can select Import… --> Existing Projects into Workspace from the File menu.

Run AirportFinderApplication as Spring boot app.

#### Running as a packaged application

```
$ mvn clean install
$ java -jar target/airport.finder-0.0.1-SNAPSHOT.jar
```

## Running the tests

### Smoke and Sanity test

AirportFinderApplicationTest.java
Assert if the AirportRestController is alive.
#### IDE
1. Run AirportFinderApplicationTest as a JUnit test.

#### Maven
1. $ mvn -Dtest=AirportFinderApplicationTest test

### Integration test
AirportRestControllerIT.java
Test AirportRestController and AirportService
#### IDE
1. Run AirportRestControllerIT as a JUnit test.

#### Maven
1. $ mvn -Dtest=AirportRestControllerIT test

### Unit test
AirportRestControllerTest, AirportServiceTest and AirportFilterTest
Test standalone controller, AirortService and FilterStrategy
#### IDE
1. Run AirportRestControllerTest as a JUnit test.
2. Run AirportServiceTest as a JUnit test.
3. Run AirportFilterTest as a JUnit test.

####Maven
1. $ mvn -Dtest=AirportRestControllerTest test
2. $ mvn -Dtest=AirportServiceTest test
3. $ mvn -Dtest=AirportFilterTest test


## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* [Spring-boot](https://spring.io/projects/spring-boot) - Stand-alone framework
 
## Authors

* **Eric Lee** - *Initial work* - [ericlee83](https://github.com/ericlee83)

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

