<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@ include file="include/header.jsp"%>
<br/>
<br/>

<table>
	<thead>
		<tr align=center height="30px">
			<th>#</th>
			<th>이름</th>
			<th>종류</th>
			<th>가격</th>
			<th>판매수</th>
		</tr>
	</thead>
	
	<tbody id="my__tbody">
<!-- 	 리스트라서 FOR문  var=사용할 변수 명  items('복수'여려건이라서) collection객체  -->
		<c:forEach var="product" items="${products}">
			<tr align=center height="30px" id="product-${product.id}">
				<td>${product.id}</td>
				<td>${product.name}</td>
				<td>${product.type}</td>
				<td>${product.price}</td>
				<td>${product.count}</td>
				<td>
					<i class="large material-icons" onclick="deleteItem(${product.id})" style="cursor: pointer;">delete</i>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<script>
	function append(result, listType) {
		for (var product of result){
			
			var string =
				"					<tr id=\"product-"+product.id+"\">\r\n" + 
				"						<td>"+product.id+"</td>\r\n" + 
				"						<td>"+product.name+"</td>\r\n" + 
				"						<td>"+product.type+"</td>\r\n" + 
				"						<td>"+product.price+"</td>\r\n" + 
				"						<td>"+product.count+"</td>\r\n" + 
				"						<td><i class=\"large material-icons\" onclick=\"deleteItem("+product.id+")\" style=\"cursor:pointer;\">delete</i></td>" +
				"					</tr>";
			
			$('#my__tbody').append(string);
		}
	}

	function deleteItem(productId) {
		
		console.log(productId);
		
		$.ajax({
			type : "get",
			url : "cont?cmd=delete&productId="+productId,
			dataType : "json"
			
		}).done(function (result) {
			if(result == "1"){
				$("#product-"+productId).remove();
				alert("삭제에 성공함.");				
			} else{
				alert("왜일까요? .");
			}
			
// 			$("#my__tbody").empty();
// 			append(result);
		}).fail(function (result) {
			alert("삭제 실패얌.");
		});	
	}

	function reset() {
		
		$.ajax({
			type : "get",
			url : "cont?cmd=reset",
			dataType : "json"
			
		}).done(function (result) {		
			$("#my__tbody").empty();
			append(result);
			
		}).fail(function (result) {	
		});
	}
	
function priceAsc() { 
		
		$.ajax({
			type : "get",
			url : "cont?cmd=priceAsc",
			dataType : "json"
			
		}).done(function (result) {
			$("#my__tbody").empty();
			append(result);
			
		}).fail(function (result) {
			alert("실패");
		});
		
	}

function priceDesc() {
		
		$.ajax({
			type : "get",
			url : "cont?cmd=priceDesc",
			dataType : "json"
			
		}).done(function (result) {
			$("#my__tbody").empty();
			append(result, "priceDesc");
			
		}).fail(function (result) {
		});
	}
	
function countDesc() {
		
		$.ajax({
			type : "get",
			url : "cont?cmd=countDesc",
			dataType : "json"
			
		}).done(function (result) {
			$("#my__tbody").empty();
			append(result);
			
		}).fail(function (result) {	
		});
	}
</script>

</body>
</html>

