public class Moto extends Vehiculo{
    
    public Moto(String p, String m, String c){
        super(p,m,c,30000000);
    }
    
    public Moto (String p, String m, String c, int v){
        super(p,m,c,v);
    }
    
    public String tipo(){
        return "moto";
    }
}