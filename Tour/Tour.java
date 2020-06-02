import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;

public class Tour {
    
	LinkedHashMap<Integer,List<Float>> hmap=new LinkedHashMap<>(); 
    int count=0;
    
    public List<Integer> ShortestPath(HashSet<Integer> hset,List<Integer> result){

    	if(hset.size()<hmap.size()) {
    		if(hset.size()<hmap.size()-1) {
    			Integer Planet=getNearestPlanet(hset,hmap.get(result.get(result.size()-1)));
    			result.add(Planet);
    			hset.add(Planet);
    			ShortestPath(hset,result);
    		}
    		else {
    			hset.remove(hmap.size());
    		for(Integer a:hmap.keySet()) {
    			if(hset.contains(a)) {
    				continue;
    				}
    			result.add(a);
    			hset.add(a);
    			}
    		}
    		
    	}
    	
    	
    	return result;
    }
    
    public Integer getNearestPlanet(HashSet<Integer> hset,List<Float> cordinates) {
    	Float min=Float.MAX_VALUE;
    	Integer Nearest_Planet=Integer.MAX_VALUE;
    	for(Integer a:hmap.keySet()) {
			if(hset.contains(a)) {
				continue;
				}
			List<Float> list=hmap.get(a);
			Float temp=0F;
			for(int i=0;i<5;i++) {
				temp=temp+(cordinates.get(i)-list.get(i))*(cordinates.get(i)-list.get(i));
			}
			if(temp<min) {
				min=temp;
				Nearest_Planet=a;
			}
			}
    	return Nearest_Planet;
    }

    public void WritePath(String line ){ 
        String[] str=line.split(" ");
        List<Float> list=new ArrayList<>();
        for(int i=0;i<str.length;i++) {
            list.add(Float.valueOf(str[i]));
        }
        this.count++;
        hmap.put(count,list);
     
     }
    
    public static void main(String args[]) {
        Tour t=new Tour();
       
        
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
            String line=null;
            Integer count=null;
          Integer instance=0;
            while((line = br.readLine())!=null) {
                if(line.length()<=2&&line.length()>0) {count=Integer.valueOf(line);}
                else {
                    
                        count--;
                        t.WritePath(line);
                        
                    if(count==0) {
                    	instance++;
                    	HashSet<Integer> hset=new HashSet<>();
                    	hset.add(1);
                    	hset.add(t.hmap.size());
                    	List<Integer> result=new ArrayList<>();
                    	result.add(1);
                    	result=t.ShortestPath(hset,result);
                    	System.out.print("Instance "+instance+": ");
                    	for(int i=0;i<result.size();i++) {
                    		System.out.print(" ");
                    		System.out.print(result.get(i));
                    	}
                    	System.out.println();
                    	
                    	
                    	
                    	t.hmap.clear();
                    	t.count=0;
                    }
               }
      
                 
            }
            
            br.close();
           
            }
            catch(Exception e) {
                System.out.println(e);
            }
    }
}

