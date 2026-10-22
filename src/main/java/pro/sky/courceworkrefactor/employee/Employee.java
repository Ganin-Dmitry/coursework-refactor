package pro.sky.courceworkrefactor.employee;

public class Employee {
    private String firstName;
    private String lastName;

    public Employee (String firstName, String lastName) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    public String getFirstName () {
        return this.firstName;
    }

    public String getLastName () {
        return this.lastName;
    }

    public void setFirstName (String firstName) {
        this.firstName = firstName;
    }

    public void setLastName (String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString () {
        return this.getFirstName() + " " + this.getLastName();
    }

    @Override
    public int hashCode () {
        return java.util.Objects.hash(this.toString());
    }

    public boolean equals (Employee employee) {
        if (this.hashCode()!=employee.hashCode()) {
            return false;
        }
        return this.toString().equals(employee.toString());
    }
}
