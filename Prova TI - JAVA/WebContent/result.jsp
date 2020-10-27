<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <div class="col-md-12 order-md-1">
     <div class="col-md-12">
      <div class="row no-gutters border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
        <div class="col p-4 d-flex flex-column position-static">
          <strong class="d-inline-block mb-2 text-primary">Título</strong>
          <h3 class="mb-0"><%=request.getAttribute("proc_titulo")%></h3>
          <p class="card-text mb-auto">
       	<b> Requerentes:</b>
         <br>
         <span><%=request.getAttribute("proc_requerentes")%></span>
         <br>
         <b>Número de publicação: </b>
         <br>
         <span><%=request.getAttribute("proc_num_pub")%></span>
         <br>
         <b>Número internacional:</b>
          <br>
         <span><%=request.getAttribute("proc_num_inter")%></span>
         <br>
         <b>Data publicação:</b>
         <br>
         <span><%=request.getAttribute("proc_data_pub")%></span> 
         <br>
          </p>
        </div>
        
      </div>
    </div>
    </div>
</body>
</html>