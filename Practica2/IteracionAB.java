package Practica2;
public class IteracionAB {
	static void iteracionConFor(int a,int b) {
		  for(a=1;a<b;a++)
			  System.out.println(a);
	  }
	static void iteracionConWhile(int a,int b) {
		while(a<b) {
			System.out.println(a);
			a++;
		}
	}
	static int recursion(int a,int b) {
		if (a==b)
			return a;
		else {
			a++;
			System.out.println(a);
			recursion(a,b);
		}
		return a;
			
	}

	public static void main(String[] args) {
	  int a=1;
	  int b=10;
	  int c;
	  iteracionConFor(a,b);
	  System.out.println("----------------------");
	  iteracionConWhile(a,b);
	  System.out.println("----------------------");
	  c=recursion(a,b);
	}
}
