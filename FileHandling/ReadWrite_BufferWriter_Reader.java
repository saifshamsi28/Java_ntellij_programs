package FileHandling;

import java.io.*;

public class ReadWrite_BufferWriter_Reader  {
    public static void main(String[] args) throws IOException {
        // WRITING in a file using BufferWriter
//        FileWriter fw=new FileWriter("C:\\Users\\saifs\\Desktop\\Profile.txt",true);
//        BufferedWriter bw=new BufferedWriter(fw,10);
//        bw.write(" \ni hope you are doing well");
//        bw.close();

        // READING in a file using BufferWriter
        FileReader fr=new FileReader("C:\\Users\\saifs\\Desktop\\Profile.txt");
        BufferedReader buffReader =new BufferedReader(fr);
        //using "readLine()" method
//        String s;
//        while ((s=buffReader.readLine())!=null){
//            System.out.print(s);
//        }
//        buffReader.close();
        char []charReader=new char[247];
        buffReader.read(charReader,5,242);   //  or you can give the length of buffer and use thr loops to print entire file
        System.out.println(charReader);
//        System.out.println("hey this is saif working on laptop\n and learning java you should also learn cause \nits an awesome language ok then Good Bye... see you\ni m learning android development as well\n hey again i m back what".length());
        buffReader.close();
    }

}
