package myUtilAula2;

import java.util.*;

public class MovieList extends ArrayList<Movie> {
    public Movie getMovieById(int id){
        for(Movie m : this){
            if(m.getId() == id){
                return m;
            }
        }
        return null;
    }
    public boolean getMovieAvailability(int id){
        for(Movie c : this){
            if(c.getId() == id){
                return true;
            }
        }
        return false;
    }
    public boolean addMovie(Movie movie){
        //if(this.contains(movie)) return false;
        this.add(movie);
        return true;
    }
    public String listMovies(){
        return listMovies("", "id");
    }
    public String listMovies(String filter, String sortBy){
        Collections.sort(this,(m1, m2)->{
            if(sortBy == "id"){
                if(m1.getId() > m2.getId()) return 1;
                if(m1.getId() < m2.getId()) return -1;
            }
            else if(sortBy == "rating"){
                if(m1.getAverageRating() < m2.getAverageRating()) return 1;
                if(m1.getAverageRating() > m2.getAverageRating()) return -1;
            }
                    return 0;
            }
        );
        String result = Movie.getHeader();
        for(Movie c: this){
            if(filter.equals("") || c.getCategory().equals(filter))
                result += c.toString() + "\n";
        }
        return result;
    }
}
