$(document).ready(
		function() {// 初始化
			$.ajax({ // 从服务器获取用户头像
				type : "post",
				url : "/ConferencePortal/userinfo/useravatarget.action",
				data : {},
				dataType : "json",
				success : function(result) {
					if (result.model.avatar == null)
						$("#avatar").attr("src","/ConferencePortal/images/T/error.png");
					else
						$("#avatar").attr("src", result.model.avatar);
				}
			})
		})

$(document).ready(function() { // 关于提交按钮
	$("#submitinfo").click(function() {
		var formData = new FormData($("#uploadForm")[0]);
		$.ajax({
			type : "post",
			url : "/ConferencePortal/simpleFileupload",
			/* contentType:"multipart/form-data", */
			data : formData,
			processData : false,
			contentType : false,
			dataType : "text",
			success : function(result) {
				if(result=="success"){
					window.alert("上传成功");
					location.href="";
				}else if(result=="endwrong"){
					window.alert("请上传jpg格式结尾的图片");
					$("#fileselect").val("");
				}
				else{
					window.alert("图片小于200k");
					$("#fileselect").val("");
				}
			}

		})
	})
})