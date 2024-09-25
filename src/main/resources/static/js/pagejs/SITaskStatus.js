
		console.log("-------------------Welcome to project page------------------");
		var tableData = $('#approvaldataList').DataTable();
		var JobId;
	
		$(document).ready(function(){
			
			/*	alert("testing111");*/

			
			getListAA();
			
		});

	
//get  list
		function getListAA(){
	
	/*alert("testing");*/
	
			var i = 0;
					console.log("------approvaldataList----------");
	
					$.get(url+"getSiTaskStatusList/"+localStorage.getItem("userId"), function( data ) { //from API list
		
					
					console.log("--getProductList----data----------",$.parseJSON(data.data));
					console.log("--getProductList----data.result----------",data.result);
					//console.log("--getProductList----JobId----------",data.result[0].id);
					
					tableData.destroy();
					
										console.log("111");

       
					$('#approvaldataList.tbody').empty();
					
					console.log("111");
		
					var editIcon = function ( data, type, row ) {
				 
				console.log("--getProductList---here-------",data);
						
			        if ( type === 'display' ) {
			            
			        	i = i + 1;
			        return '<td><input type="text" class="table-input-item" placeholder="EnterRemark" id = "remark'+i+'" value='+data.Remark+'><input type="button" class="table-input-btn updateRemark" value="Update" JobId='+data.id+' cnt = '+i+'> </td>';
			        
			        }
			        
			        return data;
					};
			    
			    console.log("333");
					
					var deleteIcon = function ( data, type, row ) {
					
						console.log("--deleteIcon---here-------",data);
					
					if ( type === 'display' ) {
					
					var test=data.IncId;
				    var res = parseInt(test)-parseInt(1);
					return '<td><input type="button" class="table-input-btn cust-btn-style custom_style_btn" id="generatePdfAction" value="Create ATP" idval="'+data.IncId+'"  CustomerName="'+data.CustName+'" ProductName="'+data.Product+'">'+
				    		'<a data-auto-download href="../ProApp/GeneratePDF/ATP'+res+'.pdf" class="table-input-btn cust-btn-style custom_style_btn" download>Download ATP </a>'+
				    		'<input type="button" class="table-input-btn cust-btn-style custom_style_btn approveStatusId" id="approveStatusId" value="Approve" instId='+data.IncId+' cnt = '+i+'>'+
				    		'<input type="button" class="table-input-btn cust-btn-style custom_style_btn Reopen " value="Reopen"  instId='+data.IncId+' TEId='+data.TE_Id+'>'+
				    		'</td>';
					       
					}
					
					return data;
					};
					
					console.log("444");
					
					i++;
					var table = $('#approvaldataList').DataTable( {
				
				//	dom: 'Blfrtip',   
					buttons: ['excel', 'print'],
				 	 destroy: true,
    				 data: $.parseJSON(data.data),
    				 "initComplete": function(settings, json) {
					  },
    			
			//   scrollCollapse: true,
				
	            width: '100%',
    				 columns: [
    				    { "data": "JobId" },
    				    { "data": "CustName" },
    		            { "data": "SI" },
    		            { "data": "Product" },
    		            { "data": "Site" },
    		            { "data": "Location" },
    		            { "data": "Status" },
    		          /*  { "data": "Stages" },*/
    		            /*{ "data": editIcon },*/
    		            { "data": deleteIcon },
    				 
    				 ],
    				 /*"columnDefs": 
					 [	
		               {
		                    "targets": [ 4 ],
		                    "orderable": false
		                },
		                {
		                    "targets": [ 5 ],
		                    "orderable": false
		                }
		            ],
    				 "order": [[0, 'desc']],*/
		    } );
		    
		    
		    console.log("5555");
		    
			
	});
	}
//get  list

		
		$(document).on("click", ".approveStatusId", function(e){

			
			console.log("--------click on approveStatusId--------");
		
		 	/*var favorite = [];
            $.each($("input[name='approv']:checked"), function(){            
                favorite.push($(this).val());
            });
           
            console.log("--------click on update--------",favorite.join(", "));*/
			
			
			instId = $(this).attr("instId");
			console.log("--------click on update--instId------",instId);

			var dataVal = {
				"role": localStorage.getItem("role"),
				"incId": instId,
				"action": 19,
				"actionBy":localStorage.getItem("userId")
				
		    	}
		
			console.log("----seekApproval----click on dataVal-------",dataVal);
		
			$.ajax({
			
			type: 'POST',
			url: url+"PMSIApproveInstallation",  //from API update data
			data : JSON.stringify(dataVal),
			processData: false,
			contentType: "application/json; charset=utf-8",
    
			success: function(result) {
    	
			console.log("Update--seekApproval result==="+result);
			
			getListAA();  

			}
		});
			
			
 		
});
		
		
$(document).on("click", ".Reopen", function(e){

			
			console.log("--------click on approveStatusId--------");
		
		 	/*var favorite = [];
            $.each($("input[name='approv']:checked"), function(){            
                favorite.push($(this).val());
            });
           
            console.log("--------click on update--------",favorite.join(", "));*/
			
			
			instId = $(this).attr("instId");
			console.log("--------click on update--instId------",instId);
			var TEId = $(this).attr("TEId");
			
			var dataVal = {
				"role": localStorage.getItem("role"),
				"incId": instId,
				"teId" : TEId,
				"action": 5,
				"actionBy":localStorage.getItem("userId"),
				remark : ""
				
		    	}
		
		

 
		
			console.log("----seekApproval----click on dataVal-------",dataVal);
		
			$.ajax({
			
			type: 'POST',
			url: url+"SIReOpensJob",  //from API update data
			data : JSON.stringify(dataVal),
			processData: false,
			contentType: "application/json; charset=utf-8",
    
			success: function(result) {
    	
			console.log("Update--seekApproval result==="+result);
			
			getListAA();  

			}
		});
			
			
 		
});
