 
// Import required java libraries
import java.io.*;
import javax.tools.*;
import javax.servlet.*;
import javax.servlet.http.*;

// Extend HttpServlet class
public class getSolution extends HttpServlet {
 
   private String message;

   public void init()  {
      // Do required initialization

   }



   public  void createInputFile (String name)  throws IOException{

      String path = "./Docker/"+name;
      // Use relative path for Unix systems
      File f = new File(path);
      
      f.getParentFile().mkdirs(); 
      f.createNewFile();   
   


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
         
      


     if(total.contains("error")==true)
     out.println(docType +
     "<html>\n" +
        "<body>\n" +
               "<p>" + total + "</p>" + "\n" +
        "</body>" +
     "</html>"
  );

      else 
     {
      out.println(docType +
         "<html>\n" +
            "<body>\n" +
                   "<p>" + "Fisier compilat cu succes" + "</p>" + "\n" +
            "</body>" +
         "</html>"
      );
      createInputFile("qwert.in");
     
   }

      out.close();

      }


   public void destroy() {
      // do nothing.
   }
}




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