package Cpu;

import java.util.Arrays;

public class Command {
    private final String[] arguments;
    private final String name;

    public Command(String description) {
        this.arguments = Arrays.copyOfRange(description.split(" "), 1, description.split(" ").length);
        name = description.split(" ")[0];
    }

    public String[] GetArguments() {
        return arguments;
    }
    public String GetName() { return name; }
}
