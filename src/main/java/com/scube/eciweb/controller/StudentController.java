package com.scube.eciweb.controller;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.scube.eciweb.entity.FilterPayload;
import com.scube.eciweb.entity.Student;
import com.scube.eciweb.service.StudentService;

@Controller
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        super();
        this.studentService = studentService;
    }
    
    @GetMapping(value = {"/","/login"})
    public String login() {
        return "login";
    }
    
    @GetMapping(value = {"/index"})
    public String index() {
        return "login";
    }
    
    @GetMapping("/ProductMaster")
    public String productMaster(Model model) {
    	 Student student = new Student();
         model.addAttribute("student", student);
    	
        return "ProductMaster";
    }
    
    @GetMapping("/MenuPage")
    public String menuPage(Model model) {
        return "MenuPage";
    }
    
    @GetMapping("/TaskMaster")
    public String taskMaster(Model model) {	
        return "TaskMaster";
    }
    
    @GetMapping("/RegionMaster")
    public String regionMaster(Model model) {
        return "RegionMaster";
    }
    
    @GetMapping("/CustomerMaster")
    public String customerMaster(Model model) {
        return "CustomerMaster";
    }
    
    @GetMapping("/PurchaseOrderMaster")
    public String purchaseOrderMaster(Model model) {
        return "PurchaseOrder";
    }
    
    @GetMapping("/PurchaseOrder")
    public String purchaseOrder(Model model) {
        return "PurchaseOrder";
    }
    
    @GetMapping("/UserMaster")
    public String userMaster(Model model) {
    	return "UserMaster";
    }
    
    @GetMapping("/NewAtpTest")
    public String newAtpTest(Model model) {
        return "NewAtpTest";
    }
    
    @GetMapping("/Atp_TestProduct")
    public String atpTestProduct(Model model) {
        return "AtpTestProduct";
    }
    
    @GetMapping("/SICompany")
    public String sICompany(Model model) {
        return "SICompany";
    }
    
    
	/* reports mapping */
    
    @GetMapping("/AdminReports")
    public String adminReports(Model model) {
        return "AdminReports";
    }
    
    @GetMapping("/POReports")
    public String pOReports(Model model) {
        return "POReports";
    }
    
    
    @GetMapping("/ApprovedTasksReport")
    public String approvedTasksReport(Model model) {
        return "ApprovedTasks";
    }
    
    @GetMapping("/WipPending")
    public String wipPending(Model model) {
        return "WipPending";
    }
    
    @GetMapping("/CompleteJob")
    public String completeJob(Model model) {
        return "CompleteJob";
    }
    
    @GetMapping("/AdHocReport")
    public String adHocReport(Model model) {
        return "AdHocReport";
    }
    
    @GetMapping("/QcSurvey")
    public String qcSurvey(Model model) {
        return "QcSurveyReport";
    }
    
    @GetMapping("/QualityReport")
    public String qualityReport(Model model) {
        return "QualityReport";
    	
    //	return "ApprovedTaskTest";
    }
    
    
	/* PM login screens */
    
    
    @GetMapping("/Summary")
    public String summary(Model model) {
        return "Summary";
    }
    
 /*   @GetMapping("/SISummary")
    public String SIsummary(Model model) {
        return "SISummary";
    }
    
    @GetMapping("/SITaskStatus")
    public String SITaskStatus(Model model) {
        return "SITaskStatus";
    }
    
    @GetMapping("/SIApprovals")
    public String SIApprovals(Model model) {
        return "SIApprovals";
    }*/

    @GetMapping("/TaskStatus")
    public String taskStatus(Model model) {
        return "TaskStatus";
    }

    @GetMapping("/POKitty")
    public String pOKitty(Model model) {
        return "POKitty";
    }
    
    @GetMapping("/Installations")
    public String installations(Model model) {
        return "ProjectManager";
    }
    
    @GetMapping("/Unassigned")
    public String unassigned(Model model) {
        return "Unassigned";
    }
    
    @GetMapping("/PendingApprovals")
    public String pendingApprovals(Model model) {
        return "PendingApprovals";
    }
    
    @GetMapping("/ApprovedTasks")
    public String ApprovedTasks(Model model) {
        return "ApprovedTasksForPM";
    }

    @GetMapping("/ReportTasks")
    public String ReportTasks(Model model) {
        return "ReportTasksForPM";
    }
    
	/* HPM login screens */
    
    @GetMapping("/ApproveHPM")
    public String approveHPM(Model model) {
    	System.out.println("testing");
        return "ApproveHPM";
    }
    
    @GetMapping("/GetApprovedTask")
    public String hpmApprovedTask(Model model) {
    	System.out.println("testing222222");

        return "HpmApprovedTask";
    }
    
    
	/* Admin Managment */
    @GetMapping("/AdminManagement")
    public String adminManagement(Model model) {
        return "MenuPage";
    }

	/* customer login screens */
    
    @GetMapping("/CustomerHReports")
    public String customerHReports(Model model) {
        return "CustomerHReports";
    }
    
    /* Quality login screens */
    
    @GetMapping("/QualityReports")
    public String qualityReports(Model model) {
        return "QualityReports";
    }
    
    @GetMapping("/QlAdHocReport")
    public String qlAdHocReport(Model model) {
        return "QlAdHocReport";
    }
    
    @GetMapping("/QlQcSurvey")
    public String qlQcSurvey(Model model) {
        return "QlQcSurvey";
    }
    
    @GetMapping("/QlQualityReport")
    public String qlQualityReport(Model model) {
        return "QlQualityReport";
    }

    /*
    @GetMapping("/")
    public String index() {
        return "index";
    }
	*/
    
    @GetMapping("/legacy")
    public String legacy(Model model) {
        return findPaginated(1, 10, "id", "ASC", model);
    }

    @GetMapping("/students/details/{id}")
    public String details(@PathVariable("id") Long id, Model model) {
        Student student = studentService.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Invalid student Id:" + id));

        model.addAttribute("student", student);

        return "details";
    }

    @GetMapping("/students/{page}/{size}")
    public String findPaginated(
            @PathVariable int page,
            @PathVariable int size,
            @RequestParam(value = "field", defaultValue = "id") String field,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction,
            Model model) {
        if (page < 1)
            page = 1;
        if (size < 1)
            size = 5;

        Page<Student> students = studentService.findAll(page, size, field, direction);
        Iterable<Student> studentList = students.getContent();

        model.addAttribute("currentPage", page);
        model.addAttribute("size", size);
        model.addAttribute("totalPages", students.getTotalPages());
        model.addAttribute("totalItems", students.getTotalElements());
        model.addAttribute("students", studentList);
        model.addAttribute("field", field);
        model.addAttribute("direction", direction);
        model.addAttribute("pagination", new FilterPayload());
        model.addAttribute("reverseDirection", direction.equalsIgnoreCase("ASC") ? "DESC" : "ASC");

        return "students";
    }

    @PostMapping("/students/filter/{page}")
    public String filter(
            @PathVariable int page,
            @RequestParam(value = "field", defaultValue = "id") String field,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction,
            @RequestParam(value = "keyword", defaultValue = "") String keyword,
            @ModelAttribute("pagination") FilterPayload request,
            Model model
    ) {
        if (page < 1)
            page = 1;

        int size = request.getEntriesPerPage() == null || request.getEntriesPerPage().isEmpty() ? 5 : Integer.parseInt(request.getEntriesPerPage());
        Page<Student> students = studentService.findAll(page, size, field, direction);
        Iterable<Student> studentList = students.getContent();

        model.addAttribute("currentPage", page);
        model.addAttribute("size", size);
        model.addAttribute("totalPages", students.getTotalPages());
        model.addAttribute("totalItems", students.getTotalElements());
        model.addAttribute("students", studentList);
        model.addAttribute("field", field);
        model.addAttribute("direction", direction);
        model.addAttribute("pagination", request);
        model.addAttribute("reverseDirection", direction.equalsIgnoreCase("ASC") ? "DESC" : "ASC");

        return "students";
    }

    @GetMapping("/students/new")
    public String createStudentForm(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);

        return "create_student";
    }
    



    @PostMapping("/students/search")
    public String searchStudent(
            @RequestParam("keyword") String keyword,
            Model model) {
        int page = 1;
        int size = 5;

        Page<Student> students = studentService.search(keyword);
        Iterable<Student> studentList = students.getContent();

        model.addAttribute("students", studentService.search(keyword));
        model.addAttribute("currentPage", page);
        model.addAttribute("size", size);
        model.addAttribute("totalPages", students.getTotalPages());
        model.addAttribute("totalItems", students.getTotalElements());
        model.addAttribute("students", studentList);
        model.addAttribute("field", "id");
        model.addAttribute("direction", "ASC");
        model.addAttribute("pagination", new FilterPayload());
        model.addAttribute("reverseDirection", "DESC");

        return "students";
    }

    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable("id") Long id, Model model) {
        Student student = studentService.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Invalid student Id:" + id));

        model.addAttribute("student", student);

        return "edit_student";
    }

    @GetMapping("/students/delete/{id}")
    public String deleteStudentForm(@PathVariable("id") Long id) {
        studentService.deleteById(id);

        return "index";
    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student) {
        student.setPhotoUrl("https://www.w3schools.com/bootstrap4/img_avatar1.png");
        studentService.save(student);

        return "index";
    }

    @PostMapping("/students/{id}")
    public String updateStudent(
            @PathVariable("id") Long id, @ModelAttribute("student") Student student) {
        studentService.update(student, id);

        return "index";
    }
}
