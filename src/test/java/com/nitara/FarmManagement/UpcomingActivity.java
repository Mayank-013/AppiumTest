//package com.nitara.FarmManagement;
//
//import com.nitara.APIFunctions.AddHeatAPI;
//import com.nitara.APIFunctions.AddTreatmentAPI;
//import com.nitara.APIFunctions.GetCattleId;
//import com.nitara.APIFunctions.GetFarmId;
//import com.nitara.APIFunctions.LoginAPI;
//import com.nitara.APIFunctions.RegisterMilkingCattle;
//import com.nitara.APIFunctions.UpdateFarmLocation;
//import com.nitara.AccountManagement.Login;
//import com.nitara.CattleManagement.RegisterMilkingorDryCattle;
//import com.nitara.Helper.GenerateRandomData;
//
//import appCommonClasses.GenericBase;
//
//public class UpcomingActivity extends GenericBase{
//
//
//
//	public void upcomingActivity() throws Exception {
//
//		/**Login **/
//		new Login().Login_ValidData();
//
//		//API Login
//		String url = prop.getProperty("APIbaseUrl");
//		LoginAPI user = new LoginAPI();
//		String usertoken = user.API_FarmerLogin(url);
//		
//		//Update Farmer Location
//		double longitude = 77.7243733;
//		double latitude = 8.088306;
//		new UpdateFarmLocation().updateFarmLocation(url, latitude, longitude);
//		
//		
//		//Register cattle to farm
//		String Tag = new RegisterMilkingCattle().registerMilkingOrDryCattle(url,usertoken,"RegisterMilkingCattle_Inseminated");
//		String farmId = new GetFarmId().getFarmId(url,usertoken);
//		String cattleId = new GetCattleId().getCattleId(url,usertoken, farmId,Tag);
//		
//		//Add treatment for upcoming followUp
//		new AddTreatmentAPI().addTreatment(url,cattleId,new GenerateRandomData().getPastDateAPI(10),10,usertoken);
//		
//		//Add heat for Expected Heat 
//		new AddHeatAPI().addHeatData(url,usertoken, cattleId, new GenerateRandomData().getPastDateAPI(18));
//		
//
//	}
//
//
//
//
//
//}
