package Cpu;
import Program.IIterator;
import Program.IProgram;

public class Executor {
    private final ICPU cpu;

    public Executor(ICPU _cpu) {
        cpu = _cpu;
    }

    private void handleJump(Command command, String commandName, String flag, IIterator progIterator) throws Exception {
        if (command.GetName().equals(commandName)) {
            if (cpu.getFlagState(flag) == 1) {
                progIterator.changeIP(progIterator.getIP() + Integer.parseInt(command.GetArguments()[0]));
            }
            cpu.clearFlagsState();
            command = progIterator.next();
        }
    }

    public void run(IProgram prog) throws Exception {
        IIterator progIterator = prog.iterator();
        while (progIterator.hasNext()) {
            Command command = progIterator.next();

            if (command.GetName().equals("JMP")) {
                progIterator.changeIP(Integer.parseInt(command.GetArguments()[0]));
            }
            handleJump(command,"JE",  "e",  progIterator);
            handleJump(command,"JLE", "le", progIterator);
            handleJump(command,"JGE", "ge", progIterator);
            handleJump(command,"JG",  "g",  progIterator);
            handleJump(command,"JL",  "l",  progIterator);
            handleJump(command,"JNE", "ne", progIterator);

            cpu.exec(command);
        }
    }
}
