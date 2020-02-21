import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

class Main {
  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    String menu="\n\t\tMENU\n\t Escoge un algortimo:\n \t 1 = Fibonacci\n \t 2 = Padovan\n \t 3 = Triangulo Pascal\n \t 4 = salir\n";
    String opcion, lim; 
    int o, li; 
    boolean loop = true;

    while (loop){
      System.out.format(menu);
      opcion = sc.nextLine();

      if (validacion(opcion) == true && Integer.parseInt(opcion)>=1 && Integer.parseInt(opcion)<=3) {
        o = Integer.parseInt(opcion);
        System.out.println("¿Cual es el limite?");
        lim = sc.nextLine();
        if (validacion(lim) == true ) {
          li = Integer.parseInt(lim);
          switch (o) {
            case 1:
              System.out.println(fibo(li));
            break; 
            case 2:
              System.out.println(padovan(li));
            break; 
            case 3:
              pascal(li);
            break; 
          }
        } else if (validacion(lim) == false){
          System.out.println("Solo se aceptan valores Numericos");
          System.out.println("Volviendo al Menu...");
        }
      }
      else {
        if (validacion(opcion) == true && Integer.parseInt(opcion)==4){
          System.out.println("ADIOS");
          loop = false;
        } else {
          System.out.println("Solo se Aceptan Numeros del 1 al 4");
        }
      }
    }
  }
    
    //pascal(14);
  
  
  static boolean validacion(String opcion){
	try {
		Integer.parseInt(opcion);
		return true;
	} catch (NumberFormatException nfe){
		return false;
	}
  }

  public static List<String> fibo(long n) {
    long num1 = 0, num2 = 1, suma = 1;
    List<String> listado = new ArrayList<String>();
    listado.add(0, num1 + "");
    for (int i = 1; suma <= n; i++) { 
      listado.add(i, suma + "");
      suma = num1 + num2;
      num1 = num2;
      num2 = suma;
    }
     return listado;  
  }

  public static List<String>  padovan(long n){
    long pPrevPrev = 1, pPrev = 1, pCurr = 1, pNext = 1;
    List<String> listado = new ArrayList<String>();
    listado.add(0, pPrevPrev + "");
    listado.add(1, pPrevPrev + "");
    listado.add(2, pPrevPrev + "");
        for (int i = 3; pPrevPrev + pPrev <= n; i++) {  
            pNext = pPrevPrev + pPrev; 
            pPrevPrev = pPrev; 
            pPrev = pCurr; 
            pCurr = pNext; 
            listado.add(i, pNext + "");
        } 
    return listado;
  }

  public static void pascal(long n){
        for(int i =0;i<n;i++) {
            long number = 1;
            System.out.format("%"+(n-i)*2+"s","");
            for(int j=0;j<=i;j++) {
                System.out.format("%4d",number);
                number = number * (i - j) / (j + 1);
            }
            System.out.println();
        }
  }

 
}
