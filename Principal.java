import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Principal
{
      public static void main(String[] args)
      { Principal.mostrarMenu();
      }   
      
      public static void mostrarMenu(){
        int n;
        int comando=-1;
        int esp;
        Scanner scan= new Scanner(System.in);
        System.out.println("Cuantos espacios tiene su parqueadero?"); 
        n=scan.nextInt();
        Sensor.sensores= new Sensor[n];
        
        for(int i=0;i<Sensor.sensores.length;i++){//inicializar los sensores en 0 (libres)
            Sensor.sensores[i]=new Sensor(0);}//inicializar los sensores en 0 (libres)
        
        
        while(comando!=0){
        System.out.println("Ingrese el numero del comando");
        comando=scan.nextInt();
            switch(comando ){
            case 0: 
                break;
            
            case 1:
                System.out.println(Sensor.sensorLibre());
                break;
            
            case 2:
                System.out.println("En que espacio se desea parquear?");
                esp=scan.nextInt();
                if(esp>n){
                    System.out.println("Espacio inexistente");
                    break;
                }
                if((Sensor.sensores[esp]).getEstado()==1){
                    System.out.println("Este espacio esta ocupado");}
                else{
                    System.out.println("Ingrese placa");
                    String p=scan.next();
                    System.out.println("Ingrese marca");
                    String m=scan.next();
                    System.out.println("Ingrese color");
                    String c=scan.next();
                    Vehiculo v=new Vehiculo(p,m,c);
                    (Vehiculo.vehiculos).add(v);
                    (Sensor.sensores[esp]).setEstado(1);
                    System.out.println(v.toString());
                }
                break;
                
            case 3:
              System.out.println("En que espacio se desea parquear?");
                esp=scan.nextInt();
                if(esp>n){
                    System.out.println("Espacio inexistente");
                    break;
                }
                if((Sensor.sensores[esp]).getEstado()==1){
                    System.out.println("Este espacio esta ocupado");}
                else{
                    System.out.println("Ingrese placa");
                    String p=scan.next();
                    System.out.println("Ingrese marca");
                    String m=scan.next();
                    System.out.println("Ingrese color");
                    String c=scan.next();
                    System.out.println("Ingrese valor comercial");
                    int precio=scan.nextInt();
                    Vehiculo v=new Vehiculo(p,m,c,precio);
                    (Vehiculo.vehiculos).add(v);
                    (Sensor.sensores[esp]).setEstado(1);
                    System.out.println(v.toString());
                }
                break; 
                
            case 4:
                System.out.println(Vehiculo.toStringVehiculos(Vehiculo.vehiculos));
                break;
                
            case 5:
                System.out.println("la cantidad de ehiculos parqueados hasta el momento es: "+Vehiculo.cantidadVehiculos());
                break;
                
            case 6:
                System.out.println("ingrese el numero de el espacio para conocer su estado");
                esp=scan.nextInt();
                if((Sensor.sensores[esp]).getEstado()==1){
                    System.out.println("Espacio ocupado");}else{
                    System.out.println("Espacio libre");}
                break;
                
            case 7:
                System.out.println(Sensor.sensorEstado());
                break;
                
            case 8:
                System.out.println("Escriba el color a buscar");
                String c=scan.next();
                System.out.println(Vehiculo.colorVehiculos(c));
                break;
                
            case 9:
                Collections.sort(Vehiculo.vehiculos,Comparator.comparing(Vehiculo::getValorComercial));
                System.out.println(Vehiculo.toStringVehiculos(Vehiculo.vehiculos));
                break;
                
            default:
                System.out.println("Comando incorrecto");  
            }
            
        }
        }
        
      
}
