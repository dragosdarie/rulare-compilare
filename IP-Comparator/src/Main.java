import java.nio.file.Paths;


public class Main {

    public static void main(String[] args) {

        Comp comparator = new Comp();
 /*     comparator.getInput("E:\\CURSURI\\AN 2\\SEM 2\\IP-Comparator\\inputuri Problema1.txt");
        comparator.getOutput("E:\\CURSURI\\AN 2\\SEM 2\\IP-Comparator\\outputuri Problema1.txt");
        comparator.test("2 3","da", 1);
        comparator.test("2 5","nu", 2);
        comparator.test("5 6","nu", 3);
        comparator.test("7 2","nu", 4);
        System.out.println("Numar teste corecte: " + comparator.getNumarTesteCorecte()); */


        comparator.testing(1,Paths.get("E:\\CURSURI\\AN 2\\SEM 2\\IP-Comparator\\Problema1\\outputTest1.txt"), Paths.get("E:\\CURSURI\\AN 2\\SEM 2\\IP-Comparator\\Problema1\\outputTest3.txt"));
        comparator.testing(2,Paths.get("E:\\CURSURI\\AN 2\\SEM 2\\IP-Comparator\\Problema1\\outputTest1.txt"), Paths.get("E:\\CURSURI\\AN 2\\SEM 2\\IP-Comparator\\Problema1\\outputTest4.txt"));
        System.out.println("Numar teste corecte: " + comparator.getNumarTesteCorecte());
    }
}
