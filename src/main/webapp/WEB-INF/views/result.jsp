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
                    <div class="col-sm-12">
                        <h4 style="background-color: rgb(23, 23, 112); border: black; color:white; text-align: center;">Search(Global)</h4><br>
                        <div class="col-sm-12 text-right">
                            <button type="button" class=" btn btn-primary btn-sm text-right" style="background-color: rgb(23, 23, 112); border: black; color:white; text-align: center; width: 15%">Search</button>
                        </div>
                        ${empByDept}
                        ${empByPrj}
                       ${empByJoinDate}
                        <table class="table table-striped table-bordered" style="border-width: 1px solid;">
                            <tr>
                                <th>Sl.No</th>
                                <th>Emp.code</th>
                                <th>Emp.name</th>
                                <th>Email</th>
                                <th>Dept.Name</th>
                                <th>Project Name</th>
                            </tr>
                            <tr>
                                <td>1</td>
                                <td>emp-1</td>
                                <td>jack</td>
                                <td>jack@email.com</td>
                                <td>BI</td>
                                <td>clone app</td>
                            </tr>
                            
                        </table>

                    </div>
                </div>
            <div class="row">
                <div class="col-sm-6">
                    <div id="employee_department"></div>
                </div>

                <div class="col-sm-6">
                    <div id="employee_project"></div>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-10" >
                    <div id="new_join"></div>
                </div>
            </div>
          </div>
		</div>
	</div>
     
	
 	  <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
  <script type="text/javascript">
 	var empByDept = ${empByDept};
 	var empByPrj = ${empByPrj};
 	var empByJoinDate = ${empByJoinDate};
    google.charts.load("current", {packages:['corechart']});
    google.charts.setOnLoadCallback(function (){
    	drawChart(empByDept);
    	drawChart1(empByPrj);
    	drawBackgroundColor();
    	});
    function drawChart(empByDept) {
      	var data = new google.visualization.DataTable();
    	data.addColumn('string','dept_name');
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
      	var chart = new google.visualization.ColumnChart(document.getElementById("employee_department"));
      	chart.draw(view, options);
  }
    function drawChart1(empByPrj) {
    	var data = new google.visualization.DataTable();
      	data.addColumn('string','prj_name');
   		data.addColumn('number','count');
   		var dataArray = [];
   		$.each(empByPrj, function(i, obj) {
   			dataArray.push([obj.prj_name, obj.count]);
   		});
		data.addRows(dataArray);

        var view = new google.visualization.DataView(data);
        view.setColumns([0, 1]); 

        var options = {
          title: "Employees By Project",
          width: 600,
          height: 400,
          bar: {groupWidth: "95%"},
          legend: { position: "none" },
        };
        var chart = new google.visualization.ColumnChart(document.getElementById("employee_project"));
        chart.draw(view, options);
    }
    function drawBackgroundColor() {
        var data = new google.visualization.DataTable();
        data.addColumn('number', 'X');
        data.addColumn('number', 'Dogs');

        data.addRows([
          [0, 0],   [1, 10],  [2, 23],  [3, 17],  [4, 18],  [5, 9],
          [6, 11],  [7, 27],  [8, 33],  [9, 40],  [10, 32], [11, 35],
          [12, 30], [13, 40], [14, 42], [15, 47], [16, 44], [17, 48],
          [18, 52], [19, 54], [20, 42], [21, 55], [22, 56], [23, 57],
          [24, 60], [25, 50], [26, 52], [27, 51], [28, 49], [29, 53],
          [30, 55], [31, 60], [32, 61], [33, 59], [34, 62], [35, 65],
          [36, 62], [37, 58], [38, 55], [39, 61], [40, 64], [41, 65],
          [42, 63], [43, 66], [44, 67], [45, 69], [46, 69], [47, 70],
          [48, 72], [49, 68], [50, 66], [51, 65], [52, 67], [53, 70],
          [54, 71], [55, 72], [56, 73], [57, 75], [58, 70], [59, 68],
          [60, 64], [61, 60], [62, 65], [63, 67], [64, 68], [65, 69],
          [66, 70], [67, 72], [68, 75], [69, 80]
        ]);

        var options = {
          hAxis: {
            title: 'Time'
          },
          vAxis: {
            title: 'Popularity'
          }
        };

        var chart = new google.visualization.LineChart(document.getElementById('new_join'));
        chart.draw(data, options);
      }
  </script>   
</body>
</html>