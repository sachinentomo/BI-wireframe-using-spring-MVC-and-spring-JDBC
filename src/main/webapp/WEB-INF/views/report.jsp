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
	            	
	            	<div class="col-lg-6">
	        			<h4 style="background-color: rgb(23, 23, 112); border: black; color:white; text-align: center;">Summary</h4>
	        			<form>
							  <div class="form-group row">
							  	<div class="col-sm 6">
								    <label for="exampleInputEmail1">No of employees</label>
								    
								</div>
								<div class="col-sm 6">
									<input type="text" class="form-control" id="empCount">
								</div>    
							  </div>
							  <div class="form-group row">
	                                <label class="col-sm-6 col-form-label">No. of Deparments</label>
	                                <div class="col-sm-6">
	                                    <input type="text" class="form-control" id="deptCount">
	                                </div> 
	                            </div>
	                            <div class="form-group row">
	                                <label class="col-sm-6 col-form-label">No. of Projects</label>
	                                <div class="col-sm-6">
	                                    <input type="text" class="form-control" id="prjCount">
	                                </div>
	                            </div>
	                        </form>
	    			</div>
	    			<div class="col-lg-6">
	                	<div id="summary_graph"></div>
	                </div>
	            </div>	
	            	
	            <div class="row">	
	            	<div class="col-lg-6" style="">
					<h4 style="background-color: rgb(23, 23, 112); border: black; color:white; text-align: center;">Department Summary</h4>
					<table class="table table-striped table-bordered" id="departmentSummary" style="border-width: 1px solid;">
						<tr>
							<th>Department Name</th>
							<th>Count Of Employees</th>
						</tr>
						<tr>
						</tr>
					</table>
				</div>
					<div class="col-lg-6" style="">
						<h4 style="background-color: rgb(23, 23, 112); border: black; color:white; text-align: center;">Project Summary</h4>
						<table class="table table-striped table-bordered" id="projectSummary" style="border-width: 1px solid;">
							<tr>
								<th>Project Name</th>
								<th>Count Of Employees</th>
							</tr>
							<tr>
							</tr>
						</table>
					</div>
	            </div>
	            
	            
	            <div class="row">
	            	<div class="col-lg-12">
					<h4 style="background-color: rgb(23, 23, 112); border: black; color:white; text-align: center;">All Details</h4>
					<table class="table table-striped table-bordered" style="border-width: 1px solid;">
						<tr>
							<th>Employee Name</th>
							<th>Employee Details</th>
							<th>Department Name</th>
							<th>Project Name</th>
						</tr>
						<tr>
							<td>jack</td>
							<td>dorsey</td>
							<td>Devops</td>
							<td>pipeline</td>
						</tr>
						<tr>
							<td>jack</td>
							<td>dorsey</td>
							<td>Devops</td>
							<td>pipeline</td>
						</tr>
					</table>
				</div>
				</div>
				
          </div>
		</div>
	</div>
     
	<script src="javascript/ems.js"></script>
	<script type="text/javascript">
		var empByDept = ${empByDept};
		var empByPrj = ${empByPrj};
		var totalCount = ${totalCount};
		$('#empCount').val(totalCount[0].emp_count);
		$('#deptCount').val(totalCount[0].dept_count);
		$('#prjCount').val(totalCount[0].prj_count);
		
		addEmpByPrj(empByPrj);
		addEmpByDept(empByDept);
		function addEmpByPrj(empByPrj) { 
		    var rows = "";
		    $.each(empByPrj, function(i, val) {
		        rows += "<tr><td>" + val.prj_name + "</td><td>" + val.count + "</td>";
		    });
		    $('#projectSummary').append(rows);
		}
		function addEmpByDept(empByDept) { 
		    var rows = "";
		    $.each(empByDept, function(i, val) {
		        rows += "<tr><td>" + val.dept_name + "</td><td>" + val.count + "</td>";
		    });
		    $('#departmentSummary').append(rows);
		}
		
		
		google.charts.load("current", {packages:['corechart']});
	    google.charts.setOnLoadCallback(function (){
	    	drawChart(empByDept);
	    	});
	    function drawChart(empByDept) {
	      	var data = new google.visualization.DataTable();
	      	data.addColumn('string','count');
	      	data.addColumn('number','count');
	 		var dataArray = [];
	 		$.each(empByDept, function(i, obj) {
	 			dataArray.push([obj.dept_name, obj.count]);
	 		});

	 		data.addRows(dataArray);

	      	var view = new google.visualization.DataView(data);
	      	view.setColumns([0, 1]); 

	      	var options = {
	        	title: "Employees By Department",
	        	width: 600,
	        	height: 400,
	        	bar: {groupWidth: "95%"},
	        	legend: { position: "none" },
	      	};
	      	var chart = new google.visualization.ColumnChart(document.getElementById("summary_graph"));
	      	chart.draw(view, options);
	  }
		
		
	</script>      
</body>
</html>