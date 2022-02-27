import com.dwteam.reader.CsvReader;
import org.junit.Assert;
import org.junit.Test;


public class CsvReaderTest {
    CsvReader csvReader;

    public CsvReaderTest() throws Exception {
        csvReader = new CsvReader();
    }

    @Test
    public void readAllDataAtOnceTest() {

        Assert.assertNotNull(csvReader.getList());
        Assert.assertNotNull(csvReader.getListFut());
        Assert.assertNotNull(csvReader.getListYes());
        Assert.assertNotNull(csvReader.filterAPFut("LIS"));
        Assert.assertNotNull(csvReader.filterAPFut("BCL"));
        Assert.assertNotNull(csvReader.filterAP("BCL"));
        Assert.assertNotNull(csvReader.filterAPYes("BCL"));

    }

}
