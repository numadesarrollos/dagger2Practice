package com.numadesarrollos.dagger2practice.ui.main.posts;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.numadesarrollos.dagger2practice.R;
import com.numadesarrollos.dagger2practice.models.Post;
import com.numadesarrollos.dagger2practice.ui.main.Resource;
import com.numadesarrollos.dagger2practice.util.VerticalSpaceItemDecoration;
import com.numadesarrollos.dagger2practice.viewmodels.ViewModelProviderFactory;

import java.util.List;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

public class PostsFragment extends DaggerFragment {

    private static final String TAG = "PostsFragment";

    private PostsViewModel viewModel;

    private RecyclerView recyclerView;

    @Inject
    ViewModelProviderFactory viewModelProviderFactory;
    @Inject
    PostsRecyclerAdapter adapter;
    @Inject
    LinearLayoutManager linearLayoutManager;
    @Inject
    VerticalSpaceItemDecoration itemDecoration;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_posts,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        recyclerView = view.findViewById(R.id.recycler_view);

        viewModel = ViewModelProviders.of(this,viewModelProviderFactory).get(PostsViewModel.class);

        initRecyclerView();
        subscribeObservers();
    }

    private void subscribeObservers(){
        viewModel.observePosts().removeObservers(getViewLifecycleOwner());
        viewModel.observePosts().observe(getViewLifecycleOwner(), new Observer<Resource<List<Post>>>() {
            @Override
            public void onChanged(Resource<List<Post>> listResource) {
                if(listResource != null){
                    switch (listResource.status){
                        case LOADING:
                            Log.d(TAG, "onChanged: LOADING....");
                            break;
                        case SUCCESS:
                            Log.d(TAG, "onChanged: getPOst...");
                            adapter.setPosts(listResource.data);
                            break;
                        case ERROR:
                            Log.e(TAG, "onChanged: ERROR ... " + listResource.message);
                            break;
                    }
                }
            }
        });
    }

    private void initRecyclerView(){
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(itemDecoration);
        recyclerView.setAdapter(adapter);

    }
}
