
import java.util.ArrayList;
import java.util.Date;

public abstract class Vehiculo{
  
    public static Vehiculo [] vehiculos;  //vector de las estancias de vehiculos abiertas
    public static int cantidad=0;  //cuenta cuantos carros se han parqueado
    
    private String placa;
    private String marca;
    private String color;
    private int valorComercial;
    
    private Date entrada;


    public Vehiculo(){}
    
    public Vehiculo(String p, String m, String c){
        this(p,m,c,30000000);
    }
    
    public Vehiculo(String p, String m, String c, int v){
        this.entrada= new Date();
        this.placa=p;
        this.marca=m;
        this.color=c;
        this.valorComercial=v;
        cantidad++;
    }
    
    public void setPlaca(String p){
        this.placa=p;
    }
    
    public void setMarca(String m){
        this.marca=m;
    }

    public void setColor(String c){
        this.color=c;
    }
    
    public void setValorComercial(int v){
        this.valorComercial=v;
    }
    
    public String getPlaca(){
        return this.placa;
    }    
    
    public String getMarca(){
        return this.marca;
    }  
    
    public String getColor(){
        return this.color;
    }  
    
    public int getValorComercial(){
        return this.valorComercial;
    }  
    
    public Date getEntrada(){
        return this.entrada;
    }
    
    
    public String toString(){
        String texto= "Placa: "+this.getPlaca()+" ||  "+"Color: "+this.getColor()+" ||  "+ "Marca: "+this.getMarca()+" ||  "+"Valor: "+this.getValorComercial()
        +" ||  Tipo de vehiculo: " +this.tipo() + " ||  fecha de entrada: "+ entrada;
        return texto;
    }
    
    
    public static String toStringVehiculos(Vehiculo [] vs){
        String texto="";
            for(int i=0;i<vs.length;i++){
                if(vs[i]!=null){
                    texto=texto+"\n"+vs[i].toString();
                }
            }
        return texto;
    }    
    
    
    public static String colorVehiculos(String c){
        String texto="";
            for(int i=0;i<vehiculos.length;i++){
                  if(vehiculos[i]==null){
                      continue;
                  }
                  String color=(vehiculos[i].color).toLowerCase();
                  if(color.equals(c.toLowerCase())){
                      texto=texto+"\n"+vehiculos[i].toString();
                  }
                
            }
        return texto;
    }
    
 
    public static int cantidadVehiculos(){
        return Vehiculo.cantidad;
    }
    
    public abstract String tipo();
}    
    
    
    
    
    
    
    
    