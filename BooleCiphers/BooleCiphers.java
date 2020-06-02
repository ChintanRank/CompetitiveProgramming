import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class BooleCiphers {

 class Node{
	String val;
	Node(String x){this.val=x;}
	Node left;
	Node right;
	
}
 
 
HashMap<String,String> hmap=new HashMap<>();
//reading the first input line and generating the tree y passing it to CreateTree()	
	public Node ReadLine(String line) {
		Stack<Node> stack=new Stack<>();
		Node root=null;
		if(line.charAt(0)=='[') {
		 root=new Node("");
		stack.push(root);
		CreateTree(stack,1,line.toCharArray());
		}
		return root;
	}

//creating a hashmap for values by creating string from the tree and appending their respective character to it
HashMap<String,String> hash=new HashMap<String,String>();
public void  TraverseTree(Node root,String str) {
	
	if(hmap.containsKey(root.val)) {
		str=str+hmap.get(root.val);
		hash.put(str,root.val);
	}
	else {
		str=str+root.val;
	}
	
	if(root.left!=null) {
		TraverseTree(root.left,str);
	}
	if(root.right!=null) {
		TraverseTree(root.right,str);
	}
	
}


//Concluding the main resultant string	
public String Result(String line) {
	int pointer=0;
	String str="";
	for(int i=1;i<=line.length();i++) {
	String sub=line.substring(pointer,i);
	if(hash.containsKey(sub)) {
		str=str+hash.get(sub);
		pointer=i;
	}
	}
	System.out.println(line+"\n"+str);
	return str;
}

//Generation of the tree
public void CreateTree(Stack<Node> stack,int index,char[] c) {
	
	while(!stack.isEmpty()) {
		Node root=stack.pop();
		if(index<c.length&&root.left==null) {
			if(c[index]=='[') {
				root.left=new Node("0");
				stack.push(root);
				stack.push(root.left);
				index++;continue;
			}
			else {
				root.left=new Node(String.valueOf(c[index]));
				hmap.put(String.valueOf(c[index]),"0");
				stack.push(root);
				index++;continue;
			}
		}
		else if(index<c.length&&root.right==null) {
			if(c[index]=='[') {
				root.right=new Node("1");
				stack.push(root);
				stack.push(root.right);
				index++;continue;
			}
			else {
				root.right=new Node(String.valueOf(c[index]));
				hmap.put(String.valueOf(c[index]),"1");
				stack.push(root);
				index++;continue;
			}
		}
		else if(index<c.length&&c[index]==']'){
			index++;continue;
		}
		
	}
	}

public static void main(String args[]) {
	
		BooleCiphers bc=null;
		try {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   
	        String line;
	        Integer count=null;  //for keeping the count of the lines from the input
            Integer instance=0;  //for writing the sample number in output
            Node root=null;		//passing the node to method
	        while((line = br.readLine())!=null) {
	        	if(line.contains("SAMPLE")) {count=2;root=null;bc=new BooleCiphers();continue;}
                else {
                        count--;
                      	if(count==1) {
                      		root=bc.ReadLine(line);
                      	}
                      	if(count==0) {
                      		String result="";
                      		System.out.println("-- SAMPLE "+(++instance)+" --");
                      		bc.TraverseTree(root,result);
                    	    bc.Result(line); 
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
