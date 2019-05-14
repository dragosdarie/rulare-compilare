import java.sql.ResultSet;
import java.sql.*;
import java.util.*;

public class Problem {

    Connection myConn = Database.getConnection();

    public Map<String, String> getTeste(int id)
    {
        Map<String,String> dict = new HashMap<String,String>();
        try {
            //Statement myStmt = myConn.createStatement();
            PreparedStatement statement = myConn.prepareStatement("select test1_in, test1_out, test2_in, test2_out, test3_in, test3_out, " +
                    "test4_in, test4_out from teste_probleme" + " WHERE id_problema = ?");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            while(rs.next())
            {
                String test1_in = rs.getString(1);
                String test1_out = rs.getString(2);
                String test2_in = rs.getString(3);
                String test2_out = rs.getString(4);
                String test3_in = rs.getString(5);
                String test3_out = rs.getString(6);
                String test4_in = rs.getString(7);
                String test4_out = rs.getString(8);

                dict.put(test1_in, test1_out);
                dict.put(test2_in, test2_out);
                dict.put(test3_in, test3_out);
                dict.put(test4_in, test4_out);


//                System.out.println("Test1_in:" + test1_in);
//                System.out.println("Test1_out:" + test1_out);
//                System.out.println("Test2_in:" + test2_in);
//                System.out.println("Test2_out:" + test2_out);
//                System.out.println("Test3_in:" + test3_in);
//                System.out.println("Test3_out:" + test3_out);
//                System.out.println("Test4_in:" + test4_in);
//                System.out.println("Test4_out:" + test4_out);
//
//                System.out.println(dict);
            }

            rs.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dict;
    }

}
