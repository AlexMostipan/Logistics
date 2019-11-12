<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8" %>

  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
  <html lang="ru">

    <head>
      <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
          <meta http-equiv="X-UA-Compatible" content="ie=edge">
            <title>Niko Logistics</title>
            <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBc-cr54O1G4ho2TiBGexhxU4k2QkfPE6w&libraries=places"></script>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
              <link rel="stylesheet" href="${pageContext.request.contextPath}/pages/stylesheet.css">
                <script src="${pageContext.request.contextPath}/pages/main.js"></script>
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
                <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
                  integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
                  crossorigin="anonymous"></script>
                  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
                    integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
                    crossorigin="anonymous"></script>

                  </head>

                  <body>

                    <form action="${pageContext.request.contextPath}/site/calculateCost">
                      <div class="container-fluid bg-niko">
                        <div class="container p-5">
                          <h1>Доставка грузов</h1>
                          <p class="lead w-50">
                            С помощью нашено сервиса Вы можете расчитать стоимость доставки груза и оформить заявку на доставку.
                          </p>

                          <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio1"
                              onclick="checkImport()" value="import">
                              <label class="form-check-label" for="inlineRadio1">Хочу импортировать груз</label>
                            </div>


                            <div class="form-check form-check-inline">
                              <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2"
                                onclick="checkExport()" value="export">

                                <label class="form-check-label" for="inlineRadio2">Хочу экспортировать груз</label>
                              </div>

                              <h3>Общая информация</h3>
                              <div class="form-group">
                                <input class="form-control form-control-lg" name="citySender" type="text" id = "cityFrom" placeholder="Город отправителя">
                                </div>
                                <div class="custom-control custom-switch">
                                  <input type="checkbox" class="custom-control-input" id="customSwitch1" onclick="checkSenderPort()">
                                    <label class="custom-control-label" for="customSwitch1">Хочу указать порт</label>
                                  </div>

                                  <div class="form-group">
                                    <select class="form-control form-control-lg" name="portSender" id="port1" hidden>
                                      <c:forEach var="port" items="${ports}">
                                        <option value="<c:out value="${port.name}"/>"><c:out value="${port.name}"/></option>
                                      </c:forEach>
                                    </select>
                                  </div>
                                  <div class="form-group" >


                                    <input class="form-control form-control-lg" name="cityRecipient" type="text" id="cityTo" placeholder="Город получателя">
                                    </div>
                                    <div class="custom-control custom-switch">
                                      <input type="checkbox" class="custom-control-input" id="customSwitch2" onclick="checkRecipientPort()">
                                        <label class="custom-control-label" for="customSwitch2">Хочу указать порт</label>
                                      </div>

                                      <div class="form-group">

                                        <select class="form-control form-control-lg" name="portRecipient" id="port2" hidden>
                                          <c:forEach var="port" items="${ports}">
                                            <option value="<c:out value="${port.name}"/>"><c:out value="${port.name}"/></option>
                                          </c:forEach>
                                        </select>

                                      </div>

                                      <h3>Информация о грузе</h3>
                                      <div class="form-group">
                                        <input class="form-control form-control-lg" name="weight" type="number" placeholder="Вес (кг)">
                                        </div>
                                        <div class="form-group">
                                          <label class="control-label"  for="type1">Тип груза</label>
                                          <select class="form-control form-control-lg" name="typeCargo" id="type1">
                                            <option>Тип №1</option>
                                            <option>Тип №2</option>
                                            <option>Тип №3</option>
                                            <option>Тип №4</option>
                                          </select>
                                        </div>
                                        <div class="form-group" containers>
                                          <label class="control-label"  for="type2">Тип контейнера</label>
                                          <select class="form-control form-control-lg" name="typeContainer" id="type2">
                                          <c:forEach var="container" items="${containers}">
                                            <option value="<c:out value="${container.containerType}"/>"><c:out value="${container.containerType}"/></option>
                                          </c:forEach>
                                          </select>
                                        </div>
                                        <div class="form-group">
                                                  <label class="control-label"  for="type3">Перевозчик сушей по Украине </label>
                                                  <select class="form-control form-control-lg" name="companyLand" id="type3">
                                                    <c:forEach var="company" items="${companiesLand}">
                                                      <option value="<c:out value="${company.name}"/>"><c:out value="${company.name}"/></option>
                                                    </c:forEach>
                                                  </select>
                                                </select>
                                              </div>
                                              <div class="form-group">
                                                <label class="control-label"  for="type3">Перевозчик море </label>
                                                <select class="form-control form-control-lg" name="companySea" id="type3">
                                                  <c:forEach var="company" items="${companiesSea}">
                                                    <option value="<c:out value="${company.name}"/>"><c:out value="${company.name}"/></option>
                                                  </c:forEach>
                                                </select>
                                              </div>

                                      <button class="btn btn-success btn-lg mx-auto d-block"  >Посчитать стоимость</button>
                                    </div>

                                  </div>
                                </form>


                              </body>

                            </html>
