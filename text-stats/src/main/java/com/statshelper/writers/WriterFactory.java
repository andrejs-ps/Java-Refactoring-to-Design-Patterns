package com.statshelper.writers;

public class WriterFactory {

    public enum WriterType {
        PDF, TXT
    }

    public static Writer getWriter(WriterType type){
        switch (type){
            case TXT:
                return new FileWriter();
            case PDF:
                return new PdfWriter();
            default:
                throw new IllegalArgumentException("Unsupported writer type");
        }
    }
}
