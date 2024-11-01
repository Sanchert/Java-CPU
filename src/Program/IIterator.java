package Program;
import Cpu.Command;

public interface IIterator {
    void changeIP(int newIP) throws Exception;
    int getIP();
    boolean hasNext();
    Command next() throws Exception;
}
