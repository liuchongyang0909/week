<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fm"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%
	String path=request.getContextPath();
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" type="text/css" href="<%=path%>/css/index_work.css"/> 
  <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
</head>
<body>
	<table>
		<thead>
			<tr>
				<td colspan="100">降水量列表</td>
			</tr>
			<tr>
				<td colspan="3">
					<form action="list">
						<span>省</span>
						<select id="province" name="sid">
							<option value="0" selected="selected">-- 请选择 --</option>
						</select>
						<span>市</span>
						<select id="city" name="cid">
							<option value="0" selected="selected">-- 请选择 --</option>
						</select>
						<span>县</span>
						<select id="county" name="xid">
							<option value="0" selected="selected">-- 请选择 --</option>
						</select>
						<input type="button" value="查询">
					</form>
				</td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>测量区域</td>
				<td>降水量(毫米)</td>
				<td>测试时间</td>
				<td>测量人</td>
			</tr>
			<c:forEach items="${info.list}" var="l">
				<tr>
					<td>${l.dname }</td>
					<td>${l.number }</td>
					<td>${l.testdate }</td>
					<td>${l.people }</td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="100">
					<a href="list?pageNum=1">首页</a>
					<a href="list?pageNum=${info.prePage }">上一页</a>
					<a href="list?pageNum=${info.nextPage }">下一页</a>
					<a href="list?pageNum=${info.pages }">尾页</a>
				</td>
			</tr>
		</tfoot>
	</table>
</body>
<script type="text/javascript">
$(function() {
	$.ajax({
		type:'get',
		url:"findProvince",
	    dataType:'json',
		success: function(parseArray) {
			$('#province option').remove();
			$('#province').append("<option value='0' selected='selected'>-- 请选择 --</option>");
			for(var i in parseArray) {
				$('#province').append("<option value='" + parseArray[i].aid + "'>" + parseArray[i].aname + "</option>")
			}
		}
	});
});

$(function() {
	$('#province').change(function() {
		$.ajax({
			type:"get",
			url:"findNext?id=" + $(this).val(),
			dataType:'json',
			success: function(array) {
				$('#city option').remove();
				$('#city').append("<option value='0' selected='selected'>-- 请选择 --</option>");
				for(var i in array) {
					$('#city').append("<option value='" + array[i].aid + "'>" + array[i].aname + "</option>")
				}
			}
		});
	});
});

$(function() {
	$('#city').change(function() {
		$.ajax({
			type: "get",
			url:"findNext?id=" + $(this).val(),
			dataType:'json',
			success: function(array) {
				$('#county option').remove();
				$('#county').append("<option value='0' selected='selected'>-- 请选择 --</option>");
				for(var i in array) {
					$('#county').append("<option value='" + array[i].aid + "'>" + array[i].aname + "</option>")
				}
			}
		});
	});
});
</script>
</html>