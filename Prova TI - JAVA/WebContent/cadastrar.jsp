


    <div class="col-md-12 order-md-1">
     <div class="col-md-12">
      <div class="row no-gutters border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
        <div class="col p-4 d-flex flex-column position-static">
          <strong class="d-inline-block mb-2 text-primary">Título</strong>
          <h3 class="mb-0"><%=request.getAttribute("proc_titulo")%></h3>
          <p class="card-text mb-auto">
          <form method="post" action="process?acao=cadastro">
  
          titulo: <input type="text" class="form-control" name="proc_titulo" value="<%=request.getAttribute("proc_titulo")%> ">         
       
          Número Publicação: <input type="text" class="form-control" name="proc_num_pub" value="<%=request.getAttribute("proc_num_pub")%>">
          
          Número Internacional: <input type="text" class="form-control" name="proc_num_inter" value="<%=request.getAttribute("proc_num_inter")%>">
             
          Data Publicação: <input type="text" class="form-control" name="proc_data_pub" value="<%=request.getAttribute("proc_data_pub")%>">
          
           Requerente: <textarea type="text" class="form-control" name="proc_requerente"><%=request.getAttribute("proc_requerente")%></textarea>
       	 <br>
       	 <button type="btn" class="btn btn-secondary" onclick="cadastrar()">Cadastrar no banco de dados </button>
   
          
          </p>
          </form>
          
        </div>
        <div class="col-auto d-none d-lg-block">
           <img src="https://patentscope.wipo.int/<%=request.getAttribute("proc_img")%>" style="height: 500px; width:500px;">  
        </div>
      </div>
    </div>
    </div>


 