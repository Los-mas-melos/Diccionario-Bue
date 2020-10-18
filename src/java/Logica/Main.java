package Logica;

public class Main {

    public static void main(String[] args) {
        float start_Time = System.nanoTime();
        Diccionario BueEsp = new Diccionario();
//        int tamañoBueEsp = BueEsp.size;
//        for (int i = tamañoBueEsp; i < tamañoBueEsp + 100000; i++) {
//            BueEsp.ingresarEntrada("aloha", "quiubo");
//        }

//        FALLA '.buscarPalabra()'
//        System.out.println(BueEsp.buscarPalabra("chica"));

        float end_Time = System.nanoTime();
        System.out.println("Tiempo en nanosegundos: "+(end_Time-start_Time));
        System.out.println("Tiempo en segundos: "+((end_Time-start_Time)/1000000000));

    }

}
