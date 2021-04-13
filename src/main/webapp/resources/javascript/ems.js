
		$(document).ready(function(){
			//Add Popup
			$('.add-employee').click(function(){
				$('#save').val('Add');
				$('#save').show();
	         	$('#modal-title').text('Add New Employee');
	        	$('#update-action').val('ADD'); 
	        	$('#validationSummary').hide();
	        	$('#employee-name').focus();
	        	$('#employee-id').val('');
	        	$('#employee-code').val('');
	        	$('#employee-name').val('');
	        	$('#employee-email').val('');
	        	$('#employee-password').val('');
	        	$('#employee-department').val('');
	        	$('#employee-project').val('');
				$('#employee-modal').modal('show');	
			});
			
			//View Popup
			$('.view-employee').click(function(){
				//var emp_id=$(this).parent().data('emp_id');
	         	//var emp_code=$(this).parent().data('emp_code');
	         	var emp_name = $(this).parent().data('emp_name');
	         	var emp_email = $(this).parent().data('emp_email');
	         	var emp_pass = $(this).parent().data('emp_pass');
	         	var emp_dept = $(this).parent().data('emp_dept');
	         	var emp_prj = $(this).parent().data('emp_prj');
	         	var emp_join = $(this).parent().data('emp_join');
				$('#save').hide();
	         	$('#modal-title').text('Employee Details');
	        	$('#update-action').hide(); 
	        	$('#validationSummary').hide();
	        	$('#employee-name').focus();
	        	$('#employee-name').val(emp_name);
	        	$('#employee-email').val(emp_email);
	        	$('#employee-password').val(emp_pass);
	        	$('#employee-department').val(emp_dept);
	        	$('#employee-project').val(emp_prj);
				$('#employee-modal').modal('show');	
			});
			
			//Edit Popup
			$('.edit-employee').click(function(){
				var emp_id = $(this).parent().data('emp_id');
	         	var emp_code = $(this).parent().data('emp_code');
	         	var emp_name = $(this).parent().data('emp_name');
	         	var emp_email = $(this).parent().data('emp_email');
	         	var emp_pass = $(this).parent().data('emp_pass');
	         	var emp_dept = $(this).parent().data('emp_dept');
	         	var emp_prj = $(this).parent().data('emp_prj');
	         	var emp_join = $(this).parent().data('emp_join');
				$('#save').show();
				$('#save').val('Save Changes');
	         	$('#modal-title').text('Edit Employee Details');
	         	$('#update-action').val('UPDATE');
	        	$('#validationSummary').hide();
	        	$('#employee-name').focus();
	        	$('#employee-id').val(emp_id);
	        	$('#employee-code').val(emp_code);
	        	$('#employee-name').val(emp_name);
	        	$('#employee-email').val(emp_email);
	        	$('#employee-password').val(emp_pass);
	        	$('#employee-department').val(emp_dept);
	        	$('#employee-project').val(emp_prj);
	        	$('#employee-join').val(emp_join);
				$('#employee-modal').modal('show');	
			});
			
			$('#save').click(function(){
				var emp_id = $('#employee-id').val();
			 	var emp_code = $('#employee-code').val();
				var emp_name = $('#employee-name').val();
	        	var emp_email = $('#employee-email').val();
	        	var emp_pass = $('#employee-password').val();
	        	var emp_dept = $('#employee-department').val();
	        	var emp_prj = $('#employee-project').val();
	        	var emp_join = $('#employee-join').val();
	        	var action = $('#update_action').val();
	        	if(emp_id=='' && emp_code=='')
	        	{
	        		$("#validationSummary").attr("class","alert alert-warning");
		   	        $("#validationSummary").html("<b>Please wait...</b>");
		   	        $("#validationSummary").show();
		   	       	var data1 = $('#employee-form').serialize();
		   	        $.ajax({
		 	         	type: "post",
		 	        	url: "/ems/addemployee",
		 	        	dataType: "json",
		 	        	data : JSON.stringify(data1),
		 	        	success: function(data){
		 	        		var result = '<tr>';
		 	        		result+= '<td>'+ data.emp_id +'</td>';
		 	        		result+= '<td>'+ data.emp_name + '</td>';
		 	        		result+= '<td data-emp_id="'+ data.emp_id +'"';
		 	        		result+= ' data-emp_code="'+ data.emp_code  +'"';
		 	        		result+= ' data-emp_name="'+ data.emp_name  +'"';
		 	        		result+= ' data-emp_email="'+ data.emp_email  +'"';
		 	        		result+= ' data-emp_pass="'+ data.emp_pass  +'"';
		 	        		result+= ' data-emp_dept="'+ data.emp_dept  +'"';
		 	        		result+= ' data-emp_prj="'+ data.emp_prj  +'"';
		 	        		result+= ' data-emp_join="'+ data.emp_join  +'"';
		 	        		result+= '><button role="button" class="btn btn-link view-employee" data-modal="employee-modal">';
					        result+= '<i class="fas fa-eye text-dark"></i>';
					        result+= '</button>';
					        result+= '<button role="button" class="btn btn-link edit-employee">';
					        result+= '<i class="fas fa-pencil-alt text-warning"></i>';
					        result+= '</button>';
					        result+= '<button role="button" class="btn btn-link">';
					        result+= '<i class="fas fa-trash text-danger"></i>';
					        result+= '</button>';
		 	        		result+= '</td>';	
		 	        		result+= '</tr>';
		 	        		$('#example').append(result);
		 	        		alert(data);
		 	        		alert(data.emp_id);
		 	        		console.log(data);
		 	        		console.log(data.emp_id);
		 	        		console.log(typeof(data));
		 	        		console.log(typeof(data.emp_id));
		 	        	},
		 	        	error: function(err){
		 	        		console.log(err);	
		 	        	}
		 	        });
	        	}
	        	else if(emp_id!='' && emp_code!='' ){
	        		$("#validationSummary").attr("class","alert alert-warning");
		   	        $("#validationSummary").html("<b>Please wait...</b>");
		   	        $("#validationSummary").show();
		   	       var data1 = $('#employee-form').serialize();
		   	        $.ajax({
		 	         	type: "post",
		 	        	url: "/ems/editemployee",
		 	        	dataType: "json",
		 	        	data : JSON.stringify(data1),
		 	        	success: function(data){
		 	        	
		 	        	},
		 	        	error: function(err){
		 	        	console.log(err);	
		 	        	
		 	        	}
		 	 
			 			});
	        
	        	}
	        	/*else{
	        		$.ajax({
		 	         	type: "post",
		 	        	url: "/ems/deleteemployee",
		 	        	dataType: "json",
		 	        	data : {emp_id:emp_id},
		 	        	success: function(data){
		 	        		console.log(data);
		 	        		},
		 	        	error: function(err){
		 	        	console.log(err);	
		 	        	
		 	        	}
		 	 
			 			});
	        	}*/
			});
			
	});
			/*
			 $('#save').button().click(function(){
			 		alert('hello');
				 	var emp_id = $('#employee-id').val();
				 	var emp_code = $('#employee-code').val();
					var emp_name = $('#employee-name').val();
		        	var emp_email = $('#employee-email').val();
		        	var emp_pass = $('#employee-password').val();
		        	var emp_dept = $('#employee-department').val();
		        	var emp_prj = $('#employee-project').val();
		        	var emp_join = $('#employee-join').val();
		        	if(emp_id==''&&emp_code==''){
		        		console.log(emp_join);
		        		$("#validationSummary").attr("class","alert alert-warning");
		   	         	$("#validationSummary").html("<img src='../img/6.gif' alt='loading'/> <b>Please wait...</b>");
		   	         	$("#validationSummary").show();
		   	         $.ajax({
		 	         	type: "post",
		 	        	url: "/ems/addemployee",
		 	        	data: {	emp_name:emp_name, 
		 	        			emp_email:emp_email,
		 	        			emp_pass:emp_pass,
		 	        			emp_dept:emp_dept,	
		 	        			emp_prj:emp_prj,
		 	        			emp_join:emp_join
		 	        	},
		 	        	success: function(data){
		 	        		alert(data);
		 	        		}
		 	 
			 			});
		        	}
			 });		
		});*/

