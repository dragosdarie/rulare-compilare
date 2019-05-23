 
// Import required java libraries
import java.io.*;
import javax.tools.*;


import javax.servlet.*;
import javax.servlet.http.*;
import java.util.HashMap;
import java.util.Scanner;
import java.io.*;

// Extend HttpServlet class
public class getSolution extends HttpServlet {
 
   private String message;
   private HashMap<String, String> testInput;

   public void init()  {
      // Do required initialization
   
   }

   public void initializarePerechiIO(){
      testInput = new HashMap<>();
      testInput.put("5 3", "8");
      testInput.put("-1 7", "6");
      testInput.put("7 13", "20");
      testInput.put("0 0", "0");
   }

   public boolean compareOutput(String s1, String s2){
      return s1.trim().equals(s2.trim());
   }

   public  int generareScor (String name)  throws IOException{ //  HashMap <int , Boolean >

      int iteratii=0;

      String path = "./Docker/" + name;
      // Use relative path for Unix systems
      File f = new File(path);
      
      f.getParentFile().mkdirs();
      f.createNewFile();

      initializarePerechiIO();
      int scor = 0;   
      FileWriter fileWriter;
      PrintWriter printWriter;
      for (String i : testInput.keySet()){

         fileWriter = new FileWriter(f);
         printWriter = new PrintWriter(fileWriter);
         printWriter.print(i);
         printWriter.close();  //punem in fisierul creat cheia hashmapului
         fileWriter.close();
         
         Process tempProcess = Runtime.getRuntime().exec("./sandbox.sh");

         try{
            tempProcess.waitFor();
         }
         catch(Exception e){
            return 1000;
         }
         
         BufferedReader br = new BufferedReader(new FileReader("./Docker/sandbox/output.txt")); 
  
         String st =  br.readLine();

         //String st="0";
         
         if(compareOutput(st, testInput.get(i)) == true )    //scor = scor +1;
         
         iteratii++;

      }
      return scor;

   }

   public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      
      // Set response content type
      response.setContentType("text/html");

      PrintWriter out = response.getWriter();
      String cod= request.getParameter("sol");

      // punem codul din textbox in fisierul main.c

      PrintWriter scriitor = new PrintWriter("Docker/main.c");

      scriitor.println(cod);

      scriitor.close();


         /*
      //Runtime.getRuntime().exec("echo test > testfile");
      Process p2 = Runtime.getRuntime().exec("./sandbox.sh");


      String total = "";

      BufferedReader stdout = new BufferedReader(new InputStreamReader(p2.getInputStream()));

      String s = null;
      while ((s = stdout.readLine()) != null){
         total=total + s + "<br>";
      }
   


      
      String docType =
         "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
   
      int val;

      if(total.contains("error")==true)
         out.println(docType +
         "<html>\n" +
            "<body>\n" +
               "<p>" + "Eroare compilare" + "</p>" + "\n" +
            "</body>" +
         "</html>");

      else {

     
   }

   */

  String docType =
  "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";

   int val = generareScor("suma.in");


   out.println(docType +
      "<html>\n" +
         "<body>\n" +
            "<p>" + "Fisier compilat cu succes. Scor: " + val + "</p>" + "\n" +
         "</body>" +
      "</html>"
   );



      out.close();

      }


   public void destroy() {
      // do nothing.
   }
}


/*

boolean compareOutput(){

   luam cheia din hashmap(inputul) si il punem in fisierul cu numele exact ca in enuntul problemei
   fisierul cu inputul sa se afle in folderul docker
   se ruleaza docker
   outputul la ecran se afla in Docker/sandbox/output.txt
   se ia outputul sub forma de string si se compara cu valoarea din hashmap (outputul) 

   daca e egal, return true
   else return false
}


*/







// Se da fisierul vector.in in care se afla numarul de elem. unui vector
// de numere intregi pe prima linie si toate elementele sale pe a doua linie.
// Sa se sorteze crescator vectorul si sa se scrie pe o singura linie in fisierul vector.out .


//docker build -t comp .



//docker run -it --name=container2  --user 1001:1001 -v /home/ursul/dockertest2:/home/ursul/safehouse comp



/*



      Runtime.getRuntime().exec("docker build -t compile-run ./Docker");
      Runtime.getRuntime().exec("docker rm ip-container");
      Runtime.getRuntime().exec("docker run --name=ip-container compile-run");
      Runtime.getRuntime().exec("docker cp ip-container:/sandbox/output.txt ./Docker");
      Runtime.getRuntime().exec("echo test > ./Docker/testfile");




#include <stdio.h>

int main(){

   printf("salut!\n");
   return 0;

}





-------------------------------------------------

#include <fstream>

using namespace std;


ifstream fin("vector.in");
ofstream fout("vector.out");

void printData(int n, int v[]) {
    for (int i = 0; i < n; i++)
        fout << v[i] << ' ';
}

void bubbleSort(int n, int v[]) {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n -1; j++) {
            if (v[j] > v[j + 1]) {
                int aux = v[j];
                v[j] = v[j + 1];
                v[j + 1] = aux;
            }
        }
    }
    printData(n, v);
}

void readData() {
    int n, v[101];
    fin >> n;
    for (int i = 0; i < n; i++) {
        fin >> v[i];
    }

    bubbleSort(n, v);
}

int main() {
    readData();
    
    return 0;
}




-----------------------------------




FROM gcc:4.9
RUN adduser --disabled-password --gecos "" --uid 1001 ursul
COPY . /home/ursul
WORKDIR /home/ursul
RUN gcc main.c
RUN mkdir safehouse
RUN ./a.out > /home/ursul/output.txt
*/

//docker cp container2:/home/ursul/output.txt .
