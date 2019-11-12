package util;
import java.io.FileOutputStream;
import java.text.DecimalFormat;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import model.Client;

public class PrintReport {

    public static void createPDF (String pdfFilename, Client client, int landCost , int seaCost , int unload, int load , int allCost){

        Document doc = new Document();
        PdfWriter docWriter = null;

        DecimalFormat df = new DecimalFormat("0.00");

        try {
            BaseFont bf = BaseFont.createFont("/home/alex/Downloads/ArialCyr.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            //special font sizes
            Font bfBold12 = new Font(bf);
            Font bf12 = new Font(bf);

            //file path
            String path = "docs/" + pdfFilename;
            docWriter = PdfWriter.getInstance(doc , new FileOutputStream(path));

            //document header attributes
            doc.addAuthor("betterThanZero");
            doc.addCreationDate();
            doc.addProducer();
            doc.addCreator("MySampleCode.com");
            doc.addTitle("Report with Column Headings");
            doc.setPageSize(PageSize.LETTER);

            //open document
            doc.open();

            //create a paragraph
            Paragraph paragraph = new Paragraph("Заказчик: " , bf12);
            Paragraph paragraph1 = new Paragraph(client.getFullName(), bf12);
            Paragraph paragraph2 = new Paragraph(client.getEmail(),bf12);
            Paragraph paragraph3 = new Paragraph(client.getPhone(),bf12);
            Paragraph paragraph4 = new Paragraph("", bf12);

            //specify column widths
            float[] columnWidths = {1.5f, 2f, 5f, 2f};
            //create PDF table with the given widths
            PdfPTable table = new PdfPTable(columnWidths);
            // set table width a percentage of the page width
            table.setWidthPercentage(90f);


            //insert column headings
            insertCell(table, "", Element.ALIGN_RIGHT, 1, bfBold12);
            insertCell(table, "", Element.ALIGN_LEFT, 1, bfBold12);
            insertCell(table, "Услуга", Element.ALIGN_LEFT, 1, bfBold12);
            insertCell(table, "Стоимость", Element.ALIGN_RIGHT, 1, bfBold12);
            table.setHeaderRows(1);

            //insert an empty row
            insertCell(table, "", Element.ALIGN_LEFT, 4, bfBold12);
            //create section heading by cell merging

            double orderTotal, total = 0;

            //just some random data to fill
//            for(int x=1; x<5; x++){

                insertCell(table, "" , Element.ALIGN_RIGHT, 1, bf12);
                insertCell(table, "" , Element.ALIGN_LEFT, 1, bf12);
                insertCell(table, " Доставка суша " , Element.ALIGN_LEFT, 1, bf12);
                orderTotal = landCost;
                insertCell(table, df.format(orderTotal), Element.ALIGN_RIGHT, 1, bf12);

            insertCell(table, "" , Element.ALIGN_RIGHT, 1, bf12);
            insertCell(table, "" , Element.ALIGN_LEFT, 1, bf12);
            insertCell(table, " Доставка море" , Element.ALIGN_LEFT, 1, bf12);
            orderTotal = seaCost;
            insertCell(table, df.format(orderTotal), Element.ALIGN_RIGHT, 1, bf12);

            insertCell(table, "" , Element.ALIGN_RIGHT, 1, bf12);
            insertCell(table, "" , Element.ALIGN_LEFT, 1, bf12);
            insertCell(table, "Погрузка" , Element.ALIGN_LEFT, 1, bf12);
            orderTotal = load;
            insertCell(table, df.format(orderTotal), Element.ALIGN_RIGHT, 1, bf12);

            insertCell(table, "" , Element.ALIGN_RIGHT, 1, bf12);
            insertCell(table, "" , Element.ALIGN_LEFT, 1, bf12);
            insertCell(table, "Выгрузка" , Element.ALIGN_LEFT, 1, bf12);
            orderTotal = unload;
            insertCell(table, df.format(orderTotal), Element.ALIGN_RIGHT, 1, bf12);
//            }
            //merge the cells to create a footer for that section
            total = allCost;
            insertCell(table, "Итого ", Element.ALIGN_RIGHT, 3, bfBold12);
            insertCell(table, df.format(total), Element.ALIGN_RIGHT, 1, bfBold12);

            //repeat the same as above to display another location

            doc.add(paragraph);
            doc.add(paragraph1);
            doc.add(paragraph2);
            doc.add(paragraph3);
            doc.add(paragraph4);
            //add the PDF table to the paragraph
            doc.add(table);
            // add the paragraph to the document

        }
        catch (DocumentException dex)
        {
            dex.printStackTrace();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            if (doc != null){
                //close the document
                doc.close();
            }
            if (docWriter != null){
                //close the writer
                docWriter.close();
            }
        }
    }

    public static void insertCell(PdfPTable table, String text, int align, int colspan, Font font){

        //create a new cell with the specified Text and Font
        PdfPCell cell = new PdfPCell(new Phrase(text.trim(), font));
        //set the cell alignment
        cell.setHorizontalAlignment(align);
        //set the cell column span in case you want to merge two or more cells
        cell.setColspan(colspan);
        //in case there is no text and you wan to create an empty row
        if(text.trim().equalsIgnoreCase("")){
            cell.setMinimumHeight(10f);
        }
        //add the call to the table
        table.addCell(cell);

    }

}