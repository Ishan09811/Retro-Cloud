package com.retro.cloud.gaming;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.*;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.net.Uri;
import android.os.*;
import android.os.Bundle;
import android.text.*;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.*;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener;
import androidx.webkit.*;
import com.bumptech.glide.Glide;
import com.google.android.material.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.io.InputStream;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;
import com.google.android.material.progressindicator.CircularProgressIndicator;

public class MainActivity extends AppCompatActivity {
	
	private double n1 = 0;
	
	private ArrayList<HashMap<String, Object>> listmap = new ArrayList<>();
	
	private LinearLayout linear1;
	private CardView cardview1;
	private SwipeRefreshLayout swiperefreshlayout1;
	private ImageView imageview2;
	private TextView textview2;
	private CircularProgressIndicator progressbar1;
	private LinearLayout linear2;
	private TextView textview1;
	private LinearLayout linear3;
	private ImageView imageview1;
	private EditText edittext1;
	private GridView gridview1;
	
	private RequestNetwork net;
	private RequestNetwork.RequestListener _net_request_listener;
	private Intent i = new Intent();
	private SharedPreferences sherd;
	private AlertDialog.Builder d;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		cardview1 = findViewById(R.id.cardview1);
		swiperefreshlayout1 = findViewById(R.id.swiperefreshlayout1);
		imageview2 = findViewById(R.id.imageview2);
		textview2 = findViewById(R.id.textview2);
		progressbar1 = findViewById(R.id.progressbar1);
		linear2 = findViewById(R.id.linear2);
		textview1 = findViewById(R.id.textview1);
		linear3 = findViewById(R.id.linear3);
		imageview1 = findViewById(R.id.imageview1);
		edittext1 = findViewById(R.id.edittext1);
		gridview1 = findViewById(R.id.gridview1);
		net = new RequestNetwork(this);
		sherd = getSharedPreferences("sherd", Activity.MODE_PRIVATE);
		d = new AlertDialog.Builder(this);
		
