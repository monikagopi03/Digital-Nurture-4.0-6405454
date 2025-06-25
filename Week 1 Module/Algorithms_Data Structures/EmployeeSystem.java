class Employee {
    int employeeId;
    String name;
    String position;
    double salary;

    Employee(int id, String name, String pos, double salary) {
        this.employeeId = id;
        this.name = name;
        this.position = pos;
        this.salary = salary;
    }
}

class EmployeeSystem {
    Employee[] employees = new Employee[100];
    int count = 0;

    void addEmployee(Employee e) {
        employees[count++] = e;
    }

    Employee searchEmployee(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) return employees[i];
        }
        return null;
    }

    void traverse() {
        for (int i = 0; i < count; i++)
            System.out.println(employees[i].name + " - " + employees[i].position);
    }

    void deleteEmployee(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                employees[i] = employees[count - 1];
                count--;
                return;
            }
        }
    }

    public static void main(String[] args) {
        EmployeeSystem system = new EmployeeSystem();

        system.addEmployee(new Employee(101, "Alice", "Manager", 50000));
        system.addEmployee(new Employee(102, "Bob", "Developer", 40000));
        system.addEmployee(new Employee(103, "Charlie", "Designer", 35000));

        System.out.println("All Employees:");
        system.traverse();

        System.out.println("\nSearching for Employee with ID 102:");
        Employee e = system.searchEmployee(102);
        if (e != null)
            System.out.println(e.name + " - " + e.position);
        else
            System.out.println("Employee not found.");

        System.out.println("\nDeleting Employee with ID 102...");
        system.deleteEmployee(102);

        System.out.println("\nAll Employees after deletion:");
        system.traverse();
    }
}
