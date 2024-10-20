<%@ page import="java.util.List" %>
<%@ page import="org.example.touristastravelagency_v0.models.Countries" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create New Destinations</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f8f9fa;
            font-family: "Roboto", sans-serif;
        }
        .container {
            margin-top: 50px;
        }
        .form-section {
            background: #FFFFFF;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.1), 0 5px 5px 0 rgba(0, 0, 0, 0.1);
            margin-bottom: 20px;
        }
        .form-section h3 {
            margin-bottom: 20px;
            color: #333;
        }
        .form-section input, .form-section select, .form-section textarea {
            margin-bottom: 15px;
        }
        .form-section button {
            width: 100%;
            padding: 10px;
            background-color: #66ccff;
            color: #fff;
            border: none;
            border-radius: 4px;
            font-size: 16px;
        }
        .form-section button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="form-section">
        <h3>Create New Destinations</h3>
        <form action="CreateDestinationServlet" method="post" enctype="multipart/form-data">
            <input type="text" name="d_name" placeholder="Name of Destination" class="form-control" required />
            <textarea name="d_description" placeholder="Description" class="form-control" rows="3" required></textarea>
            <select name="id_country" class="form-control" required>
                <option value="">Choose Country</option>
                <%
                    List<Countries> countries = (List<Countries>) request.getAttribute("countriesList");
                    if (countries != null) {
                        for (Countries country : countries) {
                %>
                <option value="<%= country.getIdCountry() %>"><%= country.getCountry() %></option>
                <%
                        }
                    }
                %>
            </select>
            <textarea name="attractions" placeholder="Αξιοθέατα" class="form-control" rows="3"></textarea>
            <input type="file" name="image" />

            <div id="packageContainer">
                <h3>Travel Packages</h3>
                <div class="package">
                    <h5>Πακέτο:</h5>
                    <input type="number" step="0.01" name="price" placeholder="Price" class="form-control" required />
                    <input type="number" name="duration" placeholder="Duration (days)" class="form-control" required />
                    <input type="date" name="startDate" placeholder="Start Date" class="form-control" required />
                    <input type="date" name="endDate" placeholder="End Date" class="form-control" required />
                </div>
            </div>
            <button type="button" id="addPackageButton" class="btn btn-info">Add Package</button>
            <button type="submit">Create New Destination</button>
        </form>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script>
    $(document).ready(function() {
        $('#addPackageButton').click(function() {
            var packageHTML = '<div class="package">' +
                '<h5>Πακέτο:</h5>'+
                '<input type="number" step="0.01" name="price" placeholder="Price" class="form-control" required />' +
                '<input type="number" name="duration" placeholder="Duration" class="form-control" required />' +
                '<input type="date" name="startDate" placeholder="Start Date" class="form-control" required />' +
                '<input type="date" name="endDate" placeholder="End Date" class="form-control" required />' +
                '<button type="button" class="btn btn-danger removePackageButton">Remove Package</button>' +
                '</div>';
            $('#packageContainer').append(packageHTML);
        });

        $(document).on('click', '.removePackageButton', function() {
            $(this).closest('.package').remove();
        });
    });
</script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
