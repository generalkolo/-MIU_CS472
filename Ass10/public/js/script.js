$(document).ready(function () {
    $('[required="required"]').prev('label').append('<span>*</span>').children('span').addClass('required');
    $('tbody tr:even').addClass('even');

    function updateTaskCount() {
        var taskCount = $('#tblTasks tbody tr').length;
        $('#taskCount').text(taskCount);
    }

    function validateForm() {
        var task = $('input[name="task"]').val();
        var requiredBy = $('input[name="requiredBy"]').val();

        if (task === "" || requiredBy === "") {
            alert("Task and Date are required.");
            return false;
        }

        var today = new Date().toISOString().split('T')[0];
        if (requiredBy < today) {
            alert("Date must be today or in the future.");
            return false;
        }

        return true;
    }

    $('#btnAddTask').click(function (evt) {
        evt.preventDefault();
        $('#taskCreation').removeClass('not');
    });

    $('#clearForm').click(function (evt) {
        evt.preventDefault();
        $('form')[0].reset();
    });

    $('tbody').on('click', 'tr', function (evt) {
        $(evt.target).closest('td').siblings().andSelf().toggleClass('taskCompleted');
    });

    $('#tblTasks tbody').on('click', '.deleteRow', function (evt) {
        evt.preventDefault();
        $(evt.target).parents('tr').remove();
        updateTaskCount();
    });

    $('#tblTasks tbody').on('click', '.completeRow', function (evt) {
        evt.preventDefault();
        $(evt.target).closest('td').siblings().andSelf().toggleClass('taskCompleted');
    });

    $('#saveTask').click(function (evt) {
        evt.preventDefault();
        if (validateForm()) {
            var task = $('form').toObject();
            $('#taskRow').tmpl(task).appendTo($('#tblTasks tbody'));
            updateTaskCount();
            $('form')[0].reset();
        }
    });

    $('#clearAllTasks').click(function (evt) {
        evt.preventDefault();
        $('#tblTasks tbody').empty();
        updateTaskCount();
    });

    updateTaskCount();
});

(function ($) {
    $.fn.extend({
        toObject: function () {
            var result = {}
            $.each(this.serializeArray(), function (i, v) {
                result[v.name] = v.value;
            });
            return result;
        },
        fromObject: function (obj) {
            $.each(this.find(':input'), function (i, v) {
                var name = $(v).attr('name');
                if (obj[name]) {
                    $(v).val(obj[name]);
                } else {
                    $(v).val('');
                }
            });
        }
    });
})(jQuery);