<%@ page import="java.util.ArrayList" %>
<%@ page import="Model.Leilao" %><%--
  Created by IntelliJ IDEA.
  User: Gabriel Loff
  Date: 21/06/2019
  Time: 18:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="./MenuGeral.jsp" />


<ul class="collection with-header">
    <li class="collection-header"><h4>Leilões Ativos</h4></li>
    <%
        ArrayList<Leilao> leilaos = (ArrayList) request.getAttribute("leiloes");
        for (Leilao l: leilaos) {

        %>
    <li class="collection-item"><div><%=l.getNome()%><a href="#!" class="secondary-content"><i class="material-icons">send</i></a></div></li>
    <%}%>
</ul>

</body>
</html>
