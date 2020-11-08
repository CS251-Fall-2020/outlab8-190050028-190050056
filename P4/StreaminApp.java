/*
DO NOT MODIFY THE CODE STUB
NO NEED TO DEFINE main()
*/

import java.util.*;
class StreaminApp
{
	public static Map<String, ArrayList<String> > getFavouriteGenres(Map<String, ArrayList<String> > userMovies, Map<String, ArrayList<String> > movieGenres){
		Map<String, ArrayList<String>> ans=new HashMap<>();
		for (Map.Entry<String,ArrayList<String>> entry: userMovies.entrySet()){
			String name=entry.getKey();
			ArrayList<String> Arr=entry.getValue();
			List<String> Arr2=Arr.stream().map(movie->movieGenres.entrySet().stream().filter(etr->etr.getValue().contains(movie)).map(Map.Entry::getKey).findFirst().get()).collect(java.util.stream.Collectors.toList());
			// System.out.println(Arr2);
			int maxfreq=0;
			for(String s: Arr2){
				int freq=Collections.frequency(Arr2,s);
				if(freq>maxfreq) maxfreq=freq;
			}
			ArrayList<String> Arr3=new ArrayList<String>();
			for(String g: Arr2){
				if(Collections.frequency(Arr2,g)==maxfreq && !Arr3.contains(g)){
					Arr3.add(g);
				}
			}
			ans.put(name, Arr3);
		}
		return ans;
	}
}
