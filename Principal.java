import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;

public class Principal{

      public static void main(String[] args){
          Principal.mostrarMenu();
      }   
      
      public static void mostrarMenu(){
          int n;
          double vmoto,vcarro;
          int comando=-1;
          int esp;
          Scanner scan= new Scanner(System.in);
          System.out.println("Cuantos espacios tiene su parqueadero?"); 
          n=scan.nextInt();
          System.out.println("Cuanto vale la hora de una moto?");
          vmoto=scan.nextDouble();
          System.out.println("Cuanto vale la hora de un carro?");
          vcarro=scan.nextDouble();
          Sensor.sensores= new Sensor[n];
          Vehiculo.vehiculos= new Vehiculo[n];
          
            
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
                      esp=scan.nextInt()-1;
                      if(esp>=n){
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
                          System.out.println("Ingresetipo de vehiculo");
                          String t=scan.next();
                          t=t.toLowerCase();
                          Vehiculo v;
                          if(t.equals("carro")){
                              v=new Carro(p,m,c);
                          }
                          else if(t.equals("moto")){
                              v=new Moto(p,m,c);
                          }
                          else{System.out.println("tipo de vehiculo no reconocido");
                              break;
                          }
                          Vehiculo.vehiculos[esp]=v;
                          (Sensor.sensores[esp]).setEstado(1);
                          System.out.println(v.toString());
                      }
                      break;
                        
                  case 3:
                    System.out.println("En que espacio se desea parquear?");
                      esp=scan.nextInt()-1;
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
                          System.out.println("Ingresetipo de vehiculo");
                          String t=scan.next();
                          t=t.toLowerCase();
                          Vehiculo v;
                          if(t.equals("carro")){
                              v=new Carro(p,m,c,precio);
                          }
                          else if(t.equals("moto")){
                              v=new Moto(p,m,c,precio);
                          } 
                          else{System.out.println("tipo de vehiculo no reconocido");
                              break;
                          }
                          Vehiculo.vehiculos[esp]=v;
                          (Sensor.sensores[esp]).setEstado(1);
                          System.out.println(v.toString());
                      }
                      break; 
                        
                  case 4:
                      System.out.println(Vehiculo.toStringVehiculos(Vehiculo.vehiculos));
                      break;
                        
                  case 5:
                      System.out.println("la cantidad de vehiculos parqueados hasta el momento es: "+Vehiculo.cantidadVehiculos());
                      break;
                        
                  case 6:
                      System.out.println("ingrese el numero de el espacio para conocer su estado");
                      esp=scan.nextInt()-1;
                      if(esp>=n){
                          System.out.println("Espacio inexistente");
                          break;
                      }
                      if((Sensor.sensores[esp]).getEstado()==1){
                          System.out.println("Espacio ocupado");
                      }else{
                          System.out.println("Espacio libre");
                      }
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
                      Vehiculo [] a = new Vehiculo[n];
                      int h=0;
                      for (int i=0; i<n; i++){
                          if(Vehiculo.vehiculos[i] != null){
                              a[h]=Vehiculo.vehiculos[i];
                              h++;
                          }
                      }
                      
                      for(int i=0; i<n; i++){
                          for(int j=0; j<n-1; j++){
                              if(a[j]!= null && a[j+1] != null && a[j].getValorComercial()<a[j+1].getValorComercial()){
                                  Vehiculo b;
                                  if(a[j].tipo().equals("carro")){
                                      b = new Carro(a[j].getPlaca(), a[j].getMarca(), a[j].getColor(), a[j].getValorComercial());
                                  }
                                  else{
                                      b = new Moto(a[j].getPlaca(), a[j].getMarca(), a[j].getColor(), a[j].getValorComercial());
                                  }
                                  // falta aclarar el tipo de vehiculo 
                                  a[j]=a[j+1];
                                  a[j+1]=b;
                              }
                          }
                      }
                      System.out.println(Vehiculo.toStringVehiculos(a));
                      break;
                  case 10:
                      Date salida=new Date();
                      Date entrada;
                      double horas;
                      System.out.println("En que espacio estaba parqueado");
                      esp=scan.nextInt()-1;
                      Vehiculo v=Vehiculo.vehiculos[esp];
                      if (v==null){
                          System.out.println("ese espacio estaba desocupado");
                          break;
                      }
                      entrada=v.getEntrada();
                      double mlsegundos=(salida.getTime()-entrada.getTime());
                      Vehiculo.vehiculos[esp]=null;
                      Sensor.sensores[esp].setEstado(0);
                      if(v.tipo().equals("carro")){
                          System.out.println("El valor a pagar es: " + mlsegundos*vcarro/3600000 );
                          break;
                      }
                      else{
                          System.out.println("El valor a pagar es: " + mlsegundos*vmoto/3600000 );
                          break;
                      }
                      
                      
                  default:
                      System.out.println("Comando incorrecto");
                      break;
             }            
          }
      }   
}
