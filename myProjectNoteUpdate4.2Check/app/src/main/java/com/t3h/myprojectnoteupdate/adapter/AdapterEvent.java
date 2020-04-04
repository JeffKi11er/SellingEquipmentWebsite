package com.t3h.myprojectnoteupdate.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;

//import com.t3h.myprojectnoteupdate.BR;
import com.t3h.myprojectnoteupdate.R;
import com.t3h.myprojectnoteupdate.item.Item;
import com.t3h.myprojectnoteupdate.item.ItemEvent;
import com.t3h.myprojectnoteupdate.utils.AppUtils;
import com.t3h.myprojectnoteupdate.utils.NoteDistinc;

import org.w3c.dom.Text;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdapterEvent extends RecyclerView.Adapter<AdapterEvent.ViewHolder> {
    //private @LayoutRes int resId;
    private static final String TAG = "AdaperEvent";
    private LayoutInflater inflater;
    private List<Item>data;
   // private ListItemListener listener;

    public AdapterEvent(Context context) {
        inflater = LayoutInflater.from(context);
    }

    public AdapterEvent(List<Item> data) {
        this.data = data;
    }

    public void setData(List<Item> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
      View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.new_event_calendar,null);
      ViewHolder viewHolder = new ViewHolder(v);
//       ViewDataBinding binding = DataBindingUtil.inflate(inflater,resId,viewGroup,false);
       return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Item item = getItem(i);//Item t = data.get(i);
        viewHolder.tvDate.setText(AppUtils.getFormattedTimeStringMenu(item.getCreatedAt()));
        viewHolder.tvDescrip.setText(item.getDescription());
        viewHolder.tvTime.setText(item.getCreatedAt().getHours()+":"+item.getCreatedAt().getMinutes());
        viewHolder.tvTitle.setText(item.getTitle());
    }
    @Override
    public int getItemCount() {
        return data==null?0:data.size();
    }
    public Item getItem(int position){
        return data.get(position);
    }
    public void addTask(List<Item>newitems){
        NoteDistinc noteDistinc = new NoteDistinc(data,newitems);
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(noteDistinc);
        data.clear();
        data.addAll(newitems);
        diffResult.dispatchUpdatesTo(this);
    }
    public final class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvTime;
        TextView tvDate;
        TextView tvTitle;
        TextView tvDescrip;
        ImageButton imageButton;
        public ViewHolder(@NonNull View view) {
            super(view);
            tvTime = view.findViewById(R.id.tv_time);
            tvDate= view.findViewById(R.id.tv_date_item);
            tvTitle = view.findViewById(R.id.tv_title);
            tvDescrip = view.findViewById(R.id.tv_address);
            imageButton = view.findViewById(R.id.imgBtPopup);
            imageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    PopupMenu popupMenu = new PopupMenu(v.getContext(),v);
                    popupMenu.getMenuInflater().inflate(R.menu.menu_main,popupMenu.getMenu());
                    Object menuHelper;
                    Class[]argTypes;
                    try{
                        Field fMenuHelper = PopupMenu.class
                                .getDeclaredField("mPopup");
                        fMenuHelper.setAccessible(true);
                        menuHelper = fMenuHelper.get(popupMenu);
                        argTypes = new Class[]{boolean.class};
                        menuHelper.getClass()
                                .getDeclaredMethod("setForceShowIcon",
                                argTypes).invoke(menuHelper,true);
                    }catch (Exception e){
                        Log.w(TAG,"error forcing menu icon",e);
                        popupMenu.show();
                        return;
                    }
                    popupMenu.show();
                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem menuItem) {
                            switch (menuItem.getItemId()){
                                case R.id.menu_delete:
                                    return true;
                                case R.id.menu_pin:
                                    return true;
                                case R.id.menu_share:
                                    return true;
                            }
                            return false;
                        }
                    });
                }
            });
        }
        //public void setBinding(Item item){
       // }
    }
//    public interface ListItemListener{}
}
