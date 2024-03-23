import java.util.ArrayList;

//here we are implementing JAVA OOPs Concepts mainly Four Pillars - Abstraction, Encapsulation, Inheritance & Polymorphism
//here we are creating abstract class just to implement abstraction. It is not necessary to use abstraction here.

abstract class Employee {
    //here we are making our data members as private so that there will not be any direct manipulation for it
    //this is an example for the implementation of encapsulation
    private String name;
    private int id;

    //this is a parameterized constructor where took name and id and assigned using this keyword
    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }
    //encapsulation is nothing but process of wrapping code(methods) and data(variables) together into a single unit
    //so by using encapsulation we wrapped the variables into methods
    //name and id are private variables and cannot be accessed outside this class
    //so, to get the values of the variables we have created method getName and getId
    public String getName() {
        return name;
    }

    //cannot access id but by using getId now we can access value of id anywhere since it is public
    public int getId() {
        return id;
    }
    //this is the abstract method
    //speciality of abstraction is that we just need to declare it and no need to implement here itself
    //so, wherever this abstract class is extended or inherited, there itself we need to implement it.
    //abstraction is nothing but hiding lower level details(implementation in my case)
    //and exposing only the essentials & relevant details(declare) to the user
    public abstract double calculateSalary();

    //toString is a function in collection framework which converts any values into String type
    //or generates the string value
    //we are using @Override to override the baseclass(toString) to produce the output like what we intend to.
    @Override
    public String toString() {
        //we want our Output as "Employee name id salary"
        return "Employee [name=" + name + ", id=" + id + ", salary=" + calculateSalary() + "] ";
    }

}
//Inheritance is a mechanism in which one Object acquires all the properties & behaviours of a Parent Object
//so, here we are inheriting the properties of Parent(Employee such as name,id) into a subclass(FullTimeEmployee)
//by using extend keyword because employee is a common resource and its property will be used for any kind of other employees.
//once extended the abstract class, an error will be occurred and abstract method need to be implemented to solve the error.
class FullTimeEmployee extends Employee {
    private double monthlySalary;
    private double bonus;

    //Parameterized Constructor is implemented
    public FullTimeEmployee(String name, int id, double monthlySalary, double bonus) {
        //super keyword is used to refer the parent class object(Employee is the parent)
        //and name and id values are assigned by this.
        //advantage  is that it increases code re-usability.
        super(name, id);
        //now we have to assign monthlySalary and bonus values using this keyword
        this.monthlySalary = monthlySalary;
        this.bonus = bonus;
    }

    //Polymorphism is nothing but perform a single action in different ways.
    //this is an example of Polymorphism where function name is same(calculateSalary) but actions are different
    //every employee has different salary structure but method name is same.
    @Override
    public double calculateSalary() {
        //returns salary after the operation performed(addition in this case)
        return monthlySalary + bonus;
    }
}
//Inheritance
class PartTimeEmployee extends Employee {
    //Encapsulation
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String name, int id, int hoursWorked, double hourlyRate) {
        super(name, id);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }
    //Polymorphism
    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }
}
class PayrollSystem {
    //We are using a ArrayList to store all the values into employeeList
    private ArrayList<Employee> employeeList;

    public PayrollSystem() {
        employeeList = new ArrayList<>();
    }

    //here we are adding new employee by using inbuilt add function
    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    //here we are removing current employee by using inbuilt remove function
    //in-order to remove we need id and a for loop
    //In case of ArrayList the best compatible for loop is For-Each Loop
    public String removeEmployee(int id) {
        String removeEmployeeInfo = null;
        for(Employee employee :  employeeList){
            if(employee.getId() == id) {
                removeEmployeeInfo = "Employee ID: " +employee.getId()+ ", Name: " +employee.getName();
                employeeList.remove(employee);
                break;
            }
        }
        return removeEmployeeInfo;
    }

    //here we are displaying all current employee in the list just by iterating through the employeeList
    public void displayEmployee() {
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }

}

public class Main {
    public static void main(String[] args) {

        PayrollSystem payrollSystem = new PayrollSystem();
        Employee emp1 = new FullTimeEmployee("vikas", 1, 50000, 10000);
        FullTimeEmployee emp2 = new FullTimeEmployee("Shivam", 2, 89000, 20000);
        Employee emp3 = new PartTimeEmployee("vishal", 3, 40, 100);

        payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(emp2);
        payrollSystem.addEmployee(emp3);

        System.out.println("--------Initial Employees Details--------");
        payrollSystem.displayEmployee();

        int idToRemove = 2;
        System.out.println("---------Removing Employees----------");
        String removedEmployeeInfo = payrollSystem.removeEmployee(idToRemove);
        if(removedEmployeeInfo != null){
            System.out.println("Removed Employee: " +removedEmployeeInfo);
        }
        else {
            System.out.println("Employee with ID " +idToRemove+ "not found.");
        }

        System.out.println("-------Remaining Employee Details---------");
        payrollSystem.displayEmployee();
    }
}