package com.statshelper.writers;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Path;

public class PdfWriter implements Writer {

    @Override
    public void write(String s, Path path) {
        String sanitized = s.replaceAll("\\p{C}", "");
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);
        PDPageContentStream contentStream;
        try {
            contentStream = new PDPageContentStream(document, page);
            contentStream.setFont(PDType1Font.COURIER, 12);
            contentStream.beginText();
            contentStream.showText(sanitized);
            contentStream.endText();
            contentStream.close();
            document.save(path.toFile());
            document.close();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }



    }
}
