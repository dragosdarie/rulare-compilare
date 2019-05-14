 
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

   public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      
      // Set response content type
      response.setContentType("text/html");

      PrintWriter out = response.getWriter();
      String cod= request.getParameter("sol");
      String docType =
         "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
         
      out.println(docType +
         "<html>\n" +
            "<body>\n" +
                   "<p>" + cod + "</p>" + "\n" +
            "</body>" +
         "</html>"
      );

      // punem codul din textbox in fisierul main.c

      PrintWriter scriitor = new PrintWriter("Docker/main.c");

      scriitor.println(cod);

      scriitor.close();



      PrintWriter scriitor2 = new PrintWriter("Docker/test.txt");

      Runtime.getRuntime().exec("docker build -t compile-run ./Docker");
      Process p2 = Runtime.getRuntime().exec("docker run compile-run");




      BufferedReader stdout = new BufferedReader(new InputStreamReader(p2.getInputStream()));

      String s = null;
      while ((s = stdout.readLine()) != null){
         scriitor2.println(s);
      }


      scriitor2.close();

   }

   public void destroy() {
      // do nothing.
   }
}




// Se da fisierul vector.in in care se afla numarul de elem. unui vector
// de numere intregi pe prima linie si toate elementele sale pe a doua linie.
// Sa se sorteze crescator vectorul si sa se scrie pe o singura linie in fisierul vector.out .