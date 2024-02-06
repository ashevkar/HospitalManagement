>Create a new Sakila Sample Database Actor
<img width="1440" alt="1" src="https://github.com/itmd4515/itmd4515-s24-fp-ashevkar/assets/152341739/70cbd329-b6e9-46ee-9e32-aaeb1c7f3b13">

>Confirmation page where it displays the user input
<img width="1440" alt="2" src="https://github.com/itmd4515/itmd4515-s24-fp-ashevkar/assets/152341739/c351d250-3c5e-407e-ae1d-809346dcd862">

>A new data has been inserted in the Sakila database table actor.
<img width="822" alt="3" src="https://github.com/itmd4515/itmd4515-s24-fp-ashevkar/assets/152341739/c62bcece-e3b0-4038-a614-5854f6a7ba8d">

>One Constraint Violation
<img width="1440" alt="4" src="https://github.com/itmd4515/itmd4515-s24-fp-ashevkar/assets/152341739/fb3951a7-05d8-40e9-b03c-51a5b97ff8b4">

>Two Constraint Violations
<img width="1440" alt="5" src="https://github.com/itmd4515/itmd4515-s24-fp-ashevkar/assets/152341739/614306c2-a789-4f6b-9272-6bd558634a17">

>Three Constraint Violations
<img width="1440" alt="6" src="https://github.com/itmd4515/itmd4515-s24-fp-ashevkar/assets/152341739/75b514f8-d8fc-40b0-ba5c-392911763a64">


1. Your understanding of the difference between the forward and redirect operations.
The main difference between forward and redirect operations lies in how they handle the request-response cycle. A redirect initiates a completely new cycle, resulting in a loss of state from the original request. To preserve or transfer information during a redirect, additional mechanisms like query parameters or session management are needed. On the other hand, a forward operation passes control to another server-side resource without starting a new cycle. It retains the state in the request or response objects, ensuring data persistence throughout the forwarding process.


2. How would you be validating user submissions without the Bean Validation API
standard?
Without the Bean Validation API, I would implement custom validation logic tailored to the project's requirements. I’d create specific validation classes to address missing data, checking for null or empty strings. Additionally, I'd ensure proper validation for malformed data, verifying values are in the correct format.


3. How do you think this approach would scale to a real application with 100's of
entities?
For a large-scale application with hundreds of entities, a custom validation approach should prioritize modular and reusable design, efficiency optimization, parallel processing, and clear documentation. However, challenges may arise in scalability due to potential maintenance issues and code duplication. In contrast, the Bean Validation API provides a standardized and efficient solution, promoting code reusability and consistency, making it a more suitable choice for larger-scale applications.


4. Why didn't we need to include any additional dependencies (i.e. Bean Validation,
JDBC) in this project?1
In this project, Jakarta Enterprise 10 dependency is automatically included with a scope "provided”. The “provided” means the libraries that are underneath the Jakarta enterprise umbrella are now included as dependencies like Jakarta servlet, JSP, and JSTL, so all the dependencies are included in our project. The "provided" scope indicates that these dependencies are included in the project during compilation, development, and testing. Maven includes them in the artifact, but at runtime, they are supplied by the Payara server. As a result, there's no need to include additional dependencies, such as Bean Validation and JDBC, as they are bundled with the application and provided by the application server during runtime.

