<%@ page import="DTO.LeilaoDTO" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Gabriel Loff
  Date: 24/06/2019
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="./MenuGeral.jsp" />


<ul class="collection with-header">
    <li class="collection-header"><h5>Leilões</h5></li>
    <%
        ArrayList<LeilaoDTO> leilaos = (ArrayList) request.getAttribute("leiloes");
        for (LeilaoDTO l: leilaos) {

    %>
    <li class="collection-item"><div><%=l.getDescricao()+" - "+l.getStatus()%><a href="adminDetalhes?id=<%=l.getId()%>" class="secondary-content"><i class="material-icons">send</i></a></div></li>
    <%}%>
</ul>
</body>
</html>
