package com.example.thitbvsinh.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thitbvsinh.R;
import com.example.thitbvsinh.item.ContactLink;

import java.util.List;

public class AdapterContact extends RecyclerView.Adapter<AdapterContact.ContactHolder> {
    private List<ContactLink>contactLinks;
    private Context context;

    public AdapterContact(List<ContactLink> contactLinks, Context context) {
        this.contactLinks = contactLinks;
        this.context = context;
    }

    @NonNull
    @Override
    public ContactHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        LayoutInflater inflater = LayoutInflater.from(context);
        v = inflater.inflate(R.layout.item_link_contact,parent,false);
        return new ContactHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactHolder holder, int position) {
        holder.linkTitle.setText(contactLinks.get(position).getLinkTitle());
        holder.phoneTitle.setText(contactLinks.get(position).getPhoneTitle());
        holder.mediaTitle.setText(contactLinks.get(position).getMediaTitle());
        holder.websiteTitle.setText(contactLinks.get(position).getWebsiteTitle());
        holder.phone1.setText(contactLinks.get(position).getPhone1());
        holder.phone2.setText(contactLinks.get(position).getPhone2());
        holder.phone3.setText(contactLinks.get(position).getPhone3());
        holder.nameWebsite.setText(contactLinks.get(position).getNameWebsite());
        holder.email.setText(contactLinks.get(position).getEmail());
        holder.contact1.setText(contactLinks.get(position).getContact1());
        holder.contact2.setText(contactLinks.get(position).getContact2());
        holder.contact3.setText(contactLinks.get(position).getContact3());

    }

    @Override
    public int getItemCount() {
        return contactLinks.size();
    }

    public static class ContactHolder extends RecyclerView.ViewHolder{
        private TextView linkTitle;
        private TextView phoneTitle;
        private TextView mediaTitle;
        private TextView websiteTitle;
        private TextView phone1;
        private TextView phone2;
        private TextView phone3;
        private TextView nameWebsite;
        private TextView contact1;
        private TextView contact2;
        private TextView contact3;
        private TextView email;
        public ContactHolder(@NonNull View itemView) {
            super(itemView);
            linkTitle =itemView.findViewById(R.id.title_link);
            phoneTitle =itemView.findViewById(R.id.tv_phone_title);
            mediaTitle =itemView.findViewById(R.id.tv_media);
            websiteTitle =itemView.findViewById(R.id.tv_website_title);
            phone1 =itemView.findViewById(R.id.tv_number);
            phone2 =itemView.findViewById(R.id.tv_number2);
            phone3 =itemView.findViewById(R.id.tv_phone3);
            nameWebsite =itemView.findViewById(R.id.tv_name_website);
            email = itemView.findViewById(R.id.tv_email3);
            contact1 =itemView.findViewById(R.id.contact1);
            contact2 =itemView.findViewById(R.id.tv_contact2);
            contact3 =itemView.findViewById(R.id.tv_contact3);
        }
    }
}
