# ESHOP WEBSITE:

MY DEBIT CARD FOR NOW IS NOT WORKING SO WILL DO IT ON NEXT MODULE 😢

# MODULE 1 - SULTANADIKA SHIDQI M - 2406365326

# REFLECTION 1

In this project, I implemented two additional features using Spring Boot, which are Edit Product and Delete Product, alongside the existing Create and List Product features. While working on these features, I tried to apply the clean code and secure coding principles that were in module.

## Clean Code Principles I Applied

One clean code principle I applied is separation of concerns. The project is divided into several layers such as Controller, Service, Repository, and Model. Each layer has its own responsibility, which makes the code easier to read and understand. For example, the controller only handles HTTP requests, while the service handles business logic and the repository manages the data.

I also tried to use clear and meaningful naming for classes and methods, such as createProductPage, productListPage, and deleteByName. These names help explain what the method does without needing extra comments.

Another principle I followed is the single responsibility principle. Each method is written to do only one main task. For instance, the delete method only handles deleting a product and does not mix other logic inside it. This makes the code easier to maintain and test.

Lastly, I kept the code formatting and structure consistent throughout the project so it is easier to read and follow.

## Secure Coding Practices I Applied

For security, I used POST requests for actions that modify data, such as creating and editing products, instead of using GET requests. This follows proper HTTP practices and helps reduce unintended changes.

I also used Spring’s @ModelAttribute to handle user input, which helps avoid manual parsing of request parameters and reduces the chance of mistakes when handling input data.

All product operations go through the controller and service layers, which means users cannot directly access or manipulate the repository. This helps keep the application logic more controlled and structured.

## Things That Can Be Improved

Currently, products are edited and deleted using the product name, which can be problematic if two products have the same name. A better approach would be to use a unique identifier such as productId for these operations.

There is also no input validation yet. This means users could potentially submit empty names or negative quantities. 


## Conclusion

This project helped me better understand how clean code and security concepts are applied in a real Spring Boot application.


# Reflection 2

### Question 1 and Answer
After writing the unit test, how do you feel? How many unit tests should be made in a
class? How to make sure that our unit tests are enough to verify our program? It would be
good if you learned about code coverage. Code coverage is a metric that can help you
understand how much of your source is tested. If you have 100% code coverage, does
that mean your code has no bugs or errors?

Answer: 

I started to feel more confident about my code. Before using tests, I usually just ran the app and hoped everything worked. With unit tests, I can quickly check if a specific part of the code is working or not.
There is no exact number of unit tests that must be written in one class. For me, a good rule is that each important method should have at least one test, and more if the method has different cases. The goal is not to write many tests, but to write tests that actually check the logic.
Code coverage helps to see how much of the code is tested. However, even if the code has 100% coverage, it does not mean the program has no bugs. Tests can still miss logical mistakes, so coverage is helpful, but it should not be the only thing i relied on.

### Question 2 and Answer

Suppose that after writing the CreateProductFunctionalTest.java along with the
corresponding test case, you were asked to create another functional test suite that
verifies the number of items in the product list. You decided to create a new Java class
similar to the prior functional test suites with the same setup procedures and instance
variables.
What do you think about the cleanliness of the code of the new functional test suite? Will
the new code reduce the code quality? Identify the potential clean code issues, explain
the reasons, and suggest possible improvements to make the code cleaner! Please write
your reflection inside the repository's README.md file.

Answer: 

Making another functional test suite that verifies the number of items in the product list by copying the setup from CreateProductFunctionalTest.java will make the code not very clean but it works because
copying the same setup code a makes the code harder to maintain. If something changes, I would have to update many test files, which is inefficient and error-prone.

A couple of problems I Might Face:

- Repeated setup code in multiple test classes
 
- Code duplication

- Harder to maintain and update

How to Improve It

- Keep each test class focused on one main feature

- Make another functional test suite with different setup 

# MODULE 2 - Sultanadika Shidqi M

## Reflection 3:

### 1. List the code quality issue(s) that you fixed during the exercise and explain your strategy on fixing them.

Answer:
I run into a couple of code quality issues which it is tedious when fixing it, heres the list of the issues i fix:

1. Unused Imports and Dead Code
Some unused imports and unnecessary code were detected by SonarCloud. I fixed this by removing unused statements and cleaning up redundant code to make the codebase simpler and easier to maintain.

2. Unclear Naming
A few variables and methods had non-descriptive names. I renamed them using clearer and more meaningful naming conventions so the code is easier to read and understand.

3. Minor Code Duplication
There were small cases of repeated logic. I refactored the duplicated parts into reusable methods to reduce redundancy and improve maintainability.

4. General Code Clean-Up
Some minor code smells such as formatting and small structural issues were addressed through simple refactoring and better organization of the code.

5. CI and SonarCloud Integration
To prevent similar issues in the future, I integrated SonarCloud with the CI pipeline so code quality checks run automatically on every change.


### 2. Look at your CI/CD workflows (GitHub)/pipelines (GitLab). Do you think the current implementation has met the definition of Continuous Integration and Continuous Deployment? Explain the reasons (minimum 3 sentences)!

Answer:

