package abstracta;

public class abstractatest {
	static int calc(int a,int b,int c)
	{
	    if (a>10) return a;
	    while (a<10){
	        if(b<0){
	            b++;
	            System.out.println("Corrio B");
	        }
	        if(b>a){
	            a=b;
	            System.out.println("Corrio BA");

	        }
	        else if(c<0){
	            c++;
	            System.out.println("Corrio C");

	        }
	        else{
	            a++;
	            System.out.println("Corrio Else");

	        }
	    }
	    return a;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		    calc(-2,-1,-1);
	}
	
	

}
