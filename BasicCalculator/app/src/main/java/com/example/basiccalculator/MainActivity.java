public class MainActivity extends AppCompatActivity {

    private EditText editTextNumber1;
    private EditText editTextNumber2;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNumber1 = findViewById(R.id.editTextNumber1);
        editTextNumber2 = findViewById(R.id.editTextNumber2);
        textViewResult = findViewById(R.id.textViewResult);

        findViewById(R.id.buttonAdd).setOnClickListener(v -> calculate(Operation.ADD));
        findViewById(R.id.buttonSubtract).setOnClickListener(v -> calculate(Operation.SUBTRACT));
        findViewById(R.id.buttonMultiply).setOnClickListener(v -> calculate(Operation.MULTIPLY));
        findViewById(R.id.buttonDivide).setOnClickListener(v -> calculate(Operation.DIVIDE));
    }

    private void calculate(Operation operation) {
        double num1 = Double.parseDouble(editTextNumber1.getText().toString());
        double num2 = Double.parseDouble(editTextNumber2.getText().toString());
        double result = 0;
        switch (operation) {
            case ADD:
                result = num1 + num2;
                break;
            case SUBTRACT:
                result = num1 - num2;
                break;
            case MULTIPLY:
                result = num1 * num2;
                break;
            case DIVIDE:
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    textViewResult.setText("Error: Division by zero");
                    return;
                }
                break;
        }
        textViewResult.setText("Result: " + result);
    }

    private enum Operation {
        ADD, SUBTRACT, MULTIPLY, DIVIDE
    }
}
