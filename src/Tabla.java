public class Tabla {
    Casa[] casas;
    int numElementos;
    int factorCarga;
    Hash disperse = new Hash();
    public Tabla(){
        casas= new Casa[101];
        for(int i=0; i<101; i++){
            casas[i]=null;
        }
        this.factorCarga=0;
        this.numElementos=0;
    }
    public boolean revision(Casa casa){
        int clave = disperse.direccionar(casa.codigo, 101);
        if(casas[clave]==null){
            this.insertar(clave, casa);
            return true;
        } else {
            if(casa.codigo.equals(casas[clave].codigo)){
                return false;
            } else {
                clave=disperse.solucionColision(casas, clave);
                this.insertar(clave, casa);
                return true;
            }
        }
    }
    private void insertar(int claveHash, Casa casa){
        this.casas[claveHash]=casa;
        this.numElementos++;
        this.factorCarga=numElementos/101;
        if(factorCarga>0.5){
            System.out.println("Factor de carga excediendo el 50%! Se recomienda aumentar el espacio.");            
        }
    }
    public boolean eliminar(String codigo){
        int posicion = disperse.direccionar(codigo, 101);
        if(casas[posicion]!=null){
            if(casas[posicion].existe){
                casas[posicion].existe=false;
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    public void mostrar(){
        for(int i=0;i<casas.length;i++){
            if(casas[i]!=null){
                System.out.print("Casa N° "+(i+1)+" ");
                casas[i].mostrar();
            }
        }
    }
}
