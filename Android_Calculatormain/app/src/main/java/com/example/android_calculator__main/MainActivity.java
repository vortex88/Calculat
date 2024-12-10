package com.example.android_calculator__main;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText number_field_1, number_field_2;
    private Button add_button, subtract_button, multiply_button, share_button, reset_button; // Добавляем кнопку сброса
    private EditText resultDisplayEditText;
    private float currentResult = 0; // Переменная для хранения текущего результата

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Настройка отступов для системных панелей
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Инициализация элементов интерфейса
        number_field_1 = findViewById(R.id.number_field_1);
        number_field_2 = findViewById(R.id.number_field_2);
        add_button = findViewById(R.id.add_button);
        subtract_button = findViewById(R.id.subtract_button);
        multiply_button = findViewById(R.id.multiply_button);
        share_button = findViewById(R.id.share_button);
        reset_button = findViewById(R.id.reset_button); // Инициализация кнопки сброса
        resultDisplayEditText = findViewById(R.id.resultDisplayEditText);

        // Обработка нажатия кнопки Сложение
        add_button.setOnClickListener(v -> {
            try {
                // Получение значений из полей ввода и преобразование их в числа
                float num1 = currentResult == 0 ? Float.parseFloat(number_field_1.getText().toString()) : currentResult;
                float num2 = Float.parseFloat(number_field_2.getText().toString());
                // Вычисление суммы
                currentResult = num1 + num2;
                // Отображение результата в новом EditText
                resultDisplayEditText.setText(String.valueOf(currentResult));
                // Очищаем number_field_1 после выполнения операции
                number_field_1.setText("  ");
            } catch (NumberFormatException e) {
                // Обработка ошибки, если введены некорректные данные
                Toast.makeText(MainActivity.this, "Пожалуйста, введите числа", Toast.LENGTH_SHORT).show();
            }
        });

        // Обработка нажатия кнопки Вычитание
        subtract_button.setOnClickListener(v -> {
            try {
                // Получение значений из полей ввода и преобразование их в числа
                float num1 = currentResult == 0 ? Float.parseFloat(number_field_1.getText().toString()) : currentResult;
                float num2 = Float.parseFloat(number_field_2.getText().toString());
                // Вычисление разности
                currentResult = num1 - num2;
                // Отображение результата в новом EditText
                resultDisplayEditText.setText(String.valueOf(currentResult));
                // Очищаем number_field_1 после выполнения операции
                number_field_1.setText("  ");
            } catch (NumberFormatException e) {
                // Обработка ошибки, если введены некорректные данные
                Toast.makeText(MainActivity.this, "Пожалуйста, введите числа", Toast.LENGTH_SHORT).show();
            }
        });

        // Обработка нажатия кнопки Умножение
        multiply_button.setOnClickListener(v -> {
            try {
                // Получение значений из полей ввода и преобразование их в числа
                float num1 = currentResult == 0 ? Float.parseFloat(number_field_1.getText().toString()) : currentResult;
                float num2 = Float.parseFloat(number_field_2.getText().toString());
                // Вычисление произведения
                currentResult = num1 * num2;
                // Отображение результата в новом EditText
                resultDisplayEditText.setText(String.valueOf(currentResult));
                // Очищаем number_field_1 после выполнения операции
                number_field_1.setText("  ");
            } catch (NumberFormatException e) {
                // Обработка ошибки, если введены некорректные данные
                Toast.makeText(MainActivity.this, "Пожалуйста, введите числа", Toast.LENGTH_SHORT).show();
            }
        });

        // Обработка нажатия кнопки Деление
        share_button.setOnClickListener(v -> {
            try {
                // Получение значений из полей ввода и преобразование их в числа
                float num1 = currentResult == 0 ? Float.parseFloat(number_field_1.getText().toString()) : currentResult;
                float num2 = Float.parseFloat(number_field_2.getText().toString());
                // Проверка деления на ноль
                if (num2 == 0) {
                    Toast.makeText(MainActivity.this, "Деление на ноль невозможно", Toast.LENGTH_SHORT).show();
                } else {
                    // Вычисление частного
                    currentResult = num1 / num2;
                    // Отображение результата в новом EditText
                    resultDisplayEditText.setText(String.valueOf(currentResult));
                    // Очищаем number_field_1 после выполнения операции
                    number_field_1.setText("  ");
                }
            } catch (NumberFormatException e) {
                // Обработка ошибки, если введены некорректные данные
                Toast.makeText(MainActivity.this, "Пожалуйста, введите числа", Toast.LENGTH_SHORT).show();
            }
        });

        // Обработка нажатия кнопки Сброс
        reset_button.setOnClickListener(v -> {
            currentResult = 0; // Сбрасываем текущий результат
            number_field_1.setText("  "); // Очищаем поле ввода 1
            number_field_2.setText("  "); // Очищаем поле ввода 2
            resultDisplayEditText.setText("  "); // Очищаем поле отображения результата
        });
    }
}