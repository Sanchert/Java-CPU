package Program;
import Cpu.Command;

public class Program implements IProgram {
    private final int memSize = 1024;
    private final Command[] prog = new Command[memSize];
    private int n = 0;

    @Override
    public void add(Command command) throws Exception {
        if(n >= memSize) throw new Exception("no mem");
        prog[n] = command;
        n++;
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
}
