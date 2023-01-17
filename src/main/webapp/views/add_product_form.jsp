<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="./base.jsp" %>

</head>
<body>

<div class="container mt-3">
    <div class="row">
        <div class="col-md-6 offset-md-3">
            <h1 class="text-center md-3">Fill the Product Details..</h1>

<form  action="handle-product" method="post">
    <div class="form-group">
        <label >Name</label >
        <input type="text" name="name" class="form-control" placeholder="Enter Product Name">

    </div>
    <div class="form-group">
        <label >Product Description</label>
        <input class="form-control" name="description" row="5"
                  placeholder="Enter product details..">
        </input>
    </div>

    <div class="form-group">
        <label >Price</label >
        <input type="text" name="price" class="form-control" placeholder="Enter Product price">

    </div>
    <div class="container text-center">
         <a href="/" class="btn btn-outline-danger">Back</a>
        <button type="submit" class="btn btn-primary">Add</button>
    </div>

</form>
    </div>
    </div>
</div>

</body>
</html>
