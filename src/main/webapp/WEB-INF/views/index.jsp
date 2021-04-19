<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored = "false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
 <%@ include file = "linkFile.jsp" %>
  <title>Index file</title>
</head>
<body> 
	<%@ include file = "navbar.jsp" %>
	<div class="container-fluid">
    	<div class="row my-4">
    		<%@ include file = "sidebar.jsp" %>
    		<div class="col-lg-10" id="main_content">
                <div class="row">
	                <div class="col-lg-10" >
					    <form class="form-group mb-0">
					        <input class="form-control " type="Search" placeholder="Search items based ID and Employee name" id="searchbox"
					            aria-label="Search">
					    </form>
					</div>
			
					<div class="col-lg-2">
					    <button class="btn btn-primary btn-sm add-employee" data-modal="employee-modal">Add New Employee</button>
					</div>
					<div class="col-lg-12 my-4">
					    <table id="example" class="table table-hover " style="width:100%">
					        <thead>
					            <tr>
					                <th>Sl no</th>
					                <th>Name</th>
					                <th>Action</th>
					            </tr>
					        </thead>
					        <tbody>
					        	<c:forEach var="emp" items="${empList}">   
								   <tr>  
								   	<td>${emp.emp_id}</td>  
								   	<td>${emp.emp_name}</td> 
								   	<td data-emp_id="${emp.emp_id}"
											data-emp_code="${emp.emp_code}" 
											data-emp_name="${emp.emp_name}"
											data-emp_email="${emp.emp_email}" 
											data-emp_pass="${emp.emp_pass}"
											data-emp_dept="${emp.emp_dept}"
											data-emp_prj="${emp.emp_prj}"
											data-emp_join="${emp.emp_join}"
											>
					                    <button role="button" class="btn btn-link view-employee" data-modal="employee-modal">
					                        <i class="fas fa-eye text-dark"></i>
					                    </button>
					
					                    <button role="button" class="btn btn-link edit-employee">
					                        <i class="fas fa-pencil-alt text-warning"></i>
					                    </button>
					                    <button role="button" class="btn btn-link delete-employee">
					                        <i class="fas fa-trash text-danger"></i>
					                    </button>
					                </td>   
								   	</tr>  
								</c:forEach>  
					        
					        
					<!--              <tr>
					                <td>1</td>
					                <td>SACHIN M</td>
					                <td>
					                    <a role="button" class="btn btn-link">
					                        <i class="fas fa-eye text-dark"></i>
					                    </a>
					
					                    <a href="#editEmployeeModal" data-toggle="modal" role="button" class="btn btn-link">
					                        <i class="fas fa-pencil-alt text-warning"></i>
					                    </a>
					                    <a href="#deleteEmployeeModal" data-toggle="modal" role="button" class="btn btn-link">
					                        <i class="fas fa-trash text-danger"></i>
					                    </a>
					                </td>
					            </tr>
					            <tr>
					                <td>2</td>
					                <td>ADITYA N</td>
					                <td>
					                    <button role="button" class="btn btn-link">
					                        <i class="fas fa-eye text-dark"></i>
					                    </button>
					
					                    <button role="button" class="btn btn-link">
					                        <i class="fas fa-pencil-alt text-warning"></i>
					                    </button>
					                    <button role="button" class="btn btn-link">
					                        <i class="fas fa-trash text-danger"></i>
					                    </button>
					                </td>
					            </tr>
					            <tr>
					                <td>3</td>
					                <td>IDRIS</td>
					                <td>
					                    <button role="button" class="btn btn-link">
					                        <i class="fas fa-eye text-dark"></i>
					                    </button>
					
					                    <button role="button" class="btn btn-link">
					                        <i class="fas fa-pencil-alt text-warning"></i>
					                    </button>
					                    <button role="button" class="btn btn-link">
					                        <i class="fas fa-trash text-danger"></i>
					                    </button>
					                </td>
					            </tr> --> 
				
					        </tbody>
					        <tfoot>
					            <tr>
					                <th>Sl no</th>
					                <th>Name</th>
					                <th>Action</th>
					            </tr>
					        </tfoot>
					    </table>
					</div>
				</div>
           </div>
          </div>
         </div>
                   
         <div id="employee-modal" class="modal fade">
    		<div class="modal-dialog">
      			<div class="modal-content">
        			<form id="employee-form">
          				<div class="modal-header">
            				<h4 class="modal-title" id="modal-title">Add Employee</h4>
            				<button type="button" id="old" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
          				</div>
          				
          				<div class="modal-body">
          					<div class='error-msg' id='validationSummary'></div>
          					<div  id="confirm-msg"></div>
          					<div class="form-group" style="display:none">
              					<label>lastname</label>
              					<input type="text" class="form-control" name="last_name" id="employee-lastname" required>
            				</div>
            				
            				<div class="form-group" id="div1">
              					<label>Name</label>
              					<input type="text" class="form-control" name="emp_name" id="employee-name" required>
            				</div>
            				
            				
            				
            				<div class="form-group" id="div2">
              					<label>Email</label>
              					<input type="email" class="form-control" name="emp_email" id="employee-email" required>
            				</div>
			
							<div class="form-group" id="div3">
              					<label>Password</label>
              					<input type="password" class="form-control" name="emp_password"  id="employee-password" required>
            				</div>

							<div class="form-group" id="div4">
              					<label>Department</label>
              					<select class="custom-select" name="emp_dept" id="employee-department">
              						<option selected value="">Select Department</option>
              					<c:forEach var="dept" items="${deptList}">
								  	<option value="${dept.dept_id}">${dept.dept_name}</option>
								</c:forEach>
								</select>
            				</div>
            				
            				<div class="form-group" id="div5">
              					<label>Project</label>
              					<select class="custom-select" name="emp_prj" id="employee-project" >
									<option selected value="">Select Project</option>
								<c:forEach var="prj" items="${prjList}">
								  	<option value="${prj.prj_id}">${prj.prj_name}</option>
								</c:forEach>
								</select>
            				</div>
            				
            				<div class="form-group">
            					<input type="hidden" name="emp_join" id="employee-join"/>
            				</div>
            
          				</div>
          				
          				<div class="modal-footer">
          					<input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
            				<input type="button" class="btn btn-success" value="Add" id="save">
          					<input type="hidden" name="emp_id" id="employee-id" >
          					<input type="hidden" name="emp_code" id="employee-code" >
          					<input type="hidden" name="action"  id="update-action"/>
          				</div>
          				
        			</form>
      			</div>
    		</div>
  	     </div>
  	    <script src="${pageContext.request.contextPath}/resources/javascript/ems.js"></script>
  </body>
</html>