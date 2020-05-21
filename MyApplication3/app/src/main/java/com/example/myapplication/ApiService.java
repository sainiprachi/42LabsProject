package com.softpillar.salestrendz.network;

import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface ApiService {
    @GET("customer/outstanding?")
    Call<InvoiceData> getDelivery(@Header("Authorization")
                                          String Authentication,
                                  @Query("org_id") String org_id,
                                  @Query("logged_in_userid")
                                          String logged_in_userid,
                                  @Query("comp_id") String comp_id,
                                  @Query("cust_id") String cust_id);

    @GET("brochure/app/show?comp_id?")
    void getBrochure(@Header("Authorization")
                             String Authentication,
                     @Query("logged_in_userid")
                             String logged_in_userid,
                     @Query("comp_id") String comp_id,
                     @Query("org_id") String org_id,
                     @Query("cust_sup_type_id") String cust_sup_type_id, @Query("sup_id") String sup_id);

    @GET("target/tabular/Alllist?")
    Call<ResponseBody> getTargetList(@Header("Authorization") String Authorization,
                                     @Query("comp_id") String comp_id,
                                     @Query("format")
                                             String format,
                                     @Query("logged_in_userid") String logged_in_userid);


    @GET("web/target/achievements/details?")
    Call<ResponseBody> getAchievmentDetails(@Header("Authorization") String Authorization,
                                            @Query("comp_id") String comp_id,
                                            @Query("format")
                                                    String format,
                                            @Query("logged_in_userid")
                                                    String logged_in_userid, @Query("target_code") String target_code,
                                            @Query("target_achivement_date") String target_achivement_date, @Query("mobile") String mobile);


    @GET("mobile/target/user/list?")
    Call<ResponseBody> getTargets(@Header("Authorization") String Authorization,
                                  @Query("comp_id") String comp_id,
                                  @Query("format")
                                          String format,
                                  @Query("logged_in_userid")
                                          String logged_in_userid, @Query("user_id")
                                          String user_id, @Query("user_type_id")
                                          String user_type_id, @Query("datex") String target_achivement_date);

    @GET("customform/forms/eligibility/list?")
    Call<ResponseBody> getFormsData(@Header("Authorization") String Authorization,
                                    @Query("logged_in_userid") String logged_in_userid, @Query("comp_id") String comp_id,
                                    @Query("org_id") String org_id, @Query("cust_sup_type_id") String cust_sup_type_id);

    @GET("customform/component/data?")
    Call<ResponseBody> getFormsDetail(@Header("Authorization") String Authorization,
                                      @Query("comp_id") String comp_id,
                                      @Query("logged_in_userid") String logged_in_userid, @Query("custom_form_id") String custom_form_id);

    @POST("customform/component/submits/add")
    Call<JsonObject> postForm(@Header("Authorization") String Authorization, @Body JsonObject jsonObject);


    @GET("target/list/sort?")
    Call<ResponseBody> getTargetFilter(@Header("Authorization") String Authorization,
                                       @Query("comp_id") String comp_id,
                                       @Query("format")
                                               String format,
                                       @Query("logged_in_userid")
                                               String logged_in_userid, @Query("sort_by") String sort_by);


    @GET("end/day/forms/app/eligibility?")
    Call<ResponseBody> getEndofDayForm(@Header("Authorization") String Authorization,
                                       @Query("comp_id") String comp_id,
                                       @Query("org_id")
                                               String org_id,
                                       @Query("logged_in_userid")
                                               String logged_in_userid,
                                       @Query("check_in_date")
                                               String check_in_date);


    @POST("end/day/filled/form/save?")
    Call<JsonObject> postEodForm(@Header("Authorization") String Authorization, @Body JsonObject jsonObject);


    @GET("end/day/forms/all/app?")
    Call<ResponseBody> getAllForms(@Header("Authorization") String Authorization,
                                   @Query("comp_id")
                                           String comp_id,
                                   @Query("logged_in_userid") String logged_in_userid);


    @GET("end/day/admin/view/specific/form/value/app?")
    Call<ResponseBody> getFormDetails(@Header("Authorization") String Authorization,
                                      @Query("comp_id")
                                              String comp_id,
                                      @Query("logged_in_userid") String logged_in_userid,
                                      @Query("date") String date, @Query("eodr_setting_id") String eodr_setting_id);


    @GET("schedule/cust/visit/list?")
    Call<ResponseBody> getSchedules(@Header("Authorization") String Authorization,
                                    @Query("comp_id")
                                            String comp_id,
                                    @Query("logged_in_userid") String logged_in_userid,
                                    @Query("date_range") String date, @Query("format")
                                            String format, @Query("user_id") String user_id);


    @GET("end/day/filled/form/view?")
    Call<ResponseBody> getEndDaySelf(@Header("Authorization") String Authorization,
                                     @Query("comp_id")
                                             String comp_id,
                                     @Query("logged_in_userid") String logged_in_userid,
                                     @Query("date") String date, @Query("user_id") String user_id);

    @POST("livetracking/getJourneySummary?")
    Call<ResponseBody> getJourneyListData(@Header("Authorization") String Authorization,
                                          @Query("comp_id") String comp_id,
                                          @Query("logged_in_userid") String logged_in_userid,
                                          @Query("user_id") String user_id,
                                          @Query("start") String start,
                                          @Query("end") String end,
                                          @Query("format") String JSON);

    /*/livetracking/getLastSnapshot?logged_in_userid=370&comp_id=80&format=json&user_id=370*/
    @GET("livetracking/getLastSnapshot?")
    Call<ResponseBody> getSalesmanLiveTrackingData(@Header("Authorization") String Authorization,
                                                   @Query("comp_id") String comp_id,
                                                   @Query("logged_in_userid") String logged_in_userid,
                                                   @Query("user_id") String user_id,
                                                   @Query("format") String json);
    @GET("collection/invoice?")
    Call<ResponseBody> getInvoice(@Header("Authorization")String Authorization,
                                    @Query("comp_id")
                                            String comp_id,
                                    @Query("logged_in_userid")String logged_in_userid,
                                    @Query("org_id")String org_id,@Query("cust_sup_id")
                                            String cust_sup_id,@Query("cust_sup_type")String cust_sup_type,@Query("sup_id")String
sup_id);

    @GET("collection/payment_master/show?")
    Call<ResponseBody> getPaymentMode(@Header("Authorization")String Authorization,
                                  @Query("comp_id")
                                          String comp_id,
                                  @Query("logged_in_userid")String logged_in_userid,
                                  @Query("org_id")String org_id);

    @GET("collection/bank_master/show?")
    Call<ResponseBody> getBankInfo(@Header("Authorization")String Authorization,
                                      @Query("comp_id")
                                              String comp_id,
                                      @Query("logged_in_userid")String logged_in_userid,
                                      @Query("org_id")String org_id);


    @GET("collection/companySuppliers?")
    Call<ResponseBody> getSupplier(@Header("Authorization")String Authorization, @Query("comp_id") String comp_id,@Query("search")String search,
                                 @Query("org_id")String org_id,@Query("logged_in_userid")String logged_in_userid );

    /*/livetracking/getLastSnapshot?logged_in_userid=370&comp_id=80&format=json&user_id=370*/
    @POST("livetracking/addDeviceLog?format=json")
    Call<ResponseBody> addDecviceLog(@Header("Authorization") String Authorization,
                                     @Query("comp_id") String comp_id,
                                     @Query("logged_in_userid") int logged_in_userid,
                                     @Query("user_id") int user_id,
                                     @Query("event") String event,
                                     @Query("datetime") String datetime,
                                     @Query("battery") Float bettery,
                                     @Query("format") String json);


    /* /livetracking/getDeviceLogs?logged_in_userid=370&comp_id=171&format=json&user_id=1288&datetime=2020-03-03
     */
    @GET("livetracking/getDeviceLogs?")
    Call<ResponseBody> getDeviceLog(@Header("Authorization") String Authorization,
                                    @Query("comp_id") String comp_id,
                                    @Query("logged_in_userid") String logged_in_userid,
                                    @Query("user_id") String user_id,

                                    @Query("datetime") String datetime,
                                    @Query("format") String json);


    /*WebAccess.NEW_MAIN_URL + "customer/edit/save?logged_in_userid="
    + logged_in_userid + "&comp_id=" + comp_id + "&org_id=" + org_id + "&cust_id=" + cust_id)*/
    /*@POST("customer/edit/save?")
    Call<ResponseBody> setCustomerData(@Header("Authorization") String Authorization,
                                       @Query("comp_id") String comp_id,
                                       @Query("cust_id") int cust_id,
                                       @Query("org_id") int org_id,
                                       @Query("logged_in_userid") String logged_in_userid,
                                       @Query("format") String json);
*/
   // @Headers("Content-Type: application/JSON")
    @Headers({"Accept: application/json"})
    @POST("customer/edit/save")
    Call<JSONObject> setCustomerData(@Header("Authorization") String Authorization,
                                     @Header("Content-Type") String type,
                                     @Query("logged_in_userid") String logged_in_userid,@Body JSONObject jsonObject);
    @POST("collection/insert/app")
    Call<JsonObject> postCollection(@Header("Authorization")String Authorization, @Body JsonObject jsonObject );


    @Multipart
    @POST("collection/image")
    Call<ResponseBody> submitImageCollection(@Header("Authorization")String Authorization,@Part("comp_id") RequestBody comp_id,
                                @Part("logged_in_userid") RequestBody logged_in_userid,
                                @Part("type") RequestBody type,
                                             @Part MultipartBody.Part file);


    @GET("collection/show/app?")
    Call<ResponseBody> getCollectionData(@Header("Authorization")String Authorization, @Query("comp_id") String comp_id,
                                   @Query("org_id")String org_id,@Query("logged_in_userid")String logged_in_userid,@Query("cust_sup_id")
                                                 String cust_sup_id,@Query("cust_sup_type")String cust_sup_type );

    @GET("expense/setting/show?")
    Call<ResponseBody> addExpenseSettingsDetails(@Header("Authorization") String Authorization,  @Query("comp_id")
            String comp_id,@Query("logged_in_userid") String logged_in_userid);


    @POST("expense/insert")
    Call<ResponseBody> addExpenseDetails(@Header("Authorization") String token,@Body JsonObject jsonObject);
@Multipart
    @POST("expense/image")
    Call<ResponseBody>getExpenseImage(@Header("Authorization")String token, @Part MultipartBody.Part image, @Part("comp_id") RequestBody comp_id, @Part("logged_in_userid") RequestBody logged_in_userid, @Part("type")
        RequestBody type);


    @GET("expense/info?")
    Call<ResponseBody>editExpenseDetails(@Header("Authorization")String Authorization,@Query("comp_id")String comp_id,@Query("logged_in_userid")String logged_in_userid,@Query("expense_id")
            int id,@Query("org_id") String org_id);

    @POST("expense/update")
    Call<ResponseBody>updateDetails(@Header("Authorization")String Authorization,@Body JsonObject jsonObject);

    @GET("expense/app/show?")
    Call<ResponseBody>showExpenseDetails(@Header("Authorization")String Authorization,@Query("comp_id")
            String comp_id,@Query("logged_in_userid")
            String logged_in_userid
    ,@Query("org_id")String org_id);

    @POST("expense/approve/all")
    Call<ResponseBody>approveExpense(@Header("Authorization")String Authorization,@Body JsonObject jsonObject);

    @GET("expense/app/myself")
    Call<ResponseBody>showExpenseDetails_Myself(@Header("Authorization")
                                                        String Authorization,@Query("comp_id")
            String comp_id,@Query("logged_in_userid") String logged_in_userid
            ,@Query("org_id")String org_id);

    @POST("expense/reject/all")
    Call<ResponseBody>RejectExpense(@Header("Authorization")String Authorization,@Body JsonObject jsonObject);


    @GET("collection/delete?")
    Call<ResponseBody> deleteCollection(@Header("Authorization")String Authorization, @Query("comp_id") String comp_id,
                                         @Query("org_id")String org_id,@Query("logged_in_userid")String logged_in_userid,@Query("collection_id")
                                                 String collection_id);

}
