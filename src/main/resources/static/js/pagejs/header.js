/**
 * 
 */console.log("--FOR CHANGE PASSWORD---");

$(document).ready(function() 
	{
	
	console.log("uname-in header---",localStorage.getItem("uname"));
	
	
	if(localStorage.getItem("uname")=="")
	{
		window.location.replace('index');
	}
	
	
	
	$("#logName").text(localStorage.getItem("uname"));
	$("#logName1").text(localStorage.getItem("uname"));
	
	 // $("#logName").attr("href", localStorage.getItem("authkey"));
	// change pswd modal
	$("#pswdChangeAction").bind("click",function(){
		emptyAllField();
		$("#passErr").empty();
		
		console.log("change pswd button clicked.11");	
	//	displayemp();
		$("#pswd_userdiv").modal('show');
		//$("#Err pull-left").reset();
		});	
				
});//doc ready
//$("#pswd_userdiv").empty();
//$("#pswd_userdiv").modal('hide');

function OnSignOut()
{

	localStorage.setItem("authkey", "");
	localStorage.setItem("role", "");
	localStorage.setItem("uname", "");
	localStorage.setItem("userId", "");

	window.location.replace('index');

	
}


	function displayemp(){

		$.ajax({
		url  : "readEmpiD?"+new Date().getTime(),
		type : 'POST',
		async: false,
	
		success : function(res) 
		{
			var CtrObj = $.parseJSON(res);
			
			console.log("----",CtrObj);
			console.log("----",CtrObj.Emp_Email);
			$("#pswdemail").empty();
			$("#pswdemail").append(CtrObj.Emp_Email);
			if (CtrObj.result == "success"){
				$.each( CtrObj, function( index, value ){
					
				});
//passErr				
			}
	  }
});
	
	
}
	
	/*if(document.AddChangePswd.txtoldpswd.value == "")
	{
	alert('Please input old password');
	document.AddChangePswd.txtoldpswd.focus();
	
	} */
	
/*// onclick password change
	$(document).on("click", "#AddChangePswd", function(e){
		
		console.log("uname================  ",localStorage.getItem("uname"));
		console.log("authkey==============  ",localStorage.getItem("authkey"));
		console.log("old password is  ",$("#txtoldpswd").val());
		console.log("new password is  ",$("#txtnewpswd").val());		
		console.log("confirm new password ",$("#txtcnfmpswd").val());
		
		if(NotAllowedNullVal("#passErr","Old Password",$('#txtoldpswd')))
		if(NotAllowedNullVal("#passErr","New Password",$('#txtnewpswd')))
		if(NotAllowedNullVal("#passErr","Confirm Password" ,$('#txtcnfmpswd')))
		if(ValidatePswd("#passErr","New Password",$('#txtnewpswd'),$('#txtcnfmpswd')))
			{
			
			data= {
				    "oldpassword":$("#txtoldpswd").val(),
				    "newpassword":$("#txtnewpswd").val(),
					"emppassword":$("#txtcnfmpswd").val(),
					"userName"    : localStorage.getItem("uname"),
					"authKey"      : localStorage.getItem("authkey")
				 }
			console.log("--------click on dataVal-------",data);
			
			$.ajax({
				   type: 'POST',
				   url: url+"changePswd",  //from API add new data
				   data : JSON.stringify(data),
				  // processData: false,
				   contentType: "application/json; charset=utf-8",
	 
				   success : function(res) 
				   {
					   
					   console.log("res----",res);
					   console.log("res.result----",res.result);
					   
					   $("#passErr").empty();
					      
					   if (res.result == "success"){
						   
						$("#pswd_userdiv").modal('hide');
						
						window.location.href="index?PFlag=cp" ;
						
						console.log("PFlag---PFlag---PFlag---PFlag-",PFlag);
						
					//    ('<a id="" data-toggle="" >' Your Password has been changed, Login Again '</a></p>');
						
					   }else if(CtrObj.result == "NoData"){
						   
						$("#passErr").empty();
						//$("#passErr").append("You Enter Incorrect Old Password");	
					   }
					
				}	
				
		});
	}
});	
*/	
	function emptyAllField(){
		
		document.getElementById('pswdemail').value = "";
		document.getElementById('txtoldpswd').value = "";
		document.getElementById('txtnewpswd').value = "";
		document.getElementById('txtcnfmpswd').value = "";
		
	}
