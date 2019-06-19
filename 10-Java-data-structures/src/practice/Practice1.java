package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;


public class Practice1 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("dsd");
		
		Set<String> set = new LinkedHashSet<String>();
		set.add("A");
		set.add("b");
		set.add("c");
		set.add("b");
		set.add("e");
		set.add("q");

		
		System.out.println(set);
		
		Map<Integer, String> map = new HashMap<>();
		map.put(123, "veg-biryani");
		map.put(125, "mut-biryani");
		map.put(126, "mut-biryani");

		map.put(124, "ch-biryani");
		map.put(124, "ch-biryani");
		map.put(512021, "ch-biryani");

		
		
		System.out.println(map);
		
		Set<Integer> keys = map.keySet();
		
		for(Integer key:keys)
		System.out.println(key+" "+map.get(key));
		
		
		
	}

}
