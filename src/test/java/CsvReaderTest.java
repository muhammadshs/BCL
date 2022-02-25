import com.dwteam.repository.CsvReader;
import org.junit.Test;

public class CsvReaderTest {
    CsvReader csvReader;

    public CsvReaderTest() throws Exception {
        csvReader=new CsvReader();
    }

    @Test
     void readAllDataAtOnceTest(){

        csvReader.readAllDataAtOnce("G:\\Java Project\\bcl\\src\\main\\resources\\info_csv\\Flights.csv");
    }
}
