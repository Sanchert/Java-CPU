package Program;

import Cpu.Command;

public interface IProgram {
    void add(Command command) throws Exception;

    IIterator iterator();

    void frequentInstruction();

    void addressRange();

    void printInstructions();
}
