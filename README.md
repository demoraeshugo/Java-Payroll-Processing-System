# Java-Payroll-Processing-System

## Project Description

In this project, you will develop a Payroll Processing System to process the payments to the employees in a company.
For simplicity, the system will not process the possible deduction items in the paychecks.Your project shall processthe command lines entered on the console and display the output on the console. The command lines include the instructions for adding/removing an employee, calculating the payments, printing the earning statements, and managing the working hours of the part time employees.

Let’s assume the system maintains an employee database, which may include 3 different types of employees: full time,
part time and management. Note that an employee with a management role is also a full-time employee. You are required
to implement an array-based container class to hold the employee database. Every employee in the database has a profile,
including the employee’s name, department and the date hired, assuming there are 3 departments in the company:
“computer science”, “electrical and computer engineering” and “information technology”. The payroll is processed every
other week. Calculation of the payments are different depending on an employee’s employment type.

## Documentation

### Supported Commands

| Command | Description | Example
| --- | --- | --- |
| AP | Add a new Parttime level Employee to the system | AP Doe,Jane CS 7/1/2020 45.9 |
| AF | Add a new Fulltime level Employee to the system | AF Doe,Jane CS 1/1/2005 85000 |
| AM | Add a new Manament level Employee to the system | AM Doe,Jane CS 2/28/2012 85000 1 |
| R | Remove the employee with the matching profile | R Doe,Jane CS 7/1/2020 |
| C | Calculate payment for all employees | C |
| S | Set the hours of the given Parttime employee | S Doe,Jane IT 7/1/2020 77 |
| PA | Print all Employees in the system | PA |
| PH | Print all Employees in the system by hire-date | PH |
| PD | Print all Employees in the system by department type | PD |
| Q | Quit out of the program | Q |
| RF | Run commands from file | RF |
| N | Create a new Company, discards all previously entered data | N |

### Javadoc

<a href="https://demoraeshugo.github.io/Java-Payroll-Processing-System/payroll_processing_system/package-summary.html"> Hosted on Github Pages 🚀  </a>

## UML Diagram

![Web_Frame@2x](https://raw.githubusercontent.com/demoraeshugo/Java-Payroll-Processing-System/main/payroll_processing_system.png?token=AKZ6UIYTCYH33IV32J7KNXTAH27VY)
