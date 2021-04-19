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
import ems.dao.ReportDao;
import ems.dao.ResultDao;
import ems.model.Department;
import ems.model.TotalCount;
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
     
     @Autowired
     ReportDao reportDao;

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
	
	@RequestMapping("/report")
	public ModelAndView report() throws JsonProcessingException  {
		ModelAndView modelAndView = new ModelAndView("report");
		String totalCount = reportDao.getTotalCount();
		String empByDept = resultDao.getEmployeeByDepartment(); ;
		String empByPrj = resultDao.getEmployeeByProject();
		modelAndView.addObject("totalCount",totalCount);
		modelAndView.addObject("empByDept", empByDept);
		modelAndView.addObject("empByPrj", empByPrj);
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
	        } 
	        catch (JsonProcessingException e) {
	        	e.printStackTrace();
	        }
			return null;
		}
	@RequestMapping(path = "/deleteemployee", method = RequestMethod.POST, headers = "content-type=application/x-www-form-urlencoded") 
	public @ResponseBody String  deleteemployee(HttpServletRequest request) throws Exception {
		int emp_id = Integer.parseInt(request.getParameter("emp_id"));
		boolean result = employeeDao.deleteEmployee(emp_id);
		 ObjectMapper objectMapper = new ObjectMapper();
	        try {
				String json = objectMapper.writeValueAsString(result);
				return json;
	        } 
	        catch (JsonProcessingException e) {
	        	e.printStackTrace();
	        }
			return null;
		

	}
	@RequestMapping("/department")
	public ModelAndView departmentindex()
	{
		ModelAndView modelAndView = new ModelAndView("department");
		//List<Employee> empList= employeeDao.getEmployees(); 
		List<Department> deptList= departmentDao.getDepartments();
		//List<Project> prjList= projectDao.getProjects();
		//modelAndView.addObject("empList", empList);
		modelAndView.addObject("deptList", deptList);
		//modelAndView.addObject("prjList", prjList);
		return modelAndView;
	}
	
	@RequestMapping(path = "/adddepartment", method = RequestMethod.POST, headers = "content-type=application/x-www-form-urlencoded") 
	public @ResponseBody String adddepartment(HttpServletRequest request) {
		
			String dept_name = request.getParameter("dept_name");
			String dept_desc = request.getParameter("dept_desc");
			String dept_loc = request.getParameter("dept_loc");
			
			
			Department dept = new Department(dept_name, dept_desc, dept_loc);
			Department dept1 = departmentDao.insertDepartment(dept);
		   

		        ObjectMapper objectMapper = new ObjectMapper();

		        try {
		        	String json = objectMapper.writeValueAsString(dept1);
		           return json;
		        } catch (JsonProcessingException e) {
		            e.printStackTrace();
		        }
				
				return null;
		       
		       
		}
		
	@RequestMapping(path = "/editdepartment", method = RequestMethod.POST, headers = "content-type=application/x-www-form-urlencoded") 
	public @ResponseBody String editdepartment(HttpServletRequest request) throws Exception {
			int dept_id = Integer.parseInt(request.getParameter("dept_id"));
			//String dept_code = request.getParameter("dept_code");
			String dept_name = request.getParameter("dept_name");
			String dept_desc = request.getParameter("dept_desc");
			String dept_loc = request.getParameter("dept_loc");
			//Date emp_join=new SimpleDateFormat("yyyy-MM-dd HH:MM:ss").parse(request.getParameter("emp_join")); 
			Department dept = new Department(dept_id, dept_name, dept_desc, dept_loc);
			departmentDao.updateDepartment(dept);
			

	        ObjectMapper objectMapper = new ObjectMapper();
	        try {
				String json = objectMapper.writeValueAsString("sucess");
				return json;
	        } 
	        catch (JsonProcessingException e) {
	        	e.printStackTrace();
	        }
			return null;
		}
	@RequestMapping(path = "/deletedepartment", method = RequestMethod.POST, headers = "content-type=application/x-www-form-urlencoded") 
	public @ResponseBody String  deletedepartment(HttpServletRequest request) throws Exception {
		int dept_id = Integer.parseInt(request.getParameter("dept_id"));
		boolean result = departmentDao.deleteDepartment(dept_id);
		 ObjectMapper objectMapper = new ObjectMapper();
	        try {
				String json = objectMapper.writeValueAsString(result);
				return json;
	        } 
	        catch (JsonProcessingException e) {
	        	e.printStackTrace();
	        }
			return null;
		

	}
	
	@RequestMapping("/project")
	public ModelAndView projectindex()
	{
		ModelAndView modelAndView = new ModelAndView("project");
		//List<Employee> empList= employeeDao.getEmployees(); 
		List<Project> prjList= projectDao.getProjects();
		//List<Project> prjList= projectDao.getProjects();
		//modelAndView.addObject("empList", empList);
		modelAndView.addObject("prjList", prjList);
		//modelAndView.addObject("prjList", prjList);
		return modelAndView;
	}
	
	@RequestMapping(path = "/addproject", method = RequestMethod.POST, headers = "content-type=application/x-www-form-urlencoded") 
	public @ResponseBody String addproject(HttpServletRequest request) {
		
			String prj_name = request.getParameter("prj_name");
			String prj_desc = request.getParameter("prj_desc");
			//String dept_loc = request.getParameter("prj_loc");
			
			
			Project prj = new Project(prj_name, prj_desc);
			Project prj1 = projectDao.insertProject(prj);
		   

		        ObjectMapper objectMapper = new ObjectMapper();

		        try {
		        	String json = objectMapper.writeValueAsString(prj1);
		           return json;
		        } catch (JsonProcessingException e) {
		            e.printStackTrace();
		        }
				
				return null;
		       
		       
		}
		
	@RequestMapping(path = "/editproject", method = RequestMethod.POST, headers = "content-type=application/x-www-form-urlencoded") 
	public @ResponseBody String editproject(HttpServletRequest request) throws Exception {
			int prj_id = Integer.parseInt(request.getParameter("prj_id"));
			//String dept_code = request.getParameter("dept_code");
			String prj_name = request.getParameter("prj_name");
			String prj_desc = request.getParameter("prj_desc");
			//String dept_loc = request.getParameter("prj_loc");
			//Date emp_join=new SimpleDateFormat("yyyy-MM-dd HH:MM:ss").parse(request.getParameter("emp_join")); 
			Project prj = new Project(prj_id, prj_name, prj_desc);
			projectDao.updateProject(prj);
			

	        ObjectMapper objectMapper = new ObjectMapper();
	        try {
				String json = objectMapper.writeValueAsString("sucess");
				return json;
	        } 
	        catch (JsonProcessingException e) {
	        	e.printStackTrace();
	        }
			return null;
		}
	@RequestMapping(path = "/deletedepartment", method = RequestMethod.POST, headers = "content-type=application/x-www-form-urlencoded") 
	public @ResponseBody String  deletedepartment(HttpServletRequest request) throws Exception {
		int dept_id = Integer.parseInt(request.getParameter("dept_id"));
		boolean result = departmentDao.deleteDepartment(dept_id);
		 ObjectMapper objectMapper = new ObjectMapper();
	        try {
				String json = objectMapper.writeValueAsString(result);
				return json;
	        } 
	        catch (JsonProcessingException e) {
	        	e.printStackTrace();
	        }
			return null;
		

	}
	
	
}

	
	

