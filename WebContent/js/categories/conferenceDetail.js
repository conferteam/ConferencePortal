$(document).ready(function(){
	$.ajax({
		url: "/ConferencePortal/conferenceInfo/queryCategories.action",
		success: function (data){ 
			console.log(data, "ccc");
			document.getElementById("Categories").innerHTML=data;
			/* $("#byCategories").html(data);  */
			}
	});
	
	$.ajax({
		url: "/ConferencePortal/conferenceInfo/queryByDate.action",
		success: function (data){ 
			console.log(data, "bbb");
			/* document.getElementById("byDate").innerHTML=data; */
			$("#byDate").html(data); 
			}
	});

});

