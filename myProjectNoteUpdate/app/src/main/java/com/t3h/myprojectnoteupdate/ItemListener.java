package com.t3h.myprojectnoteupdate;

import com.t3h.myprojectnoteupdate.adapter.EventAdapter;

public interface ItemListener<T extends EventModel>extends EventAdapter.ListItemListener
{
    void onItemClick(T t);
}
