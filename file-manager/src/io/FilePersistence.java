package io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public abstract class FilePersistence {
    protected final String currentDir = System.getProperty("user.dir");
    protected final String storageDir = "/managedFiles/IO/";
    protected final String fileName;

    public FilePersistence(String fileName) {
        this.fileName = fileName;
    }

    public abstract String write(final String data);

    public abstract boolean remove(final String sentence);

    public abstract String replace(final String oldContent, final String newContent);

    public abstract String findAll();

    public abstract String findBy(final String sentence);

    protected void clearFile() {
        try (OutputStream outputStream = new FileOutputStream(currentDir + storageDir + fileName)) { // serve para classes com autoclosable, se declarar com try-with-resources a classe fecha automaticamente
            System.out.println("Inicializando recursos em " + currentDir + storageDir + fileName);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
