package com.example.madt_2023_10_02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity
{

    private EditText edUserInput;

    private TextView tvResult;

    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.edUserInput = findViewById(R.id.edUserInput);
        this.tvResult = findViewById(R.id.tvResult);

        this.spinner = findViewById(R.id.spCountOption);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.selection_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinner.setAdapter(adapter);
    }

    public void btnCountClick(View view)
    {
        String selectedOption = this.spinner.getSelectedItem().toString();
        String selectionChars = getResources().getString(R.string.selection_chars);
        String selectionWords = getResources().getString(R.string.selection_words);
        String userInputText = this.edUserInput.getText().toString();

        if (TextUtils.isEmpty(userInputText))
        {
            Toast.makeText(this, "You did not enter anything", Toast.LENGTH_SHORT).show();
            return;
        }

        if (selectedOption.equals(selectionChars))
        {
            String charsCount = CharsCounter.getCharsCount(userInputText);
            this.tvResult.setText(charsCount);
        }
        else if (selectedOption.equals(selectionWords))
        {
            String wordsCount = WordsCounter.getWordsCount(userInputText);
            this.tvResult.setText(wordsCount);
        }
    }
}