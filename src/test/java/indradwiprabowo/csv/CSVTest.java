package indradwiprabowo.csv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class CSVTest {

    @Test
    void createCSV() throws IOException {
        StringWriter write = new StringWriter();

        CSVPrinter printer = new CSVPrinter(write, CSVFormat.DEFAULT);
        printer.printRecord("Eko", "Saputro", 90);
        printer.printRecord("Indra", "Dwi", 100);
        printer.flush();

        System.out.println(write.getBuffer().toString());
    }

    @Test
    void readCSV() throws IOException {
        Path path = Path.of("sample.csv");
        Reader reader = Files.newBufferedReader(path);

        CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT);
        for (CSVRecord record : parser) {
            System.out.println("First Name: " + record.get(0));
            System.out.println("Last Name: " + record.get(1));
            System.out.println("Value: " + record.get(2));
        }
    }

    @Test
    void readCSVWithHeader() throws IOException {
        Path path = Path.of("sample.csv");
        Reader reader = Files.newBufferedReader(path);

        CSVFormat format = CSVFormat.DEFAULT.builder().setHeader().build();
        CSVParser parser = new CSVParser(reader, format);

        for (CSVRecord record : parser) {
            System.out.println("First Name: " + record.get("First Name"));
            System.out.println("Last Name: " + record.get("Last Name"));
            System.out.println("Value: " + record.get("Value"));
        }
    }

    @Test
    void createCSVWithHeader() throws IOException {
        StringWriter write = new StringWriter();

        CSVFormat format = CSVFormat.DEFAULT.builder()
                .setHeader("First Name", "Last Name", "Value").build();
        CSVPrinter printer = new CSVPrinter(write, format);

        printer.printRecord("Eko", "Saputro", 90);
        printer.printRecord("Indra", "Dwi", 100);
        printer.printRecord("Joko", "Hugroho", 45);
        printer.flush();

        System.out.println(write.getBuffer().toString());
    }

}
