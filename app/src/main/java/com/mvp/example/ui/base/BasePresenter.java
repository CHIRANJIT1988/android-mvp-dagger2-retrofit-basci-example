package com.mvp.example.ui.base;

public class BasePresenter<V extends MvpView> implements MvpPresenter<V>
{
    private V mMvpView;

    @Override
    public void attachView(V mvpView)
    {
        this.mMvpView = mvpView;
    }

    @Override
    public void detachView()
    {
        this.mMvpView = null;
    }


    public boolean isViewAttached()
    {
        return mMvpView != null;
    }

    public V getMvpView()
    {
        return mMvpView;
    }

    public void checkViewAttached()
    {
        if (!isViewAttached()) throw new MvpViewNotAttachedException();
    }

    public static class MvpViewNotAttachedException extends RuntimeException
    {
        public MvpViewNotAttachedException()
        {
            super("Please call Presenter.attachView(MvpView) before" +
                    " requesting data to the Presenter");
        }
    }
}