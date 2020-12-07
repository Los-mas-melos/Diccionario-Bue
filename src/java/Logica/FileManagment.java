package Logica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileManagment implements Serializable {
    
//  String fileUsers = "src/java/Datos/Usuarios.txt";
    private String fileData;
    private Path rootData;
    private File f;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    
    public FileManagment() {
    }
    
    public void setPath(String filePath) {
        this.fileData = filePath;
        this.rootData = Paths.get(fileData);
        this.f = rootData.toFile();
    }
    
    public void writeObject(Object object, String path) {
        try {
            oos = new ObjectOutputStream(new FileOutputStream(path));
            oos.writeObject(object);
            oos.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
        
    public Object readObject(String path) {
        Object object;
        
        try {
            ois = new ObjectInputStream(new FileInputStream(path));
            object = ois.readObject();
            
            return object;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return null;
    }
    
}
