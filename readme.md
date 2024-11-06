# Tiiimspot
Na Devoxx maak ik altijd van de talk die ik gezien heb een projectje waar ik wat ik wil bijleren in gebruik. Hier zijn de issues en oplossingen die ik heb gebruikt.

De talks waar dit voornamelijk uit komt zijn:
* Bootiful Spring Boot 3.x (Deep dive) https://www.youtube.com/watch?v=vebXemNocGA&list=PL4IWfHFsp7XkomaQjEdzg5akb701TaujH
* Bootiful Spring Boot 3.x (Conf) https://www.youtube.com/watch?v=vY6d2SNYeY4&list=PL4IWfHFsp7XkomaQjEdzg5akb701TaujH&index=2
* Top REST API design pitfalls: https://www.youtube.com/watch?v=CNlLWCvazcQ&list=PL4IWfHFsp7XkomaQjEdzg5akb701TaujH&index=3
* Hexagonal Architecture: https://www.youtube.com/watch?v=YPmKHm7G19Q&list=PL4IWfHFsp7XkomaQjEdzg5akb701TaujH&index=4

## Wat is Tiiimspot?
Tiiimspot moet een hulp zijn voor trainers om hun ploegen te managen. Meer specifiek bij deze iteratie gaat het over wedstrijdopstellingen. Iedereen moet ongeveer evenveel spelen maar we willen wel de sterkst mogelijke ploeg altijd opstellen.

Hoe gaan we dit doen:
* Via business logica in het domain
* De data aan een AI geven en dit voor ons laten doen.
* En dan de gebruiker laten kiezen tussen de AI versie of de eigen implementatie versie.

# Challenges
## Project setup
Ik wil een multimodule project waar het domein zoals in de Hexagonal talk, (bijna) geen external dependencies heeft. In ons geval heeft die een dependency op JUNIT maar dat is dan om testen te schrijven.
In infrastructure zetten we een SpringBoot met Spring Modularize

Bekijk ook de HELP.md deze is gegenereerd door de springinatializr en geeft gerichte help 

### Challenge Maven setup
Ik wil pas dat mijn pom overerft van SpringBoot parent in de infrastructure.

> TODO: The graalvm plugin is not completely working. The lightning startups time moeten maar even wachten. Dit is nu geen prio.

### Challenge Domain

* Define Domain
* Do Validation in side your Domain so in the Record. If the record can be created it's automatically valid.

### Challenge Infrastructure


### Challenge Hexagonal approach

I have already quite some experience with Hexagonal Architecture but the implementation of the talk was so clear that I needed to do an example of this on my own. The Stubs are in the domain.


### Challenge business logic
* Business logic is harder then expected (my logic to pick a team)
