package th.co.magicsoftware.exceltoactivemq.repository;

import lombok.Data;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Repository;

import java.io.FileInputStream;
import java.io.IOException;

@Repository
public class ExcelRepository extends XSSFWorkbook {

    private FileInputStream fileInputStream;
    private XSSFWorkbook workbook;

    public ExcelRepository(){

    }

    public ExcelRepository(String path) throws IOException {
        this.fileInputStream = new FileInputStream(path);
        this.workbook = new XSSFWorkbook(fileInputStream);
    }

    public FileInputStream getFileInputStream() {
        return fileInputStream;
    }

    public void setFileInputStream(FileInputStream fileInputStream) {
        this.fileInputStream = fileInputStream;
    }

    public XSSFWorkbook getWorkbook() {
        return workbook;
    }

    public void setWorkbook(XSSFWorkbook workbook) {
        this.workbook = workbook;
    }

    public XSSFSheet getSheetBySheetIndex(int indexSheet){
        return workbook.getSheetAt(indexSheet);
    }

    public int getSheetIndexBySheetName(String sheetName){
        return workbook.getSheetIndex(sheetName);
    }

    @Override
    public String toString() {
        return "ExcelRepository{" +
                "fileInputStream=" + fileInputStream +
                ", workbook=" + workbook +
                '}';
    }
}
