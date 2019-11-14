package myUtilAula2;

public class Movie {
    public enum AgeRating {
        ALL, M6, M12, M16, M18
    }
    private int id, totalRating, ratingCount;
    private String title, category;
    private AgeRating ageRating;
    private static int idCount = 1;

    public Movie(String title, String category, AgeRating ageRating) {
        this.id = idCount;
        this.title = title;
        this.category = category;
        this.ageRating = ageRating;
        idCount++;
    }

    public boolean rate(int rating){
        if(rating < 1 || 10 < rating) return false;
        ratingCount++;
        totalRating += rating;
        return true;
    }

    public static String getHeader(){
        return  "|-----|----------|-----|-----------|--------|\n"+
                "|   id|     Title| Rate|   Category| min Age|\n"+
                "|-----|----------|-----|-----------|--------|\n";
    }

    @Override
    public String toString() {
        return String.format("|%5.5s|%10.10s|%5.5s|%11.11s|%8.8s|",
                id,
                title,
                this.getAverageRating(),
                category,ageRating.name()
        );
    }

    public double getAverageRating() {
        return (double)totalRating/(double)ratingCount;
    }

    public int getTotalRating() {
        return totalRating;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public AgeRating getAgeRating() {
        return ageRating;
    }
}
