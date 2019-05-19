package comparator;

import java.util.*;

public class Comparator {
    private Map<String,String> database_tests;
    private Map<String,String> sandbox_tests;

    public Comparator() {
        database_tests = new HashMap<>();
        sandbox_tests = new HashMap<>();
    }

    //Get Tests From DB
    private Map<String, String> getTestsFromDB(int id){
        Problem pr = new Problem();
        return pr.getTeste(id);
    }

    //Get Tests From SandBox
    private Map<String, String> getTestsFromSB(int id){
        Problem pr = new Problem();
        return pr.getTeste(id);
    }

    //Compare Test and compute score
    public int compare_test(int id){
        database_tests = getTestsFromDB(id);
        sandbox_tests = getTestsFromSB(id);
        int nrTest = 1;

        int score = 0;

        for(String k: database_tests.keySet())
        {
            if(database_tests.get(k).equals(sandbox_tests.get(k))){
                score += 25;
                System.out.println("Testul " + nrTest + " este corect");
            }
            else
            {
                System.out.println("Testul "+ nrTest + " este incorect");
            }
            nrTest ++;
        }
        System.out.println("Punctaj: " + score);
        return score;
    }
}

