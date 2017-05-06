package com.patientsProfile.utill;

import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFGenerator {

	public static void main(String[] args) {
		Document doc = new Document();
		try {
			PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream("test.pdf"));
			doc.open();
			doc.add(new Paragraph("This is a new pdf"));
			doc.close();
			writer.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	
	

}
