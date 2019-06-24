<%@ page import="DTO.LeilaoDTO" %>
<%@ page import="DTO.LanceDTO" %><%--
  Created by IntelliJ IDEA.
  User: Gabriel Loff
  Date: 24/06/2019
  Time: 15:10
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

%>

<div class="row">
    <div class="col s12">
        <h4 class="col s6"><%=leilao.getDescricao()%></h4>

        <h4 class="col s6">Ultimo Lance: <%=lanceV.toString()%></h4>
    </div>
</div>
<div class="row">
    <form action="admLeilao" method="post" class="col s12">
        <div class="row">
            <input type="hidden" name="serv" value="adm">
            <input type="hidden" name="id" value="<%=leilao.getId()%>">
            <label>
                <input name="op" type="radio" value="Encerrar" checked />
                <span>Encerrar</span>
            </label>
            <label>
                <input name="op" type="radio" value="Cancelar"/>
                <span>Cancelar</span>
            </label>
            <div class="input-field col s6">
                <button class="btn waves-effect waves-light" type="submit" name="#">Executar</button>
            </div>
        </div>
    </form>
</div>


</body>
</html>