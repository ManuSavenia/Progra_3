import java.util.Scanner;
public class Multiplos {
	static int[] getMultiplos(int n) {
		int[] v = new int[n];
		int i;
		for(i=0;i<n;i++) {
			v[i]=n*i;
		}
		return v;
	}
	
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n;
		int i;
		int arreglo[];
		n=s.nextInt();
		arreglo=getMultiplos(n);
		for(i=0;i<n;i++) {
			System.out.println(arreglo[i]);
		}

	}
}
