public class Parttime extends Employee{
    private float hourlyRate;
    private int hours;

    Parttime(String name, String department, Date dateHired, float hourlyRate) {
        super(name, department, dateHired);
        this.hourlyRate = hourlyRate;
    }

    Parttime(String name, String department, Date dateHired, int hours) {
        super(name, department, dateHired);
        this.hours = hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getHours() {
        return hours;
    }

    @Override
    public String toString() {
        return super.toString() + "PART TIME" + this.hourlyRate + "Hours worked this period: " + this.hours ; }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }


        if (!(obj instanceof Parttime)) {
            return false;
        }

        // typecast f to Fulltime so that we can compare data members
        Parttime p = (Parttime) obj;
        if(super.equals(p) &&
                this.hourlyRate == p.hourlyRate &&
                this.hours == p.hours){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public void calculatePayment() {

    }
}
