package com.patientsProfile.utill;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import com.patientsProfile.abstractClass.AbstractITextPdfView;
import com.patientsProfile.model.Patient;
import com.patientsProfile.model.PatientVisit;

public class PDFBuilder extends AbstractITextPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document doc, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		@SuppressWarnings("unchecked")
		Map<String, Object> patientList = (Map<String, Object>) model.get("patientList");
		
		Patient patient = (Patient) patientList.get("patient");
		PatientVisit visit = (PatientVisit) patientList.get("patientVisit");
		
		doc.add(getDoctorInformation());
		doc.add(getVisitDate(visit));
		doc.add(getPatientInformation(patient, visit));
        //doc.add(new Paragraph("Recommended books for Spring framework"));
         
        /*PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100.0f);
        table.setWidths(new float[] {3.0f, 2.0f, 2.0f, 2.0f, 1.0f});
        table.setSpacingBefore(10);
         
        // define font for table header row
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(BaseColor.WHITE);
         
        // define table header cell
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(BaseColor.BLUE);
        cell.setPadding(5);
         
        // write table header
        cell.setPhrase(new Phrase("Book Title", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Author", font));
        table.addCell(cell);
 
        cell.setPhrase(new Phrase("ISBN", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Published Date", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Price", font));
        table.addCell(cell);*/
         
        // write table row data
        /*for (Book aBook : listBooks) {
            table.addCell(aBook.getTitle());
            table.addCell(aBook.getAuthor());
            table.addCell(aBook.getIsbn());
            table.addCell(aBook.getPublishedDate());
            table.addCell(String.valueOf(aBook.getPrice()));
        }*/
         
        //doc.add(table);
         
    }
	
	private Paragraph getDoctorInformation(){
		Paragraph doctorInfo = new Paragraph();
		doctorInfo.add(new Phrase("Dr. Md. Shafiqur Rahman",largeFont));
		addEmptyLine(doctorInfo, 1);
		doctorInfo.add(new Phrase("MBBS; DTCD; MPH (CM)",smallFont));
		addEmptyLine(doctorInfo, 1);
		doctorInfo.add(new Phrase("REGISTRATION NO. - 3501",smallFont));
		addEmptyLine(doctorInfo, 1);
		doctorInfo.add(new Phrase("CONSULTANT MEDICIN, TUBERCULOSIS & CHEST DISEASES",smallFont));
		addEmptyLine(doctorInfo, 1);
		LineSeparator ls = new LineSeparator();
		doctorInfo.add(ls);
		
		doctorInfo.setAlignment(Element.ALIGN_CENTER);
		
		return doctorInfo;
	}
	
	private Paragraph getVisitDate(PatientVisit visit){
		String visitDate = visit.getVisitDate();
		try {
			visitDate = new SimpleDateFormat("dd-MMM-yyyy").format(new SimpleDateFormat("dd/MM/yyyy").parse(visit.getVisitDate()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Paragraph visitDateParagraph = new Paragraph();
		addEmptyLine(visitDateParagraph, 1);
		visitDateParagraph.add(new Phrase("Visit Date: " + visitDate, mediamFont));
		visitDateParagraph.setAlignment(Element.ALIGN_RIGHT);
		
		return visitDateParagraph;
	}
	
	private Paragraph getPatientInformation(Patient patient, PatientVisit visit){
		Paragraph patientInfo = new Paragraph();
		
		patientInfo.add(new Phrase("Registration No: " + patient.getRegNo(), mediamFont));
		addEmptyLine(patientInfo, 1);
		patientInfo.add(new Phrase("Patient Name: " + patient.getName(), mediamFont));
		addEmptyLine(patientInfo, 1);
		patientInfo.add(new Phrase("Phone No: " + patient.getContactNo(), mediamFont));
		addEmptyLine(patientInfo, 1);
		patientInfo.add(new Phrase("Address: Area - " + patient.getArea(), mediamFont));
		patientInfo.add(new Phrase(", Thana - " + patient.getThana(), mediamFont));
		patientInfo.add(new Phrase(", Zilla - " + patient.getZilla(), mediamFont));
		addEmptyLine(patientInfo, 1);
		patientInfo.add(new Phrase("Chief Complains: " + visit.getChiefComplains(), mediamFont));
		
		return patientInfo;
	}
	
	private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }
	
	Font smallFont = new Font(Font.FontFamily.HELVETICA,8);
	Font mediamFont = new Font(Font.FontFamily.HELVETICA ,10);
	Font mediamLargeFont = new Font(Font.FontFamily.HELVETICA ,12);
	Font largeFont = new Font(Font.FontFamily.HELVETICA ,15);
	
}
