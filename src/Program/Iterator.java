package Program;
import Cpu.Command;

public class Iterator implements IIterator {
    private final Program program;
    private int IP = 0; // instruction pointer

    public Iterator(Program program) {
        this.program = program;
    }
    @Override
    public void changeIP(int newIP) throws Exception {
        if (IP < 0 || IP > program.getN()) {
            throw new Exception("index out of range");
        }
        IP = newIP;
    }

    @Override
    public int getIP() {
        return IP;
    }

    @Override
    public boolean hasNext() {
        return IP < program.getN();
    }

    @Override
    public Command next() throws Exception{
        IP++;
        return program.get(IP - 1);
    }
}
