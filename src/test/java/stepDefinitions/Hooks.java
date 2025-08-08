package stepDefinitions;

import drivers.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    @Before
    public void setUp() {
        DriverFactory.getDriver(); // 初始化 driver，如果尚未创建
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver(); // 清理当前线程的 driver
    }
}
