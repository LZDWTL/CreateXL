import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFCell;

import java.io.FileOutputStream;


public class CreateXL {
    /**
     * Excel 文件要存放的位置，假定在F盘下
     */
    public static String outputFile = "D:/临时文件夹/蓝桥视频及Markdown笔记/视频/2020-12-06/test.xls";

    public static void main(String argv[]) {
        try {
            // 创建新的Excel 工作簿
            HSSFWorkbook workbook = new HSSFWorkbook();
            // 在Excel工作簿中建一工作表，其名为缺省值
            // 如要新建一名为"效益指标"的工作表，其语句为：
            HSSFSheet sheet = workbook.createSheet("学生成绩");
            // 在索引0的位置创建行（最顶端的行）

			String array[][]={
					{"科目","分数","学分"},
					{"语文","96","3"},
					{"数学","90","3.5"},
					{"英语","92","3"}
			};

			for(int i=0;i<array.length;i++){
				HSSFRow row = sheet.createRow((short)i);
				for(int j=0;j<array[i].length;j++){
					HSSFCell cell = row.createCell((short)j);
					cell.setCellValue(array[i][j]);
				}
			}
/*					HSSFRow row = sheet.createRow((short)0);
					//在索引0的位置创建单元格（左上端）
					HSSFCell cell01 = row.createCell((short)0);

					HSSFCell cell02 = row.createCell((short)1);
					
					// 在单元格中输入一些内容
					cell01.setCellValue("科目");
					cell02.setCellValue("分数");

*/

//            String s[] = {"科目", "分数", "语文", "99", "数学", "100", "英语", "101"};
//            for (int i = 0; i < 4; i++) {
//
//                setData(s[i * 2], s[i * 2 + 1], sheet, i);
//
//            }

            // 新建一输出文件流
            FileOutputStream fOut = new FileOutputStream(outputFile);
            // 把相应的Excel 工作簿存盘
            workbook.write(fOut);
            fOut.flush();
            // 操作结束，关闭文件
            fOut.close();
            System.out.println("文件生成...");
        } catch (Exception e) {
            System.out.println("已运行 xlCreate() : " + e);
        }
    }

/*    public static void setData(String s1, String s2, HSSFSheet sheet, int i) {

        HSSFRow row_i = sheet.createRow(i);
        //在索引0的位置创建单元格（左上端）

        for (short k = 0; k < 2; k++) {

            HSSFCell cell_k = row_i.createCell(k);

            if (k == 0) {
                cell_k.setCellValue(s1);
            } else {
                cell_k.setCellValue(s2);
            }
        }
    }*/

}