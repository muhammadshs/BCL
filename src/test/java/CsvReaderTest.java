import com.dwteam.reader.CsvReader;
import org.junit.jupiter.api.Test;

import java.io.File;

public class CsvReaderTest {
    CsvReader csvReader;
    public CsvReaderTest() throws Exception {
        csvReader=new CsvReader();
    }

    @Test
     void readAllDataAtOnceTest(){
        String url=new File("src/main/resources/info_csv/Flights.csv").getAbsolutePath();
        csvReader.readAllDataAtOnce(url);

    }
}
