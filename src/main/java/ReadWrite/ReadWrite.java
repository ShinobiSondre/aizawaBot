package ReadWrite;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadWrite {


    public void WriteToFile (String filename,String information,Boolean boo){
        try {
            FileWriter myWriter = new FileWriter("C:\\Users\\narut\\aizawaBot\\src\\main\\java\\"+filename,boo);
            myWriter.write(information);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public ArrayList<String> ReadFile(String filename){


        ArrayList<String> quirks = new ArrayList();

        try {
            File myObj = new File("C:\\Users\\narut\\aizawaBot\\src\\main\\java\\"+filename);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                quirks.add(data);


                //System.out.println(data);
            }
            myReader.close();
            return quirks;
        } catch (
                FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    return null;}

}
