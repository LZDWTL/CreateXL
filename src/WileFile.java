import java.io.File;

public class WileFile {
    public static void main(String args[]){
        File file=new File("D:\\����\\��˼����");
        WhFile(file);
    }

    private static void WhFile(File file) {
        System.out.println(file.getName());
    }
}
