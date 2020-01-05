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
    <div class="left_col">
        <div class="marque">
            <h3>Voitures</h3>
            <ul>
                <li><label for="audi"><input type="checkbox" name="audi" id="audi"> AUDI</label></li>
                <li><label for="bmw"><input type="checkbox" name="bmw" id="bmw"> BMW</label></li>
                <li><label for="mercedes"><input type="checkbox" name="mercedes" id="mercedes"> MERCEDES</label></li>
                <li><label for="citroen"><input type="checkbox" name="citroen" id="citroen"> CITROEN</label></li>
                <li><label for="ford"><input type="checkbox" name="ford" id="ford"> FORD</label></li>
                <li><label for="peugeot"><input type="checkbox" name="peugeot" id="peugeot"> PEUGEOT</label></li>
                <li><label for="jeep"><input type="checkbox" name="jeep" id="jeep"> JEEP</label></li>
                <li><label for="mini"><input type="checkbox" name="mini" id="mini"> MINI COOPER</label></li>
                <li><label for="opel"><input type="checkbox" name="opel" id="opel"> OPEL</label></li>
                <li><label for="volkswagen"><input type="checkbox" name="volkswagen" id="volkswagen"> VOLKSWAGEN</label></li>
                <li><label for="scoda"><input type="checkbox" name="scoda" id="scoda"> SCODA</label></li>
                <li><label for="renault"><input type="checkbox" name="renault" id="renault"> RENAULT</label></li>
                <li><label for="fiat"><input type="checkbox" name="fiat" id="fiat"> FIAT</label></li>
                <li><label for="toyota"><input type="checkbox" name="toyota" id="toyota"> TOYOTA</label></li>
            </ul>
        </div>

        <div class="transmission">
            <h3>Transmission</h3>
            <ul>
                <li><label for="auto"><input type="checkbox" name="auto" id="auto"> Automatique</label></li>
                <li><label for="man"><input type="checkbox" name="man" id="man"> Manuelle</label></li>
                <li><label for="notr"><input type="checkbox" name="notr" id="notr"> Non precis</label></li>
            </ul>
        </div>

        <div class="model_year">
            <h3>Model Year</h3>
            <ul>
                <li><label for="2010y"><input type="checkbox" name="2010y" id="2010y"> 2010</label></li>
                <li><label for="2011y"><input type="checkbox" name="2011y" id="2011y"> 2011</label></li>
                <li><label for="2012y"><input type="checkbox" name="2012y" id="2012y"> 2012</label></li>
                <li><label for="2013y"><input type="checkbox" name="2013y" id="2013y"> 2013</label></li>
                <li><label for="2014y"><input type="checkbox" name="2014y" id="2014y"> 2014</label></li>
                <li><label for="2015y"><input type="checkbox" name="2015y" id="2015y"> 2015</label></li>
                <li><label for="2016y"><input type="checkbox" name="2016y" id="2016y"> 2016</label></li>
                <li><label for="2017y"><input type="checkbox" name="2017y" id="2017y"> 2017</label></li>
                <li><label for="2018y"><input type="checkbox" name="2018y" id="2018y"> 2018</label></li>
                <li><label for="2019y"><input type="checkbox" name="2019y" id="2019y"> 2019</label></li>
            </ul>
        </div>

        <div class="carburant">
            <h3>Carburant</h3>
            <ul>
                <li><label for="essence"><input type="checkbox" name="essence" id="essence"> Essence</label></li>
                <li><label for="diesel"><input type="checkbox" name="diesel" id="diesel"> Diesel</label></li>
                <li><label for="electric"><input type="checkbox" name="electric" id="electric"> Electric</label></li>
            </ul>
        </div>
        <div class="car_body">
            <h3>Body Type</h3>
            <ul>
                <li><label for="coupe"><input type="checkbox" name="coupe" id="coupe"> Coupé </label></li>
                <li><label  for="sedan"><input type="checkbox" name="sedan" id="sedan"> Sedan</label></li>
                <li><label for="suv"><input type="checkbox" name="suv" id="suv"> SUV</label></li>
                <li><label for="minivan"><input type="checkbox" name="minivan" id="minivan"> Minivan</label></li>
                <li><label for="pickup"><input type="checkbox" name="pickup" id="pickup"> Pickup</label></li>
                <li><label for="cabriolet"><input type="checkbox" name="cabriolet" id="cabriolet"> Cabriolet</label></li>
                <li><label for="cabriolet"><input type="checkbox" name="cabriolet" id="cabriolet"> Crossover</label></li>
            </ul>
        </div>
    </div>

    <div class="right_col">
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
                    <div class="res_info"><p>Pour <c:out value = "${days}"/> jours: <c:out value = "${days*car.price}"/> euros</p></div>
                </div>

        </c:forEach>
    </div>
</div>
</body>
</html>
