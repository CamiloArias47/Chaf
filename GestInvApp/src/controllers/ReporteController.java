/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import models.ReporteModel;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author Carlos Andres
 */
public class ReporteController {
    private HSSFWorkbook workbook = new HSSFWorkbook();
    private HSSFSheet sheet = workbook.createSheet("Reporte");
    private ReporteModel modeloReporte = new ReporteModel();
    private HSSFCellStyle  estiloCabecera,estiloCuerpo;
    
    
    public ReporteController(){
        this.estiloCabecera = this.workbook.createCellStyle();
        this.estiloCabecera.setFillForegroundColor(IndexedColors.BLUE.index);
        this.estiloCabecera.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        HSSFFont titleFont = workbook.createFont();
	titleFont.setCharSet(HSSFFont.DEFAULT_CHARSET);
        titleFont.setColor(IndexedColors.WHITE.index);
	titleFont.setBold(true);
        this.estiloCabecera.setFont(titleFont);
        
        
    }
    public void crearReporteVentas(){
        
        int rowNum = 0;
        System.out.println("Creando excel");
        ArrayList<ArrayList> ventas = this.modeloReporte.getVentaInfo();
        for(int i = 0;i<ventas.size();i++) {
            
            Row row = sheet.createRow(rowNum++);
            
            int colNum = 0;
            for(int j = 0;j<ventas.get(i).size();j++){
                
                if(j>0){
                    sheet.autoSizeColumn(j);
                    Cell cell = row.createCell(colNum++);                                    
                    if(i>0){
                        cell.setCellValue(ventas.get(i).get(j).toString());
                        
                    }else{
                        switch(j){
                            case 1:{
                                    cell.setCellValue("Producto ID");
                                    cell.setCellStyle(estiloCabecera);
                            }
                            break;
                            case 2:{
                                    cell.setCellValue("Nombre Cliente");
                                    cell.setCellStyle(estiloCabecera);
                            }
                            break;
                            case 3:{
                                    cell.setCellValue("Nombre Vendedor");
                                    cell.setCellStyle(estiloCabecera);
                            }
                            break;
                            case 4:{
                                    cell.setCellValue("Fecha Venta");
                                    cell.setCellStyle(estiloCabecera);
                            }
                            break;
                            case 5:{
                                    cell.setCellValue("Total Venta");
                                    cell.setCellStyle(estiloCabecera);
                            }
                            break;    
                        }
                    }
                }
            }
        }
        try {
            String FILE_NAME = "Reporte_de_Ventas.xls";
            FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
            workbook.write(outputStream);
            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Done");
    }
    
    public void crearReporteUsuarios(){
        int rowNum = 0;
        System.out.println("Creando excel");
        ArrayList<ArrayList> usuarios = this.modeloReporte.getUsersInfo();
        for(int i = 0;i<usuarios.size();i++) {
            
            Row row = sheet.createRow(rowNum++);
            
            int colNum = 0;
            for(int j = 0;j<usuarios.get(i).size();j++){
                    sheet.autoSizeColumn(j);
                    Cell cell = row.createCell(colNum++);                                    
                    if(i>0){
                        cell.setCellValue(usuarios.get(i).get(j).toString());
                        
                    }else{
                        switch(j){
                            case 0:{
                                    cell.setCellValue("ID Interno");
                                    cell.setCellStyle(estiloCabecera);
                            }
                            break;
                            case 1:{
                                    cell.setCellValue("Login Usuario");
                                    cell.setCellStyle(estiloCabecera);
                            }
                            break;
                            case 2:{
                                    cell.setCellValue("Nombre Usuario");
                                    cell.setCellStyle(estiloCabecera);
                            }
                            break;
                            case 3:{
                                    cell.setCellValue("Tipo de Documento");
                                    cell.setCellStyle(estiloCabecera);
                            }
                            break;
                            case 4:{
                                    cell.setCellValue("Numero de Identificacion");
                                    cell.setCellStyle(estiloCabecera);
                            }
                            break;    
                            case 5:{
                                    cell.setCellValue("Direccion");
                                    cell.setCellStyle(estiloCabecera);
                            }
                            break;
                            case 6:{
                                    cell.setCellValue("Telefono");
                                    cell.setCellStyle(estiloCabecera);
                            }
                            break;
                            case 7:{
                                    cell.setCellValue("Estado");
                                    cell.setCellStyle(estiloCabecera);
                            }
                            break;        
                        }
                    }
                }
        }
        try {
            String FILE_NAME = "Reporte_de_Usuarios.xls";
            FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
            workbook.write(outputStream);
            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Done");
    }
}
