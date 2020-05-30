package com.library.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.library.rest.api.vo.book.BookVo;
import com.library.ui.R;

import org.jetbrains.annotations.NotNull;

public class BookAdapter extends ListAdapter<BookVo, BookAdapter.BookVoHolder> {
    private OnItemClickListener listener;

    public BookAdapter() {
        super(new DiffUtil.ItemCallback<BookVo>() {
            @Override
            public boolean areItemsTheSame(@NotNull BookVo oldItem, @NotNull BookVo newItem) {
                return oldItem.getId().equals(newItem.getId());
            }

            @Override
            public boolean areContentsTheSame(@NotNull BookVo oldItem, @NotNull BookVo newItem) {
                return oldItem.getId().equals(newItem.getId()) &&
                        oldItem.getTitle().equals(newItem.getTitle()) &&
                        oldItem.getAuthor().getName().equals(newItem.getAuthor().getName());
            }
        });
    }

    @NonNull
    @Override
    public BookVoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_book_item, parent, false);
        return new BookVoHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull BookVoHolder holder, int position) {
        BookVo current = getBookVoAt(position);
        holder.title.setText(current.getTitle());
        holder.authorName.setText(current.getAuthor().getName());
    }


    public BookVo getBookVoAt(int position) {
        return getItem(position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(BookVo user);
    }

    class BookVoHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView authorName;


        public BookVoHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title_view);
            authorName = itemView.findViewById(R.id.authorName_view);

            itemView.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if (listener != null && position != RecyclerView.NO_POSITION) {
                    listener.onItemClick(getBookVoAt(position));
                }
            });
        }
    }
}
