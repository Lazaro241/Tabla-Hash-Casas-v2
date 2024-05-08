public class Hash {
    private double n=0.618033988;
    private int generar(String codigo){
        int clave=0;
        for(int i=0; i<Math.min(10,codigo.length()); i++){
            clave=clave*27+(int)codigo.charAt(i);
        }
        return clave;
    }
    public int direccionar(String codg, int m){
        int direccion;
        double a=this.generar(codg);
        a=a*this.n-Math.floor(a*this.n);
        direccion=(int)(m*a);
        return direccion;
    }
    public int solucionColision(Casa[] casa, int indice){
        int i=1; int nueva=indice;
        while(casa[nueva]!=null){
            nueva=(i^2)+indice;
            i++;
        }
        return nueva;
    }
}
