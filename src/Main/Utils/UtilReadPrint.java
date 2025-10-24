package Main.Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class UtilReadPrint {


    public void printFile(String path){

    try (BufferedReader br = new BufferedReader(new FileReader(path))){

        String line = br.readLine();
        while (line != null){

            System.out.println(line);
            line = br.readLine();
        }
        
    }catch(IOException e){
        System.out.println("Error: " + e.getMessage());
    }
}


}


