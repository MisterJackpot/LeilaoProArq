<%@ page import="Model.Leilao" %>
<%@ page import="DTO.LeilaoDTO" %>
<%@ page import="DTO.LanceDTO" %><%--
  Created by IntelliJ IDEA.
  User: Gabriel Loff
  Date: 22/06/2019
  Time: 12:10
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
    <form action="leilao" method="post" class="col s12">
        <div class="row">
            <input type="hidden" name="serv" value="lance">
            <input type="hidden" name="id" value="<%=leilao.getId()%>">
            <div class="input-field col s6">
                <input id="lance" name="lance" type="number" step="0.01" class="validate">
                <label for="lance">Valor do Lance</label>
            </div>
            <div class="input-field col s6">
                <button class="btn waves-effect waves-light" type="submit" name="#">Enviar Lance
                    <i class="material-icons right">send</i>
                </button>
            </div>
        </div>
    </form>
</div>


</body>
</html>
