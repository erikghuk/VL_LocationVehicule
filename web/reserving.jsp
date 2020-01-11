<%--
  Created by IntelliJ IDEA.
  User: Erik
  Date: 21/12/2019
  Time: 00:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/header.jsp" />
<div class="containerRow">
    <div id="block1">Départ</div>
    <div id="block1">List</div>
    <div id="block1">Réservation</div>
    <div id="block2">Confirmation</div>
</div>
    <p><c:out value = "${ message }" /></p>
<div class="av_car_result">
    <div class="car_info">
        <div class="car_marque_model"><c:out value = "${car.marque}"/> <c:out value = "${car.model}"/></div>
        <div class="containerRow">
            <div class="image"><img src="<c:out value = "${car.imageURL}"/>"></div>
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
        <div class="res_info"><p class="price">Pour <c:out value = "${days}"/> jours:</p> <p class="montant"> <c:out value = "${days*car.price}"/> euros</p></div>
    </div>
</div>
    <div class="res">
        <form action="VL-confirmation" method="post">
            <p><input type="text" name="client_surname" placeholder="Entré votre nom" size="50" required></p>
            <p><input type="text" name="client_name" placeholder="Entré votre prénom" size="50" required></p>
            <p><input type="text" name="client_address" placeholder="Entré votre address" size="50" required></p>
            <p><input type="email" name="client_email" placeholder="Entré votre address e-mail" size="50" required></p>
            <p><input type="text" name="client_startDate" value='<c:out value = "${startDate}"/>' readonly  size="50"></p>
            <p><input type="text" name="client_endDate" value='<c:out value = "${endDate}"/>' readonly size="50"></p>
            <p><input type="checkbox" name="condition" required>Je suis d'accord avec les <a href="">conditions general</a> </p>
            <p><button class="reserve_button">RESERVER</button>
        </form>
    </div>


</body>
</html>