		textview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				imageview2.setVisibility(View.GONE);
				textview2.setVisibility(View.GONE);
				progressbar1.setVisibility(View.VISIBLE);
				net.startRequestNetwork(RequestNetworkController.GET, "https://script.googleusercontent.com/macros/echo?user_content_key=AN_CnP850O7l36XS2cpT_icGfGPvUsi-LZ0LEtcvaM-bWx7feRoGKmrPm6ChZ6yQcgWOko-V2hKQCS65Lyg9yWeVmhrv_IGQm5_BxDlH2jW0nuo2oDemN9CCS2h10ox_1xSncGQajx_ryfhECjZEnCOIJr_nHXjdkPkXk1iCMfzPOp6AJQW3YRKlKBSVGriTtVevhCMzQWqaGROhDqW4_fa43erpFcJuGmad-SS9nabwX5fdpKh8c9z9Jw9Md8uu&lib=MefMCRsxSfTHfhSdP4PIfChoZjK-0W8qS", "A", _net_request_listener);
			}
		});
		
		textview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), SettingsActivity.class);
				startActivity(i);
			}
		});
		
		edittext1.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				if (!edittext1.getText().toString().equals("")) {
					if (edittext1.getText().toString().length() > 0) {
						n1 = listmap.size() - 1;
						for(int _repeat21 = 0; _repeat21 < (int)(listmap.size()); _repeat21++) {
							if (listmap.get((int)n1).get("game name").toString().toLowerCase().contains(edittext1.getText().toString().toLowerCase())) {
								
							}
							else {
								listmap.remove((int)(n1));
							}
							n1--;
						}
						gridview1.setAdapter(new Gridview1Adapter(listmap));
					}
					else {
						
					}
				}
				else {
					net.startRequestNetwork(RequestNetworkController.GET, "https://script.googleusercontent.com/macros/echo?user_content_key=AN_CnP850O7l36XS2cpT_icGfGPvUsi-LZ0LEtcvaM-bWx7feRoGKmrPm6ChZ6yQcgWOko-V2hKQCS65Lyg9yWeVmhrv_IGQm5_BxDlH2jW0nuo2oDemN9CCS2h10ox_1xSncGQajx_ryfhECjZEnCOIJr_nHXjdkPkXk1iCMfzPOp6AJQW3YRKlKBSVGriTtVevhCMzQWqaGROhDqW4_fa43erpFcJuGmad-SS9nabwX5fdpKh8c9z9Jw9Md8uu&lib=MefMCRsxSfTHfhSdP4PIfChoZjK-0W8qS", "A", _net_request_listener);
				}
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		gridview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				sherd.edit().putString("source", listmap.get((int)_position).get("source").toString()).commit();
				i.setClass(getApplicationContext(), EmulationActivity.class);
				startActivity(i);
			}
		});
		
		_net_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				listmap = new Gson().fromJson(_response, new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
				gridview1.setAdapter(new Gridview1Adapter(listmap));
				swiperefreshlayout1.setVisibility(View.VISIBLE);
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				swiperefreshlayout1.setVisibility(View.GONE);
				imageview2.setVisibility(View.VISIBLE);
				progressbar1.setVisibility(View.GONE);
				textview2.setVisibility(View.VISIBLE);
			}
		};
	}
	
	private void initializeLogic() {
		getWindow().getDecorView().setSystemUiVisibility( View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
		if (sherd.getString("renderer_type", "").equals("hardware")) {
			getWindow().getDecorView().setLayerType(View.LAYER_TYPE_HARDWARE, null);
		}
		else {
			if (sherd.getString("renderer_type", "").equals("software")) {
				getWindow().getDecorView().setLayerType(View.LAYER_TYPE_SOFTWARE, null);
			}
			else {
				getWindow().getDecorView().setLayerType(View.LAYER_TYPE_NONE, null);
			}
		}
		swiperefreshlayout1.setVisibility(View.GONE);
		imageview2.setVisibility(View.GONE);
		textview2.setVisibility(View.GONE);
		net.startRequestNetwork(RequestNetworkController.GET, "https://script.googleusercontent.com/macros/echo?user_content_key=AN_CnP850O7l36XS2cpT_icGfGPvUsi-LZ0LEtcvaM-bWx7feRoGKmrPm6ChZ6yQcgWOko-V2hKQCS65Lyg9yWeVmhrv_IGQm5_BxDlH2jW0nuo2oDemN9CCS2h10ox_1xSncGQajx_ryfhECjZEnCOIJr_nHXjdkPkXk1iCMfzPOp6AJQW3YRKlKBSVGriTtVevhCMzQWqaGROhDqW4_fa43erpFcJuGmad-SS9nabwX5fdpKh8c9z9Jw9Md8uu&lib=MefMCRsxSfTHfhSdP4PIfChoZjK-0W8qS", "", _net_request_listener);
		gridview1.setColumnWidth((int)175);
		gridview1.setHorizontalSpacing((int)20);
		gridview1.setVerticalSpacing((int)20);
		gridview1.setNumColumns((int)2);
		imageview1.setImageResource(R.drawable.icon_settings);
		gridview1.setSelector(android.R.color.transparent);
		swiperefreshlayout1.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
			@Override
			public void onRefresh() {
				swiperefreshlayout1.setRefreshing(false);
				if (edittext1.getText().toString().equals("")) {
					swiperefreshlayout1.setVisibility(View.GONE);
					imageview2.setVisibility(View.GONE);
					progressbar1.setVisibility(View.VISIBLE);
					textview2.setVisibility(View.GONE);
					net.startRequestNetwork(RequestNetworkController.GET, "https://script.googleusercontent.com/macros/echo?user_content_key=AN_CnP850O7l36XS2cpT_icGfGPvUsi-LZ0LEtcvaM-bWx7feRoGKmrPm6ChZ6yQcgWOko-V2hKQCS65Lyg9yWeVmhrv_IGQm5_BxDlH2jW0nuo2oDemN9CCS2h10ox_1xSncGQajx_ryfhECjZEnCOIJr_nHXjdkPkXk1iCMfzPOp6AJQW3YRKlKBSVGriTtVevhCMzQWqaGROhDqW4_fa43erpFcJuGmad-SS9nabwX5fdpKh8c9z9Jw9Md8uu&lib=MefMCRsxSfTHfhSdP4PIfChoZjK-0W8qS", "A", _net_request_listener);
				}
				else {
					
				}
			}
		});
	}
	
	public class Gridview1Adapter extends BaseAdapter {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Gridview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public int getCount() {
			return _data.size();
		}
		
		@Override
		public HashMap<String, Object> getItem(int _index) {
			return _data.get(_index);
		}
		
		@Override
		public long getItemId(int _index) {
			return _index;
		}
		
		@Override
		public View getView(final int _position, View _v, ViewGroup _container) {
			LayoutInflater _inflater = getLayoutInflater();
			View _view = _v;
			if (_view == null) {
				_view = _inflater.inflate(R.layout.game_list, null);
			}
			
			final com.google.android.material.card.MaterialCardView cardview1 = _view.findViewById(R.id.cardview1);
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final ImageView imageview1 = _view.findViewById(R.id.imageview1);
			final LinearLayout linear2 = _view.findViewById(R.id.linear2);
			final TextView textview1 = _view.findViewById(R.id.textview1);
			final TextView textview2 = _view.findViewById(R.id.textview2);
			
			textview1.setText(listmap.get((int)_position).get("game name").toString());
			textview2.setText(listmap.get((int)_position).get("game type").toString());
			Glide.with(getApplicationContext()).load(Uri.parse(listmap.get((int)_position).get("logo").toString())).into(imageview1);
			cardview1.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					sherd.edit().putString("source", listmap.get((int)_position).get("source").toString()).commit();
					i.setClass(getApplicationContext(), EmulationActivity.class);
					startActivity(i);
				}
			});
			
			return _view;
		}
	}
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels() {
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels() {
		return getResources().getDisplayMetrics().heightPixels;
	}
}