<%@page import="com.winkle.gobay.entity.Item"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/main.css" media="screen">
        <title>GoBay</title>
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
        <%
            List<Item> list = (ArrayList<Item>) request.getAttribute("list");
            double total = 0;
        %>                

        <div align="center">
            <form action="${pageContext.request.contextPath}/pay" method="POST">
                <table border="1">
                    <thead>
                        <tr>
                            <th>clave</th>
                            <th>Nombre</th>
                            <th>Precio</th>
                            <th>Cantidad</th>
                            <th>Subtotal</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            for (Item item : list) {
                        %>
                        <tr>
                            <td><%= item.getProduct().getId()%></td>
                            <td><%= item.getProduct().getName()%></td>
                            <td><%= item.getProduct().getPrice()%></td>
                            <td><%= item.getAmount()%></td>
                            <td><%= item.getSubtotal()%></td>
                        </tr>
                        <%
                                total += item.getSubtotal();
                            }
                            list.clear();
                        %>
                        <tr>
                            <td colspan="3"></td>
                            <td>Total</td>
                            <td><%= total%></td>
                        </tr>
                    </tbody>
                </table>
                        <%-- Dont do this, insecure --%>
                        <input type="hidden" name="total" value="<%= total %>" />
                <a><button>Pagar</button></a>
            </form>
        </div>


    </body>
</html>