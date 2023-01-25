import java.util.Scanner;
import java.util.Stack;

class CheckValid {
    
    public boolean brackets(String input){
        int pos;       
        Stack<Character> stack = new Stack<>();     
        char[] charArray = input.toCharArray();
        for (pos = 0; pos < charArray.length; pos++) {     
            char current = charArray[pos];     
            if (current == '{' || current == '[' || current == '(') {     
                    break;   
            }
        }
        if(pos==charArray.length){
            return arithmeticCheck(input); 
        }
        for (int i = 0; i < charArray.length; i++) {     
            char current = charArray[i];     
            if (current == '{' || current == '[' || current == '(') {     
                stack.push(current);   
                continue;   
            }     
            if (stack.isEmpty()) { 
                System.out.println("empty");   
                return false;   
            }     
            if (current == ')' || current == '}' || current == ']') { 
                char popChar;
                switch (current) {   
                    case ')':   
                    popChar = (char) stack.pop();   
                    if (popChar == '{' || popChar == '[')   
                        return false;   
                    break;   
                    case '}':   
                    popChar = (char) stack.pop();   
                    if (popChar == '(' || popChar == '[')   
                        return false;   
                    break;   
                    case ']':   
                    popChar = (char) stack.pop();   
                    if (popChar == '(' || popChar == '{')   
                        return false;   
                    break;   
                }   
            }
        }   
       if(stack.isEmpty())
            return arithmeticCheck(input);    
        return false ;
    }
     public boolean arithmeticCheck(String input){
            char x=input.charAt(0);
            if(x=='/'||x=='%'){
                return false;
            }
            x=input.charAt(input.length()-1);
            if(x=='+'||x=='-'||x=='/'||x=='%'||x=='*'){
                return false;
            }
            for(int pos=1;pos<input.length()-1;pos++){
                x=input.charAt(pos);
                char prevX=input.charAt(pos-1);
                char postX=input.charAt(pos+1);
                if(x=='+'||x=='-'||x=='/'||x=='%'||x=='*'){
                    if(!(prevX>95&&prevX<123))
                        return false;
                    if(!(postX>95&&postX<123))
                        return false;
                }

            }
        return true; 
     }  
}
public class ExpressionValid{
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String s=sc.next();
        CheckValid cv=new CheckValid();
        System.out.println(cv.brackets(s));
        sc.close();
    }
}
