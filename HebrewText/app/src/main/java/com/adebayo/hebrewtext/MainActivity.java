package com.adebayo.hebrewtext;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.kosherjava.zmanim.hebrewcalendar.HebrewDateFormatter;
import com.kosherjava.zmanim.hebrewcalendar.JewishCalendar;
import com.kosherjava.zmanim.hebrewcalendar.JewishDate;

import net.time4j.calendar.HebrewCalendar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private final Map<String, List<String>> comments = new HashMap<>();
    private final Map<String, String> resources = new HashMap<>();

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        JewishCalendar jd = new JewishCalendar();
//        HebrewDateFormatter hdf = new HebrewDateFormatter();
//        jd.setJewishDate(5781, JewishDate.NISSAN, 12);
//        System.out.println(jd.isTaanisBechoros());
//
//        HebrewCalendar hebcal = HebrewCalendar.nowInSystemTime();
//        int weekOfYear = hebcal.getInt(HebrewCalendar.DAY_OF_MONTH);
String[] day1 = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};




//        Typeface typeface = getResources().getFont(R.font.FrankRuehlCLM_Bold);
//        textView.setTypeface(typeface);
        cacheResources();

        List<String> temp = getMergedVerses("hebrew.json"),  mergedVerses = new ArrayList<>();
        if(temp != null && temp.size() > 0){
            mergedVerses.addAll(temp);
        }

        //DISPLAYING MERGED VERSES
        ((ListView) findViewById(R.id.hebrew1List)).setAdapter(
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mergedVerses)
        );
        Intent mIntent = getIntent();
        int value = mIntent.getIntExtra("DAY", 0);

        switch (value) {

            case 1 :
                ((ListView) findViewById(R.id.hebrew1List)).setSelection(1);
                break;
            case 2 :
                ((ListView) findViewById(R.id.hebrew1List)).setSelection(10);
                break;
            case 3 :
                ((ListView) findViewById(R.id.hebrew1List)).setSelection(18);
                break;
            case 4 :
                ((ListView) findViewById(R.id.hebrew1List)).setSelection(23);
                break;
            case 5 :
                ((ListView) findViewById(R.id.hebrew1List)).setSelection(29);
                break;
            case 6 :
                ((ListView) findViewById(R.id.hebrew1List)).setSelection(35);
                break;
            case 7 :
                ((ListView) findViewById(R.id.hebrew1List)).setSelection(39);
                break;
            case 8 :
                ((ListView) findViewById(R.id.hebrew1List)).setSelection(44);
                break;
            case 9 :
                ((ListView) findViewById(R.id.hebrew1List)).setSelection(49);
                break;
            case 10 :
                ((ListView) findViewById(R.id.hebrew1List)).setSelection(55);
                break;
            case 11 :
                ((ListView) findViewById(R.id.hebrew1List)).setSelection(60);
                break;
            case 12 :
                ((ListView) findViewById(R.id.hebrew1List)).setSelection(66);
                break;
            case 13 :
                ((ListView) findViewById(R.id.hebrew1List)).setSelection(69);
                break;
            case 14 :
                ((ListView) findViewById(R.id.hebrew1List)).setSelection(72);
                break;
            case 15 :
                ((ListView) findViewById(R.id.hebrew1List)).setSelection(77);
                break;
            case 16 :
                ((ListView) findViewById(R.id.hebrew1List)).setSelection(79);
                break;
            case 17 :
                ((ListView) findViewById(R.id.hebrew1List)).setSelection(83);
                break;
            case 18 :
                ((ListView) findViewById(R.id.hebrew1List)).setSelection(88);
                break;
            case 19 :
                ((ListView) findViewById(R.id.hebrew1List)).setSelection(90);
                break;
            case 20 :
                ((ListView) findViewById(R.id.hebrew1List)).setSelection(97);
                break;
            case 21 :
                ((ListView) findViewById(R.id.hebrew1List)).setSelection(104);
                break;
            case 22 :
                ((ListView) findViewById(R.id.hebrew1List)).setSelection(106);
                break;
            case 23 :
                ((ListView) findViewById(R.id.hebrew1List)).setSelection(108);
                break;
            case 24 :
                ((ListView) findViewById(R.id.hebrew1List)).setSelection(113);
                break;
            case 25 :
                ((ListView) findViewById(R.id.hebrew1List)).setSelection(119);
                break;
            case 26 :
                ((ListView) findViewById(R.id.hebrew1List)).setSelection(119);
                break;
            case 27 :
                ((ListView) findViewById(R.id.hebrew1List)).setSelection(120);
                break;
            case 28 :
                ((ListView) findViewById(R.id.hebrew1List)).setSelection(135);
                break;
            case 29 :
                ((ListView) findViewById(R.id.hebrew1List)).setSelection(140);
                break;
            case 30 :
                ((ListView) findViewById(R.id.hebrew1List)).setSelection(145);
                break;



            default:
                ((ListView) findViewById(R.id.hebrew1List)).setSelection(1);

                break;
        }





