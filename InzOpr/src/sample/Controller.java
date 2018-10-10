package sample;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;

import javax.swing.*;
import java.io.*;


public class Controller {


    public Button buttonX;
    public TextField textX;
    public String message, message2;


    public Button buttonY;
    public TextField textY;
    public Button wiersz;
    
    public SplitMenuButton przyciskPrzedmiot;
    public SplitMenuButton przyciskProwadzacy;
    public SplitMenuButton przyciskSala;


    public HSSFWorkbook workbook = new HSSFWorkbook();
    public HSSFSheet sheet = workbook.createSheet("firstSheet");

    public Controller() throws IOException {

        System.out.println("Constructor working!");


        HSSFRow row = sheet.createRow((short) 0);
        for (int i = 0; i <= 20; i++) {
            row.createCell(i).setCellValue("0");
        }
        row = sheet.createRow((short) 1);
        for (int i = 0; i <= 20; i++) {
            row.createCell(i).setCellValue("1");
        }

        row = sheet.createRow((short) 2);
        for (int i = 0; i <= 20; i++) {
            row.createCell(i).setCellValue("2");
        }

        FileOutputStream out = new FileOutputStream(new File("excel2.xls"));
        workbook.write(out);
        //out.close();
        System.out.println("excel.xls written successfully");

    }


    public void Generate(ActionEvent actionEvent) throws IOException {

        String excelFilePath = "excel2.xls";

        try {
            short wiersz = Short.parseShort(message2);

            HSSFRow row = sheet.createRow(wiersz);
            for (int i = 0; i <= 20; i++) {
                row.createCell(i).setCellValue(message);
            }
            System.out.println("data uploaded!");
            //inputStream.close();

            FileOutputStream outputStream = new FileOutputStream("excel2.xls");
            workbook.write(outputStream);
            // workbook.close();
            //  outputStream.close();

        } catch (IOException | EncryptedDocumentException ex) {
            ex.printStackTrace();
        }
    }


    public void PrzyciskX(ActionEvent actionEvent) {
        message= textX.getText();
        System.out.println(message);

    }



  

    public void PrzyciskZapisz(ActionEvent actionEvent) {
    }

    public void plikZapisz(ActionEvent actionEvent) {
    }

    public void PrzyciskWiersz(ActionEvent actionEvent) {
        message2= textY.getText();
        System.out.println(message2);
    }
}




