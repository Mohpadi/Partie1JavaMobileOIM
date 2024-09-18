package com.example.filterlist;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private NumberAdapter adapter;
    private List<Integer> numberList;
    private EditText editTextThreshold;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        editTextThreshold = findViewById(R.id.editTextThreshold);

        numberList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        adapter = new NumberAdapter(numberList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        editTextThreshold.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filterList();
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

    private void filterList() {
        String input = editTextThreshold.getText().toString();
        int threshold = input.isEmpty() ? 0 : Integer.parseInt(input);
        List<Integer> filteredList = numberList.stream()
                .filter(num -> num > threshold)
                .collect(Collectors.toList());
        adapter = new NumberAdapter(filteredList);
        recyclerView.setAdapter(adapter);
    }
}
