<%--
  Created by IntelliJ IDEA.
  User: Erik
  Date: 28/12/2019
  Time: 22:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/header.jsp" />
<div>Merci. Réservation avec succès</div>
<div>Un mail a été envoyé à votre mail</div>
    <div class="av_car_result">
        <div class="car_marque_model"><c:out value = "${car.marque}"/> <c:out value = "${car.model}"/></div>
        <div class="image"><img src="<c:out value = "${car.imageURL}"/>"></div>
        <div class="car_color">Color: <c:out value = "${car.color}"/> Carburant: <c:out value = "${car.carburant}"/></div>
        <div class="car_color">Name: <c:out value = "${client.name}"/> Surname: <c:out value = "${client.surName}"/></div>
        <div class="car_color">Date reserving: <c:out value = "${client.startDate}"/> Date returning: <c:out value = "${client.endDate}"/></div>

    </div>
<a href="VL-location">HOME</a>
</body>
</html>
