import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

public class PalindromeSentences {
	List<String> list=new ArrayList<>();

	List<HashMap<Integer,List<String>>> main=new ArrayList<>();
	
//iterating through the main root	
public void match() {


		HashMap<Integer,List<String>> string;
		List<String> left;
		List<String> right;
		for(String s:list) {
			HashSet<String> hash=new HashSet<>();
			hash.add(s);
			string=new HashMap<>();
			left=new ArrayList<>();
			right=new ArrayList<>();
			string.put(0, left);
			string.put(1, right);
		 String temp=FindByFirst(s.charAt(0),hash);
		 if(temp!=null) {
			 //System.out.println(right);
			 hash.add(s);
			 hash.add(temp);
			 main.add(string);
			 CheckMore(s,temp,string,hash,0,temp.length()-1);
		 }
		 
		}
		

		String result="";
		
		for(HashMap<Integer,List<String>> obj:main) {
			String strleft="";
			String strright="";
			List<String> s=obj.get(0);
			for(String str:s) {
				strleft=strleft+" "+str;
			}
			s=obj.get(1);
			for(String str:s) {
				strright=str+" "+strright;
			}
			String temp=strleft+" "+strright;
			if(result.length()<temp.length()) {
				result=temp;
		
			}
			
			
		}
		
		System.out.println(result);
	
	}
	
	
//finding more possibilities for the given matches
public void CheckMore(String sl,String sr,HashMap<Integer,List<String>> str,HashSet<String> hash,int l,int r) {
	char[] left=sl.toCharArray();
	char[] right=sr.toCharArray();
	boolean flag=true;
	int left_index=l;
	int right_index=r;
	
	while(left_index<left.length&&right_index>=0) {
		
		if(left[left_index]==right[right_index]) {
			left_index++;
			right_index-- ;
			continue;
		}
		else {
			flag=false;
			break;
			}
		
	}

	
	if(flag==true) {
		
		if(left_index==left.length||(left_index==left.length-1&&right_index<0)) {
			List<String> temp=str.get(0);
			if(!temp.contains(sl)) {
				temp.add(sl);
			}
			if(right_index>=0) {
			 String tempstr=FindByLast(sr.charAt(right_index),hash);
			 if(tempstr!=null) {
				  CheckMore(tempstr,sr,str,hash,0,right_index);
			 }
			 
			}
			
		}
		
		if(right_index<0||(right_index==0&&left_index==left.length)) {
			List<String> temp=str.get(1);
			if(!temp.contains(sr)) {
				temp.add(sr);
			}
			if(left_index<left.length) {
			  String tempstr=FindByFirst(sl.charAt(left_index),hash);
			 if(tempstr!=null) {
				  CheckMore(sl,tempstr,str,hash,left_index,tempstr.length()-1);
			 }}
		}
		
		
	}
	
}


//finding the related  string starting with desired letter
public String FindByFirst(char ref,HashSet<String> hs){
		String result=null;
		for(String s:list) {
			if(hs.contains(s)) {
				continue;
				}	
			char temp=s.charAt(s.length()-1);
			if(temp==ref) {
				hs.add(s);
				result=s;
				break;
			}
		}     

		return result;
		
	} 
	

//finding by the last character 
public String FindByLast(char ref,HashSet<String> hs) {
	String result=null;
	for(String s:list) {
		if(hs.contains(s)) {
			continue;
			}	
		char temp=s.charAt(0);
		if(temp==ref) {
			hs.add(s);
			result=s;
			break;
		}
	}     

	return result; 
}
	

public  void list(String line) {
		list.add(line);
	}



public static void main(String args[]) {
	    
		PalindromeSentences os=null;
				
		
//		os.list.add("an");
//		os.list.add("bann");
//		os.list("nab");
//		os.list.add("fap");
//		os.list.add("code");
//		os.list.add("coder'");
//		os.list.add("contest");
//		os.list.add("fast");
//		os.list.add("gnu");
//		os.list.add("problem");
//		os.list.add("redo");
//		os.list.add("reverse");
//		os.list.add("rung");
		
	
    if(args.length>0){
		try {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   boolean flag=true;
	        String line;
	        os=new PalindromeSentences();
	        while((line = br.readLine())!=null) {
	        	
	            if(line.isEmpty()) {
	            	flag=false;
	            	os.match();
	        	}
	            else {
	            	flag=true;
		            os.list(line);
	            }
	            
	        }
	        
	        if(flag==true) {
	        os.match();
	        }
	        br.close();
	    	}
	    	catch(Exception e) {
	    		System.out.println(e);
	    	}
		
	}
}
}
