<%--
  Created by IntelliJ IDEA.
  User: Erik
  Date: 28/12/2019
  Time: 22:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/header.jsp" />
<div class="containerRow">
    <div id="block1">Départ</div>
    <div id="block1">List</div>
    <div id="block1">Réservation</div>
    <div id="block1">Confirmation</div>
</div>
<div class="nice_text" style="text-align: center">Merci. Réservation avec succès</div>
<div class="nice_text" style="text-align: center">Un mail a été envoyé à votre mail</div>
    <div class="av_car_result">
        <div class="containerRow">
            <div><p class="car_marque_model" style="text-align: center"><c:out value = "${car.marque}"/> <c:out value = "${car.model}"/></p><p><img src="<c:out value = "${car.imageURL}"/>"></p></div>
            <div>
                <p><span class="name_param">Color:</span> <c:out value = "${car.color}"/></p>
                <p><span class="name_param"> Carburant:</span> <c:out value = "${car.carburant}"/></p>
                <p><span class="name_param">Name:</span> <c:out value = "${client.name}"/></p>
                <p><span class="name_param">Surname:</span> <c:out value = "${client.surName}"/></p>
                <p><span class="name_param">Date reserving:</span> <c:out value = "${client.startDate}"/></p>
                <p><span class="name_param"> Date returning:</span> <c:out value = "${client.endDate}"/></p>
            </div>
        </div>
    </div>
<div style="text-align: center"><a href="VL-location" class="reserve_button">Retour à la page principal</a></div>
</body>
</html>
