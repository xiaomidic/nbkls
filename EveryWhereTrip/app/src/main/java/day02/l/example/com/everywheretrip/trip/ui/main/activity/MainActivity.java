package day02.l.example.com.everywheretrip.trip.ui.main.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import day02.l.example.com.everywheretrip.R;
import day02.l.example.com.everywheretrip.trip.base.Constants;
import day02.l.example.com.everywheretrip.trip.bean.UsenBean;
import day02.l.example.com.everywheretrip.trip.net.ApiService;
import day02.l.example.com.everywheretrip.trip.net.BaseObserver;
import day02.l.example.com.everywheretrip.trip.net.HttpUtils;
import day02.l.example.com.everywheretrip.trip.net.RxUtils;
import day02.l.example.com.everywheretrip.trip.ui.main.adapter.MyPageAdapter;
import day02.l.example.com.everywheretrip.trip.ui.main.fragment.BanMiFragment;
import day02.l.example.com.everywheretrip.trip.ui.main.fragment.HomeFragment;
import day02.l.example.com.everywheretrip.trip.util.SpUtil;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private TabLayout mTab;
    private ViewPager mVp;
    private ArrayList<Fragment> list;
    private Toolbar mToolBar;
    private NavigationView mNa;
    private DrawerLayout mDl;
    private ImageView mImg;
    private ImageView mImg2;
    private RelativeLayout mLayu;
    /**
     * 林小姐
     */
    private TextView mMiss;
    /**
     * 四体不勤五谷不分人懒嘴花痴健忘
     */
    private TextView mGexing;
    /**
     * 编辑
     */
    private TextView mTvBianji;
    private ImageView mIv;
    /**
     * 我的钱包
     */
    private TextView mTvWallet;
    /**
     * 99
     */
    private TextView mTv99;
    /**
     * 》
     */
    private TextView mTvText;
    private RelativeLayout mRel;
    private ImageView mImgKajuan;
    private View mView;
    private ImageView mImgYigou;
    private View mView2;
    private ImageView mImgShoucang;
    private View mView3;
    private ImageView mImgGuanzhu;
    private CardView mCard;
    private ImageView mImgKefu;
    /**
     * 联系客服
     */
    private TextView mTvKefu;
    private ImageView mImgFankui;
    /**
     * 意见反馈
     */
    private TextView mTvFankui;
    private ImageView mImgBanben;
    /**
     * 我的收藏
     */
    private TextView mTvColltion;
    /**
     * 我的收藏
     */
    private TextView mTvShou;
    private RequestOptions options;

    public static void startAct(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        options = new RequestOptions().circleCrop();

        Glide.with(this).load(SpUtil.getParam(Constants.HEADIMG,"")).apply(options).into(mImg);
        mMiss.setText((String)SpUtil.getParam(Constants.SPNAME,""));
        mGexing.setText((String) SpUtil.getParam(Constants.SPPARAM, ""));
        initData();

    }

    private void initData() {
        ApiService apiserver = HttpUtils.getInstance().getApiserver(ApiService.url, ApiService.class);
        apiserver.getUser().compose(RxUtils.<UsenBean>rxObserableSchedulerHelper()).subscribe(
                new BaseObserver<UsenBean>() {
                    @Override
                    public void onNext(UsenBean usenBean) {
                      /*  UsenBean.ResultBean result = usenBean.getResult();

                        String name = result.getUserName();
                       // mMiss.setText(name);
                        String param = (String) SpUtil.getParam(Constants.SPNAME, name);
                        mMiss.setText(param);
                        String description = result.getDescription();
                        String param1 = (String) SpUtil.getParam(Constants.SPPARAM, description);
                        mGexing.setText(param1);*/
                    }

                    @Override
                    public void error(String msg) {

                    }

                    @Override
                    protected void subscribe(Disposable d) {

                    }
                }
        );
    }


    private void initView() {
        mTab = (TabLayout) findViewById(R.id.tab);
        mVp = (ViewPager) findViewById(R.id.vp);
        mNa = (NavigationView) findViewById(R.id.na);
        mDl = (DrawerLayout) findViewById(R.id.dl);
        mImg = (ImageView) findViewById(R.id.img);
        mToolBar = (Toolbar) findViewById(R.id.toolBar);
        mToolBar.setTitle("");
        setSupportActionBar(mToolBar);

        //1.设置图标不显示处理
        mNa.setItemIconTintList(null);

        //2.设置菜单点击处理


        list = new ArrayList<>();
        list.add(new HomeFragment());
        list.add(new BanMiFragment());

        mTab.addTab(mTab.newTab().setText("首页").setIcon(R.drawable.home_highlight));
        mTab.addTab(mTab.newTab().setText("伴米").setIcon(R.drawable.banmi_highlight));
        MyPageAdapter adapter = new MyPageAdapter(getSupportFragmentManager(), list);
        mVp.setAdapter(adapter);
        mTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mVp.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        mVp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTab));


        mImg2 = (ImageView) findViewById(R.id.img2);
        mLayu = (RelativeLayout) findViewById(R.id.layu);
        mMiss = (TextView) findViewById(R.id.miss);
        mGexing = (TextView) findViewById(R.id.gexing);
        mTvBianji = (TextView) findViewById(R.id.tv_bianji);
        mIv = (ImageView) findViewById(R.id.iv);
        mTvWallet = (TextView) findViewById(R.id.tv_wallet);
        mTv99 = (TextView) findViewById(R.id.tv_99);
        mTvText = (TextView) findViewById(R.id.tv_text);
        mRel = (RelativeLayout) findViewById(R.id.rel);
        mImgKajuan = (ImageView) findViewById(R.id.img_kajuan);
        mView = (View) findViewById(R.id.view);
        mImgYigou = (ImageView) findViewById(R.id.img_yigou);
        mView2 = (View) findViewById(R.id.view2);
        mImgShoucang = (ImageView) findViewById(R.id.img_shoucang);
        mView3 = (View) findViewById(R.id.view3);
        mImgGuanzhu = (ImageView) findViewById(R.id.img_guanzhu);
        mCard = (CardView) findViewById(R.id.card);
        mImgKefu = (ImageView) findViewById(R.id.img_kefu);
        mTvKefu = (TextView) findViewById(R.id.tv_kefu);
        mImgFankui = (ImageView) findViewById(R.id.img_fankui);
        mTvFankui = (TextView) findViewById(R.id.tv_fankui);
        mImgBanben = (ImageView) findViewById(R.id.img_banben);
        mTvColltion = (TextView) findViewById(R.id.tv_colltion);
        mTvColltion.setOnClickListener(this);
        mImg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDl.openDrawer(Gravity.LEFT);
            }
        });
        mImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MessageActivity.class));
            }
        });

        mTvShou = (TextView) findViewById(R.id.tv_shou);
        mTvShou.setOnClickListener(this);
        mMiss.setOnClickListener(this);
        mGexing.setOnClickListener(this);
    }

    //选项菜单
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.layout_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.tv_colltion:
                Intent intent = new Intent(this, ColltionActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_shou:
                Intent intent1 = new Intent(this, CollectionActivity.class);
                startActivity(intent1);

                break;
            case R.id.miss:
                break;
            case R.id.gexing:
                break;
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Glide.with(this).load(SpUtil.getParam(Constants.HEADIMG,"")).apply(options).into(mImg);
        mMiss.setText((String)SpUtil.getParam(Constants.SPNAME,""));
        mGexing.setText((String) SpUtil.getParam(Constants.SPPARAM, ""));
    }
}
