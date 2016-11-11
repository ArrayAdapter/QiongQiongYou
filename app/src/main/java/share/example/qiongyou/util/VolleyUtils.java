package share.example.qiongyou.util;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;

/**
 * 使用Volly作为网络数据加载框架 因为retrofit不支持type 也就是使用retrofit不可以实现recyclerview的多布局实现
 * 这是工具类   直接使用它就行了  忘了的复习    我也忘了。
 */
public class VolleyUtils<T> extends Request<T> {
    private Response.Listener<T> listener;
    private Class<T> clazz;

    public VolleyUtils(String url, Response.ErrorListener errorlistener, Response.Listener<T> listener1, Class<T> clazz) {
       this(Method.GET,url,errorlistener,listener1,clazz);
    }

    public VolleyUtils(int method, String url, Response.ErrorListener errorlistener, Response.Listener<T> listener1, Class<T> clazz) {
        super(method, url, errorlistener);
        listener = listener1;
        this.clazz = clazz;
    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        String json;
        try {
            json=new String(response.data, HttpHeaderParser.parseCharset(response.headers));
        } catch (UnsupportedEncodingException e) {
            json=new String(response.data);
        }
        T been=new Gson().fromJson(json,clazz);
        return Response.success(been,HttpHeaderParser.parseCacheHeaders(response));
    }

    @Override
    protected void deliverResponse(T response) {
        if(listener!=null){
            listener.onResponse(response);
        }
    }
}
