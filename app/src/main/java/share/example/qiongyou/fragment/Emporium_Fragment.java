package share.example.qiongyou.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import share.example.qiongyou.R;
import share.example.qiongyou.adapter.EmporiumCardGridViewAdapter;
import share.example.qiongyou.adapter.EmporiumMenuAdapter;
import share.example.qiongyou.been.EmporiumBean;
import share.example.qiongyou.util.UrlUtils;
import share.example.qiongyou.util.VolleyUtils;
import share.example.qiongyou.view.EmporiumFirstList;
import share.example.qiongyou.view.EmporiumSecondList;

/**
 * 商城
 */
public class Emporium_Fragment extends Fragment {
    private Button but_search;
    private GridView gv_menu;
    private ImageView iv_meetLeft, iv_meetRightTop, iv_meetRightBottom;
    private LinearLayout firstListLinear;
    private RequestQueue queue;
    private EmporiumBean.DataBean data;
    private List<EmporiumBean.DataBean.IconListBean> iconList = new ArrayList<>();
    private EmporiumMenuAdapter menuAdapter;
    private List<ImageView> imageViews =new ArrayList<>();
    private List<EmporiumBean.DataBean.HotAreaBean> hotAreaList=new ArrayList<>();
    private List<EmporiumBean.DataBean.DiscountTopicBean> discountList=new ArrayList<>();
    private GridView card;
    private List<EmporiumBean.DataBean.HotGoodsBean>goodsList=new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.emporium, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initNetData();
        initMenuAdapter();


    }

    private void initFirstList() {
        for (int i = 0; i <hotAreaList.size() ; i++) {
            EmporiumFirstList firstList=new EmporiumFirstList(getActivity(),hotAreaList.get(i));
            firstListLinear.addView(firstList);
        }
    }

    private void initMeetingPic() {
        for (int i = 0; i < imageViews.size(); i++) {
            Picasso.with(getActivity())
                    .load(data.getMarket_topic()
                            .get(i).getPic())
                    .placeholder(R.mipmap.ic_launcher)
                    .into(imageViews.get(i));
        }
    }

    private void initNetData() {
        queue = Volley.newRequestQueue(getActivity());
        VolleyUtils<EmporiumBean> request = new VolleyUtils<EmporiumBean>(UrlUtils.EmporiumUrl
                , new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }, new Response.Listener<EmporiumBean>() {
            @Override
            public void onResponse(EmporiumBean response) {
                data = response.getData();
                iconList.clear();
                iconList.addAll(data.getIcon_list());
                menuAdapter.notifyDataSetChanged();
                initMeetingPic();

                hotAreaList.clear();
                hotAreaList.addAll(data.getHot_area());
                initFirstList();

                discountList.clear();
                discountList.addAll(data.getDiscount_topic());
                initSecondList();

                goodsList.clear();
                goodsList.addAll(data.getHot_goods());
                initGoodsAdapter();


            }
        }, EmporiumBean.class);
        queue.add(request);

    }

    private void initGoodsAdapter() {
        EmporiumCardGridViewAdapter adapter =new EmporiumCardGridViewAdapter(goodsList,getActivity());
        card.setAdapter(adapter);
    }

    private void initSecondList() {
        for (int i = 0; i < discountList.size(); i++) {
            EmporiumSecondList secondList=new EmporiumSecondList(getActivity(),discountList.get(i));
            firstListLinear.addView(secondList);
        }

    }

    private void initMenuAdapter() {
        menuAdapter = new EmporiumMenuAdapter(getActivity(), iconList);
        gv_menu.setAdapter(menuAdapter);
    }

    private void initView(View view) {
        but_search = (Button) view.findViewById(R.id.button_search);
        gv_menu = (GridView) view.findViewById(R.id.gridView_menu);
        iv_meetLeft = (ImageView) view.findViewById(R.id.iv_meetingLeft);
        iv_meetRightTop = (ImageView) view.findViewById(R.id.iv_meetingRightTop);
        iv_meetRightBottom = (ImageView) view.findViewById(R.id.iv_meetingRightBottom);
        firstListLinear=(LinearLayout)view.findViewById(R.id.linear_first);
        card=(GridView) view.findViewById(R.id.gridView_goods);
        imageViews.clear();
        imageViews.add(iv_meetLeft);
        imageViews.add(iv_meetRightTop);
        imageViews.add(iv_meetRightBottom);

    }
}
