package com.aditya.bighatti.Activity.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aditya.bighatti.Activity.CategoryModel;
import com.aditya.bighatti.Activity.HomePageModel;
import com.aditya.bighatti.Activity.HorizontalProductModel;
import com.aditya.bighatti.Activity.SliderModel;
import com.aditya.bighatti.Adaptor.CategoryAdaptor;
import com.aditya.bighatti.Adaptor.HomePageAdaptor;
import com.aditya.bighatti.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private RecyclerView Category_recyclerView;
    private CategoryAdaptor categoryAdaptor;
    private RecyclerView testing;
    private FirebaseFirestore firebaseFirestore;
    private List<CategoryModel> categoryModelList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        Category_recyclerView=root.findViewById(R.id.catagory_recycler_view);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        Category_recyclerView.setLayoutManager(layoutManager);

        categoryModelList =new ArrayList<CategoryModel>();
        categoryAdaptor=new CategoryAdaptor(categoryModelList);
        Category_recyclerView.setAdapter(categoryAdaptor);


        firebaseFirestore=FirebaseFirestore.getInstance();
        firebaseFirestore.collection("CATEGORIES").orderBy("index").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()){
                            for (QueryDocumentSnapshot documentSnapshot : task.getResult()){
                             categoryModelList.add(new CategoryModel(documentSnapshot.get("icon").toString(),documentSnapshot.get("categoryName").toString()));
                            }
                            categoryAdaptor.notifyDataSetChanged();
                        }
                        else {
                            String exception=task.getException().getMessage();
                            Log.v("CategoryDatabase",exception);
                        }
                    }
                });

//        categoryModelList.add(new CategoryModel("link","Home"));
//        categoryModelList.add(new CategoryModel("link","Essentials"));
//        categoryModelList.add(new CategoryModel("link","Biscuits"));
//        categoryModelList.add(new CategoryModel("link","Drinks"));
//        categoryModelList.add(new CategoryModel("link","Fruits"));
//        categoryModelList.add(new CategoryModel("link","Dry Fruits"));
//        categoryModelList.add(new CategoryModel("link","Kitchen"));

        //////////////////////////////////////banner slider
       List<SliderModel> sliderModelList =new ArrayList<SliderModel>();
        sliderModelList.add(new SliderModel(R.drawable.banner));
        sliderModelList.add(new SliderModel(R.drawable.banner4));
        sliderModelList.add(new SliderModel(R.drawable.banner2));
        sliderModelList.add(new SliderModel(R.drawable.banner3));
        sliderModelList.add(new SliderModel(R.drawable.banner5));
        sliderModelList.add(new SliderModel(R.drawable.banner6));
        /////////////////////////////Horizontal Product Layout
        List<HorizontalProductModel> horizontalProductModelList=new ArrayList<>();
        horizontalProductModelList.add(new HorizontalProductModel(R.drawable.image,"Aashirvaad Aata","10kg","Rs. 590"));
        horizontalProductModelList.add(new HorizontalProductModel(R.drawable.amul,"Amul Chesse","120g","Rs. 100"));
        horizontalProductModelList.add(new HorizontalProductModel(R.drawable.image2,"Royal Aata","10kg","Rs. 540"));
        horizontalProductModelList.add(new HorizontalProductModel(R.drawable.image3,"Hershey Syrup","450 g","Rs. 200"));
        horizontalProductModelList.add(new HorizontalProductModel(R.drawable.image4,"Nestle Ice Tea","1L","Rs. 120"));
        horizontalProductModelList.add(new HorizontalProductModel(R.drawable.image5,"Roofafza","750mL","Rs. 150"));
        horizontalProductModelList.add(new HorizontalProductModel(R.drawable.image6,"Hide And Seek","120g","Rs. 30"));
        horizontalProductModelList.add(new HorizontalProductModel(R.drawable.image7,"Lotte Choco Pie","300g","Rs. 140"));
        horizontalProductModelList.add(new HorizontalProductModel(R.drawable.image8,"Little Hearts","18g","Rs. 10"));
        horizontalProductModelList.add(new HorizontalProductModel(R.drawable.image5,"Roofafza","750mL","Rs. 150"));



        testing=root.findViewById(R.id.home__page_recycler_view);
        LinearLayoutManager testingLayoutManager=new LinearLayoutManager(getContext());
        testingLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        testing.setLayoutManager(testingLayoutManager);
        List<HomePageModel> homePageModelList=new ArrayList<>();
        homePageModelList.add(new HomePageModel(0,sliderModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.stipadd1,"#000000"));
        homePageModelList.add(new HomePageModel(2,"Deals of the day!",horizontalProductModelList));
        homePageModelList.add(new HomePageModel(3,"Categories",horizontalProductModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.stipadd,"#ff0000"));
        homePageModelList.add(new HomePageModel(2,"Deals of the day!",horizontalProductModelList));
        homePageModelList.add(new HomePageModel(0,sliderModelList));
        homePageModelList.add(new HomePageModel(0,sliderModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.banner,"#ffff00"));
        HomePageAdaptor adaptor=new HomePageAdaptor(homePageModelList);
        testing.setAdapter(adaptor);
        adaptor.notifyDataSetChanged();

        //////////////////////
        return root;
    }

}