Yes, I believe the current implementation already meets the definition of Continuous Integration. Every push to the repository automatically triggers the CI pipeline, which builds the project, runs tests, and performs static analysis using SonarCloud. This ensures that code changes are continuously validated and potential issues are detected early.

For Continuous Deployment, the setup also aligns with the definition because the project is automatically deployed to a PaaS platform whenever changes are pushed to the deployment branch. This removes the need for manual deployment and ensures the latest version of the application is always available online. Overall, the integration between automated testing, code quality checks, and auto-deployment reflects both CI and CD principles.

# MODULE 3 - Sultanadika Shidqi M

## Reflection:

### 1) Explain what principles you apply to your project!

In this project, I applied the five SOLID principles to improve the structure and quality of the code.

1.  Applied the Single Responsibility Principle (SRP) by separating the system into clear layers such as Controller, Service, Repository, and Model. Each class is responsible for only one specific task, which makes the system easier to understand and maintain.

2.  Applied the Open/Closed Principle (OCP) by using interfaces such as CarService and ProductService. This allows the system to be extended with new implementations without modifying existing high-level code.

3.  Applied the Liskov Substitution Principle (LSP) by ensuring that implementation classes correctly follow the contracts defined by their interfaces, so they can be substituted without affecting the system’s behavior.

4. Applied the Interface Segregation Principle (ISP) by creating focused and specific interfaces instead of combining unrelated methods into a single large interface.

5. Implemented the Dependency Inversion Principle (DIP) by making high-level modules depend on abstractions rather than concrete classes and using constructor injection to reduce tight coupling.

### 2) Explain the advantages of applying SOLID principles to your project with examples.

Applying SOLID principles in this project provides several important advantages.

1. Improves maintainability. Because each class has a single responsibility, changes in one part of the system do not affect other parts. For example, if the data storage mechanism in CarRepository changes from in-memory storage to a database, the CarController and CarService do not need to be modified.

2. Increases flexibility and extensibility. By using interfaces such as CarService and ProductService, the system can support new implementations without modifying existing high-level code. For example, if I want to create a CarServiceDatabaseImpl, I can implement the same interface and replace the old implementation without changing the controller.

3. Improves testability. Since the controller depends on abstractions instead of concrete classes, it becomes easier to use mock implementations during testing. For example, I can create a mock CarService to test CarController without running the entire repository layer.

4. Reduces tight coupling between components. The controller does not directly depend on repository classes, and service classes do not depend on concrete implementations unnecessarily. This separation makes the architecture cleaner and easier to scale.

Overall, applying SOLID principles makes the project more organized, easier to modify, easier to test, and more scalable for future development.

### 3) Explain the disadvantages of not applying SOLID principles to your project with examples

If SOLID principles are not applied, the project becomes harder to maintain and extend.

- Without Single Responsibility Principle (SRP), one class may handle multiple responsibilities, such as a controller managing business logic and data access at the same time. This makes the code harder to debug and modify.

- Without Open/Closed Principle (OCP), adding new features may require modifying existing classes. For example, if the controller directly depends on CarServiceImpl, changing the implementation would require editing the controller, increasing the risk of errors.

- Without Liskov Substitution Principle (LSP), replacing one implementation with another could break the system if the new implementation does not follow the expected behavior.

- Without Interface Segregation Principle (ISP), interfaces may become too large and force classes to implement unnecessary methods.

- Without Dependency Inversion Principle (DIP), high-level modules would depend directly on concrete classes, creating tight coupling and making testing more difficult.

# Module 4

## Reflection

1. Reflect based on Percival (2017) proposed self-reflective questions (in “Principles and Best
Practice of Testing” submodule, chapter “Evaluating Your Testing Objectives”), whether this
TDD flow is useful enough for you or not. If not, explain things that you need to do next time
you make more tests.


Answer:

Reflection on TDD based on Percival (2017)
After completing this tutorial using the Test-Driven Development (TDD) workflow, I found that TDD is helpful in guiding the development process. Writing tests before implementing features helped me understand the expected behavior of the system more clearly. For example, when implementing the payment features, the tests helped define how the system should behave for valid and invalid voucher codes or bank transfer inputs.

However, in some cases I wrote the implementation before fully thinking about the tests, which means I did not strictly follow the RED-GREEN-REFACTOR cycle. Ideally, the tests should fail first before writing the code. In the future, I would try to follow the TDD workflow more strictly so that the tests truly guide the implementation and help catch edge cases earlier.

2. You have created unit tests in Tutorial. Now reflect whether your tests have successfully
followed F.I.R.S.T. principle or not. If not, explain things that you need to do the next time you
create more tests.

Answer:

Reflection on the F.I.R.S.T. principles
Overall, the unit tests in this tutorial mostly follow the F.I.R.S.T. principles. The tests are fast because they use unit testing and mocking instead of external systems. They are also independent and repeatable since each test runs separately and uses a fresh setup with @BeforeEach. In addition, the tests are self-validating because they use assertions to automatically determine whether they pass or fail.

However, some tests could still be improved by making them more focused and testing only one behavior at a time. In the future, I would try to write clearer and more specific test cases so that they are easier to understand and maintain.
