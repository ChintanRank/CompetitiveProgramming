import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class PureDice {

	public void GetProbability(String line) {
		
		String[] str=line.split(" ");
		Double M=Double.valueOf(str[0]);
		Integer N=Integer.valueOf(str[1]);
		
		List<Float> pro=new ArrayList<>();
		
		for(int i=2;i<str.length;i++) {
			pro.add(Float.valueOf(str[i]));
		}
		
	
		Float probability=0f;
		for(int i=0;i<pro.size();i++) {
			for(int j=0;j<pro.size();j++) {
				if(i!=j) {
				for(int k=0;k<pro.size();k++) {
					if(i!=j&&j!=k&&i!=k) {
						probability=probability+(pro.get(i)*pro.get(j)*pro.get(k));
						}
				}
			}
			}
	}

		System.out.print(String.format("%.6g%n", Math.pow(1-probability, M-1)*probability));
	}
	
	public static void main(String args[]) {
		PureDice pd=new PureDice();
		try {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   
	        String line;
	        while((line = br.readLine())!=null) {
	            pd.GetProbability(line);
	        }
	        br.close();
	    	}
	    	catch(Exception e) {
	    		System.out.println(e);
	    	}
		
	}
}
