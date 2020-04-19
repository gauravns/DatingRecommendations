package factory;

import model.InputType;
import service.FileInput;
import service.InputService;

public class InputFactory {

    public static InputService getInputFrom(InputType inputType) {
        switch (inputType) {
            case FILE: return new FileInput("./src/input.txt");
            default: return new FileInput("./src/input.txt");
        }
    }
}
