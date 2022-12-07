<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%
String ad=request.getParameter("user");
String sifre=request.getParameter("pass");
out.println("Selam "+ad);
Connection c;
Statement s;
try{
	Class.forName("org.postgresql.Driver");
	c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testvt", "postgres", "blp123");
	s = c.createStatement();
	String sql="SELECT id, ad, sifre FROM public.t_kullanici where ad='"+ad+"' and sifre='"+sifre+"';";
	ResultSet rs=s.executeQuery(sql);
	boolean login=rs.next();
	if(login){
		session.setAttribute("login","true");
		response.sendRedirect("main.jsp");
	}else{
		session.setAttribute("login","false");
		response.sendRedirect("index.jsp");
	}
}catch(Exception e){
	response.sendError(e.hashCode(), e.getLocalizedMessage());
}
%>