<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%
String crud=request.getParameter("crud");
Connection c=null;
Statement s=null;
ResultSet rs = null;
try{
	Class.forName("org.postgresql.Driver");
	c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testvt", "postgres", "blp123");
	s = c.createStatement();	
if(crud.equals("insert")){
	String ad=request.getParameter("user");
	String sifre=request.getParameter("pass");
	String sql="INSERT INTO public.t_kullanici(id, ad, sifre)VALUES (nextval('s_kullanici'), '"+ad+"', '"+sifre+"');";
	int a=s.executeUpdate(sql);
	response.getWriter().write(ad+" başarılı bir şekilde eklendi. ");
}else if(crud.equals("delete")){
	String userId = request.getParameter("userId");
	String sql = "DELETE from public.t_kullanici where id="+userId+";";
	int a = s.executeUpdate(sql);
    response.getWriter().write(userId+" idli kullanıcı başarılı bir şekilde silindi. ");
}else if(crud.equals("update")){
	String userId = request.getParameter("userId");
	String ad=request.getParameter("userName");
	String sifre=request.getParameter("password");
	  String sql = "update t_kullanici set ad='"+ad+"',sifre='"+sifre+"' where id ="+userId;
      int sonuc = s.executeUpdate(sql);
      response.getWriter().write(userId+" idli kullanıcı başarılı bir şekilde güncellendi. ");
}else if(crud.equals("list")){
	String sql = "SELECT id,ad,sifre from public.t_kullanici ORDER BY id ASC;";
	rs = s.executeQuery(sql);
	while(rs.next()){  
		   int id= rs.getInt("id");
	       String ad = rs.getString("ad");
	       String password = rs.getString("sifre");
	       
	    /*
		response.getWriter().write(
				"<tr bgcolor=\"blue\"><td>"+id+"</td><td>"+ad+"</td><td>"+password+
				"</td><td bgcolor=\"red\"><input type=\"button\" value=\"Sil\" onclick=\"deleteUserByButton("+id+
				");\"></td><td bgcolor=\"green\"><input type=\"button\" value=\"Güncelle\" onclick=\"updateUserByButton("
				+id+",'"+ad+"','"+password+"');\"></td></tr>");
	    */
	    
		response.getWriter().write(
				"<tr bgcolor=\"blue\"><td><input type=\"text\" value='"+id+"' disabled=\"disabled\"></td><td><input type=\"text\" value='"
				+ad+"' disabled=\"disabled\"></td><td><input type=\"text\" value='"
				+password+"' disabled=\"disabled\"></td><td bgcolor=\"red\"><input type=\"button\" value=\"Sil\" onclick=\"deleteUserByButton("
				+id+");\"></td><td bgcolor=\"green\"><input type=\"button\" value=\"Güncelle\" onclick=\"updateUserByButton("
				+id+",'"+ad+"','"+password+"');\"></td></tr>");	    
	}  
}
}catch(Exception e){
	response.sendError(e.hashCode(), e.getLocalizedMessage());	
}finally{
	c.close();
	s.close();
}
%>