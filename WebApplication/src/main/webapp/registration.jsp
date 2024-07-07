<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
</head>
<body>

<form action="regForm" method="post">


   Name : <input  type="text" name="name1"/>  <br>  <br>


 Email :  <input  type="email" name="email"/>  <br>  <br>

 password : <input  type="password" name="password"/>  <br>  <br>

  Gender :  <input  type="radio" name="gender" value="male">  Male  <input  type="radio" name="gender" value="female"> Female   <br>  <br> 


City : <select name="city">
<option>Select City </option>
<option> Delhi </option>
<option> Jaunpur</option>
<option> Gurgaon </option>
<option> Varanasi</option>



</select>   <br>  <br>

<input type="submit" value="Register"/>


 </form>

</body>
</html>