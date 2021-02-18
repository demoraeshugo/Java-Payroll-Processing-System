public class Employee {
    private final Profile profile;

    Employee( String name, String department, Date dateHired ) {

        profile = new Profile(name, department, dateHired);
    }

    @Override
    public String toString() {
        return (this.profile.getName() +"::"+ this.profile.getDepartment() + "::" + this.profile.getDateHired()+
                "::Payment " +"replace later w payment") ;
    }
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }


        if (!(o instanceof Employee)) {
            return false;
        }

        // typecast o to Employee so that we can compare data members
        Employee e = (Employee) o;

        // Compare the data members and return accordingly
        if ( this.profile.equals(e.profile))
        {
        return true;                // two employees are equal only if their profiles are
        }
        else {
            return false;
        }
    }

    public void calculatePayment() { }
}
