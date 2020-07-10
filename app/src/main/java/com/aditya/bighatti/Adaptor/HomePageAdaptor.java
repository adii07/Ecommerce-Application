package com.aditya.bighatti.Adaptor;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.aditya.bighatti.Activity.HomePageModel;
import com.aditya.bighatti.Activity.HorizontalProductModel;
import com.aditya.bighatti.Activity.SliderModel;
import com.aditya.bighatti.Activity.ViewAllActivity;
import com.aditya.bighatti.R;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

public class HomePageAdaptor extends RecyclerView.Adapter {
    private List<HomePageModel> homePageModelList;

    public HomePageAdaptor(List<HomePageModel> homePageModelList) {
        this.homePageModelList = homePageModelList;
    }


    @Override
    public int getItemViewType(int position) {
        switch (homePageModelList.get(position).getType()) {
            case 0:
                return HomePageModel.BANNER_SLIDER;

            case 1:
                return HomePageModel.STRIP_ADD_BANNER;
            case 2:
                return HomePageModel.HORIZONTAL_PRODUCT_VIEW;
            case 3:
                return HomePageModel.GRID_PRODUCT_VIEW;
            default:
                return -1;
        }
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case HomePageModel.BANNER_SLIDER:
                View bannerSliderView = LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_banner_layout, parent, false);
                return new BannerSliderViewHolder(bannerSliderView);
            case HomePageModel.STRIP_ADD_BANNER:
                View stripAddView = LayoutInflater.from(parent.getContext()).inflate(R.layout.strip_add_layout, parent, false);
                return new StripAddBannerViewHolder(stripAddView);
            case HomePageModel.HORIZONTAL_PRODUCT_VIEW:
                View horizontalProductView = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_scroll_layout, parent, false);
                return new HorizontalProductViewHolder(horizontalProductView);
            case HomePageModel.GRID_PRODUCT_VIEW:
                View gridProductView = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_product_layout, parent, false);
                return new GridProductViewHolder(gridProductView);
            default:
                return null;
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (homePageModelList.get(position).getType()) {
            case HomePageModel.BANNER_SLIDER:
                List<SliderModel> sliderModelList = homePageModelList.get(position).getSliderModelList();
                ((BannerSliderViewHolder) holder).setBannerSliderViewPager(sliderModelList);
                break;
            case HomePageModel.STRIP_ADD_BANNER:
                int resource = homePageModelList.get(position).getResource();
                String color = homePageModelList.get(position).getBackgroundColor();
                ((StripAddBannerViewHolder) holder).setStripAdd(resource, color);
                break;
            case HomePageModel.HORIZONTAL_PRODUCT_VIEW:
                String title=homePageModelList.get(position).getTitle();
                List<HorizontalProductModel> horizontalProductModelList=homePageModelList.get(position).getHorizontalProductModelList();
                ((HorizontalProductViewHolder) holder).setHorizontalProductLayout(horizontalProductModelList,title);
                break;
            case HomePageModel.GRID_PRODUCT_VIEW:
                String title1=homePageModelList.get(position).getTitle();
                List<HorizontalProductModel> gridProductModelList=homePageModelList.get(position).getHorizontalProductModelList();
                ((GridProductViewHolder) holder).setGridLayoutTitle(gridProductModelList,title1);
            default:
                return;

        }
    }

    @Override
    public int getItemCount() {
        return homePageModelList.size();
    }

    public class BannerSliderViewHolder extends RecyclerView.ViewHolder {

        private ViewPager banner_slider_ViewPager;
        private int currentPage = 2;
        private Timer timer;
        final private long delayTime = 3000;
        final private long PeriodTime = 3000;

        public BannerSliderViewHolder(@NonNull View itemView) {
            super(itemView);
            banner_slider_ViewPager = itemView.findViewById(R.id.banner_slider_viewPagger);
        }

        private void setBannerSliderViewPager(final List sliderModelList) {
            SliderAdaptor sliderAdaptor = new SliderAdaptor(sliderModelList);
            banner_slider_ViewPager.setAdapter(sliderAdaptor);
            banner_slider_ViewPager.setClipToPadding(false);
            banner_slider_ViewPager.setPageMargin(20);
            banner_slider_ViewPager.setCurrentItem(currentPage);
            ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int position) {
                    currentPage = position;
                }

                @Override
                public void onPageScrollStateChanged(int state) {
                    if (state == ViewPager.SCROLL_STATE_IDLE) {
                        pageLooper(sliderModelList);
                    }
                }
            };
            banner_slider_ViewPager.addOnPageChangeListener(onPageChangeListener);
            startBannerAmin(sliderModelList);

            banner_slider_ViewPager.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    pageLooper(sliderModelList);
                    stopBannerAmin();
                    if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                        startBannerAmin(sliderModelList);
                    }
                    return false;
                }
            });
        }

        private void pageLooper(List sliderModelList) {
            if (currentPage == sliderModelList.size() - 2) {
                currentPage = 2;
                banner_slider_ViewPager.setCurrentItem(currentPage, false);
            }

            if (currentPage == 1) {
                currentPage = sliderModelList.size() - 3;
                banner_slider_ViewPager.setCurrentItem(currentPage, false);
            }

        }

        private void startBannerAmin(final List sliderModelList) {
            final Handler handler = new Handler();
            final Runnable update = new Runnable() {
                @Override
                public void run() {
                    if (currentPage >= sliderModelList.size()) {
                        currentPage = 1;
                    }
                    banner_slider_ViewPager.setCurrentItem(currentPage++, true);
                }
            };
            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    handler.post(update);
                }
            }, delayTime, PeriodTime);
        }

        private void stopBannerAmin() {
            timer.cancel();
        }
    }

    public class StripAddBannerViewHolder extends RecyclerView.ViewHolder {
        private ImageView strip_add_image;
        private ConstraintLayout strip_add_container;

        public StripAddBannerViewHolder(@NonNull View itemView) {
            super(itemView);
            strip_add_image = itemView.findViewById(R.id.strip_add_image);
            strip_add_container = itemView.findViewById(R.id.strip_add_container);
        }

        private void setStripAdd(int resource, String color) {
            strip_add_image.setImageResource(resource);
            strip_add_container.setBackgroundColor(Color.parseColor(color));
        }
    }

    public class HorizontalProductViewHolder extends RecyclerView.ViewHolder{
        private TextView horizontalLayoutTitle;
        private Button horizontalLayoutViewAllButton;
        private RecyclerView horizontalRecycleView;
        public HorizontalProductViewHolder(@NonNull View itemView) {
            super(itemView);
            horizontalLayoutTitle=itemView.findViewById(R.id.horizontal_scrollLayout_title);
            horizontalLayoutViewAllButton=itemView.findViewById(R.id.horizontal_scrollLayout_button);
            horizontalRecycleView=itemView.findViewById(R.id.horizontal_scrollLayout_recyclerView);
        }
        private void setHorizontalProductLayout(List<HorizontalProductModel> horizontalProductModelList,String title){
            horizontalLayoutTitle.setText(title);
            if (horizontalProductModelList.size()>8)
            {
                horizontalLayoutViewAllButton.setVisibility(View.VISIBLE);
                horizontalLayoutViewAllButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent =new Intent(itemView.getContext(), ViewAllActivity.class);
                        intent.putExtra("layout_code",0);
                        itemView.getContext().startActivity(intent);
                    }
                });
            }
            else{
                horizontalLayoutViewAllButton.setVisibility(View.INVISIBLE);
            }

            HorizontalProductScrollAdaptor horizontalProductScrollAdaptor=new HorizontalProductScrollAdaptor(horizontalProductModelList);
            LinearLayoutManager linearLayoutManager=new LinearLayoutManager(itemView.getContext());
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            horizontalRecycleView.setLayoutManager(linearLayoutManager);

            horizontalRecycleView.setAdapter(horizontalProductScrollAdaptor);
            horizontalProductScrollAdaptor.notifyDataSetChanged();
        }
    }

    public class GridProductViewHolder extends RecyclerView.ViewHolder{
        private TextView gridLayoutTitle;
        private Button gridLayoutViewAllBTN;
        private GridView gridView;
        public GridProductViewHolder(@NonNull View itemView) {
            super(itemView);
            gridLayoutTitle=itemView.findViewById(R.id.grid_layout_title);
            gridLayoutViewAllBTN=itemView.findViewById(R.id.grid_product_layout_viewall_btn);
            gridView=itemView.findViewById(R.id.grid_product_layout_grid_view);
        }
        private void setGridLayoutTitle(List<HorizontalProductModel> horizontalProductModelList,String title){
            gridLayoutTitle.setText(title);
            gridView.setAdapter(new GridProductLayoutAdpator(horizontalProductModelList));
            gridLayoutViewAllBTN.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent =new Intent(itemView.getContext(), ViewAllActivity.class);
                    intent.putExtra("layout_code",1);
                    itemView.getContext().startActivity(intent);
                }
            });
        }
    }
}
