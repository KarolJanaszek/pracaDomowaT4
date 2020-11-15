<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org" lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Cars</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="../../webapp/css/main.css">

    <script>
        function search() {
            var createUrl = window.origin + window.location.pathname;
            var url = new URL(createUrl);
            var params = new URLSearchParams(url.search);
            params.set('color', document.getElementById('search').value.toUpperCase());
            url.search = params.toString();
            window.location.href = url;
        }
    </script>
</head>
<body>
<div class="container-fluid">
    <h1 class="text-center head">Cars jsp</h1>

    <div class="form-inline float-right">
        <input type="text" id="search" class="form-control mr-sm-2" placeholder="Search by color">
        <input type="button" class="btn btn-outline-success my-2 my-sm-0" value="Search" onclick="search()">
    </div>

    <div>
        <table class="table">
            <thead class="thead-light">
            <tr>
                <th scope="col">#</th>
                <th scope="col">Mark</th>
                <th scope="col">Model</th>
                <th scope="col">Color</th>
                <th scope="col">Options</th>
            </tr>
            </thead>
            <tbody>
            <tr th:each="car: ${cars}">
                <td th:text="${car.carId}"/>
                <td th:text="${car.mark}"><a th:href="@{/cars/edit/{id}/mark(carId=${car.carId})}"><img src="/img/edit.png"/></a></td>
                <td th:text="${car.model}"><a th:href="@{/cars/edit/{id}/model(carId=${car.carId})}"><img src="/img/edit.png"/></a></td>
                <td th:text="${car.getColor().name()}"><a th:href="@{/cars/edit/{id}/color(carId=${car.carId})}"><img src="/img/edit.png"/></a></td>
                <td >
                    <a class="show" th:href="@{/cars/{carId}(carId=${car.carId})}"><button type="button" class="btn btn-primary">Show</button></a>
                    <a class="edit" th:href="@{/cars/edit/{carId}(carId=${car.carId})}"><button type="button" class="btn btn-success">Edit</button></a>
                    <a class="delete" th:href="@{/cars/delete/{carId}(carId=${car.carId})}"><button type="button" class="btn btn-danger">Delete</button></a>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
    <div class="text-right">
        <a th:href="@{/cars/addCar}"><button type="button" class="btn btn-primary btn-md">Add new car</button></a>
    </div>
</div>


<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>
