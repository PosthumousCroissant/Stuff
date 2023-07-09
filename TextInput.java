/*mabe7752 Marcus Bergengren*/

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class TextInput {

    private static final ArrayList<InputStream> TEXT_INPUT_LIST = new ArrayList<>();

    private Scanner input;

    public TextInput() {
        this(System.in);
    }

    public TextInput(InputStream stream) {
        if (TEXT_INPUT_LIST.contains(stream)) {
            throw new IllegalStateException("Error: en instans av klassen existerar redan");
        }
        this.input = new Scanner(stream);
        TEXT_INPUT_LIST.add(stream);

    }

    public String readDogText(String inString) {
        System.out.print(inString + "?>");
        String tmp = input.nextLine();
        return tmp;

    }

    public int readDogInt(String inString) {
        System.out.print(inString + "?>");
        int tmp = input.nextInt();
        input.nextLine();
        return tmp;

    }

    public double readDogDouble(String inString) {
        System.out.print(inString + "?>");
        double tmp = input.nextDouble();
        input.nextLine();
        return tmp;
    }
}
