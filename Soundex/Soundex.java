import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class Soundex {
    public static String replace(String str) {
        HashMap<Character,Integer> hmap=new HashMap<Character,Integer>();
        hmap.put('r',6);hmap.put('b', 1);hmap.put('c', 2);hmap.put('g', 2);
        hmap.put('j', 2);hmap.put('k', 2);hmap.put('q', 2);hmap.put('s', 2);
        hmap.put('x',2);hmap.put('z', 2);hmap.put('f', 1);hmap.put('p', 1);
        hmap.put('v', 1);
        hmap.put('m',5);
        hmap.put('n',5);
        hmap.put('l',4);
        hmap.put('d', 3);
        hmap.put('t', 3);
        
        HashSet<Character> vowels=new HashSet<Character>();
        vowels.add('a');vowels.add('e');vowels.add('i');
        vowels.add('o');vowels.add('u');
        
        int i=0;ArrayList<Integer> ls=new ArrayList<Integer>();
        
        String ans=String.valueOf(str.charAt(0));
        String append="";
        
        
        while(i<str.length()) {
            Character temp=str.charAt(i);
            
            if(i>1&&vowels.contains(temp)) {
                append=append+process(ls);
                ls.clear();
                i++;
                continue;
            }
            else if(hmap.containsKey(temp)) {
                ls.add(hmap.get(temp));
                i++;
                continue;
            }
            else {
                i++;
                continue;
            }
        }
        
        if(!ls.isEmpty()) {
        	if(!vowels.contains(str.charAt(0))) {
            append=append.substring(1,append.length())+process(ls);
        	}
        	else {
        		append=append+process(ls);
        	}
        
           
        }
        
        if(append.length()>=3) {
            String sub=append.substring(0,3);
            append=sub;
            
        }
        else {
            int temp=append.length();
            while(temp<=2) {
                append=append+"0";
                temp++;
            }
            
        }
        
        ans=ans+append;
        
        
        return ans;
    }
    
    
    static String process(ArrayList<Integer> list) {
        String out="";
        LinkedHashSet<Integer> hs=new LinkedHashSet<Integer>();
        for(int i=0;i<list.size();i++) {hs.add(list.get(i));}
        for(Integer j:hs) {
            out=out+j.toString();
            
        }
        
        return out;
    }
    
    public static void main(String args[]) throws IOException {
        
        //Soundex sx=new Soundex();
        //        String s1="robert";
        //        String s2="ashcraft";
        //        System.out.println(s1+" => "+ex.soundex(s1));
        //        System.out.println(s2+" => "+ex.soundex(s2));
    	try {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   
        String line=null;
        while((line = br.readLine())!=null) {
        
            System.out.println(line+" => "+replace(line));
        }
        br.close();
    	}
    	catch(Exception e) {
    		System.out.println(e);
    	}
    }
}
