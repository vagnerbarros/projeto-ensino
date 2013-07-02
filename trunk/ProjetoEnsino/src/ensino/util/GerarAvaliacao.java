package ensino.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.swing.JFileChooser;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import ensino.entidades.Avaliacao;
import ensino.entidades.Questao;
import ensino.entidades.Usuario;

public class GerarAvaliacao {
	
	private Avaliacao avaliacao;
	private Usuario aluno;
	private List<Questao> questoes;
	
	public GerarAvaliacao(Avaliacao avaliacao, Usuario aluno, List<Questao> questoes){
		this.avaliacao = avaliacao;
		this.aluno = aluno; 
		this.questoes = questoes;
	}

	public void criar(){

		Document documento = new Document(PageSize.A4);
		try {
			String caminho = selecionarDiretorio();
			PdfWriter.getInstance(documento,
					new FileOutputStream(caminho + "/" + avaliacao.getNome() +".pdf"));

			documento.open();
			Font fonteTitulos = new Font(FontFamily.TIMES_ROMAN, 12, Font.BOLD);
			Font fonteTextos = new Font(FontFamily.TIMES_ROMAN, 9, Font.NORMAL);

			Paragraph paragrafo1 = new Paragraph("\n" + avaliacao.getNome() + " Nível: " + avaliacao.getNivel() + " Média para Aprovação: " + avaliacao.getMedia(), fonteTitulos);
			paragrafo1.setAlignment(Element.ALIGN_CENTER);
			documento.add(paragrafo1);

			Paragraph paragrafo2 = new Paragraph("\n\n Nome do Aluno : " + aluno.getNome(), fonteTitulos);
			paragrafo2.setAlignment(Element.ALIGN_CENTER);
			documento.add(paragrafo2);

			documento.add(new Paragraph(" "));

			Paragraph paragrafo3 = new Paragraph("Questões", fonteTitulos);
			paragrafo3.setAlignment(Element.ALIGN_CENTER);
			documento.add(paragrafo3);

			int contador = 1;
			for(Questao q : questoes){
				
				Paragraph paragrafo4 = new Paragraph("\n" + contador + ") " + q.getPergunta(),fonteTextos);
				paragrafo4.setAlignment(Element.ALIGN_LEFT);
				documento.add(paragrafo4);
				
				String [] alternativas = q.getAlternativa();
				for(int i = 0; i < alternativas.length; i++){
					String letra = converterLetra(i);
					Paragraph paragrafo5 = new Paragraph("\n" + letra + ") " + alternativas[i],fonteTextos);
					paragrafo5.setAlignment(Element.ALIGN_LEFT);
					documento.add(paragrafo5);
				}
				contador++;
				documento.add(new Paragraph(" "));
			}

		} catch (DocumentException de) {
			System.err.println(de.getMessage());
		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		}
		documento.close();
	}

	public String selecionarDiretorio(){
		try{
			JFileChooser escolher = new JFileChooser(System.getProperty("user.home"));
			escolher.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			escolher.showDialog(null, "Salvar");
			escolher.setDialogType(JFileChooser.OPEN_DIALOG);
			String path = escolher.getSelectedFile().getAbsolutePath();
			return path;
		}catch(Exception e){
			e.printStackTrace();
			return "erro";
		}
	}
	
	private String converterLetra(int i){
		String retorno = "";
		switch(i){
			case 0:
				retorno = "A";
				break;
			case 1:
				retorno = "B";
				break;
			case 2:
				retorno = "C";
				break;
			case 3:
				retorno = "D";
				break;
			case 4:
				retorno = "E";
				break;
		}
		return retorno;
	}
}
