# CPU — имитация на java
Небольшой проект, в котором разрабатывается модель процессора, способная исполнять код псевдо ассемблера.  
Внутри процессора есть память, с которой он работает, 4 целочисленных регистра, 6 флагов.  
Возможные комманды для процессора:
- "INIT [address] value" — проинициализировать ячейку памяти значением
- "ST [address] register" — загрузить значение из регистра в память
- "LD register [address]" — загрузить в регистр значение из памяти
- "MV register_1 register_2" — загрузить в первый регистр значение второго регистра
- "ADD" — сложить первый и второй регистры, результат записать в четвертый
- "SUB" — вычесть из первого регистра второй, результат записать в четвертый
- "MULT" — перемножить первый и второй регистры, результат записать в четвертый
- "DIV" — разделить первый регистр на второй, результат записать в четвертый
- "CMP register_1 register_2" — сравнить значения двух регистров, результат сохранится в флагах
- "JMP IP" — выполнить безусловный переход к инструкции под номером IP
- "JE +IP", "JLE +IP","JGE +IP","JG +IP","JL +IP","JNE +IP" — выполнить условный переход (переход от текущей инструкции, а не следующей) 
