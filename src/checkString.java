
public class checkString {
	public static String treatString(String in){
		for(int i = 0; i < in.length()-1; i++){
			if(i >= 2 && in.charAt(i) == in.charAt(i-1)){
				in = "doubleOp";
				return in;
			}
			if(in.charAt(i) != '0' && in.charAt(i) != '1' &&  
					in.charAt(i) != '2' &&  in.charAt(i) != '3' && 
					in.charAt(i) != '4' &&  in.charAt(i) != '5' &&  
					in.charAt(i) != '6' &&  in.charAt(i) != '7' && 
					in.charAt(i) != '8' &&  in.charAt(i) != '9' && 
					in.charAt(i) != '+' && in.charAt(i) != '-' && 
					in.charAt(i) != '*' &&  in.charAt(i) != '/' 
					&&  in.charAt(i) !=  '^')
				{
					in = "inputTypeIncorrect";
					return in;
				}
		}
		return in;		
	}

	public static boolean isOperator(char checkOp) {
	      if (checkOp == '+' || checkOp == '-' || checkOp == '*' 
	    		  || checkOp == '/' || checkOp == '^') 
	      		{
	    	  		return true;
	      		}
	      else {	    	 
	        return false;
	      }
	    }

}
