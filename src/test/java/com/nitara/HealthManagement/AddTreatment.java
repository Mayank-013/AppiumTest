package com.nitara.HealthManagement;

import java.util.Map;

import org.testng.annotations.Test;

import com.nitara.APIFunctions.LoginAPI;
import com.nitara.APIFunctions.RegisterMilkingCattle;
import com.nitara.AccountManagement.Login;
import com.nitara.utils.DataProviderUtils;
import appCommonClasses.GenericBase;
import appCommonClasses.Helper_AppNavigation;
import appCommonClasses.HelperFunctions;

public class AddTreatment  extends GenericBase{

	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void Treatment_AddData(Map<String,String> data) throws Throwable {
		
		/**Login **/
		new Login().Login_ValidData();
		
		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		String usertoken = new LoginAPI().API_FarmerLogin(url);
		String Tag = new RegisterMilkingCattle().registerMilkingOrDryCattle(url,usertoken,"RegisterMilkingCattle_Inseminated");

		
		/** In this function -
		 * Reach the add health activity page for the cattle 
		 * Reach the add health activity page for the registered cattle
		 * Farmer HomePage -> Health Management -> Search Cattle with Tag No 
		 * -> Select health activity from the list
		 * 
		 * @param activity type - Vaccination /Deworming /Treatment
		 */
		new Helper_AppNavigation().goTo_addHealthActivityScreen(Tag,"Treatment");

		/** Fill Treatment Form */
		addTreatmentPage.click_symptomsPage(); // Select symptoms

		//Select Symptoms
		int count =  Integer.valueOf(data.get("symptomsCount"));
		String[] symptomsList = new String[count];
		for(int i=0;i<count;i++) {
			symptomsList[i]= data.get("symptoms["+i+"]");
		}
		diseaseSymptoms.select_symptoms(symptomsList);
		diseaseSymptoms.click_save();

		// Select disease
		addTreatmentPage.select_disease(data.get("disease"));

		// Add Medicine - dosage
		addTreatmentPage.click_addMedicine(); 
		addTreatmentPage.enter_medicineName(data.get("medicine"));
		addTreatmentPage.enter_medicineDosage(data.get("dosage"));

		if(data.get("isAntibioticGiven").equalsIgnoreCase("true"))
			addTreatmentPage.antibioticsGiven();

		if(data.get("isFollowUpRequired").equalsIgnoreCase("true")) {
			addTreatmentPage.followUpRequired();
			addTreatmentPage.enter_followUpAfter(data.get("followUpAfter"));
		}
		addTreatmentPage.enter_amount(data.get("amount"));
		addTreatmentPage.enter_date(generateRandomData.getPastDate(15));
		addTreatmentPage.click_save();

		/** Assert record success message for the activity 
		 * @Param activity type - Vaccination /Deworming /Treatment 
		*/	
		healthRecordSuccessPage.captureScreenshots("AddTreatment");
		healthRecordSuccessPage.assertSuccessMsg("Treatment");
		



	}
}
