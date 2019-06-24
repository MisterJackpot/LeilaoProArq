<%@ page import="DTO.LeilaoDTO" %>
<%@ page import="DTO.LanceDTO" %><%--
  Created by IntelliJ IDEA.
  User: Gabriel Loff
  Date: 24/06/2019
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="./MenuGeral.jsp" />
<%

    LeilaoDTO leilao = (LeilaoDTO) request.getAttribute("leilao");
    LanceDTO lance = (LanceDTO) request.getAttribute("lance");
    Double lanceV = 0.0;
    if(lance!=null) lanceV = lance.getValor();
    String erro = (String) request.getAttribute("erro");
%>

<%if(erro != null){%>
<script>
    alert("Valor de Lance Invalido")
</script>
<%}%>
<div class="row">
    <div class="col s12">
        <h4 class="col s6"><%=leilao.getDescricao()%></h4>

        <h4 class="col s6">Ultimo Lance: <%=lanceV.toString()%></h4>
    </div>
</div>
</body>
</html>
