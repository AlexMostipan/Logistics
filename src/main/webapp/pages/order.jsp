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
  <link rel="stylesheet" href="${pageContext.request.contextPath}/pages/stylesheet.css">
  <script src="${pageContext.request.contextPath}/pages/main.js"></script>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
  integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

  <script src="https://kit.fontawesome.com/6c6dc5f601.js" crossorigin="anonymous"></script>
</head>

<body>
  <form action="${pageContext.request.contextPath}/site/recount" >
    <div class="container-fluid bg-niko">
      <div class="container p-5">
        <h1>Расчёт стоимости</h1>
        <div class="form-group">
          <label class="control-label"  for="type3">Перевозчик сушей по Украине </label>
          <select class="form-control form-control-lg" name="companyLand" onchange="" id="type3">
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
       <button class="btn btn-success btn-lg mx-auto d-block"  >Пересчитать стоимость</button>
            </form>
        <div><label class="control-label" > Расстояние  доставки сушей от ${sessionScope.citySender} к  ${sessionScope.portSender} : ${sessionScope.distanceToPort} км </label></div>
        <div><label class="control-label" > Расстояние  от между портами : ${sessionScope.distancePorts} км </label></div>

        <table class="table table-striped table-light"  >
          <thead class="thead-dark">
            <tr>
              <th>Услуга</th>
              <th>Стоимость</th>
            </tr>
          </thead>
          <tbody class="tbody-light"  >
            <tr  >
              <td>Доставка суша: </td>

          <td>${sessionScope.costLandDelivery} $</td></div>

            </tr>

            <tr>
              <td>Доставка море: </td>
                  <td><c:out value="${sessionScope.costSeaDelivery}"/> $</td>
               </tr>
                <tr>
              <td>Погрузка порт  :</td>
              <td>${sessionScope.loadingCost} $</td>
            </tr>
            <tr>
              <td>Выгрузка порт  :</td>
              <td>${sessionScope.unloadingCost} $</td>
            </tr>

              <tr>
              <td class="text-right"><strong>Итого:</strong></td>
              <td><strong>${sessionScope.allCost} $</strong></td>
            </tr>
          </tbody>
        </table>

        <form action="${pageContext.request.contextPath}/site/pdf">
          <div class="form-group">
            <input type="text" name="fullName" id="" placeholder="ФИО" class="form-control from-control-lg">
          </div>
          <div class="form-group">
            <input type="email" name="email" id="" placeholder="E-Mail" class="form-control from-control-lg">
          </div>
          <div class="form-group">
            <input type="tel" name="phone" id="" placeholder="Телефон" class="form-control from-control-lg">
          </div>

         <button class="btn btn-danger btn-lg mx-auto d-block" onclick="downloadPdf()" >Скачать PDF</button>

        </form>

        </div>

      </div>
    </form>
    <script src="main.js"></script>
   <script src="https://code.jquery.com/jquery-3.1.1.min.js">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
    integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
    crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
    integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
    crossorigin="anonymous"></script>
  </body>

  </html>
