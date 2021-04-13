package ems.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ems.dao.DepartmentDao;
import ems.dao.EmployeeDao;
import ems.dao.ProjectDao;
import ems.dao.ResultDao;
import ems.model.Department;
import ems.model.Employee;
import ems.model.Project;
import ems.model.EmployeeByDepartment;

@Controller
public class HomeController {
     @Autowired 
    EmployeeDao employeeDao;
     
     @Autowired
     DepartmentDao departmentDao;
     
     @Autowired
     ProjectDao projectDao;
     
     @Autowired
     ResultDao resultDao;

	@RequestMapping("/index")
	public ModelAndView index()
	{
		ModelAndView modelAndView = new ModelAndView("index");
		List<Employee> empList= employeeDao.getEmployees(); 
		List<Department> deptList= departmentDao.getDepartments();
		List<Project> prjList= projectDao.getProjects();
		modelAndView.addObject("empList", empList);
		modelAndView.addObject("deptList", deptList);
		modelAndView.addObject("prjList", prjList);
		return modelAndView;
	}
	
	
	@RequestMapping("/result")
	public ModelAndView result() throws JsonProcessingException
	{
		ModelAndView modelAndView = new ModelAndView("result");
		String empByDept = resultDao.getEmployeeByDepartment();
		String empByPrj = resultDao.getEmployeeByProject();
		String empByJoinDate = resultDao.getEmployeesByJoinDate();
		modelAndView.addObject("empByJoinDate",empByJoinDate);
		modelAndView.addObject("empByDept", empByDept);
		modelAndView.addObject("empByPrj", empByPrj);
		return modelAndView;
		/*List<Employee> empList= employeeDao.getEmployees(); 
		List<Department> deptList= departmentDao.getDepartments();
		List<Project> prjList= projectDao.getProjects();
		modelAndView.addObject("empList", empList);
		modelAndView.addObject("deptList", deptList);
		modelAndView.addObject("prjList", prjList);*/
		
	}
	
	  /*@RequestMapping(path = "/addemployee", method = RequestMethod.POST)
	  @ResponseBody public List<String> addemployee(@RequestParam(name="emp_name") String emp_name,
			  @RequestParam(name="emp_email") String emp_email,
			  @RequestParam(name="emp_pass") String emp_pass,
			  @RequestParam(name="emp_dept") String emp_dept,
			  @RequestParam(name="emp_prj") String emp_prj,
			  @RequestParam(name="emp_join") String emp_join){ 
		  List<String> l = new ArrayList<String>(); 
		  l.add("testing"); return l; 
	  }*/
	 
	
		
		@RequestMapping(path = "/addemployee", method = RequestMethod.POST, headers = "content-type=application/x-www-form-urlencoded") 
		public @ResponseBody String addemployee(HttpServletRequest request) {
		
			String emp_email = request.getParameter("emp_email");
			String emp_pass = request.getParameter("emp_password");
			int emp_dept = Integer.parseInt(request.getParameter("emp_dept"));
			int emp_prj = Integer.parseInt(request.getParameter("emp_prj"));
			String emp_name = request.getParameter("emp_name");
			Employee emp = new Employee(emp_name, emp_email, emp_pass, emp_dept, emp_prj);
			Employee emp1 = employeeDao.insertEmployee(emp);
			
			
			
			 Map<String, String> elements = new HashMap();
		        elements.put("message1", emp_name);
		        elements.put("message2", emp_email);
		        elements.put("message3", emp_pass);
		       // elements.put("message4", key1);
		        //elements.put("message4", emp_dept);
		        //elements.put("message5", emp_prj);
		   

		        ObjectMapper objectMapper = new ObjectMapper();

		        try {
		        	String json = objectMapper.writeValueAsString(emp1);
		           return json;
		        } catch (JsonProcessingException e) {
		            e.printStackTrace();
		        }
				
				return null;
		       
		       
		}
		
		@RequestMapping(path = "/editemployee", method = RequestMethod.POST, headers = "content-type=application/x-www-form-urlencoded") 
		public @ResponseBody String editemployee(HttpServletRequest request) throws Exception {
			int emp_id = Integer.parseInt(request.getParameter("emp_id"));
			//String emp_code = request.getParameter("emp_code");
			String emp_name = request.getParameter("emp_name");
			String emp_email = request.getParameter("emp_email");
			String emp_pass = request.getParameter("emp_password");
			int emp_dept = Integer.parseInt(request.getParameter("emp_dept"));
			int emp_prj = Integer.parseInt(request.getParameter("emp_prj"));
			//Date emp_join=new SimpleDateFormat("yyyy-MM-dd HH:MM:ss").parse(request.getParameter("emp_join")); 
			Employee emp = new Employee(emp_id,emp_name,emp_email,emp_pass,emp_dept,emp_prj);
			employeeDao.updateEmployee(emp);
			

	        ObjectMapper objectMapper = new ObjectMapper();

	        try {
	        	String json = objectMapper.writeValueAsString(emp_prj);
	           return json;
	        } catch (JsonProcessingException e) {
	            e.printStackTrace();
	        }
			
			return null;
	       

		}
			 
	 
	
	/*
	 * @RequestMapping(path = "/addemployee" , method = RequestMethod.POST) public
	 * ModelAndView details(@RequestBody Employee employee, HttpServletRequest
	 * request, HttpServletResponse response) {
	 * 
	 * ModelAndView view = new ModelAndView(); String username =
	 * employee.getEmp_name(); view.addObject("username", username);
	 * view.setViewName("index");
	 * 
	 * return view; }
	 */
	
	
}
	 
	/*
	 * @RequestMapping(path = "/process", method = RequestMethod.POST ) public
	 * String process(@ModelAttribute User user,Model model) { return "result"; }
	 */
	
	

