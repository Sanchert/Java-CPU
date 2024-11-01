package Program;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ProgramAnalyzer {
    IIterator iterator;
    private static final Map<String, Integer> commandMap = new HashMap<>();
    public void init(IProgram p) throws Exception {
        iterator = p.iterator();
        while (iterator.hasNext()) {
            String key = iterator.next().GetName();
            commandMap.put(key, commandMap.getOrDefault(key, 0) + 1);
        }
    }

    public void frequentInstruction() {
        String maxCountInstruction = commandMap.entrySet()
                                               .stream()
                                               .max(Map.Entry.comparingByValue())
                                               .map(Map.Entry::getKey)
                                               .orElse(null);
        System.out.println("Most used instruction: " + maxCountInstruction);
}

//    public void addressRange() {
//        int minAdd = 1023;
//        int maxAdd = 0;
//        System.out.println("[" + minAdd + "..." + maxAdd + "]"); //collectors grouping by
//    }

    public void printInstructions() {
        Map<String, Integer> sortedInstructions = commandMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
        System.out.println(sortedInstructions);
    }
}
