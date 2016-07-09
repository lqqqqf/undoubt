$(document).ready(function () {
    $('[data-toggle="undoubt"]').click(function () {
        $('.row-undoubt').toggleClass('active')
    });
    $("#signout").click(function() {
        $("#signoutForm").submit();
    });
});