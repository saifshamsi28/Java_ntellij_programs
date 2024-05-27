import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Multifile {
    public static void main(String[] args) {
//        Scanner scan=new Scanner(System.in);
//        System.out.println("Enter the number from which Multiplication will start : ");
//        int start=scan.nextInt();
//        System.out.println("Enter the number at which Multiplication will end : ");
//        int end=scan.nextInt();
//        File folder=new File("Multiplication tables");
//        if(!folder.exists())
//            folder.mkdir();
//        else {
//            folder.delete();
//            folder.mkdir();
//        }
//        String table=null;
//        for (int i = start; i <=end; i++) {
//            table="";
//            for (int j = 1; j <=10 ; j++) {
//                table+=i+" X "+ j +" = "+ i*j;
//                table+="\n";
//            }
//            try {
//                File file1=new File(folder,"Table of "+i);
//                file1.createNewFile();
//                FileWriter fileWriter=new FileWriter(file1);
//                fileWriter.write(table);
//                fileWriter.close();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }
//        File[] tables=folder.listFiles();
//        for(File file:tables){
//            String fileName= file.getName();
//            int fileIndex=Integer.parseInt(fileName.substring(9));
////            System.out.println("file index is: "+fileIndex+ "for file: "+fileName);
//            if(fileIndex>=start && fileIndex<=end) {
//                System.out.println("\ncontents of FILe: " + file.getName());
//                try {
//                    Scanner sc = new Scanner(file);
//                    while (sc.hasNextLine()) {
//                        System.out.println(sc.nextLine());
//                    }
//                } catch (FileNotFoundException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        }
////        System.out.println(folder.length());
        while (true){
            System.out.println("hello ");
            System.out.println("yes i m doing your wok");
        }
    }
}
