package persistencia;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import entidade.Processo;

public class ProcessoDao extends Dao {
	public void inserirProcesso(Processo proc) throws Exception {
		open();
		
		stmt = conn.prepareStatement("Insert into processos values (null, ?,?,?,?,?)");
		
		
		stmt.setString(1, proc.getProc_titulo());
		stmt.setString(2, proc.getProc_requerentes());
		stmt.setString(3, proc.getProc_num_pub());
		stmt.setString(4, proc.getProc_num_inter());
		stmt.setString(5, proc.getProc_data_pub());
		stmt.execute();
		
		stmt.close();	
			
			close();
	}
	
public List<Processo>ConsultarProcesso(String id)throws Exception{
		
		open();
		rs = conn.prepareStatement("SELECT * FROM processos where proc_num_pub ='"+id+"'").executeQuery();		 
		List<Processo> lista = new ArrayList<>();
		
		
		while(rs.next()) {
			lista.add(new Processo(rs.getInt("proc_id"),rs.getString("proc_titulo"), rs.getString("proc_requerentes"), rs.getString("proc_num_pub"), rs.getString("proc_num_inter"), rs.getString("proc_data_pub")));
		}
		rs.close();		
		close();
		return lista;
	}
	
	
}
