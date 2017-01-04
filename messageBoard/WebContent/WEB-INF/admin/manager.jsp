<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<script type="text/javascript">
$(document).ready(function(){
	 query(1);
});

function query(currentPage) {
	src = "${pageContext.request.contextPath}/admin/query";
	$.ajax({
		url:src,
		data:"&currentPage="+currentPage,
		type:"POST",
		success:function(data){
			data = eval("("+data+")");
			list = data.lists;
			
			$("tbody").empty();
			
			$.each(list, function(i, item) {
				
				if (item.status == 0) {
					status = "正在审核";
				} else if (item.status == 1) {
					status = "审核通过";
					tg = "disabled";
					jj = "";
				} else {
					status = "审核不通过";
					tg = "";
					jj = "disabled";
				}
				
				power = item.power==0?"管理员":"普通用户";
				
				var content="";
				if (i%2 == 0) {
					content += "<tr class='info'>";
					
				} else {
					content += "<tr>";
				}
				
				content += "<td><input type='hidden' name='userId' value='"+item.userId+"' />"+item.userName+"</td>"+
				"<td>"+item.nickName+"</td>"+
				"<td>"+item.createTime+"</td>"+
				"<td>"+status+"</td>"+"<td>";
				
				if (item.status == 0) {
					content += "<button class='btn btn-success btn-xs' onclick='verify("+item.userId+","+1+")'>通过</button>&nbsp;"+
					"<button class='btn btn-warning btn-xs' onclick='verify("+item.userId+","+2+")'>拒绝</button>";
				} else if (item.status == 1) {
					content += "<button class='btn btn-success btn-xs disabled'>通过</button>&nbsp;"+
					"<button class='btn btn-warning btn-xs' onclick='verify("+item.userId+","+2+")'>拒绝</button>";
				} else {
					content += "<button class='btn btn-success btn-xs' onclick='verify("+item.userId+","+1+")'>通过</button>&nbsp;"+
					"<button class='btn btn-warning btn-xs disabled'>拒绝</button>";
				}
				
				content += "</td>"+
				"<td>"+power+"</td>"+
				"<td>"+
					"<button class='btn btn-danger btn-xs' onclick='del("+item.userId+")'>删除</button>"+
				"</td>"+
				"</tr>";
				
				$("#userTable").append(content);
				
			});
			
			$("#userul").empty();
			
			page = data.page;
			var string = "";
			for(var i=1; i<=page.pageCount; i++){
				if (i==1) {
					if (currentPage == 1) {
						string += "<li class='disabled'><a>上一页</a></li>";
					} else {
						string += "<li><a href='javascript:query("+(currentPage-1)+")'>上一页</a></li>";
					}
				} 
				
				if (i == currentPage) {
					string += "<li class='active'><a>"+i+"</a></li>";
				} else {
					string += "<li><a href='javascript:query("+i+")'>"+i+"</a></li>";
				}
				
				
				if (i == page.pageCount) {
					if (currentPage == page.pageCount) {
						string += "<li class='disabled'><a>下一页</a></li>";
					} else {
						string += "<li><a href='javascript:query("+(currentPage+1)+")'>下一页</a></li>";
					}
				} 
				
			}
			
			$("#userul").append(string);
		}
	});
}

function verify(userId, status) {
	src = "${pageContext.request.contextPath}/admin/verify";
	$.ajax({
		url:src,
		data:"&userId="+userId+"&status="+status,
		type:"POST",
		success:function(data){
			data = eval("("+data+")");
			if (data.status == "success") {
				alert("审核成功");
				query(1);
			} else {
				alert("审核失败");
			}
		}
	});
}

function del(userId) {
	var flag = confirm("确定删除吗？");
	if (flag) {
		src = "${pageContext.request.contextPath}/admin/del";
		$.ajax({
			url:src,
			data:"&userId="+userId,
			type:"POST",
			success:function(data){
				data = eval("("+data+")");
				if (data.status == "success") {
					alert("删除成功");
					query(1);
				} else {
					alert("删除失败");
				}
			}
		});
	}
}
</script>
<div class="col-md-12 column">
	<br />
	<h2 class="text-center text-info">用户管理</h2>
	<br />
	<table id="userTable" class="table table-hover table-bordered">
		<thead>
			<tr>
				<th>账号</th>
				<th>昵称</th>
				<th>注册时间</th>
				<th>审核状态</th>
				<th>审核</th>
				<th>权限</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		</tbody>
	</table>
	<center>
		<ul id="userul" class="pagination"></ul>
	</center>
</div>