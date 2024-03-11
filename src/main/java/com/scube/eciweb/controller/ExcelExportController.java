/*
 * package com.scube.eciweb.controller;
 * 
 * import jakarta.servlet.http.HttpServletRequest;
 * 
 * import org.json.simple.JSONArray; import org.json.simple.JSONObject;
 * 
 * public class ExcelExportController {
 * 
 * JSONObject jsonOutObject = null; JSONObject jsonGetObject = null; JSONArray
 * jsonSetArray = null;
 * 
 * ExcelExportDao exportDao = null; ExcelExportUtil excelExportUtil = null;
 * 
 * private String filePath = "";
 * 
 * public JSONObject requestSalesOrderC(HttpServletRequest request,JSONObject
 * jsonInObject) {
 * 
 * jsonSetArray = new JSONArray(); jsonOutObject = new JSONObject();
 * jsonGetObject = new JSONObject();
 * 
 * exportDao = new ExcelExportDao(); excelExportUtil = new ExcelExportUtil();
 * try {
 * 
 * // get data from database
 * 
 * jsonSetArray.add(exportDao.requestSalesOrderDataDo(jsonInObject));
 * jsonSetArray.add(exportDao.requestSalesOrderPaymentTerms(jsonInObject));
 * jsonSetArray.add(exportDao.requestSalesOrderInrOtherExpenses(jsonInObject));
 * jsonSetArray.add(exportDao.requestSalesOrderActualPayments(jsonInObject));
 * jsonSetArray.add(exportDao.requestSalesOrderProducts(jsonInObject));
 * jsonSetArray.add(exportDao.requestSalesOrderPrincipalReceivables(jsonInObject
 * ));
 * jsonSetArray.add(exportDao.requestSalesOrderCustomerReceivables(jsonInObject)
 * );
 * jsonSetArray.add(exportDao.requestSalesOrderPayableLocalVendor(jsonInObject))
 * ;
 * 
 * 
 * jsonGetObject = exportDao.requestSalesOrderDataDo(); jsonGetObject =
 * exportDao.requestSoOrderPaymentTerms(); jsonGetObject =
 * exportDao.requestSoInrOtherExpenses(); jsonGetObject =
 * exportDao.requestSoOrderActualPayments(); jsonGetObject =
 * exportDao.requestSoOrderProducts(); jsonGetObject =
 * exportDao.requestSoPrincipalReceivables(); jsonGetObject =
 * exportDao.requestSoCustomerReceivables(); jsonGetObject =
 * exportDao.requestSoPayableLocalVendor();
 * 
 * //
 * System.out.println("--------------jsonGetObject---------------"+jsonGetObject
 * .get("columnsH"));
 * 
 * filePath = excelExportUtil.exportToExcelU(request,jsonSetArray);
 * 
 * jsonOutObject.put("result", filePath);
 * 
 * }catch (Exception e) { e.printStackTrace(); }
 * 
 * return jsonOutObject; }
 * 
 * public JSONObject requestServiceOrderC(HttpServletRequest request,JSONObject
 * jsonInObject) { // TODO Auto-generated method stub
 * 
 * jsonSetArray = new JSONArray(); jsonOutObject = new JSONObject();
 * jsonGetObject = new JSONObject();
 * 
 * exportDao = new ExcelExportDao(); excelExportUtil = new ExcelExportUtil();
 * try {
 * 
 * // get data from database
 * 
 * jsonSetArray.add(exportDao.requestServiceOrderDataDo(jsonInObject));
 * jsonSetArray.add(exportDao.requestServiceOrderPlannedPayment(jsonInObject));
 * jsonSetArray.add(exportDao.requestServiceOrdeProducts(jsonInObject));
 * jsonSetArray.add(exportDao.requestServiceOrderServiceVisits(jsonInObject));
 * jsonSetArray.add(exportDao.requestServiceOrderActualPayments(jsonInObject));
 * 
 * 
 * filePath = excelExportUtil.exportToExcelU(request,jsonSetArray);
 * 
 * jsonOutObject.put("result", filePath);
 * 
 * }catch (Exception e) { e.printStackTrace(); }
 * 
 * return jsonOutObject;
 * 
 * } }
 * 
 */