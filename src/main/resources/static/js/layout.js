$(document).ready(function () {
    $('.burger-menu').click(function () {
        $('.sidebar').toggleClass('collapsed');
        $('.content').toggleClass('collapsed');
        $('.user-management').toggleClass('collapsed'); // Toggle user-management visibility
        $('i.fa-caret-down').toggleClass('collapsed'); // Toggle user-management visibility
    });

    $('.nav-link').has('i.fa-caret-down').click(function () {
        $(this).next('.submenu').toggleClass('show');
        $(this).find('i.fa-caret-down').toggleClass('fa-caret-down fa-caret-up');
    });
});