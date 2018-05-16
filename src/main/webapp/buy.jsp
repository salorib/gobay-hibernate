<%@page import="com.winkle.gobay.entity.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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

        <%
            Product p = (Product) request.getAttribute("producto");
        %>


        <form action="${pageContext.request.contextPath}/pay" id="pagarForm">
            <div style="float: left" >
                <center>
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
                            <tr>
                                <td><%= p.getId()%></td>
                                <td><%= p.getName()%></td>
                                <td><%= p.getPrice()%></td>
                                <td><input type="text" id="cunt" name="cantidad" value="<%= request.getAttribute("cantidad")%>" size="5" /></td><input type="hidden" name="ItemID" value="<%= p.getId()%>" /><input type="hidden" name="buy" value="8" />
                        </tr>
                        </tbody>
                    </table>
                </center>
            </div>
        </form>

        <div style="float: left">
            <center>
                <a href='' onclick="this.href = '${pageContext.request.contextPath}/cart?add=1&ItemID=<%= p.getId()%>&cantidad=' + document.getElementById('cunt').value">
                    <button>Agregar</button>
                </a><br>
                <button type="submit" form="pagarForm" value="Submit">Comprar</button>
            </center>
        </div>  

    </body>
</html>
