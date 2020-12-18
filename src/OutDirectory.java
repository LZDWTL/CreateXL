import java.io.File;

public class OutDirectory {
    public static void main(String[] args) {

        File file = new File("D:\\缓存\\爱思助手");
//        fileList(file);
        m2(file);
//        m(new File("D:\\软件\\压缩包"));

    }

    private static void fileList(File file) {

        //通过直接判断是不是文件夹来决定是否进行下一步可以减少时间开销
        if(file.isDirectory()){   //如果不对文件进行判断的话会导致不是文件夹的文件创建了数组，而该文件下又无其它文件，这样的话会导致空指针
            File[] files = file.listFiles();

            if (files.length >0) {   //如果将判断条件改为 (files != null) 则可以不用在上面判断是不是文件夹
                for (File f : files) {
                    System.out.println(f.getName());
                    fileList(f);
                }
            }
        }
    }
    /*static void m(File file) {
        System.out.println(file.getName());
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if(files != null){   //如果文件夹下为空则没有输出
                for (File f : files) {
                    m(f);
                }
            }
        }
    }*/


    public static void  m2(File file){
        if(file.isDirectory()){
            File []files=file.listFiles();
            if(files.length>0){
                for(File f: files){
                    System.out.println(f.getName()+":  "+f.getAbsolutePath());
                    m2(f);
                }
            }
        }

    }
}
