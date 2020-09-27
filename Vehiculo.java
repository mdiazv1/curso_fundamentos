

public class Vehiculo
{
   
    public static Vehiculo[] vehiculos;  //vector de las estancias de vehiculos abiertas
    public static int cantidad=0;  //cuenta cuantos carros se han parqueado
    
    private String placa;
    private String marca;
    private String color;
    
    private int valorComercial;


    public Vehiculo(){}
    
    public Vehiculo(String p, String m, String c)
    {this(p,m,c,30000000);
    }
    
    public Vehiculo(String p, String m, String c, int v)
    {this.placa=p;
     this.marca=m;
     this.color=c;
     this.valorComercial=v;
     cantidad++;
    }
    
    public void setPlaca(String p)
    {this.placa=p;
    }
    
    public void setMarca(String m)
    {this.marca=m;
    }

    public void setColor(String c)
    {this.color=c;
    }
    
    public void setValorComercial(int v)
    {this.valorComercial=v;
    }
    
    public String getPlaca()
    {return this.placa;
    }    
    
    public String getMarca()
    {return this.marca;
    }  
    
    public String getColor()
    {return this.color;
    }  
    
    public int getValorComercial()
    {return this.valorComercial;
    }  
    
    
    public String toString(){
    String texto= "Placa: "+this.getPlaca()+"||  "+"Color: "+this.getColor()+"||  "+ "Marca: "+this.getMarca()+"||  "+"Valor: "+this.getValorComercial(); 
    return texto;
    }
    
    
    public static String toStringVehiculos(){
    String texto="";
        for(int i=0;i<vehiculos.length;i++){
            if(vehiculos[i]!=null){
            texto=texto+"\n"+(vehiculos[i]).toString();
            }
        }
    return texto;
    }    
    
    
    public static int cantidadVehiculos(){
    return Vehiculo.cantidad;
    }
}    
    
    
    
    
    
    
    
    