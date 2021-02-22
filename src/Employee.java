import java.text.DecimalFormat;

public class Employee {
    private final Profile profile;
    private double payment;
    static DecimalFormat formatter = new DecimalFormat("#,###,##0.00");

    Employee( String name, String department, Date dateHired ) {
        profile = new Profile(name, department, dateHired);
    }

    @Override
    public String toString() {
        return profile.toString();
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
        if (profile.equals(e.profile)) {
            // two employees are equal only if their profiles are
            return true;
        } else {
            return false;
        }
    }

    public Profile getProfile(){
        return this.profile;
    }

    public void calculatePayment() { }

    public void setPayment(double amount) {
        payment = amount;
    }

    public void addPayment(double amount) {
        payment += amount;
    }

    public String getFormattedPayment() {
        return formatter.format(payment);
    }
}
