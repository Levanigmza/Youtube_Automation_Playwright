package Youtube_Automation;

import DataObject.Youtube_DataObj;
import StepObject.Youtube_StepObj;
import Utils.Setup;
import org.testng.annotations.*;

public class Test_Class_1 {
    private static final Youtube_DataObj Data = new Youtube_DataObj();
    private static final Youtube_StepObj Steps = new Youtube_StepObj();
    private static final Setup setup = new Setup();

    @BeforeClass
    public void setUp() {
        setup.setup();
    }

    @AfterClass
    public void tearDown() {
        setup.teardown();
    }

    @Test
    public void exampleTest() {
        setup.Navigate_ToUrl(Data.youtube_url);
        Steps.SearchQuery(Data.SearchInputData);
        Steps.playVideo();

    }
}
