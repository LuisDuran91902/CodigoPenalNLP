
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;

public class iText {

    /** The original PDF that will be parsed. */
    //public static final String PREFACE = "C://data.pdf";
    /** The resulting text file. */
    //public static final String RESULT = "C://dataiText.txt";

    /**
     * Parses a PDF to a plain text file.
     * @param pdf the original PDF
     * @param txt the resulting text
     * @throws IOException
     */
    iText(){
        
    }
    
    public void iTextmetod(String pdf, String txt){
        
        try{
            PdfReader reader = new PdfReader(pdf);
            PdfReaderContentParser parser = new PdfReaderContentParser(reader);
            PrintWriter out = new PrintWriter(new FileOutputStream(txt));
            TextExtractionStrategy strategy;
            for (int i = 1; i <= reader.getNumberOfPages(); i++) {
                strategy = parser.processContent(i, new SimpleTextExtractionStrategy());
                out.println(strategy.getResultantText());
            }
            out.flush();
            out.close();
        } catch (Exception e) {
             System.out.println("An exception occured in writing the pdf text to file.");
         }
    }

    /**
     * Main method.
     * @param    args    no arguments needed
     * @throws IOException
     */
    /*public static void main(String[] args) throws IOException {
        new iText().parsePdf(PREFACE, RESULT);
    }*/
}