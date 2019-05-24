

import java.util.ArrayList;

public class testCaseList{


   private ArrayList<String> input = new ArrayList<>();
   private ArrayList<String> output = new ArrayList<>();
   private ArrayList<Integer> id_test = new ArrayList<>();
   private int testCount;

   public testCaseList(){

         testCount=0;

   }


   public void addTestCase(Integer id, String input_str, String output_str){

      id_test.add(id);
      input.add(input_str);
      output.add(output_str);
      
      testCount++;

   }


   public String getTestInput(Integer id){

      int i = id_test.indexOf(id);
      return input.get(i);

   }


   public String getTestOutput(Integer id){

      int i = id_test.indexOf(id);
      return output.get(i);

   }



   public int getTestCount(){

      return testCount;

   }

   public void flush(){

        input.clear();
        output.clear();
        id_test.clear();
        testCount=0;

   }



}