import compilare.rulare.CompileRunC;
import compilare.rulare.Utils;

public class Main {
    //ForTest
    public static void main(String[] args)
    {
        CompileRunC compileRunC = new CompileRunC();
        Utils.FileOutputInfo info= compileRunC.CompileCType("D:\\Faculty\\IngineriaProgramarii\\GitIP\\rulare-compilare\\RulareCompilare\\CFiles\\helloWorldv2.cpp");
        System.out.println(info.Output.Output);
    }
}