//        try{
//            int i = Integer.parseInt(mergedVerses.get(value));
//            ((ListView) findViewById(R.id.hebrew1List)).smoothScrollToPosition(100);
//        } catch(NumberFormatException ex){ // handle your exception
//
//            Log.e(
//                    "response error ",
//                    "response error " + "   "  + " " + ex
//            );
//        }


    }

    public String getContents(String fileName){
        if(fileName != null && !fileName.isEmpty()){
            try {
                InputStream is = this.getAssets().open(fileName);
                int size = is.available();
                byte[] buffer = new byte[size];

                is.read(buffer);
                is.close();

                return new String(buffer, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void cacheResources(){
        String hebrew = getContents("hebrew.json");
        if(hebrew != null && !hebrew.isEmpty()){
            resources.put("hebrew.json", hebrew);
        }

        String hebrew2 = getContents("hebrew2.json");
        if(hebrew2 != null && !hebrew2.isEmpty()){
            resources.put("hebrew2.json", hebrew2);
            cacheComments("hebrew2.json");
        }

        String hebrew3 = getContents("hebrew3.json");
        if(hebrew3 != null && !hebrew3.isEmpty()){
            resources.put("hebrew3.json", hebrew3);
            cacheComments("hebrew3.json");
        }

        String hebrew4 = getContents("hebrew4.json");
        if(hebrew4 != null && !hebrew4.isEmpty()){
            resources.put("hebrew4.json", hebrew4);
            cacheComments("hebrew4.json");
        }
    }

    public List<String> getMergedVerses(String fileName) {
        List<String> verses = new ArrayList<>();

        if (fileName != null && !fileName.isEmpty() && resources != null && resources.containsKey(fileName)) {
            try {
                String contentString = resources.get(fileName);

                if (contentString != null && !contentString.isEmpty()) {
                    JSONArray chaptersJSON = new JSONObject(contentString).getJSONArray("text");

                    if(chaptersJSON.length() > 0){
                        for (int i = 0; i < chaptersJSON.length(); i++){
                            JSONArray versesJSON = chaptersJSON.getJSONArray(i);

                            if(versesJSON.length() > 0){
                                for(int j = 0; j < versesJSON.length(); j++){
                                    verses.add(versesJSON.getString(j));

                                    if(resources.size() > 1){
                                        for (int k = 1; k < resources.size(); k++){
                                            List<String> temp = getComments(fileName.replace(".", k + "."), i, j);

                                            if(temp != null && temp.size() > 0){

                                                verses.addAll(temp);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return verses;
    }

    public void cacheComments(String fileName) {
        if (fileName != null && !fileName.isEmpty()) {
            try {
                String contentString = getContents(fileName);

                if (!contentString.isEmpty()) {
                    JSONArray chaptersJSON = new JSONObject(contentString).getJSONArray("text");

                    if(chaptersJSON.length() > 0){
                        for (int i = 0; i < chaptersJSON.length(); i++){
                            JSONArray versesJSON = chaptersJSON.getJSONArray(i);

                            if(versesJSON.length() > 0) {
                                for(int j = 0; j < versesJSON.length(); j++){
                                    JSONArray commentsJSON = versesJSON.getJSONArray(j);

                                    if(commentsJSON.length() > 0){
                                        List<String> temp = new ArrayList<>();

                                        for(int k = 0; k < commentsJSON.length(); k++){
                                            temp.add(commentsJSON.getString(k));
                                        }

                                        if(!temp.isEmpty()){
                                            comments.put("f" + fileName + "c" + i + "v" + j, temp);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public List<String> getComments(String fileName, int chapter, int verse) {
        return comments.containsKey("f" + fileName + "c" + chapter + "v" + verse) ? comments.get("f" + fileName + "c" + chapter + "v" + verse) : null;
    }
}
//file 1 chapter 1 line 1
//        file 2 chapter 1 line 1 records 1,2,3
//        file 3 chapter 1 line 1 records 1,2,3,4+
//        file 4 chapter 1 line 1 records 1,2,3+
//
//        file 1 chapter 2 line 1
//        file 2 chapter 2 line 2 records 1,2,3+
//        file 3 chapter 2 line 3 records 1,2,3,4+
//        file 4 chapter 2 line 4 records 1,2,3+
//        meaning - merge each line from all 4 files