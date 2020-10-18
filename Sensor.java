
public class Sensor{
   
    public static Sensor[] sensores;  //arreglo de todos los sensores
    private int estado;


    public Sensor(){}
    
    public Sensor(int e){
        this.estado=e;
    }
    
    public void setEstado(int e){
        this.estado=e;
    }

    public int getEstado(){
        return this.estado;
    }  
    
    public String toString(){
        String texto="";
        if(this.estado==0){
            texto="libre";
        }else{
            texto="ocupado";
        }
        return texto;
    }
    
    
    public static String sensorLibre(){
        String texto="";
            for(int i=0;i<sensores.length;i++){
                if(sensores[i].getEstado()==0){
                    texto=texto+"\n"+ "El parqueadero "+i+" esta libre";
                }
            }
        return texto;
    }    
    
    
    public static String sensorEstado(){
    String texto="";
        for(int i=0;i<sensores.length;i++){
            if(sensores[i].getEstado()==0){
                texto=texto+"\n"+ "El parqueadero "+i+" esta libre";
            }else{
                texto=texto+"\n"+ "El parqueadero "+i+" esta ocupado";
            }
        }
    return texto;
    }    
    
    

}
    