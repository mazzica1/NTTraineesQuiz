package nt_me.nttraineesquiz;

import android.app.Activity;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import nt_me.nttraineesquiz.dummy.DummyContent;

/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a {@link ItemListActivity}
 * in two-pane mode (on tablets) or a {@link ItemDetailActivity}
 * on handsets.
 */
public class ItemDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public ListView list;
    ArrayList<Comment> comments;
    ArrayList<String> details;
     ArrayAdapter<String> commentAdapter;

    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private DummyContent.DummyItem mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ItemDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = DummyContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));
            details = new ArrayList<String>();
            commentAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,details);

            Activity activity = this.getActivity();
            comments =mItem.getComments();
            addComment(new Comment("Amin","not good","15/3"));
            addComment(new Comment("mahmoud","good","15/8"));
            addComment(new Comment("mohamed","excellent","20/4"));


            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mItem.content);
            }

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_detail, container, false);
        list =(ListView)rootView.findViewById(R.id.comment_list);

        // Show the dummy content as text in a TextView.
        if (mItem != null) {
            ((TextView) rootView.findViewById(R.id.item_detail)).setText(mItem.details);

            for(int i=0;i<comments.size();i++){
                Comment c=comments.get(i);
                String s= parseComment(c);
                details.add(s);
            }

            list.setAdapter(commentAdapter);

        }

        return rootView;
    }
    public void addComment(Comment c){
        mItem.addComment(c);
        String s= parseComment(c);
        details.add(s);
        commentAdapter.notifyDataSetChanged();
    }
    private String parseComment(Comment c){
        return  "Name: "+c.getName()+", Comment: "+c.getComment()+", Date: "+c.getDate();
    }
}
