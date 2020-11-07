import java.util.*;

public class StreamTest {
    public static void main(String[] args) {
		Map<String, ArrayList<String>> userMovies = new HashMap<String, ArrayList<String>>();
		Map<String, ArrayList<String>> movieGenres = new HashMap<String, ArrayList<String>>();
		userMovies.put("David", new ArrayList<String>() {{
		    add("The Conjuring");
		    add("Shoah");
		    add("The Purge");
		    add("13th");
		    add("The Dictator");
		}});
		userMovies.put("Emma", new ArrayList<String>() {{
		    add("The Matrix");
		    add("Captain America: Civil War");
		    add("John Wick");
		}});
		movieGenres.put("Horror", new ArrayList<String>() {{
		    add("The Conjuring");
		    add("The Purge");
		}});
		movieGenres.put("Action", new ArrayList<String>() {{
		    add("John Wick");
		}});
		movieGenres.put("Comedy", new ArrayList<String>() {{
		    add("The Dictator");
		}});
		movieGenres.put("Documentary", new ArrayList<String>() {{
		    add("Shoah");
		    add("13th");
		}});
		movieGenres.put("Science Fiction", new ArrayList<String>() {{
		    add("The Matrix");
		    add("Captain America: Civil War");
		}});
		Map<String, ArrayList<String>> result = StreaminApp.getFavouriteGenres(userMovies, movieGenres);
		for (Map.Entry e : result.entrySet()) {
			System.out.printf("%s:", e.getKey());
			ArrayList<String> arr = (ArrayList<String>) e.getValue();
			for (String s : arr)
				System.out.printf(" %s", s);
			System.out.printf("\n");
		}
    }
}
