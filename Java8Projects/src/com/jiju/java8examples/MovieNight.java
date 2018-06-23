package com.jiju.java8examples;

import java.util.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class MovieNight {
    public static Boolean canViewAll(Collection<Movie> movies) {
        //throw new UnsupportedOperationException("Waiting to be implemented.");
    	boolean canView= false;
    	
		for (Movie movie: movies){
			
			canView = isSameDate(movie.getStart(), movie.getEnd());
		}
		return canView;
    }

    public static void main(String[] args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("y-M-d H:m");

        ArrayList<Movie> movies = new ArrayList<Movie>();
        movies.add(new Movie(sdf.parse("2015-01-01 20:00"), sdf.parse("2015-01-01 21:30")));
        movies.add(new Movie(sdf.parse("2015-01-01 21:30"), sdf.parse("2015-01-01 23:00")));
        movies.add(new Movie(sdf.parse("2015-01-01 23:10"), sdf.parse("2015-01-01 23:30")));

        System.out.println(MovieNight.canViewAll(movies));		
    }
    
    public static boolean isSameDate(Timestamp date1, Timestamp date2) {
        return date1.compareTo(date2) == 0;
    }
}


class Movie {
    private Date start, end;
    
    public Movie(Date start, Date end) {
        this.start = start;
        this.end = end;
    }
    
    public Date getStart() {
        return this.start;
    }
    
    public Date getEnd() {
        return this.end;
    } 
}
