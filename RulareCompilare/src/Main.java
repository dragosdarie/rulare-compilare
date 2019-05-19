import comparator.Comparator;
import compilare.rulare.CompileRunC;
import compilare.rulare.Utils;

public class Main {
    //ForTest
    public static void main(String[] args)
    {
        String apthForTest = "D:\\\\Faculty\\\\IngineriaProgramarii\\\\GitIP\\\\rulare-compilare\\\\RulareCompilare\\\\CFiles\\\\helloWorld.cpp";
        CompileRunC compileRunC = new CompileRunC();
        Utils.FileOutputInfo info = compileRunC.CompileCType(apthForTest);

        System.out.println(compileRunC.runFile("helloWorld","2"));

        Comparator comp = new Comparator();

        System.out.println(comp.compare_test(3));
    }
}
