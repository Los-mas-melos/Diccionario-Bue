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
//        User user1 = new User("us1", "correo1", "contraseña1");
//        User user2 = new User("us2", "correo2", "contraseña2");
//        SimplyLinkedList<User> listUsers = new SimplyLinkedList();
//        listUsers.insert(user1);
//        listUsers.insert(user2);
//        listUsers.insert(user1);
//        FileManagment fileUsers = new FileManagment("src/java/Datos/Usuarios.bin");
//        fileUsers.writeObject(listUsers);
//        
//        SimplyLinkedList<User> list2 = (SimplyLinkedList<User>)fileUsers.readObject();
//        System.out.println(list2.toString());
        
        float end_Time = System.nanoTime();
        System.out.println("Tiempo en nanosegundos: "+(end_Time-start_Time));
        System.out.println("Tiempo en segundos: "+((end_Time-start_Time)/1000000000));

    }

}
