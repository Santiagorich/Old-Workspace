import java.util.Scanner;
public class Practico {

	public static void main(String[] args) {
	int suma=0,numero=0,promedio=0,maximo=0,minimo=0,parar=1,sumapar=0,sumaimp=0,contador=0,anterior=0,anteriormin=0,salto=0;
	Scanner input= new Scanner(System.in);
	System.out.println("Inserta un numero real");
	numero=input.nextInt();
	anteriormin=numero;
	anterior=numero;
	while (parar!=0){
		if (salto==1){
		System.out.println("Inserta un numero real");
		numero=input.nextInt();
		}
		if (numero==0){
			parar=numero;
			break;
		}
		if (anterior<numero){
			maximo=numero;
		}
		if (anteriormin>numero){
			minimo=numero;
		}
		suma=numero+suma;
		contador++;
		if (numero%2==0){
			sumapar=numero+sumapar;
		}
		else{
			sumaimp=numero+sumaimp;
		}
		anterior=numero;
		anteriormin=numero;
		salto=1;
	}
	promedio = (sumapar+sumaimp)/contador;
	suma = sumaimp+sumapar;
	System.out.println("Suma de numeros pares!" + sumapar);
	System.out.println("Suma de numeros impares!" + sumaimp);
	System.out.println("Promedio!" + promedio);
	System.out.println("Sumatoria!" + suma);
	System.out.println("Maximo!" + maximo);
	System.out.println("Minimo!" + minimo);
	}

}
