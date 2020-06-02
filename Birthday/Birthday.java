import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class Birthday {

	
	public void BirthdayParadox(List<Integer> list) {
		int count=1;
		int initial=((list.get(1)*list.get(4)*list.get(4))+(list.get(2)*list.get(4))+list.get(3))%list.get(0);
		Integer mark=(int)(Math.ceil(Math.sqrt(2*Double.valueOf(list.get(0)))));
		List<Integer> hs=new ArrayList<Integer>();
		int temp=initial;
		int A=list.get(1),B=list.get(2),C=list.get(3);
		hs.add(temp);
		while(true) {
			count++;
			temp=((A*temp*temp)+(B*temp)+C)%list.get(0);
			
			if(hs.contains(temp)) {
				break;
			}
		
			hs.add(temp);
			
		}
		
		if(hs.indexOf(temp)==0) {
		System.out.print(list.get(0)+" "+A+" "+B+" "+C+" "+list.get(4)+" ");
		System.out.print((hs.indexOf(temp))+" "+(hs.size()-(hs.indexOf(temp)))+" "+mark+"\n");
		}
		else {
			System.out.print(list.get(0)+" "+A+" "+B+" "+C+" "+list.get(4)+" ");
			System.out.print((hs.indexOf(temp)+1)+" "+(hs.size()-(hs.indexOf(temp)))+" "+mark+"\n");
		}
	}
	

	
	 public List<Integer> WritePath(String line ){ 
	        String[] str=line.split(" ");
	        List<Integer> list=new ArrayList<>();
	        for(int i=0;i<str.length;i++) {
	            list.add(Integer.valueOf(str[i]));
	        }
	     return list;
	     }
	
	public static void main(String args[]) {
		Birthday bd=new Birthday();
		try {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   
	        String line;
	        line = br.readLine();
	        while(line!=null) {
	            List<Integer> list=bd.WritePath(line);
	            bd.BirthdayParadox(list);
	            line = br.readLine();
 	        }
	        br.close();
	    	}
	    	catch(Exception e) {
	    		System.out.println(e);
	    	}
	}
}
