package pack;
import java.io.*;

public class TextFileReader {
    public static double[] readTextFile(String folderWay,String date) {
        double[] courseArray = new double[1];
        try {
            File file = new File( folderWay + date + ".txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            courseArray = new double[3];
            String s;
            int i = 0;
            while ((s = br.readLine()) != null) {
                double dnum = Double.parseDouble(s);
                courseArray[i] = dnum;
            }
            br.close();


        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        } finally {
            return courseArray;
            // While occasionally intended, such return statements may mask exceptions thrown,
            // and tremendously complicate debugging. - что это значит?
        }

    }
}
