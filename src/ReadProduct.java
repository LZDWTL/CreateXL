import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.sound.sampled.FloatControl;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;

public class ReadProduct {
    public Product[] readProduct(InputStream in) {
        Product products[] = null;
        try {
//            XSSFWorkbook xw = new XSSFWorkbook(new FileInputStream(file));
            XSSFWorkbook xw = new XSSFWorkbook(in);
            XSSFSheet xs = xw.getSheetAt(0);
            products = new Product[xs.getLastRowNum()];

            for (int j = 1; j <= xs.getLastRowNum(); j++) {     //循环行
                XSSFRow row = xs.getRow(j);
                Product product = new Product();//每循环一次就把电子表格的一行的数据给对象赋值
                for (int k = 0; k < row.getLastCellNum(); k++) {
                    XSSFCell cell = row.getCell(k);       //循环单元格

                    if (cell == null)
                        continue;
                    if (k == 0) {
                        product.setId(this.getValue(cell));//给id属性赋值
                    } else if (k == 1) {
                        product.setName(this.getValue(cell));//给name属性赋值
                    } else if (k == 2) {
                        product.setPrice(Float.valueOf(this.getValue(cell)));//给price属性赋值,并将String 类型转为float
                    } else if (k == 3) {
                        product.setDescribe(this.getValue(cell));//给describe属性赋值
                    }
                }
                products[j-1] = product;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return products;
    }

    public Product getProductById(String id,InputStream in) {

        try {

            XSSFWorkbook xw = new XSSFWorkbook(in);
            XSSFSheet xs = xw.getSheetAt(0);

            for (int j = 1; j <= xs.getLastRowNum(); j++) {     //循环行
                XSSFRow row = xs.getRow(j);
                Product product = new Product();//每循环一次就把电子表格的一行的数据给对象赋值
                for (int k = 0; k < row.getLastCellNum(); k++) {
                    XSSFCell cell = row.getCell(k);       //循环单元格

                    if (cell == null)
                        continue;
                    if (k == 0) {
                        product.setId(this.getValue(cell));//给id属性赋值
                    } else if (k == 1) {
                        product.setName(this.getValue(cell));//给name属性赋值
                    } else if (k == 2) {
                        product.setPrice(Float.valueOf(this.getValue(cell)));//给price属性赋值,并将String 类型转为float
                    } else if (k == 3) {
                        product.setDescribe(this.getValue(cell));//给describe属性赋值
                    }
                }
                if(id.equals(product.getId())){
                    return product;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getValue(XSSFCell cell) {
        String value;
        CellType type = cell.getCellType();

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
