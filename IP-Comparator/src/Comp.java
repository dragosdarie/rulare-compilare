import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;

public class Comp {

    private ArrayList<String> problemInput;
    private ArrayList<String> problemOutput;
    private int numarTesteCorecte;

    public Comp()
    {
        problemInput = new ArrayList<>();
        problemOutput = new ArrayList<>();
    }

    boolean sameContent(Path file1, Path file2) throws IOException {
        final long size = Files.size(file1);
        if (size != Files.size(file2))
            return false;

        if (size < 4096)
            return Arrays.equals(Files.readAllBytes(file1), Files.readAllBytes(file2));

        try (InputStream is1 = Files.newInputStream(file1);
             InputStream is2 = Files.newInputStream(file2)) {

            int data;
            while ((data = is1.read()) != -1)
                if (data != is2.read())
                    return false;
        }

        return true;
    }

    public void testing(int indexTest, Path file1, Path file2)
    {
        try
        {
            if(sameContent(file1,file2)) {
                System.out.println("Testul " + indexTest + " este corect");
                numarTesteCorecte++;
            }
            else
                System.out.println("Testul " + indexTest + " este incorect");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }



    public void getInput(String filename)
    {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line;

            while((line = br.readLine()) != null)
            {
                problemInput.add(line.trim());
            }
            br.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void getOutput(String filename)
    {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line;

            while((line = br.readLine()) != null)
            {
                problemOutput.add(line.trim());
            }
            br.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void test(String corectInput, String corectOutput, int indexTest)
    {
        if(!problemInput.get(indexTest - 1).equals(corectInput)) {
            System.out.println("La testul "+ indexTest + " input incorect");
        }
        else {
            if (!problemOutput.get(indexTest - 1).equals(corectOutput))
                System.out.println("La testul "+ indexTest + " output incorect");

            else {
                System.out.println("Testul " + indexTest + " corect");
                numarTesteCorecte++;
            }
        }
        //System.out.println(problemInput.get(indexTest - 1));

    }


    public int getNumarTesteCorecte()
    {
        return numarTesteCorecte;
    }




}
