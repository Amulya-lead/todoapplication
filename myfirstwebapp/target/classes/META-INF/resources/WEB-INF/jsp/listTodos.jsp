<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<!-- ✅ Force background and transparency using inline CSS -->
<style>
    html, body {
        height: 100%;
        margin: 0;
        padding: 0;
        background: url('https://unsplash.com/photos/a-pink-desk-with-a-notepad-pen-scissors-and-a-plant-_a_M0v4zgp0') 
                    no-repeat center center fixed;
        background-size: cover;
    }

    .container {
        background-color: rgba(0, 0, 0, 0.6); /* dark transparent overlay */
        border-radius: 10px;
        padding: 20px;
        margin-top: 30px;
        color: white;
    }

    .table, .table th, .table td {
        background-color: transparent !important;
        color: white;
    }

    h1, th, td, a {
        color: white;
    }
</style>

<div class="container">
    <h1>Your Todos</h1>
    <table class="table">
        <thead>
            <tr>
                <th>Description</th>
                <th>Target Date</th>
                <th>Is Done?</th>
                <th></th>
                <th></th>
            </tr>
        </thead>
        <tbody>		
            <c:forEach items="${todos}" var="todo">
                <tr>
                    <td>${todo.description}</td>
                    <td>${todo.targetDate}</td>
                    <td>${todo.done}</td>
                    <td> 
                        <a href="delete-todo?id=${todo.id}" class="btn btn-danger">Delete</a>
                    </td>
                    <td> 
                        <a href="update-todo?id=${todo.id}" class="btn btn-info">Update</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="add-todo" class="btn btn-success">Add Todo</a>
</div>

<%@ include file="common/footer.jspf" %>
