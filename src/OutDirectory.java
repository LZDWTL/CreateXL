import java.io.File;

public class OutDirectory {
    public static void main(String[] args) {

        File file = new File("D:\\����\\��˼����");
//        fileList(file);
        m2(file);
//        m(new File("D:\\���\\ѹ����"));

    }

    private static void fileList(File file) {

        //ͨ��ֱ���ж��ǲ����ļ����������Ƿ������һ�����Լ���ʱ�俪��
        if(file.isDirectory()){   //��������ļ������жϵĻ��ᵼ�²����ļ��е��ļ����������飬�����ļ������������ļ��������Ļ��ᵼ�¿�ָ��
            File[] files = file.listFiles();

            if (files.length >0) {   //������ж�������Ϊ (files != null) ����Բ����������ж��ǲ����ļ���
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
            if(files != null){   //����ļ�����Ϊ����û�����
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
