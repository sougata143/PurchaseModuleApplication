package com.aspl.org.controller;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;




@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UploadController {
	
	
	
//	@Autowired AttendanceService attendanceService;

	
	
	@RequestMapping(value = "/processExcel", method = RequestMethod.POST)
	
    public String processExcel(
            @RequestParam("excelfile") MultipartFile excelfile) {
        try {
            int i = 1;
            //Creates a workbook object from the uploaded excelfile
            HSSFWorkbook workbook = new HSSFWorkbook(excelfile.getInputStream());
            //Creates a worksheet object representing the first sheet
            HSSFSheet worksheet = workbook.getSheetAt(0);
            //Reads the data in excel file until last row is encountered
            
            while (i <= worksheet.getLastRowNum()) {
                //Creates an object for the Candidate  Model
//                Attendance attendance=new Attendance();
                //Creates an object representing a single row in excel
                HSSFRow row = worksheet.getRow(i++);
                //Sets the Read data to the model class
                
                
                
//                attendance.setFromDate(row.getCell(0).getDateCellValue());
//                attendance.setToDate(row.getCell(1).getDateCellValue());
//                attendance.setEmp_code(row.getCell(2).getStringCellValue());
//                attendance.setTotal_working_day((int) row.getCell(3).getNumericCellValue());
//                attendance.setTotal_working_hrs((Double) row.getCell(4).getNumericCellValue());
//                attendance.setTotal_absent_day((int) row.getCell(5).getNumericCellValue());
//                attendance.setTotal_absent_hrs((Double) row.getCell(6).getNumericCellValue());
//                attendance.setTotal_ot_hrs((Double) row.getCell(7).getNumericCellValue());
//                attendance.setEmployeeType( row.getCell(8).getStringCellValue());
//              
//                attendance.setFine_amt((Double) row.getCell(9).getNumericCellValue());
                
                
                
              
//                attendanceService.attendacesave(attendance);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "uploadSuccess";
    }
	
	
	
	
	
}
