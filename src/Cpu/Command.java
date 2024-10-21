package Cpu;

public class Command {
    private final String description;
    private final String name;

    public Command(String _description) {
        description = _description;
        name = _description.split(" ")[0];
    }

    public String GetDescription() {
        return description;
    }
    public String GetName() { return name; }
}
