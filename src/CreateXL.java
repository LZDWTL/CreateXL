import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFCell;

import java.io.FileOutputStream;


public class CreateXL {
    /**
     * Excel �ļ�Ҫ��ŵ�λ�ã��ٶ���F����
     */
    public static String outputFile = "D:/��ʱ�ļ���/������Ƶ��Markdown�ʼ�/��Ƶ/2020-12-06/test.xls";

    public static void main(String argv[]) {
        try {
            // �����µ�Excel ������
            HSSFWorkbook workbook = new HSSFWorkbook();
            // ��Excel�������н�һ����������Ϊȱʡֵ
            // ��Ҫ�½�һ��Ϊ"Ч��ָ��"�Ĺ����������Ϊ��
            HSSFSheet sheet = workbook.createSheet("ѧ���ɼ�");
            // ������0��λ�ô����У���˵��У�

			String array[][]={
					{"��Ŀ","����","ѧ��"},
					{"����","96","3"},
					{"��ѧ","90","3.5"},
					{"Ӣ��","92","3"}
			};

			for(int i=0;i<array.length;i++){
				HSSFRow row = sheet.createRow((short)i);
				for(int j=0;j<array[i].length;j++){
					HSSFCell cell = row.createCell((short)j);
					cell.setCellValue(array[i][j]);
				}
			}
/*					HSSFRow row = sheet.createRow((short)0);
					//������0��λ�ô�����Ԫ�����϶ˣ�
					HSSFCell cell01 = row.createCell((short)0);

					HSSFCell cell02 = row.createCell((short)1);
					
					// �ڵ�Ԫ��������һЩ����
					cell01.setCellValue("��Ŀ");
					cell02.setCellValue("����");

*/

//            String s[] = {"��Ŀ", "����", "����", "99", "��ѧ", "100", "Ӣ��", "101"};
//            for (int i = 0; i < 4; i++) {
//
//                setData(s[i * 2], s[i * 2 + 1], sheet, i);
//
//            }

            // �½�һ����ļ���
            FileOutputStream fOut = new FileOutputStream(outputFile);
            // ����Ӧ��Excel ����������
            workbook.write(fOut);
            fOut.flush();
            // �����������ر��ļ�
            fOut.close();
            System.out.println("�ļ�����...");
        } catch (Exception e) {
            System.out.println("������ xlCreate() : " + e);
        }
    }

/*    public static void setData(String s1, String s2, HSSFSheet sheet, int i) {

        HSSFRow row_i = sheet.createRow(i);
        //������0��λ�ô�����Ԫ�����϶ˣ�

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