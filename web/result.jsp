<%--
  Created by IntelliJ IDEA.
  User: Erik
  Date: 20/12/2019
  Time: 23:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/header.jsp" />
<div class="containerRow">
    <div id="block1">Départ</div>
    <div id="block1">List</div>
    <div id="block2">Réservation</div>
    <div id="block2">Confirmation</div>
</div>
<div class="containerRow">
    <div class="left_col">
        <p><c:out value = "${ message }" /></p>
        <c:forEach items="${ availableCars.vehicles }" var="car">
            <div class="av_car_result">
                <div class="image"><img src="<c:out value = "${car.imageURL}"/>"></div>
                <div class="car_info">
                    <div class="car_marque_model"><c:out value = "${car.marque}"/> <c:out value = "${car.model}"/></div>
                    <div class="containerRow">
                        <div class="car_info">
                            <p><span class="name_param">Color: </span><c:out value = "${car.color}"/></p>
                            <p><span class="name_param">Carburant: </span><c:out value = "${car.carburant}"/></p>
                            <p><span class="name_param">Chevaux: </span><c:out value = "${car.chevaux}"/>cv</p>
                            <p><span class="name_param">Ports: </span><c:out value = "${car.portCount}"/></p>
                            <p><span class="name_param">Consomation: </span><c:out value = "${car.consummation}"/>l / 100km</p>
                        </div>
                        <div class="car_info">
                            <p><span class="name_param">Sieges: </span><c:out value = "${car.siegeCount}"/></p>
                            <p><span class="name_param">Trasmission: </span><c:out value = "${car.transmission}"/></p>
                            <p><span class="name_param">Type de Carosserie: </span><c:out value = "${car.bodyType}"/></p>
                            <p><span class="name_param">Cylindres: </span><c:out value = "${car.cylindersNum}"/></p>
                            <p><span class="name_param">Annee: </span><c:out value = "${car.year}"/></p>

                        </div>
                    </div>
                    <div class="button"><a href="VL-reserving?id=<c:out value = "${ car.ID }"/>" class="reserve_button">RESERVER</a></div>
                </div>
                <div class="res_info"><p class="price">Pour <c:out value = "${days}"/> jours: </p><p class="montant"><c:out value = "${days*car.price}"/> euros</p><p class="name_param">100km/1j</p></div>
            </div>


        </c:forEach>
    </div>

    <div class="right_col">

    </div>
</div>
</body>
</html>
