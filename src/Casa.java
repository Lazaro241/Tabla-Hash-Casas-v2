public class Casa {
    private String poblacion;
    private String direccion;
    private int numHabitacion;
    private double precioDia;
    public String codigo;
    public boolean existe;
    public Casa(String pob, String dir, int NumH, double precioD, String cod){
        this.existe=true;
        this.poblacion=pob;
        this.direccion=dir;
        this.numHabitacion=NumH;
        this.precioDia=precioD;
        this.codigo=cod;
    }
    public void mostrar(){
        System.out.print("Codigo: "+this.codigo+" | Direccion: "+this.direccion+" | Poblacion: "+this.poblacion+" | Numero de habitaciones: "+this.numHabitacion+" | Precio por dia: "+this.precioDia+" | Estado: ");
        if(this.existe){
            System.out.println("Alta");
        } else {
            System.out.println("Baja");
        }
    }
}
