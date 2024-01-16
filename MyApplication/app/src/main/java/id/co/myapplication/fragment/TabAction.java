package id.co.myapplication.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import id.co.myapplication.R;

public class TabAction extends Fragment {

    private ImageView tabActionImageView;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public TabAction() {
        // Required empty public constructor
    }

    public static TabAction newInstance(String param1, String param2) {
        TabAction fragment = new TabAction();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_sci_fi, container, false);

        tabActionImageView = view.findViewById(R.id.imageView);

        tabActionImageView.setOnClickListener(v -> playVideo("trailer"));

        return view;
    }

    private void playVideo(String videoFileName) {
        String videoPath = "android.resource://" + requireActivity().getPackageName() + "/raw/" + videoFileName;
        Uri videoUri = Uri.parse(videoPath);

        Intent intent = new Intent(requireContext(), VideoActivity.class);
        intent.putExtra("VIDEO_URI", videoUri.toString());
        startActivity(intent);
    }
}
