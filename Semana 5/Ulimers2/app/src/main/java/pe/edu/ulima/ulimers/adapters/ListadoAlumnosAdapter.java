package pe.edu.ulima.ulimers.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import pe.edu.ulima.ulimers.R;
import pe.edu.ulima.ulimers.beans.Alumno;

/**
 * Created by hquintana on 3/05/16.
 */
public class ListadoAlumnosAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private List<Alumno> mAlumnos;
    private Context mContext;

    public ListadoAlumnosAdapter(Context context, List<Alumno> alumnos){
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mAlumnos = alumnos;
    }
    @Override
    public int getCount() {
        return mAlumnos.size();
    }

    @Override
    public Object getItem(int i) {
        return mAlumnos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null){
            view = mInflater.inflate(R.layout.item_listado_alumnos, null);
            viewHolder = new ViewHolder();
            viewHolder.iviAlumnoFoto =(ImageView) view.findViewById(R.id.iviAlumnoFoto);
            viewHolder.tviNombreAlumno = (TextView) view.findViewById(R.id.tviNombreAlumno);
            viewHolder.tviCodigoAlumno = (TextView) view.findViewById(R.id.tviCodigoAlumno);
            viewHolder.iviAumentarPuntaje = (ImageView) view.findViewById(R.id.iviAumentarPuntaje);

            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }

        Alumno alumno = mAlumnos.get(i);

        viewHolder.tviNombreAlumno.setText(alumno.getNombre());
        viewHolder.tviCodigoAlumno.setText(alumno.getCodigo());
        Log.i("ULimers", alumno.getUrlFoto());
        Picasso.with(mContext)
                .load(alumno.getUrlFoto())
                .resize(200,200)
                .centerCrop()
                .into(viewHolder.iviAlumnoFoto);

        return view;
    }

    class ViewHolder{
        ImageView iviAlumnoFoto;
        TextView tviNombreAlumno;
        TextView tviCodigoAlumno;
        ImageView iviAumentarPuntaje;
    }
}
