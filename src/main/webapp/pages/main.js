
function initialize() {
  var inputFrom = document.getElementById('cityFrom');
  new google.maps.places.Autocomplete(inputFrom);
var inputTO = document.getElementById('cityTo');
  new google.maps.places.Autocomplete(inputTO);
}
google.maps.event.addDomListener(window, 'load', initialize);

function checkSenderPort() {
    var ifcheck = document.getElementById('customSwitch1').checked;
    if (ifcheck) {
        document.getElementById('port1').hidden = false;
    } else {
        document.getElementById('port1').hidden = true;
    }
}
function checkRecipientPort() {
    var ifcheck = document.getElementById('customSwitch2').checked;
    if (ifcheck) {
        document.getElementById('port2').hidden = false;
    } else {
        document.getElementById('port2').hidden = true;
    }
}

function downloadPdf() {
document.orderForm.action = "http://localhost:8083/NikoLogistics/site/pdf";
}
function recount() {
document.orderForm.action = "http://localhost:8083/NikoLogistics/site/recount";
}

function checkExport() {
    var ifExport = document.getElementById('inlineRadio2').checked;
    if (ifExport) {
        $.get("exportPorts", function(responseXml) {
                      $("#port1").empty();// Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response XML...
               $("#port1").html($(responseXml).find("select").html()); // Parse XML, find <data> element and append its HTML to HTML DOM element with ID "somediv".
           });
//           $.get("allPorts", function(responseXml) {                // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response XML...
//                          $("#selectPortTo").html($(responseXml).find("data").html()); // Parse XML, find <data> element and append its HTML to HTML DOM element with ID "somediv".
//                      });
    }
    }
    function checkImport() {
        var ifImport = document.getElementById('inlineRadio1').checked;
        if (ifImport) {
            $.get("exportPorts", function(responseXml) {
                         $("#port2").empty();/// Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response XML...
                   $("#port2").html($(responseXml).find("select").html()); // Parse XML, find <data> element and append its HTML to HTML DOM element with ID "somediv".
               });
document.getElementById('cityFrom').hidden = false;
        }
}
function recountCost(){

 $.ajax({
                type: "POST",
                url: "http://localhost:8083/NikoLogistics/site/recount",
                data:$('#orderForm').serialize(),
                dataType: "html",

                success: function (responseXml){

                $("#lox").html($(responseXml).find("data").html());

                }
                });
}
