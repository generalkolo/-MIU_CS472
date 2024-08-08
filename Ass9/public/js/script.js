$(document).ready(function() {
    let gameStarted = false;

    $("#start").click(function() {
        gameStarted = true;
        $("#status").text('Game started! Avoid the boundaries!');
        $(".boundary").removeClass("youlose");
    });

    $(".boundary").mouseover(function() {
        if (gameStarted) {
            $(".boundary").addClass("youlose");
            $("#status").text('You lost! Click "S" to start again.');
            gameStarted = false;
        }
    });

    $("#end").mouseover(function() {
        if (gameStarted) {
            $("#status").text('You win! Click "S" to start again.');
            gameStarted = false;
        }
    });

    $("#maze").mouseleave(function() {
        if (gameStarted) {
            $(".boundary").addClass("youlose");
            $("#status").text('You lost! Click "S" to start again.');
            gameStarted = false;
        }
    });
});