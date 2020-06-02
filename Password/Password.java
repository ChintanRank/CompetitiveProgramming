import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Password {

	public String suggestedPassword(String str) {
		HashMap<String,String> hmap=new HashMap<String,String>();
		hmap.put("and","&");
		hmap.put("or","|");
		hmap.put("not","!");
		hmap.put("equals","=");
		hmap.put("plus","+");
		hmap.put("minus","-");
		hmap.put("times","*");
		hmap.put("slash","/");
		hmap.put("dollar","$");
		hmap.put("percent","%");
		hmap.put("at","@");
		hmap.put("zero","0");
		hmap.put("one","1");
		hmap.put("two","2");
		hmap.put("three","3");
		hmap.put("four","4");
		hmap.put("five","5");
		hmap.put("six","6");
		hmap.put("seven","7");
		hmap.put("eight","8");
		hmap.put("nine","9");
		hmap.put("to","2");
		hmap.put("for","4");
		hmap.put("ate","8");
		
		boolean flag=true;
		String test="";
		String ans="";
		String helper="";
		int i=0;
		while(i<str.length()) {
		
			Character temp=str.charAt(i);

			if(flag==true&&Character.isLetter(temp)) {
				helper=helper+temp;
				test=String.valueOf(temp);
				flag=false;
				i++;
				continue;
				
				
			}
			
			if(!Character.isLetter(temp)&&temp!=' ') {

				if(hmap.containsKey(helper.toLowerCase())) {
					ans=ans+hmap.get(helper.toLowerCase())+temp;	
				}
				else{
					ans=ans+test+temp;
				}
				
				flag=true;
				test="";
				helper="";
				i++;
				continue;
			}
			else if(!Character.isLetter(temp)&&temp==' ') {
				
				if(hmap.containsKey(helper.toLowerCase())) {
					ans=ans+hmap.get(helper.toLowerCase());	
				}
				else{
					ans=ans+test.toLowerCase();
				}
				
				flag=true;
				test="";
				helper="";
				i++;
				continue;
			}
			else {
				helper=helper+temp;
				i++;
				continue;
			}
		}

		if(str.charAt(str.length()-1)=='.') {ans=ans.substring(0,ans.length()-1);}
		
		return ans;
	}
	
	public static void main(String args[]) {
		Password pw=new Password();
		try {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   
	        String line;
	        while((line = br.readLine())!=null) {
	            System.out.println(pw.suggestedPassword(line));
	        }
	        br.close();
	    	}
	    	catch(Exception e) {
	    		System.out.println(e);
	    	}
		
	}
}
