import java.util.*;

public class Comparator {

    private int score;
    private int nrTesteCorecte;
    private Map<String,String> database_tests;
    private Map<String,String> sandbox_tests;

    public Comparator() {
        nrTesteCorecte = 0;
        score = 0;
        database_tests = new HashMap<String, String>();
        sandbox_tests = new HashMap<String, String>();
    }

    //Get Tests From DB
    public Map<String, String> getTestsFromDB(int id){
        Problem pr = new Problem();
        return pr.getTeste(id);
    }


    //Get Tests From SandBox
    public Map<String, String> getTestsFromSB(int id){
        Problem pr = new Problem();
        return pr.getTeste(id);
    }

    //Compare Test and compute score
    public int compare_test(int id){

        database_tests = getTestsFromDB(id);
        sandbox_tests = getTestsFromSB(id);
        int nrTest = 1;

        for(String k: database_tests.keySet())
        {
            if(database_tests.get(k).equals(sandbox_tests.get(k))){
                score += 25;
                nrTesteCorecte ++;
                System.out.println("Testul "+ nrTest + " este corect");
            }
            else
            {
                System.out.println("Testul "+ nrTest + " este incorect");
            }
            nrTest ++;
        }
        System.out.println("Punctaj: ");
        return getScore();
    }

    public int getScore(){
        return score;
    }

    public int getNrTesteCorecte() {
        return nrTesteCorecte;
    }
}

