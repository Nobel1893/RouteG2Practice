package nobel.com.route2.Calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import nobel.com.route2.R;

public class calculator extends AppCompatActivity {

    TextView expression,result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        expression=findViewById(R.id.expression);
        result=findViewById(R.id.result);
    }

    public void calculate(View view) {
        String expressionString=this.expression.getText().toString();
        String input=((TextView)view).getText().toString();
        switch (input)
        {
            case "=" :
                Calculate(expressionString);
                break;
            case "del":
                if(expressionString.length()>0)
                    expressionString=expressionString.substring(0,expressionString.length()-1);
                expression.setText(expressionString);
                break;
            case "c":
                expression.setText("");
                break;
            default:
                    expressionString=expressionString.concat(input);
                    expression.setText(expressionString);
                    break;

        }

    }


    void Calculate(String Expression) {

        String lhs = "", rhs = "";
        char operator = ' ';
        for (int i = 0; i < Expression.length(); i++) {
            char c = Expression.charAt(i);
            if (c >= '0' && c <= '9')
                if (operator == ' ')
                    lhs = lhs + c;
                else rhs = rhs + c;

            else operator = c;
        }

        try {
            double n1 = Double.valueOf(lhs);
            double n2 = Double.valueOf(rhs);

            double res = 0.0d;
            switch (operator) {
                case '+': {
                    res = n1 + n2;
                    result.setText(res + "");
                    expression.setText("");
                    break;
                }
                case '-': {
                    res = n1 - n2;
                    result.setText(res + "");
                    expression.setText("");
                    break;
                }
                case '*': {
                    res = n1 * n2;
                    result.setText(res + "");
                    expression.setText("");
                    break;
                }
                case '/': {
                    res = n1 / n2;
                    result.setText(res + "");
                    expression.setText("");
                    break;
                }
                default: {
                    result.setText("no operation found");
                    return;
                }

            }

            }catch(NumberFormatException e){
                result.setText("error in format");
            }catch (Exception e){
            result.setText("error");

        }

        }
    }