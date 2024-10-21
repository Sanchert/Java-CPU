package Cpu;

import java.util.HashMap;
import java.util.Map;

public class CPU implements ICPU {
    private final int[] memory;
    private static final Map<String, Integer> registers = new HashMap<>();

    public CPU() {
        memory = new int[1024];
        registers.put("A", 0);
        registers.put("B", 0);
        registers.put("C", 0);
        registers.put("D", 0);
    }

    @Override
    public void exec(Command command) {
        String description = command.GetDescription();
        switch (description.split(" ")[0]) {
            case "ADD" :
                registers.put("D", registers.get("A") + registers.get("B"));
                break;
            case "DIV" :
                registers.put("D", registers.get("A") / registers.get("B"));
                break;
            case "INIT" :
                memory[Integer.parseInt(description.split(" ")[1])] =
                       Integer.parseInt(description.split(" ")[2]);
                break;
            case "LD" :
                registers.put(description.split(" ")[1],
                              memory[Integer.parseInt(description.split(" ")[2])]);
                break;
            case "MULT" :
                registers.put("D", registers.get("A") * registers.get("B"));
                break;
            case "MV" :
                registers.put(description.split(" ")[1], registers.get(description.split(" ")[2]));
                break;
            case "PRINT" :
                System.out.printf("A = " + registers.get("A") + ", B = " + registers.get("B") +
                                  ", C = " + registers.get("C") + ", D = " + registers.get("D") + "\n");
                break;
            case "ST" :
                memory[Integer.parseInt(description.split(" ")[1])] =
                           registers.get(description.split(" ")[2]);
                break;
            case "SUB" :
                registers.put("D", registers.get("A") - registers.get("B"));
                break;
        }
    }
}
