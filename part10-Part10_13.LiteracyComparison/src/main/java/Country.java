public class Country implements Comparable<Country> {
    private String countryName;
    private String gender;
    private int year;
    private double percent;

    public Country(String countryName, String gender, int year, double percent) {
        this.countryName = countryName;
        this.gender = gender;
        this.year = year;
        this.percent = percent;
    }

    public double getPercent() {
        return this.percent;
    }

    public int compareTo(Country country) {
        if (this.getPercent() < country.getPercent()) {
            return -1;
        } else if (this.getPercent() > country.getPercent()) {
            return 1;
        } else if (this.getPercent() == country.getPercent()) {
            return 0;
        }
        return -99;
    }

    public String toString(){
        return this.countryName + " (" + this.year + "), " +this.gender + ", " + this.percent;
    }
}
