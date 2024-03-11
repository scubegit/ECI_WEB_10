/*
 * package com.scube.eciweb.utils;
 * 
 * import java.io.File; import java.io.FileNotFoundException; import
 * java.io.FileOutputStream; import java.io.IOException;
 * 
 * import jakarta.servlet.http.HttpServletRequest;
 * 
 * import org.apache.poi.ss.usermodel.Cell; import
 * org.apache.poi.ss.usermodel.CellStyle; import
 * org.apache.poi.ss.usermodel.CreationHelper; import
 * org.apache.poi.ss.usermodel.Font; import
 * org.apache.poi.ss.usermodel.IndexedColors; import
 * org.apache.poi.ss.usermodel.Row; import
 * org.apache.poi.xssf.usermodel.XSSFSheet; import
 * org.apache.poi.xssf.usermodel.XSSFWorkbook; import org.json.simple.JSONArray;
 * import org.json.simple.JSONObject;
 * 
 * public class ExcelExportUtil {
 * 
 * 
 * JSONObject jsonGetObject = null;
 * 
 * XSSFWorkbook workbook = null; XSSFSheet sheet = null;
 * 
 * CommonUtil commUtil = null;
 * 
 * private String[] columns = null; private String DEST = ""; private String
 * filePath = ""; private String sheetName = "";
 * 
 * 
 * 
 * public String exportToExcelU(HttpServletRequest request, JSONArray
 * jsonInArray) { // TODO Auto-generated method stub
 * 
 * 
 * commUtil = new CommonUtils(); workbook = new XSSFWorkbook(); jsonGetObject =
 * new JSONObject();
 * 
 * try{
 * 
 * 
 * System.out.println(jsonInArray.size());
 * 
 * System.out.println(jsonInArray.size());
 * 
 * 
 * CreationHelper createHelper = workbook.getCreationHelper();
 * 
 * for(int iSheet = 0; iSheet<jsonInArray.size(); iSheet++){
 * 
 * 
 * 
 * jsonGetObject = (JSONObject) jsonInArray.get(iSheet);
 * 
 * columns = (String[]) jsonGetObject.get("columnsH");
 * 
 * JSONArray jsonArray = (JSONArray) jsonGetObject.get("columnsD");
 * 
 * 
 * sheetName = commUtil.toString(jsonGetObject.get("sheetH"),"");
 * 
 * 
 * sheet = workbook.createSheet(sheetName);
 * 
 * 
 * // Create a Font for styling header cells Font headerFont =
 * workbook.createFont(); headerFont.setBold(true);
 * headerFont.setFontHeightInPoints((short) 12);
 * headerFont.setColor(IndexedColors.BLACK.getIndex());
 * 
 * // Create a CellStyle with the font CellStyle headerCellStyle =
 * workbook.createCellStyle(); headerCellStyle.setFont(headerFont); //
 * headerCellStyle.setFillBackgroundColor(IndexedColors.YELLOW.getIndex()); //
 * Create a Row Row headerRow = sheet.createRow(0);
 * 
 * // Creating cells for(int i = 0; i < columns.length; i++) { Cell cell =
 * headerRow.createCell(i); cell.setCellValue(columns[i]);
 * cell.setCellStyle(headerCellStyle); }
 * 
 * // Create Cell Style for formatting Date CellStyle dateCellStyle =
 * workbook.createCellStyle();
 * dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat(
 * "dd-MM-yyyy"));
 * 
 * // Create Other rows and cells with employees data int rowNum = 1; int colNum
 * = 0; for(int iRow =0; iRow<jsonArray.size(); iRow++) { Row row =
 * sheet.createRow(rowNum++);
 * 
 * JSONArray arrayIn = new JSONArray();
 * 
 * arrayIn = (JSONArray) jsonArray.get(iRow);
 * 
 * for(int jCol =0; jCol<arrayIn.size(); jCol++) {
 * 
 * row.createCell(jCol).setCellValue(commUtil.toString(arrayIn.get(jCol)
 * ," ---- "));
 * 
 * } }
 * 
 * // Resize all columns to fit the content size for(int i = 0; i <
 * columns.length; i++) { sheet.autoSizeColumn(i); }
 * 
 * }
 * 
 * 
 * request = ServletActionContext.getRequest(); DEST =
 * request.getSession().getServletContext().getRealPath(
 * "results/excel/poi-generated-file.xlsx");
 * 
 * File file = new File(DEST); file.getParentFile().mkdirs();
 * 
 * FileOutputStream outputStream = new FileOutputStream(DEST);
 * workbook.write(outputStream); workbook.close();
 * 
 * filePath = "results/excel/"+file.getName();
 * 
 * System.out.println("-----filePath-------"+filePath);
 * 
 * } catch (FileNotFoundException e) { e.printStackTrace(); } catch (IOException
 * e) { e.printStackTrace(); } return filePath; }
 * 
 * }
 */