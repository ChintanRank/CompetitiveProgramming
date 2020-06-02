import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class RelativeNeighbor {
	 List<List<Integer>> points=new ArrayList<>();  //list storing the raw input of points
	 
	//Finding the relative neighbors  
	public List<List<Integer>> FindNeighbor() {
		List<HashMap<Integer,Integer>> distances=new ArrayList<>();  //used for stroing distances from every point to everu other point
		
		//Getting distances of each point with respect to each other
		for(int i=0;i<points.size();i++) {
			HashMap<Integer,Integer> hmap=new HashMap<>();
			for(int j=0;j<points.size();j++) {
				if(i==j) {continue;}
				
			 Integer A=(points.get(i).get(0)-points.get(j).get(0))*(points.get(i).get(0)-points.get(j).get(0));
			 Integer B=(points.get(i).get(1)-points.get(j).get(1))*(points.get(i).get(1)-points.get(j).get(1));
			 Integer result=A+B;
			 hmap.put(j,result);
			}
			distances.add(hmap);
		}
		
		List<List<Integer>> result=new ArrayList<>();
		
		//Iterating through each point w.r.t. for getting list of relative points 
		for(int k=0;k<points.size();k++) {
			List<Integer> temp=new ArrayList<>();
			
			for(int l=k+1;l<points.size();l++) {	
				boolean flag=true;
				Integer distance=distances.get(k).get(l);
				HashMap<Integer,Integer> h=distances.get(k);
			
				for(Integer d:h.keySet()) {
					if(d==l) {
						continue;
					}
					if(h.get(d)<distance){
					  if(distances.get(d).get(l)<distance) {
						flag=false;
						break;}
					}
					}
				
				if(flag==true) {temp.add(l);}
			}
		
			result.add(temp);
		}
		
		return result;
	}
	

	//Creating a list of points with 
	 public void WritePath(String line ){ 
	        String[] str=line.split(" ");
	        List<Integer> list=new ArrayList<>();
	       
	        for(int i=0;i<str.length;i++) {
	            list.add(Integer.valueOf(str[i]));
	        }
	        points.add(list);
	     
	     }
	
	 
	public static void main(String args[]) {
		
		RelativeNeighbor rn=new RelativeNeighbor();
		try {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   
	        String line;
	        Integer count=null;  //for keeping the ocunt of the lines from the input
            Integer instance=0;  //for writing the sample number in output
	        while((line = br.readLine())!=null) {
	        	if(line.contains("SAMPLE")) {continue;}
	        	
	        	if(line.length()<=2&&line.length()>0) {count=Integer.valueOf(line);}
                else {
                    
                        count--;
                        rn.WritePath(line);
                        
                    if(count==0) {
                    	instance++;
                    	List<List<Integer>> list=new ArrayList<>();
                    	list=rn.FindNeighbor();
                    	System.out.println("-- SAMPLE "+instance+" --");
                    	for(int i=0;i<list.size();i++) {
                    		List<Integer> temp=list.get(i);
                    		for(int j=0;j<temp.size();j++) {
                    			System.out.println((i+1)+" "+(temp.get(j)+1));
                    		}
                    	}
                    	System.out.println("*");
                    	rn.points.clear();
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
