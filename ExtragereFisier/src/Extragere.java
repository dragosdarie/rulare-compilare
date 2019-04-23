import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Extragere {
	public void extragereFisier (String textDeExtras) 
	{
		FileOutputStream fos;
		try {
			fos = new FileOutputStream("numeFisier.txt"); //A SE INLOCUII NUMELE FISIERULUI
			DataOutputStream out = new DataOutputStream(fos);
			out.writeUTF(textDeExtras);
			out.flush();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
