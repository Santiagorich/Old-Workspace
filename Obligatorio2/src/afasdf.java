import java.util.Scanner;

public class afasdf {

	public static void main(String[] args) {
		int contador2=1;
		int contador=1;
		int [][] nota;
		int cantidad;
		int op=0;
		int intentos = 0;	
		Scanner input = new Scanner(System.in);
		nota=new int [0][2];
		String usuario;
		int contraseña;
		System.out.print("1:Calificaciones por Materia\n");
		System.out.print("2:Juicio Individual\n");
		op=input.nextInt();
		switch(op){
		case 1: System.out.print("Ingrese la cantidad de alumnos\n");
		        cantidad = input.nextInt();
		        nota=new int [cantidad+1][3];
		while (contador<=cantidad){
		    System.out.print("Ingrese la nota del alumno " + contador + " en Matemática: ");
		    nota [contador][1]=input.nextInt();
		    System.out.print("Ingrese la nota del alumno " + contador + " en Geometría: ");
		    nota [contador][2]=input.nextInt();
		    contador++;
		    System.out.print("\n");
		    System.out.print("---------------------------------------------------------");
		    System.out.print("\n");
		    }
		    contador=1;

case 3: 
    while (contador2<=2){
        switch (contador2){
            
        case 1:
            System.out.println("El alumno " + contador + " saco un " + nota [contador][contador2] + " en Matemática" );
        case 2:
            System.out.println("El alumno " + contador + " saco un " + nota [contador][contador2] + " en Geometría" );    
        
            
        }
        contador++;
    }
		}}}