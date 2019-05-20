import java.util.*;

public class Comparator {

//
//    Problem pr = new Problem();
//
//
//    Dictionary dict_bd = pr.getTeste(1);
//    System.out.println(dict_bd);
//

    //INIT
    private int score;
    private Map<String,String> database_tests;
    private Map<String,String> sandbox_tests;

    public Comparator() {
        score = 0;
        database_tests = new HashMap<String, String>();
        sandbox_tests = new HashMap<String, String>();
    }

    //Get Test From DB
    public Map<String, String> getTestFromDB(int id){
        Problem pr = new Problem();
        return pr.getTeste(id);
    }


    //Get Test From SandBox
    public Map<String, String> getTestsFromSB(int id){
        Problem pr = new Problem();
        return pr.getTeste(id);
    }


    //Compare Test and compute score
    public int compare_test(int id){

        database_tests = getTestFromDB(id);
        sandbox_tests = getTestsFromSB(id);

        for(String k: database_tests.keySet())
        {
            if(database_tests.get(k).equals(sandbox_tests.get(k))){
                score += 25;
            }
        }

        return score;
    }


    //return score to database
    public int getScore(){
        return score;
    }


}
