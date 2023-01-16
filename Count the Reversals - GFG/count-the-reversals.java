//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String s = sc.next ();
    		System.out.println (new Sol().countRev (s));
        }
        
    }
}
// Contributed By: Pranay Bansal

// } Driver Code Ends


//User function Template for Java

class Sol
{
    int countRev (String str)
    {
       if(str.length()%2!=0) return -1;
int i=0;
Stack<Character> st = new Stack<>();
int count=0;
while(i<str.length()){
	char ch = str.charAt(i);
	if(st.isEmpty()){
	   if(ch=='}') {count++;st.push('{');}
	   else st.push(ch);
	}else if(ch=='}' && st.peek()=='{') st.pop();
	else st.push(ch);
	i++;
}
return st.size()/2+count;    
    }
}