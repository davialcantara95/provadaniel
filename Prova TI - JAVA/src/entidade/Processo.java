package entidade;

import java.util.Date;

public class Processo {
	private Integer proc_id;
	private String proc_titulo;
	private String proc_requerentes;
	private String proc_num_pub;
	private String proc_num_inter;
	private String proc_data_pub;
	public Processo() {
		// TODO Auto-generated constructor stub
	}
	
	public Processo(Integer proc_id, String proc_titulo, String proc_requerentes, String proc_num_pub,
			String proc_num_inter, String proc_data_pub) {
		super();
		this.proc_id = proc_id;
		this.proc_titulo = proc_titulo;
		this.proc_requerentes = proc_requerentes;
		this.proc_num_pub = proc_num_pub;
		this.proc_num_inter = proc_num_inter;
		this.proc_data_pub = proc_data_pub;
	}

	@Override
	public String toString() {
		return "Processo [proc_id=" + proc_id + ", proc_titulo=" + proc_titulo + ", proc_requerentes="
				+ proc_requerentes + ", proc_num_pub=" + proc_num_pub + ", proc_num_inter=" + proc_num_inter
				+ ", proc_data_pub=" + proc_data_pub + "]";
	}

	public Integer getProc_id() {
		return proc_id;
	}
	public void setProc_id(Integer proc_id) {
		this.proc_id = proc_id;
	}
	public String getProc_titulo() {
		return proc_titulo;
	}
	public void setProc_titulo(String proc_titulo) {
		this.proc_titulo = proc_titulo;
	}
	public String getProc_requerentes() {
		return proc_requerentes;
	}
	public void setProc_requerentes(String proc_requerentes) {
		this.proc_requerentes = proc_requerentes;
	}
	public String getProc_num_pub() {
		return proc_num_pub;
	}
	public void setProc_num_pub(String proc_num_pub) {
		this.proc_num_pub = proc_num_pub;
	}
	public String getProc_num_inter() {
		return proc_num_inter;
	}
	public void setProc_num_inter(String proc_num_inter) {
		this.proc_num_inter = proc_num_inter;
	}
	public String getProc_data_pub() {
		return proc_data_pub;
	}
	public void setProc_data_pub(String proc_data_pub) {
		this.proc_data_pub =  proc_data_pub;
	}
	
	
	
}
