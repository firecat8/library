package com.library.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.library.rest.api.vo.book.BookRentalVo;
import com.library.ui.R;
import com.library.ui.Utils;

import org.jetbrains.annotations.NotNull;

public class BookRentalAdapter extends ListAdapter<BookRentalVo, BookRentalAdapter.BookRentalVoHolder> {
    private BookRentalAdapter.OnItemClickListener listener;

    public BookRentalAdapter() {
        super(new DiffUtil.ItemCallback<BookRentalVo>() {
            @Override
            public boolean areItemsTheSame(@NotNull BookRentalVo oldItem, @NotNull BookRentalVo newItem) {
                return oldItem.getId().equals(newItem.getId());
            }

            @Override
            public boolean areContentsTheSame(@NotNull BookRentalVo oldItem, @NotNull BookRentalVo newItem) {
                return oldItem.getId().equals(newItem.getId()) &&
                        oldItem.getBook().getTitle().equals(newItem.getBook().getTitle()) &&
                        oldItem.getReturnDeadLine().equals(newItem.getReturnDeadLine());
            }
        });
    }

    @NonNull
    @Override
    public BookRentalAdapter.BookRentalVoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_book_rent_item, parent, false);
        return new BookRentalAdapter.BookRentalVoHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull BookRentalAdapter.BookRentalVoHolder holder, int position) {
        BookRentalVo current = getBookRentalVoAt(position);
        holder.title.setText(current.getBook().getTitle());
        holder.deadline.setText(Utils.formatDate(current.getReturnDeadLine().getTimeInMillis()));
    }


    public BookRentalVo getBookRentalVoAt(int position) {
        return getItem(position);
    }

    public void setOnItemClickListener(BookRentalAdapter.OnItemClickListener listener) {
        this.listener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(BookRentalVo user);
    }

    class BookRentalVoHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private TextView deadline;

        public BookRentalVoHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title_view);
            deadline = itemView.findViewById(R.id.return_deadline_view);
            itemView.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if (listener != null && position != RecyclerView.NO_POSITION) {
                    listener.onItemClick(getBookRentalVoAt(position));
                }
            });
        }
    }
}

