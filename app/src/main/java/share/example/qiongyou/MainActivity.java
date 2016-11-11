package share.example.qiongyou;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import share.example.qiongyou.fragment.Community_Fragment;
import share.example.qiongyou.fragment.Destination_Fragment;
import share.example.qiongyou.fragment.Emporium_Fragment;
import share.example.qiongyou.fragment.HomePage_Fragment;

public class MainActivity extends FragmentActivity {
    private TabLayout mTable;
    private ViewPager mPager;
    private MyAdapter adapter;
    private String[] tabTitleArray = {"首页", "目的地", "商城", "社区"};
    private Fragment[] fragments = {new HomePage_Fragment(), new Destination_Fragment(), new Emporium_Fragment(), new Community_Fragment()};
    private ArrayList<Fragment> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initAdapter();
        initTab();
        initTabListener();
        initPageListener();
    }

    private void initTab() {
        for(int i=0;i<tabTitleArray.length;i++){
            mTable.addTab(mTable.newTab().setText(tabTitleArray[i]).setTag(i));
        }
    }

    private void initPageListener() {
        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mTable.getTabAt(position).select();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initTabListener() {
        mTable.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int index=Integer.parseInt(tab.getTag().toString());
                mPager.setCurrentItem(index);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void initData() {
        for (int i = 0; i < fragments.length; i++) {
            list.add(fragments[i]);
        }
    }

    private void initAdapter() {
        adapter = new MyAdapter(getSupportFragmentManager());
        mPager.setAdapter(adapter);
    }

    private void initView() {
        mPager = (ViewPager) findViewById(R.id.pager);
        mTable = (TabLayout) findViewById(R.id.table);
        mTable.setTabMode(TabLayout.MODE_FIXED);
        mTable.setSelectedTabIndicatorColor(Color.RED);
    }

    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }


    }

}
