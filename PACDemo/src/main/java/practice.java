import java.util.Arrays;

public class practice {
	
	
	public String transverseString(String org)
	{
		String[] str =  org.split(" ");
		
		for(int k =0; k<str.length-1; k++)
		{
			
		System.out.println("Original String is:"+str[k]);
		char[] ch = str[k].toCharArray();
		
		    for(int i =0; i<(org.length()-1)/2; i++)
		    {
			char temp  = ch[i];
			ch[i]=ch[org.length()-1-i];
			ch[org.length()-1-i]=temp;	
			
		    }
		str[k] = new String(ch);
		System.out.println(str[k]);
		}
		return Arrays.toString(str);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		practice p = new practice();
		
		p.transverseString("My Name is Sanjay");
		
		
	}

}
