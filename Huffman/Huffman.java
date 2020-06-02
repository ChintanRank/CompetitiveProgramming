import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Stack;

public class Huffman {

    public class Node{
    int val;
    Character name;
    Node(int val,Character name){
    	this.val=val;
    	this.name=name;
    }
    Node left;
    Node right;
    }
    
    public PriorityQueue<Node> WritePath(String line) {
    	Huffman hf=new Huffman();
    	HashMap<Character,Node> hs=new HashMap<>();
    	for(int i=0;i<line.length();i++) {
    		Character temp=line.charAt(i);
    		if(hs.containsKey(temp)) {
    			Node n=hs.get(temp);
    			n.val=n.val+1;
    			hs.replace(temp, n);
    		}
    		else {
    			
    			Node n=hf.new Node(1,temp);
    			hs.put(temp,n);
    		}
    	}
    
    PriorityQueue<Node> pq=new PriorityQueue<Node>(10,new Comparator<Node>(){
    	 public int compare(Node a,Node b) {
			  if(a.val<b.val) {
				  return -1;
			  }
			  else if(a.val>b.val) {
				  return 1;
			  }
			  else {
				  if(a.name<b.name) {return -1;}
				  else {return 1;}
				  
			  }
		  }
    });	
    
    for(Character n:hs.keySet()) {
    pq.add(hs.get(n));
    }
    
    return pq;
    }
   
    
    //returning the resultant string 
   public String HuffmanTree(PriorityQueue<Node> pq) {
	   Node N=null;
	   while(pq.size()!=1) { 
		   Node temp1=pq.poll();
		  Node temp2=pq.poll();
		 int sum=temp1.val+temp2.val;
		 N=new Node(sum,'#');
		 if(temp1.name=='#'||temp2.name=='#'){
			 if(temp1.name=='#'&&LeftMost(temp1)<temp2.name) {
				 N.left=temp1;
				 N.right=temp2;
			 }
			 else if(temp1.name=='#'&&LeftMost(temp1)>temp2.name){
				 N.left=temp2;
				 N.right=temp1;
			 }
			 else if(temp2.name=='#'&&LeftMost(temp2)<temp1.name) {
				 N.left=temp2;
				 N.right=temp1;
			 }
			 else if(temp2.name=='#'&&LeftMost(temp2)>temp1.name){
				 N.right=temp2;
				 N.left=temp1; 
			 }
	 
		 }
		 else if(temp1.name!='#'&&temp2.name!='#'&&(temp1.name<temp2.name)){
			 N.left=temp1;
			 N.right=temp2;
		 }
		 else if(temp1.name!='#'&&temp2.name!='#'&&(temp2.name<temp1.name)){
			 N.right=temp1;
			 N.left=temp2;
			
		 }

		 pq.add(N);
	   }
	   N=pq.poll();
	  
	   
	   return Traverse(N);
   }
    

   
  public String Traverse(Node root) {
	  Stack<Node> stack=new Stack<Node>();
	  	HashSet<Node> visited=new HashSet<Node>();
	  	String str="";
	  	str=GetMin(stack,root,str);
	  	int pointer=0;
	  	
	  while(!stack.isEmpty()) {
		 Node temp=stack.pop();
		 
		 if(visited.contains(temp)) {
			 str=str+")";
			 }
		 
		 if(temp.name!='#') {
			 str=str+"("+temp.name+")";
		 }
		 
		 if(!visited.contains(temp)&&temp.right!=null) {
			 stack.add(temp);
			 visited.add(temp);
			 str=GetMin(stack,temp.right,str);
		 }
	  }
	  
	  return str.substring(1, str.length()-1);
  }
  
  //get the leftmost character
  public Character LeftMost(Node root) {
	  Character c=null;
	  while(root!=null) {
		  c=root.name;
		  root=root.left;  
	  }
	  return c;
  }
  
  //get the min for updating the stack
  public String GetMin(Stack<Node> stack,Node root,String str){
	  
	  while(root!=null) {
		  if(root.name=='#') {
			  str=str+"(";
		  }
		  stack.push(root);
		  root=root.left;  
	  }
	  
	  return str;
  }
  

  
  public static void main(String args[]) {

	  Huffman hf=new Huffman();
	
    int count=0;
	try {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String line=null;
    while((line = br.readLine())!=null) {
    	PriorityQueue<Node> p=new PriorityQueue<>();
        p=hf.WritePath(line);
      System.out.println("String "+(++count)+": "+hf.HuffmanTree(p));
    }
    br.close();
	}
	catch(Exception e) {
		System.out.println(e);
	}
}
}
