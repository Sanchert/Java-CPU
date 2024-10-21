package Program;
import Cpu.Command;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Integer.max;
import static java.lang.Integer.min;

public class Program implements IProgram {
    private final int memSize = 500;
    private final Command[] prog = new Command[memSize];
    private int n = 0;
    private static final Map<String, Integer> commandCountMap = new HashMap<>();
    static {
        commandCountMap.put("INIT",  0);
        commandCountMap.put("LD",    0);
        commandCountMap.put("ADD",   0);
        commandCountMap.put("PRINT", 0);
        commandCountMap.put("DIV",   0);
        commandCountMap.put("ST",    0);
        commandCountMap.put("MV",    0);
        commandCountMap.put("SUB",   0);
        commandCountMap.put("MULT",  0);
    }

    @Override
    public void add(Command command) throws Exception {
        if(n >= memSize) throw new Exception("no mem");
        prog[n] = command;
        n++;
        commandCountMap.put(command.GetName(), commandCountMap.get(command.GetName()) + 1);
    }

    public Command get(int ind) throws Exception {
        if((ind < 0) || (ind >= n)) throw new Exception("out of mem");
        return prog[ind];
    }

    public int getN() {
        return n;
    }

    @Override
    public IIterator iterator() {
        return new Iterator(this);
    }

    //самая частая интсрукция
    @Override
    public void frequentInstruction() {
        String maxCountInstruction = commandCountMap.entrySet()
                                                    .stream()
                                                    .max(Map.Entry.comparingByValue())
                                                    .map(Map.Entry::getKey)
                                                    .orElse(null);
        System.out.println(maxCountInstruction);
    }

    // диапазон адресов
    @Override
    public void addressRange() {
        int minAdd = 1023;
        int maxAdd = 0;
        for (int i = 0; i < n; i++) {
            if ("INIT".equals(prog[i].GetName()) || "ST".equals(prog[i].GetName())) {
                minAdd = min(minAdd, Integer.parseInt(prog[i].GetDescription().split(" ")[1]));
                maxAdd = max(maxAdd, Integer.parseInt(prog[i].GetDescription().split(" ")[1]));
            }
        }
        System.out.println("[" + minAdd + "..." + maxAdd + "]"); //collectors grouping by
    }

    // вывод инструкций в порядке возрастания их частоты
    @Override
    public void printInstructions() {
        List<String> sortedInstructions = commandCountMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue()) // Сортируем по значениям
                .map(Map.Entry::getKey) // Берем только ключи
                .collect(Collectors.toList()); // Собираем в список
        System.out.println(sortedInstructions);
    }
}
