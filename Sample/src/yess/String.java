package yess;

public class String extends String2 {

	
	public void name()
	{
		int r=0;int t=2;
		int y=0;
		while(r<50)
		{
			r=t+y;
			System.out.println(r);
			t=y;
			y=r;
			
			
		}
	}public void nnn()
	{
		
	int	number[]= {10,-12,34,54};
	int sml=0;
	int bgt=0;
	for(int i=0;i<number.length;i++)
	{
		if(number[i]>bgt)
		{
			bgt=number[i];
		}
		else if(number[i]<sml)
		{
			sml=number[i];
		}
		
	}
	System.out.println("Small is : "+sml);
	System.out.println("Biggest is : "+bgt);
	}
	
}
