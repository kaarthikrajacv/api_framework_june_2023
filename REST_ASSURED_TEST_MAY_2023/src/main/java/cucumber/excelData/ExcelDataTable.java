package cucumber.excelData;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelDataTable {

    String path;

    Workbook workbook;

    Sheet sheet;

    Row row;

    FileInputStream fis;

    public ExcelDataTable(String path){
        this.path =  path;
    }

    public void createConnection() throws Exception {

        File file = new File(path);

        fis = new FileInputStream(file);

        workbook = new HSSFWorkbook(fis);

        sheet = workbook.getSheet("weather_data");
    }


    public String getDataFromExcel(String rowName, String colName) throws IOException {

        int rowNum=-1, colNum = -1;

        int totalRows = sheet.getLastRowNum();

        // Row match
        for (int i=0; i<=totalRows; i++){

            if(sheet.getRow(i).getCell(0).getStringCellValue().trim().equals(rowName)){
                rowNum = i;
                break;
            }
        }

        // col match
        for (int j=0; j< sheet.getRow(0).getPhysicalNumberOfCells(); j++){

            if(sheet.getRow(0).getCell(j).getStringCellValue().trim().equals(colName)){
                colNum = j;
                break;
            }
        }

        String op = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();

        fis.close();
        return op;



    }


    public List<String> getIterativeDataFromExcel(String rowName) throws IOException {

        int rowNum=-1;

        int totalRows = sheet.getLastRowNum();

        System.out.println("Total Row num is " + totalRows);

        // Row match
        for (int i=0; i<=totalRows; i++){

            if(sheet.getRow(i).getCell(0).getStringCellValue().trim().equals(rowName)){
                rowNum = i;
                break;
            }
        }

        List<String> op = new ArrayList<>();
        // Find iteration Match
        boolean iterationDone = false;
        while(!iterationDone){
            op.add(sheet.getRow(rowNum).getCell(2).getStringCellValue());

            if(sheet.getRow(rowNum).getCell(1).getNumericCellValue() > sheet.getRow(rowNum + 1).getCell(1).getNumericCellValue()){
                iterationDone = true;
            }
            else {
                rowNum++;
            }
        }
        return op;



    }

}
