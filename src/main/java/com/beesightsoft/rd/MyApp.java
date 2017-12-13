package com.beesightsoft.rd;

//https://sourceafis.machinezoo.com/

import com.beesightsoft.rd.rest.GitHubService;
import com.beesightsoft.rd.rest.Repo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyApp {

    public static void main(String[] args) throws Exception {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GitHubService service = retrofit.create(GitHubService.class);
        Call<List<Repo>> repos = service.listRepos("nhancv");
        Response<List<Repo>> response = repos.execute();

        for (Repo repo : response.body()) {
            System.out.println(repo);
        }

        SocketServer.start("localhost", 3000);
        SocketClient.start("ws://localhost:3000");

//        com.beesightsoft.rd.FingerAuthentication fingerAuthentication = new com.beesightsoft.rd.FingerAuthentication();
//        fingerAuthentication.matching1toN();
//        fingerAuthentication.matching1toN();


    }
}
