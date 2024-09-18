public class MainActivity extends AppCompatActivity {

    private EditText name, email;
    private TextView message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        message = findViewById(R.id.message);

        findViewById(R.id.submit).setOnClickListener(v -> validateForm());
    }

    private void validateForm() {
        String nameStr = name.getText().toString();
        String emailStr = email.getText().toString();

        if (nameStr.isEmpty() || emailStr.isEmpty()) {
            message.setText("Veuillez remplir tous les champs");
            return;
        }

        if (isValidEmail(emailStr)) {
            message.setText("Formulaire soumis avec succès");
        } else {
            message.setText("Email invalide");
        }
    }

    private boolean isValidEmail(String email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}
