/*
Define the profile of an employee with the following. You cannot add additional instance
variables and must include toString() and equals() methods.
 */

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
     * @param dateHired date of hire of emplyoee
     */
    Profile(String name, String department, Date dateHired) {
        this.name = name;
        this.department = department;
        this.dateHired = dateHired;
    }

    /**
     * Overriden toString method returns string representation of Profile
     * @return string containing a profiles, name, department and date hired.
     */
    @Override
    public String toString() {
        return (this.name +" " +this.department + " " + this.dateHired);
    }

    /**
     * Overriden equals method compares two Profiles and determines if they are equal
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

        if ( this.name.equals(p.name) &&
                this.department.equals(p.department) &&
                this.dateHired.compareTo(p.dateHired) == 0 )
        {
            return true;                // two profiles are equal only if their name, department and hireDates are equal
        }
        else {
            return false;
        }
    } //compare name, department and dateHired

    /**
     * getter method for name of Profile
     * @return name of Profile
     */
    public String getName() {
        return this.name;
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