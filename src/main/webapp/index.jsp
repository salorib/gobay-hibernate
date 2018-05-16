<%@page import="com.winkle.gobay.entity.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns:h="http://java.sun.com/jsf/html" xmlns:f="http://java.sun.com/jsf/core">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>GoBay</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/main.css" media="screen">        
    </head>
    <body>
    <header>
        <nav>
            <div id="navhead">
                <h1>GoBay</h1>
            </div>
            <div id="navlinks">
                <a href="${pageContext.request.contextPath}/" id="home">Home</a>
            </div>
            <div id="navlinks">
                <a href="${pageContext.request.contextPath}/cart" id="cart">Carrito</a>
            </div>
        </nav>
    </header>

    <div align="center">

        <table border="1">
            <thead>
                <tr>
                    <th>clave</th>
                    <th>nombre</th>
                    <th>precio</th>
                    <th>cantidad</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<Product> myList = (ArrayList<Product>) request.getAttribute("catalogo");
                    int v = 1;

                    if (myList.isEmpty()) {%>
                <tr>
                    <td>NA</td>
                    <td>NA</td>
                    <td>NA</td>
                    <td>NA</td>
                </tr>
                <%
                     } else {
                        for (Product p : myList) {%>
                <tr>
                    <td><%=p.getId()%></td>
                    <td><%=p.getName()%></td>
                    <td><%=p.getPrice()%></td>
                    <td><a href="${pageContext.request.contextPath}/buy?ItemID=<%= p.getId()%>" target="_parent"><button>comprar</button></a></td>
                </tr>
                <%      }
                    }
                %>        
            </tbody>
        </table>
    </div>    
</body>
</html>
