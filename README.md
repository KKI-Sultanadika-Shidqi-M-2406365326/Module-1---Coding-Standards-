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
