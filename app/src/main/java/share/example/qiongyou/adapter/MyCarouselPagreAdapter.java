package share.example.qiongyou.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by tenfei on 2016/11/11.
 */
public class MyCarouselPagreAdapter extends PagerAdapter {
    private ArrayList<ImageView> imageViews=new ArrayList<>();

    public MyCarouselPagreAdapter(ArrayList<ImageView> imageViews) {
        this.imageViews = imageViews;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
            container.addView(imageViews.get(position%imageViews.size()));
            return imageViews.get(position%imageViews.size());
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(imageViews.get(position%imageViews.size()));
    }
}
