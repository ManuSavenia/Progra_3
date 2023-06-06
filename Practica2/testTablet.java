package Practica2;
public class testTablet {

	public static void main(String[] args) {
		tablet v[]=new tablet[3];
		int i;
		for(i=0;i<3;i++) {
		v[i]=new tablet("marca"+i,"windows"+i,"modelo"+i,(double)i,(float)i);
		}
		for(i=0;i<3;i++) {
			String informacion = v[i].devolverDatos();
			System.out.println(informacion);
			System.out.println("---------------------------------");
		}
	}

}
