
public class TestDemo {
	
	


	//output = "iH I ma yajnaS";



	public String rev(String str)
	{
	   char[] ch = str.toCharArray();
	   int last=ch.length-1;
	   for(int i=0; i<ch.length/2;i++)
	{
	    char temp= ch[i];
	    ch[i] = ch[last];
	    ch[last] = temp;
	    last--;
	    
	}
	  return new String(ch);
	}

	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String info = "Hi I am Sanjay";
		
		  String[] str = info.split(" ");

			/*  Hi, I, am, Sanjay */

		  
		  TestDemo tst = new TestDemo();
			int j = str.length;
		
				
			for(int k =0; k<str.length;k++)
			{
				System.out.print(tst.rev(str[k])+" ");
			}
				
			

	

	}

}
