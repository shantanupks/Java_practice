package salary;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Salary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<String> set = new HashSet<String>();  
		HashSet<String> set2 = new HashSet<String>();          

        String[] records = {
            "E1,IT,1000",
            "E2,HR,1000",
            "E3,IT,2000",
            "E4,SALES,4000"

        };
        
        
        
        
        for(String record:records)
        {
            String[] tokens = record.split(",");
            String dep = tokens[1];
            
            set2.add(dep);

        }
        
        int size = set2.size();
        double total[] = new double[size];

        
        for(String record:records)
        {
            String[] tokens = record.split(",");
            String dep = tokens[1];
            String S = tokens[2];
            double salary = Double.parseDouble(S);
            
                        
            
            if(set.isEmpty()) {
            	set.add(dep);
            }
            
            else {
            
            
           if(set.contains(dep))
           {
        	   int i = new ArrayList<>(set).indexOf(dep);
        	   total[i] = total[i] + salary;        
           }
           else {
               set.add(dep);
           }

        }

            
        }

        
        
        
       
       Iterator<String> it = set.iterator();

		while (it.hasNext()) {

			System.out.println(it.next() + "salary:");
		}
        
        
        
        
  

	}
        

}
