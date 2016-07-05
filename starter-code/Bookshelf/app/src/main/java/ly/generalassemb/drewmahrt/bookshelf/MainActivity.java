package ly.generalassemb.drewmahrt.bookshelf;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    BaseAdapter mBookAdapter;
    ListView mListView;
    List<Book> mBookList = new ArrayList<>();

    //TODO: Define your ListView (Done)

    //TODO: Define your Book List (Done)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.listview);

        //Use helper method to add books to the list (Done)
        mBookList = generateBooks();

        //TODO: Instantiate BaseAdapter
        //Below is a partially complete example for one Adapter
        mBookAdapter = new BaseAdapter() {


            @Override
            public int getCount() {
                return mBookList.size();
            }

            @Override
            public Object getItem(int position) {
                return mBookList.get(position);
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View vInflate = convertView;
                if (vInflate == null) {
                    LayoutInflater inflater = (LayoutInflater) MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    vInflate = inflater.inflate(android.R.layout.simple_list_item_1, null);
                    //TODO: Update the view (Done)
                }
                final TextView mTextView = (TextView) vInflate.findViewById(android.R.id.text1);
                final TextView mTextView2 = (TextView) vInflate.findViewById(android.R.id.text2);
                mTextView.setText("Title: " + mBookList.get(position).getTitle());
                mTextView2.setText("Author: " + mBookList.get(position).getAuthor());

                return vInflate;
            }

        };


        //TODO: Set the ListView's adapter

        mListView.setAdapter(mBookAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView mTextView = (TextView) view.findViewById(android.R.id.text1);
                mTextView.setTextColor(Color.RED);
                TextView mTextView2 = (TextView) view.findViewById(android.R.id.text2);
                mTextView2.setTextColor(Color.RED);
                mBookAdapter.notifyDataSetChanged();
            }
        });


    };

    //Method to generate a list of Books
    private List<Book> generateBooks(){
        List<Book> books = new ArrayList<>();

        books.add(new Book("Apples Book","Brad"));
        books.add(new Book("Cats Book","Ryan"));
        books.add(new Book("Eagles Book","Kate"));
        books.add(new Book("Strawberries Cathy","Brad"));
        books.add(new Book("Dogs Book","Tom"));
        books.add(new Book("Ants Book","Zane"));

        return books;
    }
}
