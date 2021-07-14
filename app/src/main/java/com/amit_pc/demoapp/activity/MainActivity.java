package com.amit_pc.demoapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.amit_pc.demoapp.Adapter.ConceptListAdapter;
import com.amit_pc.demoapp.R;
import com.amit_pc.demoapp.interfaces.ConceptClickListener;
import com.amit_pc.demoapp.models.ConceptModel;
import com.amit_pc.demoapp.utils.Constants;
import com.amit_pc.demoapp.utils.StringPermutations;
import com.amit_pc.demoapp.utils.Utils;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener, ConceptClickListener {

    private EditText editText;
    private Button submitButton;
    private RecyclerView rvConcepts;
    private ConceptListAdapter conceptListAdapter;
    private ArrayList<ConceptModel> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.edit_text);
        submitButton = (Button) findViewById(R.id.submit_btn);
        rvConcepts = (RecyclerView) findViewById(R.id.rv_concepts);
        submitButton.setOnClickListener(this);

        setArrayList();
        setAdapter();
//        C c = new C();
//        c.running();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.submit_btn) {
            loadPattern1();
            Utils.showToast(MainActivity.this, "Now Check Your Console", Toast.LENGTH_SHORT);
            editText.setVisibility(View.GONE);
            submitButton.setVisibility(View.GONE);
        }
    }

    public void setAdapter() {
        conceptListAdapter = new ConceptListAdapter(MainActivity.this, arrayList);
        rvConcepts.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        rvConcepts.setAdapter(conceptListAdapter);
    }

    public void setArrayList() {
        arrayList = new ArrayList<>();
        arrayList.add(new ConceptModel(Constants.CONCEPT_NAME.BOUNDED_SERVICE));
        arrayList.add(new ConceptModel(Constants.CONCEPT_NAME.FOREGROUND_SERVICE));
        arrayList.add(new ConceptModel(Constants.CONCEPT_NAME.PLAY_MUSIC_USING_SERVICE));
        arrayList.add(new ConceptModel(Constants.CONCEPT_NAME.INTENT_SERVICE));
        arrayList.add(new ConceptModel(Constants.CONCEPT_NAME.STRING_PERMUTATION));
        arrayList.add(new ConceptModel(Constants.CONCEPT_NAME.LOAD_PATTERN));
        arrayList.add(new ConceptModel(Constants.CONCEPT_NAME.LAUNCH_MODES));
    }

    @Override
    public void onConceptClick(ConceptModel conceptModel) {
        switch (conceptModel.getConceptName()) {
            case Constants.CONCEPT_NAME.BOUNDED_SERVICE:
                startActivity(new Intent(MainActivity.this, BoundedServiceExampleActivity.class));
                break;
            case Constants.CONCEPT_NAME.FOREGROUND_SERVICE:
                startActivity(new Intent(MainActivity.this, ForegroundServiceExampleActvity.class));
                break;
            case Constants.CONCEPT_NAME.PLAY_MUSIC_USING_SERVICE:
                startActivity(new Intent(MainActivity.this, PlayMusicActivity.class));
                break;
            case Constants.CONCEPT_NAME.INTENT_SERVICE:
                break;
            case Constants.CONCEPT_NAME.STRING_PERMUTATION:
                StringPermutations.permutation("123");
                Utils.showToast(MainActivity.this, "Check Your Console", Toast.LENGTH_SHORT);
                break;
            case Constants.CONCEPT_NAME.LOAD_PATTERN:
                editText.setVisibility(View.VISIBLE);
                submitButton.setVisibility(View.VISIBLE);
                Utils.showToast(MainActivity.this, "Enter some number in edit text", Toast.LENGTH_SHORT);
                break;
            case Constants.CONCEPT_NAME.LAUNCH_MODES:
                startActivity(new Intent(MainActivity.this, LaunchModesExampleActivity.class));
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + conceptModel.getConceptName());
        }
    }

    private void loadPattern1() {
//        this type of pattern is loaded.
//         ***********
//          *********
//           *******
//            *****
//             ***
//              *

        int n = Integer.parseInt(editText.getText().toString());
        int N = 2 * n;
        for (int i = 0; i <= n; i++) {
            int k;
            for (k = 0; k < i; k++) {
                System.out.print(" ");
            }
            for (int j = k; j <= (N - i); j++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }

    /*interface InterfaceExample{
        void firstOverride();
        void secondOverride();
    }
    class A {
        public void fun(String str){
            System.out.println("A has "+str);
        }
        public void fun(String str,int i){
            System.out.println("A has "+str+" int "+i);
        }
    }

    class B extends A{
        public void fun(String str){
            System.out.println("B Fun"+ str);
        }
        public void fun(String str,int i){
            System.out.println("B has"+str+" int "+i);
        }
    }

    class C{
        public void running() {
            B b = new B();
            b.fun("Fun B");
            b.fun("Fun B",1);

//            B b1 = (B) new A();       //Here ClassCastException is appeared at runtime. At compile time we were not able to find out the error.
//            b1.fun("Fun A");
//            b1.fun("Fun A",2);

            A a = new B();
            a.fun("Fun B");
            a.fun("Fun B",3);

            InterfaceExample in = new InterfaceExample() {
                @Override
                public void firstOverride() {

                }

                @Override
                public void secondOverride() {

                }
            };
        }
    }*/

}
