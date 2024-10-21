package Program;
import Cpu.Command;

public class Iterator implements IIterator {
    private final Program program;
    private int i = 0;

    public Iterator(Program program) {
        this.program = program;
    }

    @Override
    public boolean hasNext() {
        return i < program.getN();
    }

    @Override
    public Command next() throws Exception{
        i++;
        return program.get(i - 1);
    }
}
