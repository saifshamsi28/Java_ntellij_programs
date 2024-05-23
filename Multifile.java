import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Multifile {
    public static void main(String[] args) {
        File folder=new File("Multiplication tables");
        folder.mkdir();
        String table=null;
        for (int i = 2; i <=10; i++) {
            table="";
            for (int j = 1; j <=10 ; j++) {
                table+=i+" X "+ j +" = "+ i*j;
                table+="\n";
            }
            try {
                File file1=new File(folder,"Table of "+i);
                file1.createNewFile();
                FileWriter fileWriter=new FileWriter(file1);
                fileWriter.write(table);
                fileWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        File[] tables=folder.listFiles();
        for(File file:tables){
            System.out.println("\ncontents of FILe: "+file.getName());
            try {
                Scanner sc=new Scanner(file);
                while (sc.hasNextLine()){
                    System.out.println(sc.nextLine());
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
//        System.out.println(folder.length());
    }
}
