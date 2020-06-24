<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<style>
	table {width: 60%;}
	table, th, td {
		border: 1px solid;
		colspan: 2;
		}
</style>
</head>
<div class=btn-group>
<!--  onclick : 클릭시 발생하는 이동경로  type :  button 타입 -->
	<button onclick="reset()" type="button" class="btn btn-outline-primary">초기화</button>
	<button onclick="priceAsc()" type="button" class="btn btn-outline-info">가격 오름차순</button>
	<button onclick="priceDesc()" type="button" class="btn btn-outline-info">가격 내림차순</button>
	<button onclick="countDesc()" type="button" class="btn btn-outline-success">판매순</button>
</div>