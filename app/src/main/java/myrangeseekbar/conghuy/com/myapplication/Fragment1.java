package myrangeseekbar.conghuy.com.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragment1 extends Fragment {
    String TAG = "Fragment1";
//    addFragment(getSupportFragmentManager(), "", R.id.container, new Fragment1());
//    addFragment(getSupportFragmentManager(), "Fragment2", R.id.container, new Fragment2());
    public static void addFragment(FragmentManager fragmentManager,
                                   String addToBackStack,
                                   int resId,
                                   android.support.v4.app.Fragment fragment) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (addToBackStack != null && addToBackStack.trim().length() > 0)
            transaction.addToBackStack(addToBackStack);
        transaction.replace(resId, fragment);
        transaction.commit();
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(TAG, "onAttach");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView");
        View view = inflater.inflate(R.layout.fragment_child, container, false);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }
}
