# Smash Picker: Exploring Super Smash Brothers 🎮

Smash Picker is a simple web app that lets you retrieve details about characters from the video game series “Super Smash Brothers”. 🎉

## About the Project

You can check out Smash Picker at its [public URL](http://smash-picker.duckdns.org:8080/).

**Spring Boot Version**: I'm using Spring Boot 3.1.5.

**Dependency Manager**: I manage my dependencies with Gradle.

**Package**: I use a .jar package.

**Java**: The app is powered by Java 17.

### Dependencies

- **Spring Web**: This is essential for building web applications.

- **Spring Data JPA**: It simplifies data access using the Java Persistence API.

- **MySQL Driver**: I use this to interact with the MySQL database.

- **Lombok**: It's a handy tool for reducing boilerplate code in Java.

- **Thymeleaf**: Thymeleaf is a modern server-side Java template engine for both web and standalone environments.

## Exploring the File Structure

- `src/main`
  - `java/com/SmashPicker/SmashPicker`
    - **Controller**
      - `ClientController`: I handle client-side interactions here.
    - **Entity**
      - `SmashCharacter`: This represents Smash Brothers characters.
      - `Franchise`: It represents the franchises that characters belong to.
    - **Repository**
      - `SmashCharacterRepository`: I manage SmashCharacter entities here.
      - `FranchiseRepository`: This takes care of the Franchise entities.
    - **Service**
      - `SmashCharacterService`: I've put all the business logic related to SmashCharacter here.
      - `FranchiseService`: The business logic related to Franchise resides here.
    - `SmashPickerApplication.java`: This is my main application class.
  - `resources`
    - `static`
      - `Script.js`: For some cool JavaScript to manipulate the DOM.
      - `Styles.css`: This is where I define my CSS for making the web app look good.
    - `templates`
      - `index.html`: The main HTML template.
    - `Application.properties`: I keep my application configuration properties here.

## The Frontend 🌐

- `index.html`: This is my main HTML template. It displays the data fetched from the server using Thymeleaf.

- `Styles.css`: CSS file, responsible for the styling.

- `Script.js`: Using jQuery, for DOM manipulation and to make the web app interactive. I use Ajax for handling fetch requests. I also use Handlebars.js to display dynamic JSON data.

## Database and Site Hosting

The MySQL database is hosted on a Raspberry Pi 4. The schema includes two tables: "smash_characters" and "franchises." Data was inserted manually.

To make this app available to the world, I configured the environment variables to match the Raspberry Pi setup and then transferred the Spring Boot app to the Raspberry Pi from my PC using WinSCP. 

The Pi runs on the lite version of Raspbian OS, and I manage different sessions for the database and the Spring Boot app using tmux. 
And, to avoid purchasing a domain, I set up a free subdomain using DuckDNS.org. 
Lastly, I configured my network to allow public traffic on port 8080.

## What Lies Ahead 🚧

As of now, everything is running smoothly without any issues. Here are potential plans for the future:

- Continuous Integration
- Automatic deployments
- New features

Feel free to try it out: [Smash Picker](http://smash-picker.duckdns.org:8080/)
