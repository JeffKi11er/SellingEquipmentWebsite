package com.example.thitbvsinh.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thitbvsinh.R;
import com.example.thitbvsinh.adapter.AdapterContact;
import com.example.thitbvsinh.item.ContactLink;

import java.util.ArrayList;
import java.util.List;

public class FragmentContact extends Fragment {
    private TextView tvName;
    private TextView tvAddress;
    private TextView tvPhone;
    private TextView tvDetail;
    private TextView tvEmail;
    private EditText edtName;
    private EditText edtAddress;
    private EditText edtPhone;
    private EditText edtDetail;
    private EditText edtEmail;
    private Button btnSend;
    private RecyclerView rclContactDetail;
    private List<ContactLink>contactLinks;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragmet_contact,container,false);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tvName = (TextView)getActivity().findViewById(R.id.tv_person_name);
        tvAddress = (TextView)getActivity().findViewById(R.id.tv_address);
        tvDetail = (TextView)getActivity().findViewById(R.id.tv_detail);
        tvPhone = (TextView)getActivity().findViewById(R.id.tv_phone);
        tvDetail = (TextView)getActivity().findViewById(R.id.tv_detail);
        edtName = (EditText)getActivity().findViewById(R.id.edt_person_name);
        edtAddress = (EditText)getActivity().findViewById(R.id.edt_address);
        edtEmail = (EditText)getActivity().findViewById(R.id.edt_email);
        edtPhone = (EditText)getActivity().findViewById(R.id.edt_phone);
        edtDetail = (EditText)getActivity().findViewById(R.id.edt_detail);
        btnSend = (Button)getActivity().findViewById(R.id.btn_gui);
        rclContactDetail = (RecyclerView)getActivity().findViewById(R.id.rcl_link_contact);
        contactLinks = new ArrayList<>();
        contactLinks.add(new ContactLink("Showroom thiết bị vệ sinh - bình nóng lạnh",
                "Điện thoại : ","Zalo, Viber, Hotline :","Website : ","024 3634 1004",
                "- 0987 730 976 - 0976 336 783","0972 120 281","thietbivesinhvn.com.vn",
                "Email : hoangmai.eco@gmail.com","Tư vấn 1 : 0981 067 466","Tư vấn 2 : 0983 055 605",
                "Tư vấn 3 : 0904 624 766"
                ));
        contactLinks.add(new ContactLink("Showroom thiết bị vệ sinh - bình nóng lạnh",
                "Điện thoại : ","Zalo, Viber, Hotline :","Website : ","024 3634 1004",
                "- 0987 730 976 - 0976 336 783","0972 120 281","thietbivesinhvn.com.vn",
                "Email : hoangmai.eco@gmail.com","Tư vấn 1 : 0981 067 466","Tư vấn 2 : 0983 055 605",
                "Tư vấn 3 : 0904 624 766"
        ));
        contactLinks.add(new ContactLink("Showroom thiết bị vệ sinh - bình nóng lạnh",
                "Điện thoại : ","Zalo, Viber, Hotline :","Website : ","024 3634 1004",
                "- 0987 730 976 - 0976 336 783","0972 120 281","thietbivesinhvn.com.vn",
                "Email : hoangmai.eco@gmail.com","Tư vấn 1 : 0981 067 466","Tư vấn 2 : 0983 055 605",
                "Tư vấn 3 : 0904 624 766"
        ));
        contactLinks.add(new ContactLink("Showroom thiết bị vệ sinh - bình nóng lạnh",
                "Điện thoại : ","Zalo, Viber, Hotline :","Website : ","024 3634 1004",
                "- 0987 730 976 - 0976 336 783","0972 120 281","thietbivesinhvn.com.vn",
                "Email : hoangmai.eco@gmail.com","Tư vấn 1 : 0981 067 466","Tư vấn 2 : 0983 055 605",
                "Tư vấn 3 : 0904 624 766"
        ));
        AdapterContact contact = new AdapterContact(contactLinks,getContext());
        rclContactDetail.setAdapter(contact);
    }
}
