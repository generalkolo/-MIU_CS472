<!DOCTYPE html>
<html>
<head>
    <title>JSON Blog Data</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        $(document).ready(function() {
            $('#userInfo').hide();
            $('#postList').hide();

            $('#userForm').submit(function(event) {
                event.preventDefault();
                var userId = $('#userId').val();

                $.ajax({
                    url: 'http://jsonplaceholder.typicode.com/users/' + userId,
                    method: 'GET',
                    success: function(user) {
                        $('#userName').text(user.name);
                        $('#userEmail').text(user.email);
                        $('#userAddress').text(user.address.street + ', ' + user.address.city);
                        $('#userInfo').show();

                        $.ajax({
                            url: 'http://jsonplaceholder.typicode.com/posts?userId=' + userId,
                            method: 'GET',
                            success: function(posts) {
                                var postList = $('#postList');
                                postList.empty();
                                $.each(posts, function(index, post) {
                                    var listItem = $('<li><button class="show-comments" data-post-id="' + post.id + '">Show Comments</button> ' + post.title + '</li>');
                                    postList.append(listItem);
                                });
                                $('#postList').show();
                            },
                            error: function() {
                                alert('Failed to fetch posts.');
                            }
                        });
                    },
                    error: function() {
                        alert('User not found.');
                    }
                });
            });

            $('#postList').on('click', '.show-comments', function() {
                var postId = $(this).data('post-id');
                var commentsContainer = $(this).parent().find('.comments-container');
                if (!commentsContainer.length) {
                    commentsContainer = $('<div class="comments-container"></div>');
                    $(this).parent().append(commentsContainer);

                    $.ajax({
                        url: 'http://jsonplaceholder.typicode.com/comments?postId=' + postId,
                        method: 'GET',
                        success: function(comments) {
                            $.each(comments, function(index, comment) {
                                commentsContainer.append('<p>' + comment.body + '</p>');
                            });
                        },
                        error: function() {
                            alert('Failed to fetch comments.');
                        }
                    });
                } else {
                    commentsContainer.toggle();
                }
            });
        });
    </script>
</head>
<body>
    <h1>JSON Blog Data</h1>
    <form id="userForm">
        <label for="userId">Enter User ID:</label>
        <input type="text" id="userId" name="userId" required>
        <input type="submit" value="Submit">
    </form>
    <div id="userInfo">
        <h2>User Details</h2>
        <p><strong>Name:</strong> <span id="userName"></span></p>
        <p><strong>Email:</strong> <span id="userEmail"></span></p>
        <p><strong>Address:</strong> <span id="userAddress"></span></p>
    </div>
    <ul id="postList">
    </ul>
</body>
</html>
