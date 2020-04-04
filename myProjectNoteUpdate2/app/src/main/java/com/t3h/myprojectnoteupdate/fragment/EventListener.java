package com.t3h.myprojectnoteupdate.fragment;

import com.t3h.myprojectnoteupdate.adapter.AdapterEvent;
import com.t3h.myprojectnoteupdate.item.ItemEvent;

public interface EventListener<T extends ItemEvent>{//extends AdapterEvent.ListItemListener {
    void OnItemClick(T t);
}
