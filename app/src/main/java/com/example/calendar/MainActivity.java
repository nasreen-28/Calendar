package com.example.calendar;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.Button;
import android.widget.Spinner;
import java.util.ArrayList;

import static com.example.calendar.R.layout.popup;

public class MainActivity extends AppCompatActivity {
    CalendarView calender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calender = (CalendarView)findViewById(R.id.calender);
        final Button button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(popup);
                final String[] select= {
                        "", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" ,"Sunday"};
                Spinner spinner = (Spinner) findViewById(R.id.static_spinner);

                ArrayList<StateVO> listVOs = new ArrayList<>();

                for (int i = 0; i < select.length; i++) {
                    StateVO stateVO = new StateVO();
                    stateVO.setTitle(select[i]);
                    stateVO.setSelected(false);
                    listVOs.add(stateVO);
                }
                MyAdapter myAdapter = new MyAdapter(MainActivity.this, 0,listVOs);
                spinner.setAdapter(myAdapter);
            }
        });
    }
    public class StateVO {
        private String title;
        private boolean selected;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }
    }

}
