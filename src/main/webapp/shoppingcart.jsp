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


        <table border="1">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Nombre</th>
                    <th>Precio</th>
                    <th>Cantidad</th>
                    <th>Subtotal</th>
                </tr>
            </thead>
            <tbody>
                <%
                    //List<Producto> catalogo = (ArrayList<Producto>) request.getAttribute("catalogo");
                    List<Item> carrito = (ArrayList<Item>) request.getAttribute("listCompra");

                    for (Item item : carrito) {%>
                <tr>
                    <td><%= item.getProduct().getId() %></td>
                    <td><%= item.getProduct().getName() %></td>
                    <td><%= item.getProduct().getPrice() %></td>
                    <td><%= item.getAmount() %></td>
                    <td><%= item.getSubtotal()%></td>
                    <td><a href="${pageContext.request.contextPath}/cart?delete=7&ItemID=<%= item.getId() %>&cantidad=0"><button>eliminar</button></a></td>
                </tr>
                <%}
                %>
            </tbody>
        </table>
        <a href="${pageContext.request.contextPath}/pay?buyAll=2"><button>Terminar Pedido</button></a> <a href="${pageContext.request.contextPath}/"><button>Continuar Comprando</button></a>

        <b><%= request.getParameter("add")%></b>
        <b><%= request.getParameter("delete")%></b>
    </body>
</html>