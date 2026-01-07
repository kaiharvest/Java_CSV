package indradwiprabowo.csv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.StringWriter;

public class CreateCSVTest {

    @Test
    void createCSV() throws IOException {
        StringWriter write = new StringWriter();

        CSVPrinter printer = new CSVPrinter(write, CSVFormat.DEFAULT);
        printer.printRecord("Eko", "Saputro", 90);
        printer.printRecord("Indra", "Dwi", 100);
        printer.flush();

        System.out.println(write.getBuffer().toString());
    }

}
