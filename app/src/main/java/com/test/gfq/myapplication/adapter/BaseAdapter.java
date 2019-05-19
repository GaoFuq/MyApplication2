package com.test.gfq.myapplication.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.test.gfq.myapplication.MyInterface.OnRVItemClickListener;

import java.util.List;

public abstract class BaseAdapter<T> extends RecyclerView.Adapter<BaseAdapter.VH>{
    public List<T> mDatas;
    private Context mContext;

    public OnRVItemClickListener onRVItemClickListener;

    public void setOnRVItemClickListener(OnRVItemClickListener onRVItemClickListener){
        this.onRVItemClickListener = onRVItemClickListener;
    }


    public BaseAdapter( List<T> datas){
        mDatas = datas;

    }




    /**
     *
     * @param layoutResId item的布局文件资源id
     * @return item的布局文件资源id
     */
    public abstract int getLayoutId(int layoutResId);

    public T getOtherTypeData(int position){
        T t = mDatas.get(position);
        return t;
    }
    @Override
    public VH onCreateViewHolder(ViewGroup parent, int layoutResId) {
        return  VH.get(parent,getLayoutId(layoutResId));
    }

    @Override
    public void onBindViewHolder(final VH holder, int position) {
        convert(holder,mDatas.get(position),position);

    }
    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public abstract void convert(VH holder, T data, int position);

    public static class VH extends RecyclerView.ViewHolder{

        /**
         * item布局里面的所有控件的稀松数组集合
         */
        private SparseArray<View> mViews;//稀松数组，更节省内存
        /**
         * item的布局视图view
         */
        private View mConvertView;
        public VH(View v){
            super(v);
            mConvertView = v;
            mViews = new SparseArray<>();

        }



        public static VH get(ViewGroup parent, int layoutResId){
            View convertView = LayoutInflater.from(parent.getContext()).inflate(layoutResId, parent, false);
            return new VH(convertView);
        }

        public <T extends View> T getView(int id){
            View v = mViews.get(id);
            if(v == null){
                v = mConvertView.findViewById(id);
                //把item布局里面的所有控件放入稀松数组中进行缓存
                mViews.put(id, v);
            }
            return (T)v;
        }



        public View setText( String value,int item_subview_res_id){
            TextView view = getView(item_subview_res_id);
            view.setText(value);
            return view;
        }
        public View setImgResId( int  img_res_id,int item_subview_res_id){
            ImageView view = getView(item_subview_res_id);
            view.setImageResource(img_res_id);
            return view;
        }
        public View setImgDrawable(Drawable drawable, int item_subview_res_id){
            ImageView view = getView(item_subview_res_id);
            view.setImageDrawable(drawable);
            return view;
        }

        /**
         *
         * @param value 从holder里面获取的数据： holder.newString(data.getMaterial_name());
         * @return itemBean 对象里面的String类型的数据
         */
        public  String newString(String value){
            return  value;
        }

    }
}