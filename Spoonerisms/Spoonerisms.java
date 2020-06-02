import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Spoonerisms {

	public String GenerateSpoonersim(String line) {
		HashSet<Character> hs=new HashSet<Character>();
		hs.add('e');
		hs.add('a');
		hs.add('i');
		hs.add('o');
		hs.add('u');
		String[] arr=line.split(" ");
		String temp1="";

		if(!hs.contains(arr[0].charAt(0))&&!hs.contains(arr[arr.length-1].charAt(0))) {
			temp1=String.valueOf(arr[arr.length-1].charAt(0));
			arr[arr.length-1]=String.valueOf(arr[0].charAt(0))+arr[arr.length-1].substring(1,arr[arr.length-1].length());
			arr[0]=temp1+arr[0].substring(1,arr[0].length());
		}
		else if(!hs.contains(arr[0].charAt(0))){
			arr[arr.length-1]=String.valueOf(arr[0].charAt(0))+arr[arr.length-1];
			arr[0]=arr[0].substring(1,arr[0].length());
		}
		else if(!hs.contains(arr[arr.length-1].charAt(0))){
			arr[0]=String.valueOf(arr[arr.length-1].charAt(0))+arr[0];
			arr[arr.length-1]=arr[arr.length-1].substring(1,arr[arr.length-1].length());
		}
		
		temp1=arr[0];
		for(int i=1;i<arr.length;i++) {
			temp1=temp1+" "+arr[i];
		}
		return temp1;
	}
	
	public static void main(String args[]) {
	 Spoonerisms sp=new Spoonerisms();
	try {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   
        String line=null;
        while((line = br.readLine())!=null) {
        	
        	System.out.println(sp.GenerateSpoonersim(line));
        }
        
        br.close();
    	}
    	catch(Exception e) {
    		System.out.println(e);
    	}
	
}
}
