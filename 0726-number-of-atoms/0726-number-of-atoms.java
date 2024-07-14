class Solution {
    public String countOfAtoms(String formula) {
        Stack<String> st = new Stack<>();
       
        for(char i=0;i<formula.length();i++){
            char f = formula.charAt(i);
            if(Character.isLowerCase(f)){
                String ch = st.pop();
                String str = ch+f;
                st.push(str);
            }
            else if(!st.isEmpty() && Character.isDigit(f) && st.peek().equals(")")){
                int val = Character.getNumericValue(f); //2
                while(i+1<formula.length() && Character.isDigit(formula.charAt(i+1))) {
                    val=val*10+formula.charAt(i+1)-'0';
                    i++;
                }
                System.out.println("val: "+val);
                st.pop();
                 Stack<String> st1 = new Stack<>();
                while(!st.isEmpty() && !st.peek().equals("(")){
                    if(st.peek().matches(".*\\d.*")){
                        st1.push(Integer.toString((Integer.valueOf(st.pop())*val)));
                    }else if(!st1.isEmpty() && st1.peek().matches(".*\\d.*")){
                        st1.push(st.pop());
                    }else{
                        st1.push(Integer.toString(val));
                        st1.push(st.pop());
                    }
                }
                 //System.out.println(st.peek());
                st.pop();
                while(!st1.isEmpty()){
                    //System.out.println(st1.peek());
                    st.push(st1.pop());
                }
            }else{
                if(Character.isDigit(f)){
                     int val = Character.getNumericValue(f); //2
                     while(i+1<formula.length() && Character.isDigit(formula.charAt(i+1))) {
                         val=val*10+formula.charAt(i+1)-'0';
                         i++;
                     }
                    System.out.println("val: "+val);
                    st.push(String.valueOf(val));
                }
                 else st.push(String.valueOf(f));
            }
       }
        //System.out.println(st.size());
       TreeMap<String,Integer> map = new TreeMap<>();
       
       while(!st.isEmpty()){
          // System.out.println(st.peek());
           if(st.peek().matches(".*\\d.*")){
               int val = Integer.valueOf(st.pop());
               String key = st.pop(); 
               if(map.containsKey(key))map.put(key,map.get(key)+val);
               else map.put(key,val);
           }else{
                String key = st.pop(); 
              if(map.containsKey(key))map.put(key,map.get(key)+1);
              else map.put(key,1);
           }
       }
      // System.out.println(st.size());
        String str = "";
        for (Map.Entry<String,Integer> entry : map.entrySet()) {
            if(entry.getKey().equals("(") ||entry.getKey().equals(")") ){
              continue;
           }
            //System.out.println("key: "+ entry.getKey()+ " "+ "value: "+entry.getValue());
            if(entry.getValue()==1) str+=entry.getKey();
            else str+=entry.getKey()+Integer.toString(entry.getValue());
        }
        return str;
    }
}