package com.example.myapplication;

import android.annotation.SuppressLint;

import androidx.annotation.NonNull;

import com.softpillar.salestrendz.Web.WebAccess;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitInstance {

    private static Retrofit retrofit;
    //private static final String BASE_URL = "https://api.nasa.gov/";

    //If null creates an instance else returns the existing instance
    //This prevents redundant instances
    public static Retrofit getRetrofitInstance(){

        if(retrofit == null){
                retrofit = new Retrofit.Builder()
                        .baseUrl(WebAccess.NEW_MAIN_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

        }

        return retrofit;
    }

    public static Retrofit getNewRetrofitInstance(String authtoken){
        if(retrofit == null){
            try {
                retrofit = new Retrofit.Builder()
                        .baseUrl(WebAccess.NEW_MAIN_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(getOKClient(authtoken))
                        .build();
            } catch (KeyManagementException e) {
                e.printStackTrace();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }

        return retrofit;
    }

    private static OkHttpClient getOKClient(String authtoken) throws KeyManagementException, NoSuchAlgorithmException {

        // Create a trust manager that does not validate certificate chains
        final TrustManager[] trustAllCerts = new TrustManager[]{
                new X509TrustManager() {
                    @SuppressLint("TrustAllX509TrustManager")
                    @Override
                    public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) {
                    }

                    @SuppressLint("TrustAllX509TrustManager")
                    @Override
                    public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) {
                    }

                    @Override
                    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                        return new java.security.cert.X509Certificate[]{};
                    }
                }
        };

        // Install the all-trusting trust manager
        final SSLContext sslContext = SSLContext.getInstance("SSL");
        sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
        // Create an ssl socket factory with our all-trusting manager
        final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.sslSocketFactory(sslSocketFactory);
        httpClient.hostnameVerifier((hostname, session) -> true);


/*
        httpClient.readTimeout(30, TimeUnit.MINUTES);
        httpClient.writeTimeout(15,TimeUnit.MINUTES);
        httpClient.connectTimeout(1, TimeUnit.MINUTES);
*/

    httpClient.connectTimeout(1, TimeUnit.MINUTES)
                .readTimeout(1, TimeUnit.MINUTES);


        httpClient.addInterceptor(interceptor);
        httpClient.addInterceptor(new Interceptor() {
            @NonNull
            @Override
            public Response intercept(@NonNull Chain chain) throws IOException {
                Request original = chain.request();

                Request request = original.newBuilder()
                        .header("Content-Type", "application/x-www-form-urlencoded")
                        .header("Authorization", authtoken)
                        .method(original.method(), original.body())
                        .build();

                return chain.proceed(request);
            }
        });

        return httpClient.build();
    }



}
