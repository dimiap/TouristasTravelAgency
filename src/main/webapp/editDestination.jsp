<%@ page import="java.util.List" %>
<%@ page import="org.example.touristastravelagency_v0.models.Countries" %>
<%@ page import="org.example.touristastravelagency_v0.models.Destinations" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Destination</title>
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
<%
    List<Destinations> destinations = (List<Destinations>) request.getAttribute("destinationsList");
    Destinations destination = destinations.get(0);
%>
<div class="container">
    <div class="form-section">
        <h3>Edit Destination</h3>
        <form action="EditDestinationServlet" method="post" enctype="multipart/form-data">
            <input type="hidden" name="destinationID" value="<%= destination.getDestinationID() %>" />
            <input type="text" name="d_name" placeholder="Name of Destination" class="form-control" value="<%= destination.getD_name() %>" required />
            <textarea name="d_description" placeholder="Description" class="form-control" rows="3" required><%= destination.getD_description() %></textarea>
            <select name="id_country" required class="select-field">
                <%
                    List<Countries> countries = (List<Countries>) request.getAttribute("countriesList");
                    int userCountryId = destination.getId_country();
                    if (countries != null) {
                        for (Countries country : countries) {
                            boolean isSelected = (country.getIdCountry() == userCountryId);
                %>
                <option value="<%= country.getIdCountry() %>" <%= isSelected ? "selected" : "" %>><%= country.getCountry() %></option>
                <%
                        }
                    }
                %>
            </select>
            <textarea name="attractions" placeholder="Attractions" class="form-control" rows="3"><%= destination.getAttractions() %></textarea>
            <input type="hidden" name="imageName" value="<%= destination.getImage() %>" />
            <input type="file" name="image" />

            <div id="packageContainer">
                <h3>Travel Packages</h3>
                <%
                    List<Destinations> packages = (List<Destinations>) request.getAttribute("destinationsList");
                    if (packages != null) {
                        for (Destinations travelPackage : packages) {
                            Integer packageID = travelPackage.getPackageID();
                %>
                <div class="package" data-packageID="<%= packageID %>">
                    <h5>Package:</h5>
                    <input type="hidden" name="packageID" value="<%= packageID %>" />
                    <input type="hidden" class="delete-package" name="deletePackage_<%= packageID %>" value="false" />
                    <input type="number" step="0.01" name="price_<%=packageID %>" placeholder="Price" class="form-control" value="<%= travelPackage.getPrice() %>" required />
                    <input type="number" name="duration_<%= packageID %>" placeholder="Duration" class="form-control" value="<%= travelPackage.getDuration() %>" required />
                    <input type="date" name="startDate_<%= packageID %>" placeholder="Start Date" class="form-control" value="<%= travelPackage.getStartDate() %>" required />
                    <input type="date" name="endDate_<%= packageID %>" placeholder="End Date" class="form-control" value="<%= travelPackage.getEndDate() %>" required />
                    <button type="button" class="btn btn-danger removePackageButton">Remove Package</button>
                </div>
                <%
                        }
                    }
                %>
            </div>
            <button type="button" id="addPackageButton" class="btn btn-info">Add Package</button>
            <button type="submit">Update Destination</button>
        </form>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script>
    $(document).ready(function() {
        $('#addPackageButton').click(function() {
            var packageHTML = '<div class="package">' +
                '<h5>Package:</h5>'+
                '<input type="number" step="0.01" name="price_new" placeholder="Price" class="form-control" required />' +
                '<input type="number" name="duration_new" placeholder="Duration" class="form-control" required />' +
                '<input type="date" name="startDate_new" placeholder="Start Date" class="form-control" required />' +
                '<input type="date" name="endDate_new" placeholder="End Date" class="form-control" required />' +
                '<button type="button" class="btn btn-danger removePackageButton">Remove Package</button>' +
                '</div>';
            $('#packageContainer').append(packageHTML);
        });

        $(document).on('click', '.removePackageButton', function() {
            var packageElement = $(this).closest('.package');
            var packageID = packageElement.attr('data-packageID')

            console.log('Package Element:', packageElement);
            console.log('Package ID:', packageID);

            if (packageID) {
                packageElement.find('.delete-package').val('true');
                packageElement.hide();
            } else {
                packageElement.remove();
            }
        });
    });
</script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
