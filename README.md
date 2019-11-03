# Airport Finder

AirportFinder application consumes the Qantas JSON API and allows the consumer to list and filter airports
by country, airport code, international, domestic airports.

AirportFinder exposes two end points for listing and filtering airports.

1. /rest/airports : It lists all the airports information based on the Qantas JSOM API.

```
e.g. get all Australian airport
/rest/airports
```

2. /rest/airports/filters : It filters the airports by the condition given via the URL. Now the service can take following four key words: countryCode, airportCode, internationalAirport and regionalAirport.


```
e.g. get all Australian airports

/rest/airports/filters?countryCode=AU
```
```
e.g. get all Australian international airports

/rest/airports/filters?countryCode=AU&internationalAirport=true
```
```
e.g. get all Australian regional airports

/rest/airports/filters?countryCode=AU&regionalAirport=true
```
```
e.g. get get Sydney airport

/rest/airports/filters?airportCode=SDY
```

This application breaks down into three layers. 

Controller layer contains all the end point and basic validations of input parameters. It also converts inputs into filter strategies. 

On service layer it applies filters on the airport list and returns filter result. 

On domain layer it has all POJOs required in the Qantas Json API.

The filter strategy is created and applied based on inputs. Currently it contains airportCodeFilter, airportContryCodeFilter, airportInternationalfilter and airportRegionalFilter. 

## Getting Started

$ get clone https://github.com/ericlee83/QT_Challenge


### Running this application

#### Running from an IDE

You can run AirportFinder application from your IDE as a simple Java application. However, you first need to import your project. Import steps vary depending on your IDE and build system.For example, STS users can select Import… --> Existing Projects into Workspace from the File menu.

#### Running as a packaged application

```
$ mvn clean install -Dmaven.test.skip=true
$ java -jar target/flightradar-0.0.1-SNAPSHOT.jar
```

## Running the tests

### Smoke and Sanity test

AirportFinderApplicationTest.java
Assert if the AirportRestController is alive.
#### IDE
1. Run AirportFinderApplicationTest as a JUnit test.

#### Maven
1. Keep AirportFinderApplicaiton alive.
2. $ mvn -Dtest=AirportFinderApplicationTest test

### System test
SystemTest.java
Test the complete FlightRadarApplication.
#### IDE
Use TestRestTemplate as a client to call local FlightRadarApplicaiton and compare the response with Qantas Json Api to make sure that FilghtRadarApplicaiton is running.
1. Run FilghtRadarApplicaiton as Spring boot application.
2. Run SystemTest.

#### Maven
1. Keep AirportFinderApplicaiton alive.
2. $ mvn -Dtest=SystemTest test

### Integration test
IntergrationTest.java
Test AirportRestController and AirportService
#### IDE
1. Run IntergrationTest as a JUnit test.

####Maven
1. Keep AirportFinderApplicaiton alive.
2. $ mvn -Dtest=SystemTest test

### Unit test
StandaloneControllerTest
Test standalone controller
#### IDE
1. Run StandaloneControllerTest as a JUnit test.
2. Run ServiceTest as a JUnit test.
3. Run FilterTest as a JUnit test

####Maven
1. Keep AirportFinderApplicaiton alive.
2. $ mvn -Dtest=StandaloneControllerTest test
2. $ mvn -Dtest=ServiceTest test
2. $ mvn -Dtest=FilterTest test


## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* [Spring-boot](https://spring.io/projects/spring-boot) - Stand-alone framework
 
## Authors

* **Eric Lee** - *Initial work* - [ericlee83](https://github.com/ericlee83)

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

