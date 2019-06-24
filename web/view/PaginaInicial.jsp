<%@ page import="java.util.ArrayList" %>
<%@ page import="Model.Leilao" %>
<%@ page import="DTO.LeilaoDTO" %><%--
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
    <li class="collection-header"><h5>Leilões Ativos</h5></li>
    <%
        ArrayList<LeilaoDTO> leilaos = (ArrayList) request.getAttribute("leiloes");
        for (LeilaoDTO l: leilaos) {

    %>
    <li class="collection-item"><div><%=l.getDescricao()%><a href="leilao?id=<%=l.getId()%>" class="secondary-content"><i class="material-icons">send</i></a></div></li>
    <%}%>
</ul>
<ul class="collection with-header">
    <li class="collection-header"><h5>Seus Leiloes</h5></li>
    <%
        ArrayList<LeilaoDTO> meusLeiloes = (ArrayList) request.getAttribute("meusLeiloes");
        for (LeilaoDTO l: meusLeiloes) {%>
    <li class="collection-item"><div><%=l.getDescricao()%><a href="leilao?id=<%=l.getId()%>" class="secondary-content"><i class="material-icons">send</i></a></div></li>
    <%}%>
</ul>
<div class="row">
    <div class="col s12 m6">
        <div class="card grey lighten-3">
            <div class="card-content">
                <span class="card-title">Criar Leilão</span>
                <form action="criarLeilao" method="post">
                    <div class="row">
                        <div class="input-field col s6 m6">
                            <input id="descricao" name="desc" type="text" class="validate">
                            <label for="descricao">Descrição</label>
                        </div>
                        <div class="input-field col s6 m6">
                            <input id="valor" type="number" step="0,01" class="validate">
                            <label for="valor">Valor Inicial</label>
                        </div>
                    </div>
                    <div class="row">
                        <button class="btn waves-effect waves-light" type="submit" name="criarLeilao">Criar
                            <i class="material-icons right">send</i>
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

</body>
</html>
