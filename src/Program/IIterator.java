package Program;
import Cpu.Command;

public interface IIterator {
    boolean hasNext();
    Command next() throws Exception;
}
