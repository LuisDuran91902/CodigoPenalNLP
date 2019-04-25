
import org.pdfbox.cos.COSDocument;
import org.pdfbox.pdfparser.PDFParser;
import org.pdfbox.pdmodel.PDDocument;
import org.pdfbox.pdmodel.PDDocumentInformation;
import org.pdfbox.util.PDFTextStripper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.PrintWriter;

 public class PDF {

     PDFParser parser;
     String parsedText;
     PDFTextStripper pdfStripper;
     PDDocument pdDoc;
     COSDocument cosDoc;
     PDDocumentInformation pdDocInfo;

     // PDFTextParser Constructor 
     public PDF() {
     }

     // Extract text from PDF Document
     String pdftoText(String fileName) {
   
         System.out.println("Parsing text from PDF file " + fileName + "....");
         File f = new File(fileName);
   
         if (!f.isFile()) {
             System.out.println("File " + fileName + " does not exist.");
             return null;
         }
   
         try {
             parser = new PDFParser(new FileInputStream(f));
         } catch (Exception e) {
             System.out.println("Unable to open PDF Parser.");
             return null;
         }
   
         try {
             parser.parse();
             cosDoc = parser.getDocument();
             pdfStripper = new PDFTextStripper();
             pdDoc = new PDDocument(cosDoc);
             parsedText = pdfStripper.getText(pdDoc);
         } catch (Exception e) {
             System.out.println("An exception occured in parsing the PDF Document.");
             try {
                    if (cosDoc != null) cosDoc.close();
                    if (pdDoc != null) pdDoc.close();
                } catch (Exception e1) {
             }
             return null;
         }
         System.out.println("Done.");
         return parsedText;
     }

     // Write the parsed text from PDF to a file
     void writeTexttoFile(String pdfText, String fileName) {
   
         System.out.println("\nWriting PDF text to output text file " + fileName + "....");
         try {
             FileWriter fichero = new FileWriter(fileName);
             PrintWriter pw = new PrintWriter(fichero);
             pw.print(pdfText);

             pw.close();  
         } catch (Exception e) {
             System.out.println("An exception occured in writing the pdf text to file.");
         }
         System.out.println("Done.");
     }

    String pdftoText(PDDocument lig) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    String pdfToText(PDDocument document) {
        String result =  "";  
        try {
                    PDFTextStripper stripper = new PDFTextStripper();
                    result = stripper.getText(document);
                    
       } catch (Exception e){
       } 
       return result;
    }

}