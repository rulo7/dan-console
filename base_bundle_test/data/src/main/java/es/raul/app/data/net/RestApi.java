package es.raul.app.data.net;
/**
 * Created by djuarez on 17/12/15.
 */

import com.google.gson.Gson;

import javax.inject.Inject;
import javax.inject.Singleton;

import es.raul.app.data.BuildConfig;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * {@link RestApi} implementation for retrieving data from the network.
 */
@Singleton
public class RestApi {

    private final Service service;

    /**
     * Constructor of the class
     */
    @Inject
    public RestApi() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (BuildConfig.DEBUG) {
            builder.addInterceptor(getLogginInterceptor());
        }
        Retrofit retro = new Retrofit.Builder().baseUrl(BuildConfig.URL_API)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(builder.build())
                .build();
        service = retro.create(Service.class);
    }

    private Interceptor getLogginInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }

    private <T> T checkResponse(Response<T> response) {
        if (!response.isSuccess()) {
            switch (response.code()) {
                case 400:
                    //TODO: propagate Bad request exception
                    break;
                case 401:
                    //TODO: propagate Unauthorized exception
                    break;
                case 403:
                    //TODO: propagate Forbidden exception
                    break;
                case 404:
                    //TODO: propagate Not found exception
                    break;
                case 422:
                    //TODO: propagate Unproccesable entity exception
                    break;
                case 500:
                    //TODO: propagate Internal server error exception
                    break;
            }
        }
        return response.body();
    }
}