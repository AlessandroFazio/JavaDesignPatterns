package github.alessandrofazio.design.patter.memento.exercise.exercise2;

import github.alessandrofazio.design.patter.memento.exercise.exercise1.Memento;

import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public class Employee {
    private int balance;
    private int salary;
    private Position position;

    public Memento createMemento() {
        return new EmployeeMemento(this);
    }

    public void setMemento(Memento memento) {
        EmployeeMemento employeeMemento = (EmployeeMemento) memento;
        if(this != employeeMemento.employeeRef.get()) {
            throw new IllegalArgumentException();
        }
        this.balance = employeeMemento.balance;
        this.position = employeeMemento.position;
        this.salary = employeeMemento.salary;
    }

    enum Position {
        TESTER, PROGRAMMER, MANAGER
    }

    public Object writeReplace() {
        return createMemento();
    }

    private static class EmployeeMemento implements Memento, Serializable {
        private final int balance;
        private final int salary;
        private final Position position;
        private final Reference<Employee> employeeRef;

        public EmployeeMemento(Employee employee) {
            this.balance = employee.balance;
            this.salary = employee.salary;
            this.position = employee.position;
            this.employeeRef = new WeakReference<>(employee);
        }

        private Object readResolve() {
            Employee employee = new Employee();
            employee.setMemento(this);
            return employee;
        }
    }
}
