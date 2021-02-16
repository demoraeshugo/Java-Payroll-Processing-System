public class Profile {
    private String name; //employee’s name in the form “lastname,firstname”
    private String department; //department code: CS, ECE, IT
    private Date dateHired;

    Profile(String name, String department, Date dateHired) {
        this.name = name;
        this.department = department;
        this.dateHired = dateHired;
    }

    @Override
    public String toString() {
        return "";
    }
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

    public String getName() {
        return this.name;
    }
    public String getDepartment(){
        return this.department;
    }

    public Date getDateHired(){
        return this.getDateHired();
    }
}