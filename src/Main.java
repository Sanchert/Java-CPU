import Cpu.BCPU;
import Cpu.Command;
import Cpu.Executor;
import Cpu.ICPU;
import Program.*;
public class Main {
    public static void main(String[] args) throws Exception {
        IProgram prog = new Program();
//        /*00*/prog.add(new Command("INIT 10 20"));
//        /*01*/prog.add(new Command("INIT 11 25"));
//        /*02*/prog.add(new Command("INIT 12 5"));
//        /*03*/prog.add(new Command("LD A 10"));
//        /*04*/prog.add(new Command("LD B 11"));
//        /*05*/prog.add(new Command("LD C 12"));
//        /*06*/prog.add(new Command("PRINT"));
//        /*07*/prog.add(new Command("JMP 10"));
//        /*08*/prog.add(new Command("ADD"));
//        /*09*/prog.add(new Command("PRINT"));
//        /*10*/prog.add(new Command("MV A D"));
//        /*11*/prog.add(new Command("MV B C"));
//        /*12*/prog.add(new Command("DIV"));
//        /*13*/prog.add(new Command("PRINT"));


        /*
         пример прграммы на C:
         int A, B, C;
         if(A > B) {
           C = A;
         } else {
           C = B;
         }
        */
        // и как она выглядит в псевдо ассемблере:
        /*[00]00*/prog.add(new Command("INIT 10 100")); // mem[10] = 100
        /*[04]01*/prog.add(new Command("INIT 11 20")); // mem[11] = 20
        /*[08]02*/prog.add(new Command("INIT 12 0")); // mem[12] = 0
        /*[12]03*/prog.add(new Command("PRINT"));      // 0, 0, 0, 0
        /*[16]04*/prog.add(new Command("LD A 10"));    // reg_A = mem[10] (100)
        /*[20]05*/prog.add(new Command("LD B 11"));    // reg_B = mem[11] (20)
        /*[24]06*/prog.add(new Command("CMP A B"));    // reg_A (100) < reg_B (20) false
        /*[28]07*/prog.add(new Command("JLE 4"));      // nop
        /*[32]08*/prog.add(new Command("LD A 10"));    // reg_A = mem[10] (100)
        /*[36]09*/prog.add(new Command("ST 12 A"));    // mem[12] = reg_A (100)
        /*[40]10*/prog.add(new Command("JMP 13"));     //                      -}
        /*[44]11*/prog.add(new Command("LD B 11"));    // reg_B = mem[11] (20)  |
        /*[48]12*/prog.add(new Command("ST 12 B"));    // mem[12] = reg_B ()    |
        /*[52]13*/prog.add(new Command("LD C 12"));    // reg_C = mem[12]     <-}
        /*[56]14*/prog.add(new Command("PRINT"));      // 100, 20, 100, 0

        ICPU cpu = BCPU.build();
        Executor exec = new Executor(cpu);
        exec.run(prog);

//        ProgramAnalyzer pa = new ProgramAnalyzer();
//        pa.init(prog);
//        pa.frequentInstruction();
//        pa.printInstructions();
    }
}
