import com.dwteam.service.BCLService;
import org.junit.Assert;
import org.junit.Test;

public class BCLServiceTest {
    @Test
    public void getFlightTest(){
        BCLService bclService=new BCLService();
        Assert.assertNotNull(bclService.getFlightSum("BCL"));
        Assert.assertNotNull(bclService.getFlightDelay());
    }
}
