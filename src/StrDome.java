import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class StrDome {
    public static void main(String[] args) {
        /**
         * String的特点：不可变
         */

        String s="ABCD";
        String newstr =s.replace("C","Z");
        System.out.println("替换后的结果:"+ s);   //s字符串替换了字符，但不是对原来的字符串s进行修改，而是生成一个新的字符串
        System.out.println("替换后的结果" +newstr);     //原来的s字符串没有改变

        /**
         * StringBuilder
         * StringBuffer
         */
        StringBuffer buffer=new StringBuffer();
        buffer.append("A");
        buffer.append("B");
        System.out.println("buffer缓存区:"+buffer);
    }

}
