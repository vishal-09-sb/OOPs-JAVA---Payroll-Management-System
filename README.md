**ReadMe - Employee Payroll System**

**Overview:**
This Java application demonstrates the implementation of a simple Employee Payroll System using Object-Oriented Programming (OOP) principles, focusing on the four pillars: Abstraction, Encapsulation, Inheritance, and Polymorphism.

**1. Abstraction:**
Abstraction is achieved through the creation of an abstract class `Employee`. It provides a blueprint for other employee types, such as `FullTimeEmployee` and `PartTimeEmployee`. The abstract method `calculateSalary()` is declared in the `Employee` class, which must be implemented by its subclasses.

**2. Encapsulation:**
Encapsulation is demonstrated by making the data members (`name` and `id`) private in the `Employee` class. Access to these variables is controlled through getter methods (`getName()` and `getId()`), ensuring no direct manipulation of data outside the class.

**3. Inheritance:**
Inheritance is utilized to inherit the common properties of an `Employee` (such as `name` and `id`) into its subclasses (`FullTimeEmployee` and `PartTimeEmployee`). This promotes code reuse and maintains a hierarchical structure.

**4. Polymorphism:**
Polymorphism is showcased through method overriding. The `calculateSalary()` method is overridden in both `FullTimeEmployee` and `PartTimeEmployee` classes, allowing different implementations of salary calculation based on employee types.

**Functionality:**
- The `PayrollSystem` class manages a list of employees using an `ArrayList`.
- Employees can be added to the system using the `addEmployee()` method.
- Employees can be removed based on their ID using the `removeEmployee()` method, which returns information about the removed employee (ID and name).
- Employee details can be displayed using the `displayEmployee()` method.

**Usage:**
- Instantiate a `PayrollSystem` object.
- Create instances of `Employee` subclasses (`FullTimeEmployee` or `PartTimeEmployee`).
- Add employees to the system using the `addEmployee()` method.
- Display initial employee details using the `displayEmployee()` method.
- Specify an employee ID to remove using the `removeEmployee()` method.
- Display remaining employee details after removal.


**Conclusion:**
This Employee Payroll System serves as a demonstration of fundamental OOP concepts in Java. It can be further extended and enhanced to accommodate additional functionalities and requirements in real-world scenarios.
