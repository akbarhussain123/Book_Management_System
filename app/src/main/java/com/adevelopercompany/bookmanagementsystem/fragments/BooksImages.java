package com.adevelopercompany.bookmanagementsystem.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.adevelopercompany.bookmanagementsystem.R;
import com.adevelopercompany.bookmanagementsystem.adapters.AdapterBookImages;
import com.adevelopercompany.bookmanagementsystem.adapters.AdapterGnBookImages;
import com.adevelopercompany.bookmanagementsystem.entities.EntityGnImages;
import com.adevelopercompany.bookmanagementsystem.entities.EntityImages;
import com.adevelopercompany.bookmanagementsystem.viewModels.ViewModelBookImages;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class BooksImages extends Fragment {
    RecyclerView recyclerView;
    AdapterBookImages adapter;
    AdapterGnBookImages adapter1;
    ViewModelBookImages viewModelBookImages;
    android.app.AlertDialog dialog;
    TextToSpeech t1;
    Toolbar toolbar;

    @Override
    public void onResume() {
        super.onResume();
        assert getArguments() != null;
        String name = (String) getArguments().get("name");
        viewModelBookImages.getAllData(name);
    }

    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModelBookImages = new ViewModelProvider(this).get(ViewModelBookImages.class);
        setHasOptionsMenu(true);

        assert getArguments() != null;
        String name = (String) getArguments().get("name");
        viewModelBookImages.getAllData(name);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_books_images, null, false);
        toolbar = view.findViewById(R.id.myToolbar);
        toolbar.inflateMenu(R.menu.search_menu);
        toolbar.setOnMenuItemClickListener(this::onOptionsItemSelected);
        return view;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull @NotNull MenuItem item) {
        if (item.getItemId() == R.id.search) {
            opnSearchDialogBox();
            return true;
        }
        return super.onOptionsItemSelected(item);


    }


    private void opnSearchDialogBox() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View dialogView = LayoutInflater.from(getContext()).inflate(R.layout.add_search, null, false);
        Button btnCancel = dialogView.findViewById(R.id.btnCancel);

        ImageView ivPronounce = dialogView.findViewById(R.id.ivPronounce);
        EditText etSearch = dialogView.findViewById(R.id.etSearech);
        builder.setView(dialogView);
        AlertDialog alertDialog = builder.create();

        ivPronounce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                t1 = new TextToSpeech(getContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        if (status != TextToSpeech.ERROR) {
                            t1.setLanguage(Locale.UK);
                        }
                    }
                });

                ivPronounce.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String text = etSearch.getText().toString();
                        t1.speak(text, TextToSpeech.QUEUE_FLUSH, null);
                    }
                });


            }

        });
        btnCancel.setOnClickListener(v -> alertDialog.dismiss());
        alertDialog.show();
    }


    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setProgressDialog();
        viewModelBookImages = new ViewModelProvider(this).get(ViewModelBookImages.class);
        List<EntityImages> list = new ArrayList<>();
        List<EntityGnImages> gnImagesList = new ArrayList<>();
        assert getArguments() != null;
        String name = (String) getArguments().get("name");
        if (name.equals("english")) {
            toolbar.setTitle("English");
        } else if (name.equals("gn")) {
            toolbar.setTitle("General Knowledge");
        }
        viewModelBookImages.getAllData(name);
        RecyclerView recyclerView = view.findViewById(R.id.rv);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        if (name.equals("english")) {
            adapter = new AdapterBookImages(getContext(), list, viewModelBookImages);
            recyclerView.setAdapter(adapter);

        } else if (name.equals("gn")) {
            adapter1 = new AdapterGnBookImages(getContext(), gnImagesList, viewModelBookImages);
            recyclerView.setAdapter(adapter1);
        }

        viewModelBookImages.imgList.observe(getViewLifecycleOwner(), new Observer<List<EntityImages>>() {
            @Override
            public void onChanged(List<EntityImages> entityImages) {
                adapter.refreshAdapter(entityImages);
                dialog.dismiss();
                Log.d("d", "Data size = " + entityImages.size());
            }
        });
        viewModelBookImages.gnImageList.observe(getViewLifecycleOwner(), new Observer<List<EntityGnImages>>() {
            @Override
            public void onChanged(List<EntityGnImages> entityImages) {
                adapter1.refreshAdapter(entityImages);
                dialog.dismiss();
                Log.d("d", "Data size = " + entityImages.size());
            }
        });


    }

    public void setProgressDialog() {

        int llPadding = 30;
        LinearLayout ll = new LinearLayout(getActivity());
        ll.setOrientation(LinearLayout.HORIZONTAL);
        ll.setPadding(llPadding, llPadding, llPadding, llPadding);
        ll.setGravity(Gravity.CENTER);
        LinearLayout.LayoutParams llParam = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        llParam.gravity = Gravity.CENTER;
        ll.setLayoutParams(llParam);

        ProgressBar progressBar = new ProgressBar(getActivity());
        progressBar.setIndeterminate(true);
        progressBar.setPadding(0, 0, llPadding, 0);
        progressBar.setLayoutParams(llParam);

        llParam = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        llParam.gravity = Gravity.CENTER;
        TextView tvText = new TextView(getActivity());
        tvText.setText("Loading ...");
        tvText.setTextColor(Color.parseColor("#000000"));
        tvText.setTextSize(15);
        tvText.setLayoutParams(llParam);

        ll.addView(progressBar);
        ll.addView(tvText);

        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getActivity());
        builder.setCancelable(true);
        builder.setView(ll);

        dialog = builder.create();
        dialog.show();
        Window window = dialog.getWindow();
        if (window != null) {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.copyFrom(dialog.getWindow().getAttributes());
            layoutParams.width = LinearLayout.LayoutParams.WRAP_CONTENT;
            layoutParams.height = LinearLayout.LayoutParams.WRAP_CONTENT;
            dialog.getWindow().setAttributes(layoutParams);
        }
    }
}