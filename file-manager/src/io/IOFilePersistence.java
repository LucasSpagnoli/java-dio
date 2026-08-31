package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.stream.Stream;

public class IOFilePersistence extends FilePersistence {



    public IOFilePersistence(String fileName) throws IOException {
        super(fileName);
        var file = new File(currentDir + storageDir);
        if (!file.exists() && !file.mkdirs()) throw new IOException("Erro ao criar arquivo");
        clearFile();
    }

    private void createFile() {

    }

    @Override
    public String write(String data) {
        try (
                var fileWriter = new FileWriter(currentDir + storageDir + fileName, true);
                var bufferedWriter = new BufferedWriter(fileWriter);
                var printWriter = new PrintWriter(bufferedWriter);
        ) {
            printWriter.println(data);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return data;
    }

    @Override
    public boolean remove(String sentence) {
        var content = this.findAll();
        var contentList = new ArrayList<>(Stream.of(content.split(System.lineSeparator())).toList());
        if (contentList.stream().noneMatch(c -> c.contains(sentence))) return false;
        clearFile();
        contentList.stream().filter(c -> c.contains(sentence)).forEach(this::write);
        return true;
    }

    @Override
    public String replace(String oldContent, String newContent) {
        var content = this.findAll();
        var contentList = new ArrayList<>(Stream.of(content.split(System.lineSeparator())).toList());
        if (contentList.stream().noneMatch(c -> c.contains(oldContent))) return "";
        clearFile();
        contentList.stream().map(c -> c.contains(oldContent) ? newContent : c).forEach(this::write);
        return newContent;
    }

    @Override
    public String findAll() {
        var content = new StringBuilder();
        try (var reader = new BufferedReader(new FileReader(currentDir + storageDir + fileName))) {
            String line;
            do {
                line = reader.readLine();
                if (line != null) content
                        .append(line)
                        .append(System.lineSeparator());
            } while (line != null);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    @Override
    public String findBy(String sentence) {
        String found = "";
        try (var reader = new BufferedReader(new FileReader((currentDir + storageDir + fileName)))) {
            String line = reader.readLine();
            while (line != null) {
                if (line.contains(sentence)) {
                    found = line;
                    break;
                }
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return found;
    }
}
