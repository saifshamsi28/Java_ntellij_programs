package FileHandling;

import java.io.FileOutputStream;

public class ReadWrite_FileInput_OutputStream {
    public static void main(String[] args) throws Exception{
        FileOutputStream fs=new FileOutputStream("C:\\Users\\saifs\\Desktop\\Profile.txt",true);
        String str=" hey again i m back what's up you guys";
        char [] charstring=str.toCharArray();
        for (int i=0;i<charstring.length;i++) {
            fs.write(charstring[i]);
        }

    }


}
