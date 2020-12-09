package eu.fade.mswarehousemanagement.domain;

public class EmployeePerFunction {

    private Function function;
    private long NumberOfEmployees;

    public EmployeePerFunction(final Function function, final long numberOfEmployees) {
        this.function = function;
        NumberOfEmployees = numberOfEmployees;
    }

    public Function getFunction() {
        return function;
    }

    public void setFunction(final Function function) {
        this.function = function;
    }

    public long getNumberOfEmployees() {
        return NumberOfEmployees;
    }

    public void setNumberOfEmployees(final long numberOfEmployees) {
        NumberOfEmployees = numberOfEmployees;
    }

    @Override
    public String toString() {
        return "EmployeePerFunction{" +
                "function=" + function +
                ", NumberOfEmployees=" + NumberOfEmployees +
                '}';
    }
}
