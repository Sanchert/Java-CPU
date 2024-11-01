package Cpu;

public interface ICPU {
        void exec(Command command);
        int getFlagState(String compare);
        void clearFlagsState();
}
