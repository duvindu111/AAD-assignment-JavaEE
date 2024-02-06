# Simple Java EE Project - Shop Management

This Java EE project is designed to provide a example of a fully functional application with a clear separation between the front-end and back-end components. This project serves as an educational resource to enhance understanding of Java EE development.

## Project Components

### Front-end

The front-end of the Shop Management system is responsible for delivering a user-friendly interface, facilitating seamless interaction with the underlying functionalities. The front-end leverages HTML, CSS, jQuery, and AJAX to create a dynamic and responsive web application.

Technologies Used
- HTML
- CSS
- jQuery
- AJAX

### Back-end

The back-end of the Shop Management system is implemented using JavaEE and is configured to run on the Apache Tomcat server. It provides the server-side logic for handling data processing, business rules, and database interactions.

Technologies Used

- JavaEE
- Apache Tomcat

## Project Structure

### Front-end

The front-end code is organized in a structured manner, ensuring clarity and maintainability. Key directories and files include:

- index.html: The main entry point for the web application.
- contollers/: Directory for JavaScript files, including jQuery and AJAX functionality.
- contollers/validations/: Directory for validation contollers
- assets/: Other resources used in the application, bootstrap, font-awesome and jquery

### Back-end

The back-end code is organized to follow best practices and maintainability. Important directories and files include:

- src/main/java: Directory containing Java classes.
- src/main/resources/assets/schema: Database schema.
- src/main/webapp/WEB-INF/: Configuration files for the JavaEE application.

#### Project Packages

The back-end codebase is further organized into the following packages:

(src/main/java/lk.ijse.gdse66)

- **api**: Contains classes defining the API endpoints and services.
- **bo**: Business Objects - classes that encapsulate business logic.
- **dao**: Data Access Objects - classes responsible for database interactions.
- **entity**: Entity classes representing database tables.
- **dto**: Data Transfer Objects - classes used for data exchange between layers.
- **filter**: Contains classes implementing filters for intercepting and processing requests.

## Getting Started

To set up and run the Shop Management project locally, follow these steps:

&nbsp;1. Clone the repository.  
&nbsp;2. Set up the back-end dependencies.  
&nbsp;3. Configure the database connection.  
&nbsp;4. Deploy the JavaEE application on the Apache Tomcat server.


## Usage

Once the back-end application is running, users can seamlessly interact with the front-end without interruptions. The system consists of four main pages: Customer, Items, Place Order, and Order Details. Users can effortlessly navigate through these pages to perform various actions and tasks.


## Dependencies

#### Front-end

- jQuery : JavaScript library for simplifying client-side scripting. (Version 3.3.1)
- Bootstrap : Front-end framework for responsive and mobile-first web development. (Version 5.3.2)
- Font-Awesome : Icon font and CSS framework for scalable vector icons. (Version 6.4.2)

#### Back-end

- Java EE : Enterprise Edition of the Java platform for building robust and scalable enterprise applications. 
- Apache Tomcat : Servlet container that implements the Java Servlet and JavaServer Pages technologies. (Version 9.0)

#### Database

- MySQL Connector : Java-based driver for connecting to MySQL databases. (Versoin 8.0.32)
- Java Naming and Directory Interface (JNDI): Java API for connecting to directory services, used for managing database connections efficiently through connection pooling, enhancing performance and scalability.

#### Development Tools

- Maven : Build automation and project management tool. (Version 4.0.0)

## License

This project is licensed under MIT License. See the [LICENSE.md](https://github.com/duvindu111/AAD-Assignment-JavaEE/blob/master/LICENSE) file for details.
