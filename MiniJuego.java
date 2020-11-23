import java.util.Random;
import java.util.Scanner; 
public class MiniJuego {
    private Bichos bichos[][] = new Bichos[2][2]; 
    
    public MiniJuego() { 
        llenarBichos();
        jugar();
    }
    
    public void jugar() {
        int pos;
        while(true) {
            imprimirMatriz();
            System.out.println("A qué posición deseas disparar?");
            //estan enumerados de izquierda a derecha de arriba hacia abajao
            Scanner scan = new Scanner(System.in);
            pos = scan.nextInt();
            switch (pos){
                case 1:
                    disparar(bichos[0][0]);
                    break;
                case 2:
                    disparar(bichos[0][1]);
                    break;
                case 3:
                    disparar(bichos[1][0]);
                    break;
                case 4:
                    disparar(bichos[1][1]);
                    break;
                default:
                    System.out.println("Esa posición no existe");
                    break;
            }
            if(contarBichosVivos()==0){
                System.out.println("Ganaste el juego!");
                break;
            }
        }
    }
    
    public void disparar(Bichos b) {
        if(b!=null){
            if(b.getSalud() > 0) {
                b.setSalud(b.getSalud() - 5);
            }   
        } else{
            System.out.println("La posición está vacía, dispare a otro lado");
        }
    }
    
    public int contarBichosVivos() {
        int cont = 0;
        for(int i = 0; i < bichos.length; i++){
            for(int j = 0; j < bichos[i].length; j++){
                if(bichos[i][j] != null && bichos[i][j].getSalud()>0) {
                    cont++;
                }
            }
        }
        return cont;
    }
    
    public void llenarBichos(){
        Random r = new Random();
        int nBichos = r.nextInt(4-1)+1;
        int fila=0;
        int col=0;
        for(int i=0;i<nBichos;i++){
            Random r1 = new Random();
            int tipo = r.nextInt(2);
            if(tipo==1){
                bichos[fila][col]= new BichosNormales();
            }else{
                bichos[fila][col]= new BichosAliens();
            }
            if(fila==0 && col==0){
                col++;
            } else if(fila==0 && col==1){
                fila++;
                col=0;
            } else if(fila==1 && col==0){
                col++;
            }
        }
    }
    
    public void imprimirMatriz(){
        for(int i=0;i<bichos.length;i++){
            System.out.println("-------------");
            for(int j=0;j<bichos[i].length;j++){
                if(bichos[i][j] != null){
                    if(bichos[i][j] instanceof BichosNormales){
                        System.out.print("|BN-"+bichos[i][j].getSalud());
                    } else{
                        System.out.print("|BA-"+bichos[i][j].getSalud());
                    }
                } else{
                    System.out.print("|     ");
                }
           }
           System.out.println("|");
        }
        System.out.println("-------------");
    }
    
    public static void main(String [] args) {
        
        MiniJuego mj = new MiniJuego();
   
    }
}