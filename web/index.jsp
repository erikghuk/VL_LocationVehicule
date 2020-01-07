<%@ page import="com.erik.model.Parc" %>
<%@ page import="com.erik.model.Vehicle" %>
<%--
  Created by IntelliJ IDEA.
  User: Erik
  Date: 21/11/2019
  Time: 23:07
  To change this template use File | Settings | File Templates.
--%>
<jsp:include page="/header.jsp" />
<div class="container">
  <div class="form_div">
    <form method="post" action="VL-result" autocomplete="off">
        <label for="car_type_select">Type</label>
        <select name="car_type" id="car_type_select" class="type">
            <option value="tourism">Tourisme</option>
            <option value="sport">Sport</option>
            <option value="camion">Camion</option>
        </select>
        <input type="text" id="date-range1-1" class="date" size="45" name="dateRange" placeholder="Merci de choisir une date" required>
        <button class="buton button2">Chercher</button>
    </form>
  </div>
    <div class="text_col">
        <p class="text_descr">Envie de louer une voiture incroyable ? Tentez l'aventure et vivez un moment magique au volant d'une voiture au cheval cabre.
            Vous serez ravis des performances inegalees de ces modeles !
            Vous aurez l'impression de conduire une voiture de course avec une facilite deconcertante
            et en prenant un plaisir inimaginable. Vous pouvez contacter nos agences de Paris,
            Cannes, Nice et Monaco pour prendre possession de la Ferrari de votre choix pour un jour, une semaine et meme un mois.</p>
    </div>
</div>
</body>
</html> 
