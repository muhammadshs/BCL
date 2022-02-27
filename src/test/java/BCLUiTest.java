import com.dwteam.ui.BCLUi;
import org.junit.Assert;
import org.junit.Test;

public class BCLUiTest {
    @Test
    public void test(){
        BCLUi bclUi=new BCLUi();
        Assert.assertNotNull(bclUi.getFlightListUi());
        Assert.assertNotNull(bclUi.getjScrollPane());
        Assert.assertNotNull(bclUi.getjLabelCDG());
        Assert.assertNotNull(bclUi.getjTable());
        Assert.assertNotNull(BCLUi.getMapFlightUi());
    }
}
