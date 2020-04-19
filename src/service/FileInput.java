package service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileInput implements InputService {
    private String filePath;

    public FileInput(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<String> readInput() {

        List<String> inputs = new ArrayList<>();
        try {
            inputs = Files.readAllLines(Paths.get(filePath));

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return inputs;
    }
}
