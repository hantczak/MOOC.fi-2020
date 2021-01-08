
public class SimpleDate {

    private int day;
    private int month;
    private int year;

    public SimpleDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public SimpleDate (SimpleDate date){
        this.day = date.day;
        this.month = date.month;
        this.year = date.year;
    }

    public void advance() {
        this.advance(1);
    }

    public SimpleDate afterNumberOfDays(int days){
        SimpleDate newDate = new SimpleDate(this.day,this.month,this.year);
        newDate.advance(days);
        return newDate;
    }


    public void advance(int howManyDays) {
        this.day += howManyDays;

        if (day > 30) {
            this.day = (day-30);
            this.month += 1;
            if (this.month > 12) {
                this.month = 1;
                this.year += 1;
            }
        }
    }

    @Override
    public String toString() {
        return this.day + "." + this.month + "." + this.year;
    }

    public boolean before(SimpleDate compared) {
        if (this.year < compared.year) {
            return true;
        }

        if (this.year == compared.year && this.month < compared.month) {
            return true;
        }

        if (this.year == compared.year && this.month == compared.month &&
                this.day < compared.day) {
            return true;
        }

        return false;
    }

}
