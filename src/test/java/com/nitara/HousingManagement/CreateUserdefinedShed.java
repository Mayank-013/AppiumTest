package com.nitara.HousingManagement;

import java.util.Map;

import org.testng.annotations.Test;
import com.nitara.AccountManagement.Login;
import com.nitara.utils.DataProviderUtils;
import appCommonClasses.GenericBase;


public class CreateUserdefinedShed extends GenericBase 
{
	
	@Test(groups="Regression",dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void CreateUserdefinedshed_withDuplicateGroupName(Map<String,String> data) throws Throwable
	{
		/**Login **/
		new Login().Login_ValidData();
		
		helper_AppNavigation.goTo_SelectionofShedTypePage();
		
		String name= createshed.Generateshedname();
			
		/** Creation of User Defined shed */
		
		/** Enter shedname */
		createshed.entershedname(name);
		
		/** Click next btn*/
		createshed.clicknextbtn();	
		
		/** Click Userdefinedshedbtn */		
		createshed.clickuserdefinedbtn();	
		
		/** Enter group name */
		String grp_name= createshed.entergroupname();	
		
		/** Click on Add more groups button */
		createshed.click_addmoregrpsbtn();
		
		/** Enter group name */
		createshed.enterNextgroupname(grp_name);
		
		/** Click on Creategroups to create userdefined shed*/
		createshed.Clickcreatemygroups();
		
		/** Assert the warning message */
		createshed.assertWarningMsg(grp_name+" "+data.get("warningMessage"));		
		
}
	@Test(groups="Regression",dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void CreateUserdefinedshed_withEmptyGroupName(Map<String,String> data) throws Throwable
	{
		/**Login **/
		new Login().Login_ValidData();
		helper_AppNavigation.goTo_SelectionofShedTypePage();
		
		String name= createshed.Generateshedname();
			
		/** Creation of User Defined shed */
		
		/** Enter shedname */
		createshed.entershedname(name);
		
		/** Click next btn*/
		createshed.clicknextbtn();	
		
		/** Click Userdefinedshedbtn */		
		createshed.clickuserdefinedbtn();	
		
		/** Enter group name */
		createshed.enterNextgroupname("");
		
		/** Click on Creategroups to create userdefined shed*/
		createshed.Clickcreatemygroups();
		
		/** Assert the warning message */
		createshed.assertWarningMsg(data.get("warningMessage"));		
		
}
	@Test
	public void CreateUserdefinedshed_withMultipleGroups() throws Throwable
	{
		/**Login **/
		new Login().Login_ValidData();
		helper_AppNavigation.goTo_SelectionofShedTypePage();
		
		String name= createshed.Generateshedname();
			
		/** Creation of User Defined shed */
		
		/** Enter shedname */
		createshed.entershedname(name);
		
		/** Click next btn*/
		createshed.clicknextbtn();	
		
		/** Click Userdefinedshedbtn */		
		createshed.clickuserdefinedbtn();	
		
		/** Enter group name */
		createshed.enteruserdefinedname();
		
		/** Click on Add more groups button */
		createshed.click_addmoregrpsbtn();
		
		/** Enter group name */
		String grp_name = generateRandomData.generateRandomNumber(7);
		createshed.enterNextgroupname(grp_name);
		
		/** Click on Creategroups to create userdefined shed*/
		createshed.Clickcreatemygroups();
		
		/** search for the created shed*/ 
		shedViewPage.Searchshed(name);
		
		/** Assert the created shed */
		shedViewPage.Assertshed(name);		
		
}
	@Test(groups="Regression",dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void CreateUserdefinedshed_withDuplicateShedName(Map<String,String> data) throws Throwable
	{
		/**Login **/
		new Login().Login_ValidData();
		
		helper_AppNavigation.goTo_SelectionofShedTypePage();
		
		String name= createshed.Generateshedname();
			
		/** Creation of 1st User Defined shed */
		
		/** Enter shedname */
		createshed.entershedname(name);
		
		/** Click next btn*/
		createshed.clicknextbtn();	
		
		/** Click Userdefinedshedbtn */		
		createshed.clickuserdefinedbtn();	
		
		/** Enter group name */
		createshed.enteruserdefinedname();	
		
		/** Click on Creategroups to create userdefined shed*/
		createshed.Clickcreatemygroups();
		
		/** search for the created shed*/ 
		shedViewPage.Searchshed(name);
		
		
		/** Assert the created shed */
		shedViewPage.Assertshed(name);		
		
		/** Creation of 2nd User Defined shed */
		createshed.ClickAddShedbtn();
		
		/** Enter shedname */
		createshed.entershedname(name);
		
		/** Click next btn*/
		createshed.clicknextbtn();	
		
		/** Assert the warning message */
		createshed.assertWarningMsg(data.get("warningMessage"));		
}
	
	
	@Test
	public void Create_Userdefinedshed() throws Throwable
	
	{
		/**Login **/
		new Login().Login_ValidData();
		
		helper_AppNavigation.goTo_SelectionofShedTypePage();
		
		String name= createshed.Generateshedname();
			
		/** Creation of User Defined shed */
		
		/** Enter shedname */
		createshed.entershedname(name);
		
		/** Click next btn*/
		createshed.clicknextbtn();	
		
		/** Click Userdefinedshedbtn */		
		createshed.clickuserdefinedbtn();	
		
		/** Enter group name */
		createshed.enteruserdefinedname();	
		
		/** Click on Creategroups to create userdefined shed*/
		createshed.Clickcreatemygroups();
		
		/** capture screenshot */
		createshed.captureScreenshots("Creation of Userdefinedshed");
		
		/** search for the created shed*/ 
		shedViewPage.Searchshed(name);
		
		
		/** Assert the created shed */
		shedViewPage.Assertshed(name);		
		
}}