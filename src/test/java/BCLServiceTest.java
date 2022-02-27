import com.dwteam.service.BCLService;
import org.junit.Assert;
import org.junit.Test;

public class BCLServiceTest {
    @Test
    public void getFlightSumTest(){
        BCLService bclService=new BCLService();
        Assert.assertNotNull(bclService.getFlightSum("BCL"));
        Assert.assertNotNull(bclService.getFlightDelay());

    }
    @Test
    public void getFlightDelayTest(){
        BCLService bclService=new BCLService();
        Assert.assertNotNull(bclService.getFlightDelay());

    }
}
