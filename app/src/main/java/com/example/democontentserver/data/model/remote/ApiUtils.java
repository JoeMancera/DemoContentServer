package com.example.democontentserver.data.model.remote;

public class ApiUtils {
    private ApiUtils() {}
    public static final String BASE_URL = "http://explorationlab.projectioncore.com/OTCS/cs.exe/api/";
    public static APIService getAPIService() {
        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}
