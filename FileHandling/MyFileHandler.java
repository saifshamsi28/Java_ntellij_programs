package FileHandling;

import java.io.*;
import java.util.Scanner;

public class MyFileHandler {
    public static void main(String[] args){
        /*
            // code to CREATE a file
        File f=new File("C:\\Users\\saifs\\Desktop\\demofile.txt");
        try {
            if(f.createNewFile()) {
                System.out.println("File (" + f.getName() + ") created successfully");
            }
            else {
                System.out.println("File already exist..!");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }        */

        /*
          code to WRITE a file
        try {
            FileWriter fw = new FileWriter("C:\\Users\\saifs\\Desktop\\demofile.txt"); // here you can also just give File-name no need to give entire path
            String details = "hey this is saif working on laptop\n " +
                    "and learning java you should also learn cause \n" +
                    "it's an awesome language ok then Good Bye... see you";
            try {
                fw.write(details);
            }
            finally {
                fw.close();
            }
            System.out.println("File written successfully");
        }
        catch (IOException e){
            System.out.println("File written not happened ");
            e.printStackTrace();
        }
*/

     //    code to READ a file
//        try {
//            FileReader fr= new FileReader("C:\\Users\\saifs\\Desktop\\Profile.txt");
//            try {
            // to READ a character at a time or TO READ the file CHARACTER-WISE
//                int i;
//                while((i=fr.read())!=-1){
//                System.out.print((char)i);
//                }
            // to READ a line at a time
            //        Scanner sc=new Scanner(fr);
            //        while (sc.hasNextLine()){
            //            System.out.println(sc.nextLine());
            //        }
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

        // code to RENAME a file
//        File oldFile=new File("C:\\Users\\saifs\\Desktop\\demofile.txt");
//        File newFile=new File("C:\\Users\\saifs\\Desktop\\Profile.txt");
//        if ( oldFile.renameTo(newFile)){
//            System.out.println("File: "+oldFile.getName()+" is renamed as "+newFile.getName()+" successfully");
//        }

        //code to COPY contents of one file into another file
        try{
        FileInputStream oldFile=new FileInputStream("C:\\Users\\saifs\\Desktop\\Profile.txt");
                FileOutputStream newFile=new FileOutputStream("C:\\Users\\saifs\\Desktop\\NewProfile.txt");
                // to COPY CHARACTER by CHARACTER
                        int i;
                        while ((i=oldFile.read())!=-1){
                            newFile.write((char)i);
                        }
            // to COPY LINE by LINE
//                Scanner sc=new Scanner(oldFile);
//                    while(sc.hasNextLine()){
//                        String str=sc.nextLine();
//                        newFile.write(str.getBytes());
//                        System.out.println(str);
//                    }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
