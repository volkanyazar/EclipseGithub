<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function addUser(){
	var url="crudkullanici.jsp?crud=insert&user="+document.getElementById('user').value+"&pass="+document.getElementById('pass').value;
	alert(url);
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	       document.getElementById("demo").innerHTML = xhttp.responseText;
	       getUsers();
	    }
	};
	xhttp.open("GET", url, true);
	xhttp.send();
}
function getUsers(){
	var url="crudkullanici.jsp?crud=list";
	
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	       var tableStart = "<tr bgcolor=\"orange\"><td>Id</td><td>Kullanıcı adı</td><td>Şifre</td><td colspan=\"2\">İşlemler</td></tr>";
	       document.getElementById("userTablom").innerHTML = tableStart+xhttp.responseText;  
	       alert(xhttp.responseText);
	    }
	};
	xhttp.open("GET", url, true);
	xhttp.send();
}
function controlDatas(){
	if(document.getElementById('rdUpdate').checked){
		document.getElementById('userName').disabled =false;
		document.getElementById('password').disabled =false;
		document.getElementById('update').disabled =false;
    }else{
    	document.getElementById('userName').disabled =true;
		document.getElementById('password').disabled =true;
		document.getElementById('update').disabled =true;
    }
}

function deleteUser(){
	var url="crudkullanici.jsp?crud=delete&userId="+document.getElementById('userId').value;
	alert(url);
	var xhttp = new XMLHttpRequest();
	
	xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    	document.getElementById("demo").innerHTML = xhttp.responseText;
	    	alert(xhttp.responseText);
	    	getUsers();
	    }
	};
	xhttp.open("GET", url, true);
	xhttp.send();
}
function deleteUserByButton(id){
	var url="crudkullanici.jsp?crud=delete&userId="+id;
	alert(url);
	var xhttp = new XMLHttpRequest();
	
	xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    	document.getElementById("demo").innerHTML = xhttp.responseText;
	    	alert(xhttp.responseText);
	    	getUsers();
	    }
	};
	xhttp.open("GET", url, true);
	xhttp.send();
}
function updateUser(){
	var url="crudkullanici.jsp?crud=update&userId="+document.getElementById('userId').value+"&userName="+document.getElementById('userName').value+"&password="+document.getElementById('password').value;
	alert(url);
	var xhttp = new XMLHttpRequest();
	
	xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    	document.getElementById("demo").innerHTML = xhttp.responseText;
	    	alert(xhttp.responseText);
	    	getUsers();
	    }
	};
	xhttp.open("GET", url, true);
	xhttp.send();
}

function updateUserByButton(id,username,password){
	var url="crudkullanici.jsp?crud=update&userId="+id+"&userName="+username+"&password="+password;
	alert(url);
	var xhttp = new XMLHttpRequest();
	
	xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    	document.getElementById('rdUpdate').checked = true;
	    	alert(id+". idli kullanıcı adı: "+username+" sifre: "+password+" bilgilere sahip kullanıcı güncellenecek!")
	    	document.getElementById('userId').value = id;
	    	document.getElementById('userName').value = username;
	    	document.getElementById('password').value = password;
	    	controlDatas();
	    	
	    }
	};
	xhttp.open("GET", url, true);
	xhttp.send();
}
</script>
</head>
<body>
<%
if(session.getAttribute("login")!=null){
	String loginFlag=(String)session.getAttribute("login");
	if(loginFlag.equals("false")){
		response.sendRedirect("index.jsp");
	}
}else{
	response.sendRedirect("index.jsp");
}

%>
<h3>Kullanıcı Ekle/Listeleme Formu</h3>
<form>
<input type="text" id="user" placeholder="Kullanıcı Adı"><br>
<input type="password" id="pass" placeholder="Şifre"><br>
<input type="button" value="Add" onclick="addUser();"> <input type="reset" value="Reset"> <input type="button" value="Listele" onclick="getUsers();">
</form>
<br>
<div id="demo">
</div>
<br>
<table border="1" id="userTablom">

</table>
<br>
<h3>Kullanıcı Güncelle/Sil Formu</h3>
<form>
<input type="radio" name="data" id="rdUpdate" onclick="controlDatas();">Güncellemek <input type="radio" name="data" id="rdDelete" onclick="controlDatas();" checked="checked">Silmek<br><br>
<input type="text" id="userId" placeholder="Güncellenecek/silinecek id">
<input type="reset" onclick="controlDatas();" value="Temizle"> <input type="button" value="Sil" onclick="deleteUser();"><br>
<input type="text" id="userName" placeholder="Güncellenecek Kullanıcı adı" disabled="disabled"><br>
<input type="text" id="password" placeholder="Güncellenecek Şifre" disabled="disabled"><br><br>
<input type="button" id="update" value="Güncelle" onclick="updateUser();" disabled="disabled">
</form>
</body>
</html>