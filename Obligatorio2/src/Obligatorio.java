import java.util.Scanner;

public class Obligatorio {
	public static void main(String[] args) {
		// Variables
		Scanner input = new Scanner(System.in);
		double num1;
		double num2;
		double x = 0;
		int promediosuma = 0;
		int max = 0;
		int min = 10000;
 		int [] a1 = {0};
		int [] a2 = {0};
		int [] a3 = {0};
		int [] a4 = {0};
		int [] a5 = {0};
		int [] a6 = {0};
		int [] a7 = {0};
		int [] a8 = {0};
		int [] a9 = {0};
		int [] a10 = {0};
		int [] a11 = {0};
		int [] a12 = {0};
		int hecho=0,hecho1=0;
		int promedio=0;
		int [] n1  = {0},n2 = {0},n3 = {0},n4 = {0},n5 = {0},n6 = {0},n7 = {0},n8 = {0},n9 = {0},n10 = {0},n11 = {0},n12 = {0};
		int contador=1;
		int [] pro = {0};
		int cantidad=0;
		int op=0;
		int op2=0;
		int intentos = 0;	
		pro=new int [19];
		String usuario;
		int contraseña;
		int faltas;
		String alumno; 
	    
	    //Login
		while (intentos < 3) {
			System.out.print("Ingrese Usuario:");
			usuario = input.next();
			System.out.print("Ingrese la Contraseña:");
			contraseña = input.nextInt();

			if (usuario.equals("admin") && contraseña == 123) {
				System.out.println("Usted se ha logeado con éxito");
				break;
				}
			else {
				System.out.println("Usuario o contraseña incorrectos");
				intentos++;
				if (intentos == 3) {
					System.out.println("Llame a el soporte técnico");
					System.exit(0);
				}
				
			}
			

		}
while (hecho==0){		
		System.out.print("1:Calificaciones por Materia\n");
		System.out.print("2:Inasistencias\n");
		System.out.print("3:Juicio Individual\n");
		System.out.print("4:Salir\n");
		op=input.nextInt();
		
		switch(op){
		case 1: System.out.print("Ingrese la cantidad de alumnos: ");
		        cantidad = input.nextInt();
		        n1=new int [cantidad+1];
		        n2=new int [cantidad+1];
		        n3=new int [cantidad+1];
		        n4=new int [cantidad+1];
		        n5=new int [cantidad+1];
		        n6=new int [cantidad+1];
		        n7=new int [cantidad+1];
		        n8=new int [cantidad+1];
		        n9=new int [cantidad+1];
		        n10=new int [cantidad+1];
		        n11=new int [cantidad+1];
		        n12=new int [cantidad+1];
		        a1=new int [cantidad+1];
		        a2=new int [cantidad+1];
		        a3=new int [cantidad+1];
		        a4=new int [cantidad+1];
		        a5=new int [cantidad+1];
		        a6=new int [cantidad+1];
		        a7=new int [cantidad+1];
		        a8=new int [cantidad+1];
		        a9=new int [cantidad+1];
		        a10=new int [cantidad+1];
		        a11=new int [cantidad+1];
		        a12=new int [cantidad+1];
		while (contador<=cantidad){
		    System.out.print("Ingrese la nota del alumno " + contador + " en Matemática: ");
		    n1 [contador]=input.nextInt();
		    System.out.print("Ingrese la nota del alumno " + contador + " en Geometría: ");
		    n2 [contador]=input.nextInt();
		    System.out.print("Ingrese la nota del alumno " + contador + " en Física: ");
		    n3 [contador]=input.nextInt(); 
		    System.out.print("Ingrese la nota del alumno " + contador + " en Introducción: ");
		    n4 [contador]=input.nextInt();
		    System.out.print("Ingrese la nota del alumno " + contador + " en Biología: ");
		    n5 [contador]=input.nextInt();
		    System.out.print("Ingrese la nota del alumno " + contador + " en Eléctricidad: ");
		    n6 [contador]=input.nextInt();
		    System.out.print("Ingrese la nota del alumno " + contador + " en Historia: ");
		    n7 [contador]=input.nextInt();
		    System.out.print("Ingrese la nota del alumno " + contador + " en Inglés: ");
		    n8 [contador]=input.nextInt();
		    System.out.print("Ingrese la nota del alumno " + contador + " en APT: ");
		    n9 [contador]=input.nextInt();
		    System.out.print("Ingrese la nota del alumno " + contador + " en Programación: ");
		    n10 [contador]=input.nextInt();
		    System.out.print("Ingrese la nota del alumno " + contador + " en Sistema Operativo: ");
		    n11 [contador]=input.nextInt();
		    System.out.print("Ingrese la nota del alumno " + contador + " en Taller de Mantenimiento: ");
		    n12 [contador]=input.nextInt();
		    contador++;
		    System.out.print("\n");
		    System.out.print("---------------------------------------------------------");
		    System.out.print("\n");
		    }
		    contador=1;
		    hecho1=1;
		    break;
		    
case 2: System.out.print("Ingrese el nombre del alumno: ");
        alumno=input.next();
        System.out.print("Ingrese las faltas del alumno: ");
        faltas= input.nextInt();
        if (faltas>20){     
            System.out.print(alumno +", Tiene que recursar la materia");
        }
        else if (faltas>=10 && faltas <20){
            System.out.print (alumno + ", Cuide sus faltas");
        }
        else if (faltas >= 1 && faltas <10){
            System.out.print (alumno +", no tiene casi faltas");
        }
        else{
            System.out.print(alumno +", Felicidades usted no tiene ninguna falta");
        }
 System.out.print("\n");
 break;    
		    
case 3: 
	if (hecho1==1){
    	   while (contador<cantidad+1){
               System.out.println("El alumno " + contador + " saco un " + n1 [contador] + " en Matemática" );
               if (n1 [contador]>=7){
                   a1[contador]=1;
               
               }
               System.out.println("El alumno " + contador + " saco un " + n2 [contador] + " en Geometría" );
               if (n2 [contador]>=7){
                   a2[contador]=1;
               
               }
               System.out.println("El alumno " + contador + " saco un " + n3 [contador] + " en Física" );
               if (n3 [contador]>=7){
                   a3[contador]=1;
             
               }
               System.out.println("El alumno " + contador + " saco un " + n4 [contador] + " en Introducción" );
               if (n4 [contador]>=7){
                   a4[contador]=1;
        
               }
               System.out.println("El alumno " + contador + " saco un " + n5 [contador] + " en Biología" );
               if (n5 [contador]>=7){
                   a5[contador]=1;
               	
               }
               System.out.println("El alumno " + contador + " saco un " + n6 [contador] + " en Eléctricidad" );
               if (n6 [contador]>=7){
               	a6[contador]=1;
               }
               System.out.println("El alumno " + contador + " saco un " + n7 [contador] + " en Historia" );
               if (n7 [contador]>=7){
               	a7[contador]=1;
               }
               System.out.println("El alumno " + contador + " saco un " + n8 [contador] + " en Inglés" );
               if (n8 [contador]>=7){
               	a8[contador]=1;
               }
               System.out.println("El alumno " + contador + " saco un " + n9 [contador] + " en APT" );
               if (n9 [contador]>=7){
               	a9[contador]=1;
               }
               System.out.println("El alumno " + contador + " saco un " + n10 [contador] + " en Programación" );
               if (n10 [contador]>=7){
               	a10[contador]=1;
               }
               System.out.println("El alumno " + contador + " saco un " + n11 [contador] + " en Sistema Operativo" );
               if (n11 [contador]>=7){
               	a11[contador]=1;
               }
               System.out.println("El alumno " + contador + " saco un " + n12 [contador] + " en Taller de Mantenimiento" );
               if (n12 [contador]>=7){
           	    a12[contador]=1;
        }
               System.out.print("\n");
               promedio=((n1 [contador]+n2 [contador]+n3 [contador]+n4 [contador]+n5 [contador]+n6 [contador]+n7 [contador]+n8 [contador]+n9 [contador]+n10 [contador]+n11 [contador]+n12[contador])/12);
               if (promedio>max) { 
                   max = promedio; 
                   } 
               if (promedio<min) { 
                   min = promedio; 
                   } 
               System.out.println("El alumno " + contador + " tiene un promedio de " + promedio );
                   if ((a1[contador]+a2[contador]+a3[contador]+a4[contador]+a5[contador]+a6[contador]+a7[contador]+a8[contador]+a9[contador]+a10[contador]+a11[contador]+a12[contador]>=7)){
                   
                       System.out.println("Exonera, pasa a Segundo de EMT, Felicitaciones!!");
            System.out.print("\n");
		    System.out.print("---------------------------------------------------------");
		    System.out.print("\n");
                   }else{
                   System.out.println("Repite el año");
            System.out.print("\n");
		    System.out.print("---------------------------------------------------------");
		    System.out.print("\n");
                   }
                   pro[contador]=promedio;
                   contador++;
                   

                   
                  
		          }   for (int i=0; i<cantidad; i++) { 
                   
                   
                   promediosuma = promedio + promediosuma; 
                   } 

                   System.out.println("Promedio Maximo: " + max); 
                   System.out.println("Promedio Minimo: " + min); 
                   System.out.println("Promedio general: " + promediosuma/cantidad);
                    }
		

             
	else{
		System.out.println("Debe completar la opcion 1 antes de usar la opcion 3");
	}
	System.out.print("\n");
	break;
	
case 4: System.out.print("Saliendo...");
System.exit(0);
   
}
}}}
     