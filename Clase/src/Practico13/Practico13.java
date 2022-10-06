package Practico13;

import javax.swing.JOptionPane;

public class Practico13 {
 public static void main(String[] args) {
 
 //Variables
 String horas,precio; 
 Double horascomunes=0.0,preciohora=0.0,sueldo=0.0;
 boolean quepasa=false;
 
 //Ingreso_de_Horas_Trabajadas
 do {
  try {
   horas = javax.swing.JOptionPane.showInputDialog("Ingrese Horas Trabajadas");
   if (horas != null) {
    horascomunes=Double.parseDouble(horas);
    quepasa=true;
   } else {
    System.exit(0);
   } 
  }catch (java.lang.NumberFormatException e) {
   JOptionPane.showMessageDialog(null, "Error de Ingreso en las Horas Trabajadas, Ingreselo nuevamente...", "Error...",JOptionPane.ERROR_MESSAGE);
   quepasa = false;
  }
 } while (quepasa == false);
 
 do {
  try {
   precio = javax.swing.JOptionPane.showInputDialog("Ingrese Precio por Hora");
   if (precio != null) {
    preciohora=Double.parseDouble(precio);
   } else {
    System.exit(0);
   } 
   if(preciohora>125) {
   JOptionPane.showMessageDialog(null, "El precio no puede exceder a 125", "Error...",JOptionPane.ERROR_MESSAGE);
   quepasa=false;
   }
   }catch (java.lang.NumberFormatException e) {
   JOptionPane.showMessageDialog(null, "Error de Ingreso en el Precio por Hora, Ingreselo nuevamente...", "Error...",JOptionPane.ERROR_MESSAGE);
   quepasa=false;
  }
 } while (quepasa == false);
 
 if(horascomunes>160){
 
  sueldo= (preciohora * 1.5);
 }
 else{
  sueldo=preciohora;
 }
 }
 
}