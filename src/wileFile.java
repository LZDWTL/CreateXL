import java.io.File;

public class wileFile {
    public static void main(String args[]){
        File file=new File("D:\\»º´æ\\°®Ë¼ÖúÊÖ");
        WhFile(file);
    }

    private static void WhFile(File file) {
        System.out.println(file.getName());
    }
}
