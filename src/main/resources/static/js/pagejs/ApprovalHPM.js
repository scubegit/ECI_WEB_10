
		console.log("-------------------Welcome to project page------------------");
		var tableData = $('#approvaldataList').DataTable();
		var JobId;
	
		$(document).ready(function(){
			
			getList();
			
		});

	
//get  list
		function getList(){
	
			var i = 0;
					console.log("------approvaldataList----------");
	
					$.get(url+"getApprovalHPMList", function( data ) { //from API list
		
					
					console.log("--getProductList----data----------",data);
					console.log("--getProductList----data.result----------",data.result);
					//console.log("--getProductList----JobId----------",data.result[0].id);
					
					tableData.destroy();
       
					$('#approvaldataList.tbody').empty();
		
					var editIcon = function ( data, type, row ) {
				 
						//console.log("--getProductList---here-------",data.id);
						
			        if ( type === 'display' ) {
			            
			        	i = i + 1;
			        return '<td><input type="text" class="table-input-item" placeholder="EnterRemark" id = "remark'+i+'" value='+data.Remark+'><input type="button" class="table-input-btn updateRemark" value="Update" JobId='+data.id+' cnt = '+i+'> </td>';
			        
			        }
			        
			        return data;
					};
			    
					
					var deleteIcon = function ( data, type, row ) {
					
					if ( type === 'display' ) {
					
					return '<td><input type="button" class="table-input-btn updateRemark" id="approveStatusId" value="Approve" instId='+data.id+' cnt = '+i+'> </td>';
					       
					}
					
					return data;
					};
					i++;
					var table = $('#approvaldataList').DataTable( {
				
					dom: 'Blfrtip',   
					buttons: ['excel', 'print'],
				 	 destroy: true,
    				 data: data.result,
    				 "initComplete": function(settings, json) {
					  },
    				 
    				 columns: [
    				    { "data": "JobId" },
    				    { "data": "CustomerName" },
    		            { "data": "SI" },
    		            { "data": "ProductName" },
    		            { "data": "Site" },
    		            { "data": "Location" },
    		            { "data": "Status" },
    		          /*  { "data": "Stages" },*/
    		            /*{ "data": editIcon },*/
    		            { "data": deleteIcon },
    				 
    				 ],
    				 "columnDefs": 
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
    				 "order": [[0, 'desc']],
		    } );
			
	});
	}
//get  list

		
		$(document).on("click", "#approveStatusId", function(e){

			
			console.log("--------click on approveStatusId--------");
		
		 	/*var favorite = [];
            $.each($("input[name='approv']:checked"), function(){            
                favorite.push($(this).val());
            });
           
            console.log("--------click on update--------",favorite.join(", "));*/
			
			
			instId = $(this).attr("instId");
			console.log("--------click on update--instId------",instId);

			var dataVal = {
				
				"id": instId,
				"authKey":localStorage.getItem("userId")
				
		    	}
		
			console.log("----seekApproval----click on dataVal-------",dataVal);
		
			$.ajax({
			
			type: 'POST',
			url: url+"approvalStatusId",  //from API update data
			data : JSON.stringify(dataVal),
			processData: false,
			contentType: "application/json; charset=utf-8",
    
			success: function(result) {
    	
			console.log("Update--seekApproval result==="+result);
			
			getList();  

			}
		});
					
});
		
