package share.example.qiongyou.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import share.example.qiongyou.R;
import share.example.qiongyou.adapter.MyCarouselPagreAdapter;
import share.example.qiongyou.been.HomePageBeen;
import share.example.qiongyou.util.UrlUtils;
import share.example.qiongyou.util.VolleyUtils;

/**
 * 首页
 */
public class HomePage_Fragment extends Fragment {
    private static final String TAG = "tmd";
    private ViewPager carouselPager;
    private Context mContext;
    private MyCarouselPagreAdapter adapter;
    private RequestQueue queue;
    private Handler handler=new Handler();
    private Runnable r;
    private boolean flag;
    private ArrayList<ImageView> imageViews=new ArrayList<>();/*图片集合*/
    private ArrayList<String> urls=new ArrayList<>();/*图片网址集合*/
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext=getActivity();
        queue= Volley.newRequestQueue(mContext);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.homepage,null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initRunable();
        initCarouselImage();/*负责下载图片的url 并添加到添加到urls中*/
        /*图片的网络数据已经全部添加到urls中后就要下载图片 并添加到imageview中*/
        /*通过urls的长度可以获知imageVeiw的数量 将获取到的imageView添加到imageViews中*/
        initCarouselPagerListener();/*设置负责轮播图的pager的监听事件*/
    }

    private void initCarouselPagerListener() {
        carouselPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                switch (state){
                    case ViewPager.SCROLL_STATE_IDLE:/*手指离开屏幕结束滑动时*/
                        if(flag){
                            handler.postDelayed(r,3000);
                            flag=false;
                        }
                    break;
                    case ViewPager.SCROLL_STATE_DRAGGING:/*手指开始触摸时*/
                        handler.removeCallbacks(r);
                        flag=true;
                    break;
                }
            }
        });
    }

    private void initHandler() {
         /*设置默认启动的位置*/
        carouselPager.setCurrentItem(1200);
        /*每过三秒执行r方法*/
        handler.postDelayed(r,3000);
    }

    private void initRunable() {

        /*每过三秒后要执行的r方法*/
        r=new Runnable() {
            @Override
            public void run() {
                carouselPager.setCurrentItem(carouselPager.getCurrentItem()+1);
                handler.postDelayed(r,3000);
            }
        };
    }

    private void initCarouselAdapter() {
        adapter=new MyCarouselPagreAdapter(imageViews);
        carouselPager.setAdapter(adapter);
    }

    private void initCarouselData() {

        for(int i=0;i<urls.size();i++){
            ImageView imageView=new ImageView(mContext);
            imageView.setImageResource(R.mipmap.loaging);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageViews.add(imageView);
            /*利用图片加载框架添加图片*/
            Picasso.with(mContext).load(urls.get(i)).into(imageView);
        }

    }

    private void initCarouselImage() {
        VolleyUtils<HomePageBeen> utils=new VolleyUtils<HomePageBeen>(UrlUtils.HomePageUrl, null, new Response.Listener<HomePageBeen>() {
            @Override
            public void onResponse(HomePageBeen response) {
                Log.i(TAG, "onResponse: "+response.getData().getSlide().get(0).getPhoto());
                for(int i=0;i<response.getData().getSlide().size();i++){
                    urls.add(response.getData().getSlide().get(i).getPhoto());/*图片的网络数据已经全部添加到urls中*/
                }
                initCarouselData();/*轮播图数据*/
                initCarouselAdapter();/*轮播图ViewPager适配器*/
                initHandler();
            }
        },HomePageBeen.class);
        queue.add(utils);

    }

    private void initView(View view) {
        carouselPager= (ViewPager) view.findViewById(R.id.carouselPager);
    }

}
