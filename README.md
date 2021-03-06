# Production Line Simulation

## Premise

A company has enlisted our help in designing a new management platform for monitoring access to various coffee machines. The company plans to develop an app which will code to the API we provide for our platform, and that platform will interface with the coffee machines through controllers also manufactured by the company. An illustration of the management platform's role in this system is depicted below.

<img src="https://user-images.githubusercontent.com/42819832/116945920-cfdd3100-ac46-11eb-96f2-824cc5fe2897.png" alt="An illustration of the management platform's role in the coffee production system." width="600"/>


An average scenario is as follows:
- An order for a coffee is sent from the app received by the platform
- The coffee machine to produce the coffee on is determined
- The order is sent to that machine's controller for production
- The platform waits for a response (success / fail) from the controller
- The platform sends the received status back to the app

The goal is to develop a proof-of-concept design that can be easily extended as more demands are made of the management platform (e.g. new types of coffee orders).

### Requirements

By the end of development, the design needed to support the following use cases:
- UC1: User orders a coffee with no condiments
- UC2: User orders a coffee with condiments (e.g. Cream, Sugar, Hazelnut)
- UC3: User orders a coffee that requires a recipe (e.g. the system must send a three-step recipe to a controller when a Latte is ordered)

Since this project was built for a course, no actual interactions with an application, database, or controller were required. As a result, some outcomes are hardcoded (see testBasicOrder() in the Testing class for an example).

## Design

### Example User Scenario

The following is a depiction of the interactions occurring within the management platform for UC2 (User orders a coffee with condiments) from the moment the platform receives the user's order to sending the status of the order back to the application.

<img src="https://user-images.githubusercontent.com/42819832/117229117-609f4280-ade8-11eb-844e-b60fcf84014b.png" alt="A sequence diagram depicting the interactions between classes in the aforementioned user scenario." width="600"/>

When the AppCommunicator receives an order from the customer, it parses the JSON file into an Order instance which is sent to a newly created OrderHandler. (An OrderHandler instance exists for every Order instance.)

OrderHandler calls on its CoffeeFactory to generate a Drink instance based on the Order’s contents. OrderHandler then decorates the Drink instance with CondimentDecorators based on the Order’s contents.

It is at this point that the OrderHandler calls upon the Database to locate an appropriate controller and coffee machine. OrderHandler generates a Command based on the Order’s contents and passes it to the ControllerCommunicator, who then sends it to an appropriate controller outside of the system.

Once the ControllerCommunicator receives a response from outside the system, it notifies the appropriate OrderHandler of the response. OrderHandler then returns the response to the AppCommunicator, which uses its contents to generate a UserResponse to be sent outside the system back to the customer.

## Project Status
This project was completed in February 2021 and is no longer being developed. More recent commits serve to organize files and add documentation.

## Authors
This project was built in collaboration with Arudrra Krishnan and Nick Hall.
