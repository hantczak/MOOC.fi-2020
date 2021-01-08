public class Film {
    private String name;
    private int ageRating;

    public Film(String filmName,int filmRating){
        this.name = filmName;
        this.ageRating = filmRating;
    }

    public String name(){
        return name;
    }

    public int ageRating(){
        return ageRating;
    }
}
