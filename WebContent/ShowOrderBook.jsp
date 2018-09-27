<%@page import="com.pojo.Order"%>
<%@page import="java.util.List"%>
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

List<Order> AllOrders=(List<Order>)request.getAttribute("orders");


%>
	<div class="box box-info">
            <div class="box-header with-border">
              <h3 class="box-title">OrderBook for Today</h3>

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
                  	<th>Time</th>
                    <th>Customer Id</th>
                    <th>Company name</th>
                    <th>Share Type</th>
                    <th>ISIN</th>
                    <th>Share Price</th>
                    <th>Quantity</th>
                    <th>Total price</th>
                    <th>Buy/Sell</th>
                  
                  </tr>
                  </thead>
                  <tbody>
                <%
					for(Order o:AllOrders){
				 %>
				<tr>
				<td><%=o.getTimeStamp()%></td>
				<td><%=o.getCustomerId()%></td>
				<td><%=o.getShareName()%></td>
				<td><%=o.getShareType()%></td>
				<td><%=o.getIsin()%></td>
				<td><%=o.getSharePrice()%></td>
				<td><%=o.getShareQuantity()%></td>
				<td><%=o.getTotalPrice()%></td>
				<td><%=o.getBuySell()%></td>
				</tr>
				<%} %>
				</tbody>
				</table>
				</div>
				</div>
				</div>
                  



</body>
</html>