/*
DO NOT MODIFY THE CODE STUB
NO NEED TO DEFINE main()
*/

import java.util.*;

class StreamingApp
{
	public static Map<String, ArrayList<String> > getFavouriteGenres(Map<String, ArrayList<String> > userMovies, Map<String, ArrayList<String> > movieGenres)
	{
		
		// WRITE YOUR CODE HERE
	    Map<String, String> movieMap = new HashMap<String, String>();
	    for (Map.Entry<String, ArrayList<String>> genre: movieGenres.entrySet())
		for (String movie : genre.getValue())
		    movieMap.put(movie, genre.getKey());
	}
}
