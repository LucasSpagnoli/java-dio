package io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.stream.Stream;

// o java.io serve para velocidade e simplicidade no gerenciamento de arquivos, o nio é para aplicações mais complexas
public class NIOFilePersistence extends FilePersistence {


    public NIOFilePersistence(String fileName) throws IOException {
        super(fileName);
        var file = new File(currentDir + storageDir);
        if (!file.exists() && !file.mkdirs()) throw new IOException("Erro ao criar arquivo");
        clearFile();
    }

    @Override
    public String write(String data) {
        try (var file = new RandomAccessFile(new File(currentDir + storageDir + fileName), "rw");) {
            file.seek(file.length());
            file.writeBytes(data);
            file.writeBytes(System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public boolean remove(String sentence) {
        var content = findAll();
        var contentList = Stream.of(content.split(System.lineSeparator())).toList();
        if (contentList.stream().noneMatch(c -> !c.contains(sentence))) return false;
        clearFile();
        contentList.stream().filter(c -> c.contains(sentence)).forEach(this::write);
        return true;
    }

    @Override
    public String replace(String oldContent, String newContent) {
        var content = findAll();
        var contentList = Stream.of(content.split(System.lineSeparator())).toList();
        if (contentList.stream().noneMatch(c -> c.contains(oldContent))) return "";
        clearFile();
        contentList.stream().map(c -> c.contains(oldContent) ? newContent : c).forEach(this::write);
        return newContent;
    }

    @Override
    public String findAll() {
        var content = new StringBuilder();
        try (
                var file = new RandomAccessFile(new File(currentDir + storageDir + fileName), "r");
                var channel = file.getChannel();
        ) {
            var buffer = ByteBuffer.allocate(256);
            var bytesReader = channel.read(buffer);
            while (bytesReader != -1) {
                buffer.flip();
                while (buffer.hasRemaining()) {
                    content.append((char) buffer.get());
                }
                buffer.clear();
                bytesReader = channel.read(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    @Override
    public String findBy(String sentence) {
        var content = new StringBuilder();
        try (
                var file = new RandomAccessFile(new File(currentDir + storageDir + fileName), "r");
                var channel = file.getChannel();
        ) {
            var buffer = ByteBuffer.allocate(256);
            var bytesReader = channel.read(buffer);
            while (bytesReader != -1) {
                buffer.flip();
                while (buffer.hasRemaining()) {
                    while (!content.toString().endsWith(System.lineSeparator())) {
                        content.append((char) buffer.get());
                    }
                    if (content.toString().contains(sentence)) {
                        return content.toString();
                    } else {
                        content.setLength(0);
                    }
                    if (content.isEmpty()) break;
                }
                buffer.clear();
                bytesReader = channel.read(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }
}
