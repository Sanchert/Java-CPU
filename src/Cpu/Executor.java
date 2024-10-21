package Cpu;
import Program.IIterator;
import Program.IProgram;

public class Executor {
    private final ICPU cpu;

    public Executor(ICPU _cpu) {
        cpu = _cpu;
    }

    public void run(IProgram prog) throws Exception {
        IIterator prog_it = prog.iterator();
        while (prog_it.hasNext()) {
            cpu.exec(prog_it.next());
        }
    }
}
