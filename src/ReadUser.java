import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;

public class ReadUser {
    public User[] readUser(InputStream in) {
        User users[] = null;
        try {
//            XSSFWorkbook xw = new XSSFWorkbook(new FileInputStream(file));
            XSSFWorkbook xw = new XSSFWorkbook(in);
            XSSFSheet xs = xw.getSheetAt(0);
            users = new User[xs.getLastRowNum()];
//            System.out.println("�к���"+xs.getLastRowNum());

            for (int j = 1; j <= xs.getLastRowNum(); j++) {     //ѭ����
                XSSFRow row = xs.getRow(j);
                User user = new User();//ÿѭ��һ�ξͰѵ��ӱ���һ�е����ݸ�����ֵ
                for (int k = 0; k < row.getLastCellNum(); k++) {
                    XSSFCell cell = row.getCell(k);       //ѭ����Ԫ��
//                    System.out.println("��Ԫ�������"+row.getLastCellNum());
                    if (cell == null)
                        continue;
                    if (k == 0) {
                        user.setUsername(this.getValue(cell));//��username���Ը�ֵ
                    } else if (k == 1) {
                        user.setPassword(this.getValue(cell));//��password���Ը�ֵ
                    } else if (k == 2) {
                        user.setAddress(this.getValue(cell));//��address���Ը�ֵ
                    } else if (k == 3) {
                        user.setPhone(this.getValue(cell));//��phone���Ը�ֵ
                    }
                }
                users[j-1] = user;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    private String getValue(XSSFCell cell) {
        String value;
        CellType type = cell.getCellTypeEnum();

        switch (type) {
            case STRING:
                value = cell.getStringCellValue();
                break;
            case BLANK:
                value = "";
                break;
            case BOOLEAN:
                value = cell.getBooleanCellValue() + "";
                break;
            case NUMERIC:
                DecimalFormat df = new DecimalFormat("#");   //�����ô����ֱ���ַ���
//                value = cell.getNumericCellValue() + "";  //���ַ������ͺ�һ�����ַ������ӣ���������ʱString
                value=df.format(cell.getNumericCellValue());   //�����ô����ֱ���ַ���

//                value=String.valueOf(cell.getNumericCellValue());
                /*
                ���ʹ������ת��������������� + ���ӵķ���һ����
                ��ᱣ�� double �� .0 �Լ����ֹ�����߹�С�ᵼ�������ѧ����������ʹ��DecimalFormat�򲻻�
                */
                break;
            case FORMULA:
                value = cell.getCellFormula();
                break;
            case ERROR:
                value = "�Ƿ��ַ�";
                break;
            default:
                value = "";
                break;
        }
        return value;
    }
}
