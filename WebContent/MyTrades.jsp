<%@page import="java.util.List"%>
<%@page import="com.pojo.Order"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MY TRADES</title>

</head>
<body>
<%

List<Order> Orderlist=(List<Order>)request.getAttribute("orders");


%>
	<div class="box box-info">
            <div class="box-header with-border">
              <h3 class="box-title">My Orders</h3>

              <div class="box-tools pull-right">
                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                </button>
                <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
              </div>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
              <div class="table-responsive">
                <table class="table no-margin">
                  <thead>
                  <tr>
                    <th>Customer Id</th>
                    <th>Share name</th>
                    <th>Share Id</th>
                    <th>Share Price</th>
                    <th>Total price</th>
                    
                  </tr>
                  </thead>
                  <tbody>
                <%
					for(Order o:Orderlist){
				 %>
				<tr>
				<td><%=o.getCustomerId()%></td>
				<td><%=o.getShareName()%></td>
				<td><%=o.getIsin() %></td>
				<td><%=o.getSharePrice()%></td>
				<td><%=o.getTotalPrice()%></td>
				</tr>
				<%} %>
				</tbody>
				</table>
				</div>
				</div>
				</div>
                  



</body>
</html>