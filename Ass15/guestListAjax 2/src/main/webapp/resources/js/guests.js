$(function() {
    $("#send").click(updateGuests);
});

function updateGuests() {
    var first = $("#first").val();
    var last = $("#last").val();

    if(first != "" && last!= ""){
        $.ajax("guest.ajax", {
        		"type": "post",
        		"data": {
                	"first": first,
                    "last": last
        		}
        }).done(displayGuests);
    }else{
        alert("Please enter guest first and last name!");
    }
}

function displayGuests(data) {

   var guestListContainer = $("#guestList");

    $("#guestList").html("");

    $.each(data, function(index, guest) {
          var paragraph = $("<p>").text("firstname: "+ guest.first +" | lastname: "+ guest.last);
          guestListContainer.append(paragraph);
    });

     $("#first").val("");
     $("#last").val("");
}