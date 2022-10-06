package EX;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {

    public static void writeXLSXFile(int row, int col,String str,String in,String out) throws IOException {
        try {
            FileInputStream file = new FileInputStream(in);

            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(1);
            Cell cell = null;

            XSSFRow sheetrow = sheet.getRow(row);
            if(sheetrow == null){
                sheetrow = sheet.createRow(row);
            }
            //Update the value of cell
            cell = sheetrow.getCell(col);
            if(cell == null){
                cell = sheetrow.createCell(col);
            }
            cell.setCellValue(str);

            file.close();

            FileOutputStream outFile =new FileOutputStream(new File(out));
            workbook.write(outFile);
            outFile.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void writeXLSFile(int row, int col,String str,String in,String out) throws IOException {
        try {
            FileInputStream file = new FileInputStream(in);

            HSSFWorkbook workbook = new HSSFWorkbook(file);
            HSSFSheet sheet = workbook.getSheetAt(1);
            Cell cell = null;

            HSSFRow sheetrow = sheet.getRow(row);
            if(sheetrow == null){
                sheetrow = sheet.createRow(row);
            }
            //Update the value of cell
            cell = sheetrow.getCell(col);
            if(cell == null){
                cell = sheetrow.createCell(col);
            }
            cell.setCellValue(str);

            file.close();

            FileOutputStream outFile =new FileOutputStream(new File(out));
            workbook.write(outFile);
            outFile.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        writeXLSXFile(70-1, 2,"String!","crt.xlsx","crtUY.xlsx");   
    }

}