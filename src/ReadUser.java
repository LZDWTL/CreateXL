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
//            System.out.println("行号是"+xs.getLastRowNum());

            for (int j = 1; j <= xs.getLastRowNum(); j++) {     //循环行
                XSSFRow row = xs.getRow(j);
                User user = new User();//每循环一次就把电子表格的一行的数据给对象赋值
                for (int k = 0; k < row.getLastCellNum(); k++) {
                    XSSFCell cell = row.getCell(k);       //循环单元格
//                    System.out.println("单元格的列是"+row.getLastCellNum());
                    if (cell == null)
                        continue;
                    if (k == 0) {
                        user.setUsername(this.getValue(cell));//给username属性赋值
                    } else if (k == 1) {
                        user.setPassword(this.getValue(cell));//给password属性赋值
                    } else if (k == 2) {
                        user.setAddress(this.getValue(cell));//给address属性赋值
                    } else if (k == 3) {
                        user.setPhone(this.getValue(cell));//给phone属性赋值
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
                DecimalFormat df = new DecimalFormat("#");   //改造让纯数字编程字符串
//                value = cell.getNumericCellValue() + "";  //非字符串类型和一个空字符串连接，最终类型时String
                value=df.format(cell.getNumericCellValue());   //改造让纯数字编程字符串

//                value=String.valueOf(cell.getNumericCellValue());
                /*
                如果使用这种转化方法和上面的用 + 连接的方法一样。
                则会保留 double 的 .0 以及数字过大或者过小会导致输出科学计数法，而使用DecimalFormat则不会
                */
                break;
            case FORMULA:
                value = cell.getCellFormula();
                break;
            case ERROR:
                value = "非法字符";
                break;
            default:
                value = "";
                break;
        }
        return value;
    }
}
