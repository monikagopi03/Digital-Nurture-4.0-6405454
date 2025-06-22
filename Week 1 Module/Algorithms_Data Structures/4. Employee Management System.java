

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
}