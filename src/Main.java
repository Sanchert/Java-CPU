import Cpu.BCPU;
import Cpu.Command;
import Cpu.Executor;
import Cpu.ICPU;
import Program.*;
public class Main {
    public static void main(String[] args) throws Exception {
        IProgram prog = new Program();
        prog.add(new Command("INIT 10 20"));
        prog.add(new Command("INIT 11 25"));
        prog.add(new Command("INIT 12 5"));
        prog.add(new Command("LD A 10"));
        prog.add(new Command("LD B 11"));
        prog.add(new Command("LD C 12"));
        prog.add(new Command("ADD"));
        prog.add(new Command("PRINT"));
        prog.add(new Command("MV A D"));
        prog.add(new Command("MV B C"));
        prog.add(new Command("DIV"));
        prog.add(new Command("PRINT"));

        ICPU cpu = BCPU.build();
        Executor exec = new Executor(cpu);
        exec.run(prog);

        ProgramAnalyzer pa = new ProgramAnalyzer();
        pa.init(prog);
        pa.frequentInstruction();
        pa.printInstructions();
    }
}
