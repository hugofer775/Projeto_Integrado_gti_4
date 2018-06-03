package br.com.projetointegrador.relatorio;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import br.com.projetointegrador.model.Bem;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class Relatorio {
	
	private HttpServletResponse response;
	private FacesContext context;
	
	public Relatorio() {
		this.context = FacesContext.getCurrentInstance();
		this.response = (HttpServletResponse) this.context.getExternalContext().getResponse();
	}
	
	
	public void getRelatorio(List<Bem> lista){
		try{
			System.out.println("aqui");
			File arquivo= new File("C:\\ProjetoIntegrador\\src\\report\\relatorio.jasper");
			//InputStream stream = this.getClass().getClassLoader().getResourceAsStream("/report/relatorio.jasper");
			InputStream stream = new FileInputStream(arquivo);
			JasperReport report = (JasperReport) JRLoader.loadObject(stream);
 			Map<String, Object> params = new HashMap<String, Object>();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			
			System.out.println("aqui1");
			
			System.out.println("aqui1");
			JasperPrint print = JasperFillManager.fillReport(report, params, new JRBeanCollectionDataSource(lista));
			JasperExportManager.exportReportToPdfStream(print, baos);
			
			response.reset();
			
			response.setContentType("application/pdf");
			
			response.setContentLength(baos.size());
			
			response.setHeader("Content-disposition","inline; filename=relatorio.pdf");
			
			
			response.getOutputStream().write(baos.toByteArray());
			
			response.getOutputStream().flush();
			
			response.getOutputStream().close();
			
			context.responseComplete();
			
		}catch(Exception e){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Erro ao gerar o relatorio!"));
		}
		
	}

	
}
