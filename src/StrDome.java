import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class StrDome {
    public static void main(String[] args) {
        /**
         * String���ص㣺���ɱ�
         */

        String s="ABCD";
        String newstr =s.replace("C","Z");
        System.out.println("�滻��Ľ��:"+ s);   //s�ַ����滻���ַ��������Ƕ�ԭ�����ַ���s�����޸ģ���������һ���µ��ַ���
        System.out.println("�滻��Ľ��" +newstr);     //ԭ����s�ַ���û�иı�

        /**
         * StringBuilder
         * StringBuffer
         */
        StringBuffer buffer=new StringBuffer();
        buffer.append("A");
        buffer.append("B");
        System.out.println("buffer������:"+buffer);
    }

}
