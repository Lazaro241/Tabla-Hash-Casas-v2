import java.util.Scanner;
public class Main {
    public static void menu(){
        System.out.println("1. Ingresar casa\n2. Eliminar casa\n3. Mostrar contenidos de la tabla\n4. Salir");
    }
    public static void ingresar(Tabla tabla){
        Scanner scanner = new Scanner(System.in);
        String direcc, pobl, cod;
        int numhab;
        double precioDia;
        System.out.println("Ingrese direccion:");
        direcc=scanner.nextLine();
        System.out.println("Ingrese poblacion:");
        pobl=scanner.nextLine();
        System.out.println("Ingrese numero de habitaciones:");
        numhab=scanner.nextInt();
        System.out.println("Ingrese el precio por dia:");
        precioDia=scanner.nextDouble();
        System.out.println("Ingrese codigo:");
        cod=scanner.nextLine();
        cod=scanner.nextLine();
        Casa casap = new Casa(pobl, direcc, numhab, precioDia, cod);
        while(!tabla.revision(casap)){
            System.out.println("Codigo en uso, ingrese uno nuevo:");
            casap.codigo=scanner.nextLine();
        }
    }
    public static void mostrar(Tabla tabla){
        tabla.mostrar();
    }
    public static void eliminar(Tabla tabla){
        Scanner scanner = new Scanner(System.in);
        String d;
        System.out.println("Ingrese codigo de la casa a eliminar:");
        d=scanner.nextLine();
        if(!tabla.eliminar(d)){
            System.out.println("No existe una casa con el codigo ingresado");
        } else {
            System.out.println("Casa eliminada con exito");
        }
    }

    public static void main(String[] args){
        Tabla tabla = new Tabla();
        int s=0;
        Scanner scanner = new Scanner(System.in);
        while(s!=4){
            menu();
            s=scanner.nextInt();
            switch(s){
                case 1:
                ingresar(tabla);
                break;
                case 2:
                eliminar(tabla);
                break;
                case 3:
                mostrar(tabla);
                break;
            }
        }
        System.out.println("Fin del programa.");
        scanner.close();
    }
}
