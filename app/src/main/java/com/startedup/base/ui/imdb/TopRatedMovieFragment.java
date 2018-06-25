package com.startedup.base.ui.imdb;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.startedup.base.R;
import com.startedup.base.model.movies.TopRatedMovieResponse;
import com.startedup.base.ui.base.BaseFragment;
import com.startedup.base.ui.base.BaseView;
import com.startedup.base.utils.ResourceFinder;

import java.lang.ref.WeakReference;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class TopRatedMovieFragment extends BaseFragment implements BaseView {

    // Views
    @BindView(R.id.rv_top_rated_movies)
    RecyclerView rvTopRatedMovies;
    Unbinder unbinder;
    @BindView(R.id.pb_loading)
    ProgressBar pbLoading;
    @BindView(R.id.tv_message)
    TextView tvMessage;
    @BindView(R.id.iv_error)
    ImageView ivError;
    @BindView(R.id.tv_error)
    TextView tvError;
    private View mView;

    private ProgressDialog progressDialog;

    // Presenter
    private TopRatedMoviePresenter mPresenter;

    // LayoutManager
    private LinearLayoutManager mLinearLayoutManager;

    public TopRatedMovieFragment() {
    }

    public static TopRatedMovieFragment newInstance() {

        Bundle args = new Bundle();

        TopRatedMovieFragment fragment = new TopRatedMovieFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_top_rated_movie, container, false);
        unbinder = ButterKnife.bind(this, mView);
        return mView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
        init();
    }

    private void init() {
        mPresenter = new TopRatedMoviePresenter(new WeakReference(this));
        mPresenter.getTopRatedMovies();
    }

    private void initViews() {
        mLinearLayoutManager = new LinearLayoutManager(getActivity());
        rvTopRatedMovies.setLayoutManager(mLinearLayoutManager);
    }

    @Override
    public void showLoading(boolean isDialog, String loadingMessage) {
        pbLoading.setVisibility(View.VISIBLE);
        tvMessage.setVisibility(View.VISIBLE);
        tvMessage.setText(loadingMessage);
    }

    @Override
    public void hideLoading() {
        pbLoading.setVisibility(View.GONE);
        tvMessage.setVisibility(View.GONE);
    }

    @Override
    public void showNetworkError(boolean isDialog, String errorMessage) {
        ivError.setVisibility(View.VISIBLE);
        tvError.setVisibility(View.VISIBLE);
        ivError.setImageResource(R.drawable.im_no_internet);
        tvError.setText(errorMessage);
    }

    @Override
    public void showUnknownError(boolean isDialog, String errorMessage) {
        ivError.setVisibility(View.VISIBLE);
        tvError.setVisibility(View.VISIBLE);
        ivError.setImageResource(R.drawable.im_something_went_wrong);
        tvError.setText(errorMessage);
    }

    @Override
    public void hideError() {
        ivError.setVisibility(View.GONE);
        tvError.setVisibility(View.GONE);
    }

    @Override
    public void onSuccess(Object object) {
        TopRatedMovieResponse response = (TopRatedMovieResponse) object;
        TopRatedMovieAdapter movieAdapter = new TopRatedMovieAdapter(response.getResults());
        rvTopRatedMovies.setAdapter(movieAdapter);
    }

    @OnClick({R.id.iv_error, R.id.tv_error})
    public void onRetryClicked(View view) {
        mPresenter.getTopRatedMovies();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    protected void onPermissionAllGranted() {
        showToastShort(ResourceFinder.getString(R.string.permission_granted));
    }

    @Override
    protected void onPermissionGranted() {
        showToastShort(ResourceFinder.getString(R.string.permission_granted));
    }

    @Override
    protected void onNetworkOn() {

    }

    @Override
    protected void onNetworkOff() {

    }
}
