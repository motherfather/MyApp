package com.bit2016.myapp.core.service;

import com.bit2016.android.network.JSONResult;
import com.bit2016.myapp.core.domain.User;
import com.github.kevinsawicki.http.HttpRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Reader;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by BITUSER on 2016-12-02.
 */

public class UserService {

    public List<User> fetchUserList() {
        String url = "http://192.168.1.18:8088/myapp-api/api/user/list";
        HttpRequest httpRequest = HttpRequest.get(url);

        httpRequest.contentType(HttpRequest.CONTENT_TYPE_JSON); // 전달 타입
        httpRequest.accept(HttpRequest.CONTENT_TYPE_JSON); // 받을 타입
        httpRequest.connectTimeout(3000);
        httpRequest.readTimeout(3000);

        int responseCode = httpRequest.code();
        if (responseCode != HttpURLConnection.HTTP_OK) {
            throw new RuntimeException("Http Response : " + responseCode);
        }
        JSONResultUserList jsonResult = fromJSON(httpRequest, JSONResultUserList.class);
        return jsonResult.getData();
    }

    public List<User> fetchUserMockList() {
        // Mock data
        List<User> list = new ArrayList<User>();
        User user = new User();
        user.setId( 1L );
        user.setName( "안대혁" );
        user.setPhone( "010-4761-6934" );
        user.setEmail( "kickscar@gmail.com" );
        user.setProfilePic("https://avatars3.githubusercontent.com/u/482271?v=3&s=72");
        user.setStatus( 1 );
        list.add( user );

        return list;
    }

    private class JSONResultUserList extends JSONResult<List<User>> {
    }
    /**
     * JSON 문자열을 자바 객체로 변환
     * @param request
     * @param target
     * @param <V>
     * @return
     */
    // GSON을 쓰기 위해서
    protected <V> V fromJSON( HttpRequest request, Class<V> target ) {
        V v = null;
        try {
            Gson gson = new GsonBuilder().create();

            Reader reader = request.bufferedReader();
            v = gson.fromJson(reader, target);
            reader.close();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return v;
    }
}
