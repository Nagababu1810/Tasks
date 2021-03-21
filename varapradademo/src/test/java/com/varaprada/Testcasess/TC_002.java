package com.varaprada.Testcasess;

import com.varaprada.baseclass.BaseTest;

public class TC_002 extends BaseTest {

	
	public static void main(String[] args) throws Exception {
		
		
		init();
		
		launch("chromebrowser");
		
		navigateUrl("amazonurl");
		
		driver.manage().window().maximize();
		
		selectItem("amazondropbox_id","Books");
		
		type("amazonsearchtext_name","Harry potter");
		
		
		elementClick("amazonsearchbutton_xpath");
		
		driver.close();
		
		
		
		
		
	}
}
