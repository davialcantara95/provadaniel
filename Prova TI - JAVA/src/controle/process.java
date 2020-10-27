package controle;

import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import entidade.Processo;

import persistencia.ProcessoDao;

/**
 * Servlet implementation class process
 */
@WebServlet("/process")
public class process extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ProcessoDao ProcDao;  
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public process() {
        super();
        // TODO Auto-generated constructor stub
    }

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		verificaAcao(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		verificaAcao(request,response);
	}

	private void verificaAcao(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		if (ProcDao == null) {
			ProcDao = new ProcessoDao();
		}
		
		String acao = request.getParameter("acao");	
		String id = request.getParameter("id_processo");
		
		if(acao.equalsIgnoreCase("cadastro")) {
			cadastrar(request,response);
		}
		if(acao.equalsIgnoreCase("consulta")) {
			consulta(request,response);
		}
		
		if(acao.equalsIgnoreCase("buscar")) {
			buscar(request,response);
		}
		
		
	}

	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			String txt_busca = request.getParameter("txt_buscar");
			txt_busca = txt_busca.replace( "/" , "");
			String WO = txt_busca.substring(0, 2);
			String ano = txt_busca.substring(2,6);
			String fim = txt_busca.substring(6);
			txt_busca = WO+"/"+ano+"/"+fim;
			System.out.println(txt_busca);
	
			List<Processo> lista = new ProcessoDao().ConsultarProcesso(txt_busca);
					
			request.setAttribute("proc_titulo", lista.get(0).getProc_titulo());
			request.setAttribute("proc_requerentes", lista.get(0).getProc_requerentes());
			request.setAttribute("proc_num_pub", lista.get(0).getProc_num_pub());
			request.setAttribute("proc_num_inter", lista.get(0).getProc_num_inter());
			request.setAttribute("proc_data_pub", lista.get(0).getProc_data_pub());
			
			request.getRequestDispatcher("result.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "Erro"+e.getMessage());
			
		}
		
	}

	private void consulta(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String proc_num_inter = null;
        
        
		try {
			
			
			String link = "https://patentscope.wipo.int/search/pt/detail.jsf?docId="+request.getParameter("id_processo")+"&redirectedID=true";
            Document doc = Jsoup.connect(link).get();
            Elements elementosTag = doc.select(".PCTtitle");
            String proc_titulo = elementosTag.html();
            elementosTag = doc.select(".biblio-person-list");
            String proc_requerente = elementosTag.html();
            Element imageElement = doc.select("img").last();
            
            String proc_img = imageElement.attr("src");  
            proc_num_inter = doc.getElementById("detailMainForm:pctBiblio:j_idt3604").outerHtml();
            System.out.println(proc_num_inter);
            String proc_num_pub = doc.getElementById("detailMainForm:pctBiblio:detailPCTtableWO").html();
            String proc_data_pub = doc.getElementById("detailMainForm:pctBiblio:detailPCTtablePubDate").html();
            String noTagRegex = "<[^>]+>";
    		proc_titulo = proc_titulo.replaceAll(noTagRegex, "");
    		proc_requerente = proc_requerente.replaceAll(noTagRegex, "");
    		proc_num_inter = proc_num_inter.replaceAll(noTagRegex, "");
    		
    		proc_num_inter = proc_num_inter.substring(30);
    		request.setAttribute("proc_titulo", proc_titulo);
    		request.setAttribute("proc_requerente", proc_requerente);
    		request.setAttribute("proc_num_inter", proc_num_inter);
    		request.setAttribute("proc_num_pub", proc_num_pub);
    		proc_data_pub = proc_data_pub.replace( "." , "/");
    		request.setAttribute("proc_data_pub", proc_data_pub);
    		request.setAttribute("proc_img", proc_img);
			
    		request.getRequestDispatcher("cadastrar.jsp").forward(request, response);
			
			
		} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				
				
				e.printStackTrace();
			}finally {
				
				if(proc_num_inter == null) {
					
					
					
					
				}
				
			
			}		
		}
			
	private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Processo p = new Processo(null, request.getParameter("proc_titulo"),request.getParameter("proc_requerente"),request.getParameter("proc_num_pub"),request.getParameter("proc_num_inter"),null);
		String dt = request.getParameter("proc_data_pub");
		
		dt = dt.replace( "." , "-");
		String dia = dt.substring(0, 2);
		String mes = dt.substring(3, 5);
		String ano = dt.substring(6, 10);
		p.setProc_data_pub(ano+"-"+mes+"-"+dia);
		request.setAttribute("msg", "Salvo com sucesso!");
		request.getRequestDispatcher("busca.jsp?sucess").forward(request, response);
		
		//calendar 20 12 2017
	
		
		
		
		
		
		//String data = "2009-01-01".replaceAll("-", "/"); String[] s = data.split("/"); String novaData = s[2]+"/"+s[1]+"/"+s[0];
		try {
			ProcDao.inserirProcesso(p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
