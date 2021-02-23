/**
 * Defines the profile of an employee with a name, department, and dateHired. A profile is unique to each employee
 */
public class Profile {
    private String name; //employee’s name in the form “lastname,firstname”
    private String department; //department code: CS, ECE, IT
    private Date dateHired;

    /**
     * constructor for Profile object, creates Profile with given name, department and date of hire
     * @param name name of employee
     * @param department department of employee
     * @param dateHired date of hire of employee
     */
    Profile(String name, String department, Date dateHired) {
        this.name = name;
        this.department = department;
        this.dateHired = dateHired;
    }

    @Override
    public String toString() {
        return String.format(IoFields.EMPLOYEE_STRING, name, department, dateHired);
    }

    /**
     * Overridden equals method compares two Profiles and determines if they are equal
     * @param obj Profile object to be evaluated for equality
     * @return true if the name, department ,and date of Hire of two Profiles are equal
     */
    @Override
    public boolean equals(Object obj) {

        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Profile)) {
            return false;
        }

        // typecast o to Employee so that we can compare data members
        Profile p = (Profile) obj;

        // two profiles are equal only if their name, department and hireDates are equal
        return this.name.equals(p.name) &&
                this.department.equals(p.department) &&
                this.dateHired.compareTo(p.dateHired) == 0;
    }

    /**
     * getter method for department of Profile
     * @return department of Profile
     */
    public String getDepartment(){
        return this.department;
    }

    /**
     * getter method for dateHired of Profile
     * @return date of hire
     */
    public Date getDateHired(){
        return dateHired;
    }
}